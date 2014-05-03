package Parsers;
import org.antlr.v4.runtime.misc.NotNull;

import Deducers.CDeduceExpr;
import Defines.DeduceDef;

public class ExprVisitor extends GrammarBBaseVisitor<CDeduceExpr> {
	private CDeduceExpr final_expr = null;
	
	public CDeduceExpr get_expr(){
		return final_expr;
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public CDeduceExpr visitExpression(@NotNull GrammarBParser.ExpressionContext ctx) {
		CDeduceExpr term_result = visitTerm(ctx.term());
		if(ctx.addsub() != null && ctx.addsub().start.getType() == GrammarBParser.SUB){
			CDeduceExpr temp_expr = new CDeduceExpr();
			temp_expr.type = DeduceDef.REV;
			temp_expr.left_data = term_result;
			term_result = temp_expr;
		}
		final_expr = visitExpression_expand(ctx.expression_expand(), term_result);
		return final_expr; 
	}
	
	public CDeduceExpr visitExpression_expand(@NotNull GrammarBParser.Expression_expandContext ctx, CDeduceExpr in_left_term){
		CDeduceExpr return_result = in_left_term;
		if(ctx.term() != null && ctx.term().size() != 0){
			for(int i = 0; i < ctx.term().size(); i++){
				DeduceDef cur_type = null;
				if(ctx.addsub(i).start.getType() == GrammarBParser.ADD){
					cur_type = DeduceDef.ADD;
				}
				else{
					cur_type = DeduceDef.SUB;
				}
				return_result = new CDeduceExpr(cur_type, return_result, visitTerm(ctx.term(i)));
			}
		}
		return return_result;
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public CDeduceExpr visitTerm(@NotNull GrammarBParser.TermContext ctx) { 
		CDeduceExpr return_result = visitFactor(ctx.factor(0));
		for(int i = 1; i < ctx.factor().size(); i++){
			DeduceDef cur_type = null;
			if(ctx.muldiv(i - 1).start.getType() == GrammarBParser.MUL){
				cur_type = DeduceDef.MUL;
			}
			else{
				cur_type = DeduceDef.DIV;
			}
			return_result = new CDeduceExpr(cur_type, return_result, visitFactor(ctx.factor(i)));
		}
		return return_result; 
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public CDeduceExpr visitFactor(@NotNull GrammarBParser.FactorContext ctx) {
		CDeduceExpr return_result = null;
		if(ctx.ID() != null){
			return_result = new CDeduceExpr(ctx.ID().getText());
		}
		else if(ctx.expression() != null){
			return_result = visitExpression(ctx.expression());
		}
		else if(ctx.INTEGER() != null){
			return_result = new CDeduceExpr(ctx.INTEGER().getText());
		}
		else if(ctx.REAL() != null){
			return_result = new CDeduceExpr(ctx.REAL().getText());
		}
		else if(ctx.CHAR() != null){
			//可能的错误地点
			return_result = new CDeduceExpr(ctx.CHAR().getText());
		}
		return return_result; 
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public CDeduceExpr visitSet(@NotNull GrammarBParser.SetContext ctx) {
		return visitChildren(ctx); 
	}
}
	