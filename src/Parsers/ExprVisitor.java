package Parsers;
import org.antlr.v4.runtime.misc.NotNull;

import Deducers.CData;
import Deducers.CDeduceExpr;
import Deducers.CDeduceTerm;
import Deducers.CSetStruct;
import Defines.DataDef;
import Defines.DeduceDef;
import Defines.QuaDef;

public class ExprVisitor extends GrammarBBaseVisitor<CDataEntity> {
	private CDataEntity final_entity = null;
	
	public CDataEntity get_entity(){
		return final_entity;
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public CDataEntity visitExpression(@NotNull GrammarBParser.ExpressionContext ctx) {
		CDataEntity term_result = visitTerm(ctx.term());
		if(term_result.type == DataDef.VALUE && ctx.addsub() != null && ctx.addsub().start.getType() == GrammarBParser.SUB){
			CDeduceExpr temp_expr = new CDeduceExpr();
			temp_expr.type = DeduceDef.REV;
			temp_expr.left_data = term_result.expr;
			term_result.expr = temp_expr;
		}
		final_entity = visitExpression_expand(ctx.expression_expand(), term_result);
		return final_entity; 
	}
	
	public CDataEntity visitExpression_expand(@NotNull GrammarBParser.Expression_expandContext ctx, CDataEntity in_left_term){
		CDataEntity return_result = in_left_term;
		if(in_left_term.type == DataDef.VALUE && ctx.term() != null && ctx.term().size() != 0){
			for(int i = 0; i < ctx.term().size(); i++){
				DeduceDef cur_type = null;
				if(ctx.addsub(i).start.getType() == GrammarBParser.ADD){
					cur_type = DeduceDef.ADD;
				}
				else{
					cur_type = DeduceDef.SUB;
				}
				return_result.expr = new CDeduceExpr(cur_type, return_result.expr, visitTerm(ctx.term(i)).expr);
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
	@Override public CDataEntity visitTerm(@NotNull GrammarBParser.TermContext ctx) { 
		CDataEntity return_result = visitFactor(ctx.factor(0));
		if(return_result.type == DataDef.VALUE){
			for(int i = 1; i < ctx.factor().size(); i++){
				DeduceDef cur_type = null;
				if(ctx.muldiv(i - 1).start.getType() == GrammarBParser.MUL){
					cur_type = DeduceDef.MUL;
				}
				else{
					cur_type = DeduceDef.DIV;
				}
				return_result.expr = new CDeduceExpr(cur_type, return_result.expr, visitFactor(ctx.factor(i)).expr);
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
	@Override public CDataEntity visitFactor(@NotNull GrammarBParser.FactorContext ctx) {
		CDataEntity return_result = new CDataEntity();
		if(ctx.set() != null){
			return_result = visitSet(ctx.set());
		}
		else if(ctx.expression() != null){
			return_result = visitExpression(ctx.expression());
		}
		else{
			return_result.type = DataDef.VALUE;
			if(ctx.ID() != null){
				return_result.expr = new CDeduceExpr(ctx.ID().getText());
			}
			else if(ctx.INTEGER() != null){
				return_result.expr = new CDeduceExpr(ctx.INTEGER().getText());
			}
			else if(ctx.REAL() != null){
				return_result.expr = new CDeduceExpr(ctx.REAL().getText());
			}
			else if(ctx.CHAR() != null){
				//可能的错误地点
				return_result.expr = new CDeduceExpr(ctx.CHAR().getText());
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
	@Override public CDataEntity visitSet(@NotNull GrammarBParser.SetContext ctx) {
		CDataEntity return_result = visitSet_term_1(ctx.set_term_1(0));
		if(ctx.SET_SYMBOL_2() != null && ctx.SET_SYMBOL_2().size() != 0){
			for(int i = 1; i < ctx.SET_SYMBOL_2().size(); i++){
				return_result.set_struct = new CSetStruct(
						DeduceDef.SUB_S, 
						return_result.set_struct, 
						visitSet_term_1(ctx.set_term_1(i)).set_struct
						);
			}
		}
		return return_result;
	}
	
	private DeduceDef set_symbol_to_deducedef(String in_symbol){
		DeduceDef return_result = null;
		if(in_symbol.equals("/-\\") ){
			return_result = DeduceDef.INT;
		}
		else if(in_symbol.equals("\\-/")){
			return_result = DeduceDef.UNI;
		}
		return return_result;
	}
	
	@Override public CDataEntity visitSet_term_1(@NotNull GrammarBParser.Set_term_1Context ctx){
		CDataEntity return_result = visitSet_term_0(ctx.set_term_0(0));
		if(ctx.SET_SYMBOL_1() != null && ctx.SET_SYMBOL_1().size() != 0){
			for(int i = 0; i < ctx.SET_SYMBOL_1().size(); i++){
				return_result.set_struct = new CSetStruct(
						set_symbol_to_deducedef(ctx.SET_SYMBOL_1(i).getText()),
						return_result.set_struct,
						visitSet_term_0(ctx.set_term_0(i + 1)).set_struct
						);
			}
		}
		return return_result;
	}
	
	@Override public CDataEntity visitSet_term_0(@NotNull GrammarBParser.Set_term_0Context ctx){
		CDataEntity return_result = null;
		
		if(ctx.element() != null && ctx.element().size() != 0){
			return_result = new CDataEntity(new CSetStruct(DeduceDef.DATA));
			for(int i = 0; i < ctx.element().size(); i++){
				return_result.set_struct.add(new CDeduceTerm(visitElement(ctx.element(i)).expr));
			}
		}
		else if(ctx.proposition() != null){
			if(ctx.ID() != null){
				CSetStruct temp_set_struct = new CSetStruct(DeduceDef.DATA);
				CDeduceExpr temp_expr = new CDeduceExpr(
						DeduceDef.SET_ELE, 
						new CDeduceExpr(
								DeduceDef.SET_LEFT_ARG, 
								new CDeduceExpr(ctx.ID().getText()), 
								null
								), 
						visitProposition(ctx.proposition()).expr);
				temp_set_struct.add(new CDeduceTerm(temp_expr));
				return_result = new CDataEntity(temp_set_struct);
			}
		}
		else if(ctx.ID() != null){
			CSetStruct temp_set_struct = new CSetStruct(ctx.ID().getText());
			return_result = new CDataEntity(temp_set_struct);
		}
		return return_result;
	}
	
	@Override public CDataEntity visitElement(@NotNull GrammarBParser.ElementContext ctx){
		CDataEntity return_result = new CDataEntity();
		if(ctx.expression() != null){
			return_result = visitExpression(ctx.expression());
		}
		else if(ctx.element_group() != null){
			
		}
		else{
			return_result.type = DataDef.VALUE;
			if(ctx.BOOL() != null){
				
			}
			else if(ctx.ID() != null){
				return_result.expr = new CDeduceExpr(ctx.ID().getText());
			}
			else if(ctx.INTEGER() != null){
				return_result.expr = new CDeduceExpr(ctx.INTEGER().getText());
			}
			else if(ctx.REAL() != null){
				return_result.expr = new CDeduceExpr(ctx.REAL().getText());
			}
			else if(ctx.CHAR() != null){
				//可能的错误地点
				return_result.expr = new CDeduceExpr(ctx.CHAR().getText());
			}
			else if(ctx.proposition() != null){
				return_result = visitProposition(ctx.proposition());
			}
		}
		return return_result;
	}
	
	@Override public CDataEntity visitProposition(@NotNull GrammarBParser.PropositionContext ctx){
		CDataEntity 	change_1_result = visitChange_1(ctx.change_1()),
						change_4_result = visitChange_4(ctx.change_4());
		
		if(change_1_result != null){
			return change_1_result;
		}
		else
			return null; 
	}
	
	@Override public CDataEntity visitChange_1(@NotNull GrammarBParser.Change_1Context ctx){
		CDataEntity return_result = null;
		if(ctx.change_2() != null){
			return_result = visitChange_1_temp_1(ctx.change_1_temp_1());
			if(ctx.PROPOSITION_SYMBOL_1() != null && !ctx.PROPOSITION_SYMBOL_1().isEmpty()){
				if(ctx.PROPOSITION_SYMBOL_1().size() % 2 == 1){
					return_result = new CDataEntity(
							new CDeduceExpr(
									DeduceDef.NOT,
									return_result.expr,
									null
									)
							);
				}
			}
			return_result = visitChange_2(ctx.change_2(), return_result);
		}
		else if(ctx.change_3() != null){
			
		}
		else if(ctx.proposition() != null){
			
		} 
		return return_result;
	}
	
	public CDataEntity visitChange_2(@NotNull GrammarBParser.Change_2Context ctx, CDataEntity left_entity){
		CDataEntity return_result = left_entity;
		if(ctx.proposition_term_1() != null && !ctx.proposition_term_1().isEmpty()){
			for(int i = 0; i < ctx.proposition_term_1().size(); i++){
				return_result = new CDataEntity(
						new CDeduceExpr(
								DeduceDef.AND,
								return_result.expr,
								visitProposition_term_1(ctx.proposition_term_1(i)).expr
								)
						);
			}
		}
		if(ctx.proposition_term_2() != null && !ctx.proposition_term_2().isEmpty()){
			for(int i = 0; i < ctx.proposition_term_2().size(); i++){
				return_result = new CDataEntity(
						new CDeduceExpr(
								DeduceDef.OR,
								return_result.expr,
								visitProposition_term_2(ctx.proposition_term_2(i)).expr
								)
						);
			}
		}
		if(ctx.proposition_term_3() != null && !ctx.proposition_term_3().isEmpty()){
			for(int i = 0; i < ctx.proposition_term_3().size(); i++){
				return_result = new CDataEntity(
						new CDeduceExpr(
								DeduceDef.ENT,
								return_result.expr,
								visitProposition_term_3(ctx.proposition_term_3(i)).expr
								)
						);
			}
		}
		return return_result;
	}
	
	@Override public CDataEntity visitChange_1_temp_1(@NotNull GrammarBParser.Change_1_temp_1Context ctx) {
		if(ctx.math_relation_proposition() != null){
			return visitMath_relation_proposition(ctx.math_relation_proposition());
		}
		else if(ctx.ID() != null){
			return new CDataEntity(new CDeduceExpr(ctx.ID().getText()));
		}
		else{
			return null;
		} 
	}
	
	private DeduceDef math_relation_to_deducedef(@NotNull GrammarBParser.Math_relation_symbolContext ctx){
		DeduceDef return_result = null;
		if(ctx.GRE() != null){
			return_result = DeduceDef.GRE;
		}
		else if(ctx.EGRE() != null){
			return_result = DeduceDef.EGRE;
		}
		else if(ctx.LES() != null){
			return_result = DeduceDef.LES;
		}
		else if(ctx.ELES() != null){
			return_result = DeduceDef.ELES;
		}
		else if(ctx.EQU() != null){
			return_result = DeduceDef.EQU;
		}
		else if(ctx.UEQU() != null){
			return_result = DeduceDef.UEQU;
		}
		return return_result;
	}
	
	@Override public CDataEntity visitMath_relation_proposition(@NotNull GrammarBParser.Math_relation_propositionContext ctx) {
		CDataEntity expr_0_result = visitExpression(ctx.expression(0)),
					expr_1_result = visitExpression(ctx.expression(1)),
					return_result = null;
		if(expr_0_result.type == DataDef.VALUE && expr_1_result.type == DataDef.VALUE){
			return_result = new CDataEntity(
					new CDeduceExpr(math_relation_to_deducedef(ctx.math_relation_symbol()), 
							expr_0_result.expr, 
							expr_1_result.expr));
		}
		else{
			//TODO 错误处理
		}
		return return_result;
	}
	
	@Override public CDataEntity visitProposition_term_0(@NotNull GrammarBParser.Proposition_term_0Context ctx) { 
		CDataEntity return_result = null;
		if(ctx.math_relation_proposition() != null){
			return_result = visitMath_relation_proposition(ctx.math_relation_proposition());
		}
		else if(ctx.ID() != null){
			return_result = new CDataEntity(new CDeduceExpr(ctx.ID().getText()));
		}
		return return_result; 
	}

	@Override public CDataEntity visitProposition_term_1(@NotNull GrammarBParser.Proposition_term_1Context ctx) {
		CDataEntity return_result = null;
		int symbol_1_count = ctx.PROPOSITION_SYMBOL_1().size();
		if(symbol_1_count % 2 == 1){
			return_result = new CDataEntity(
					new CDeduceExpr(
							DeduceDef.NOT, 
							visitProposition_term_0(ctx.proposition_term_0()).expr, 
							null));
		}
		else{
			return_result = visitProposition_term_0(ctx.proposition_term_0());
		}
		return return_result; 
	}

	@Override public CDataEntity visitProposition_term_2(@NotNull GrammarBParser.Proposition_term_2Context ctx) {
		CDataEntity return_result = visitProposition_term_1(ctx.proposition_term_1(0));
		for(int i = 0; i < ctx.PROPOSITION_SYMBOL_2().size(); i++){
			return_result = new CDataEntity(
					new CDeduceExpr(
							DeduceDef.AND, 
							return_result.expr, 
							visitProposition_term_1(ctx.proposition_term_1(i + 1)).expr));
		}
		return return_result; 
	}

	@Override public CDataEntity visitProposition_term_3(@NotNull GrammarBParser.Proposition_term_3Context ctx) {
		CDataEntity return_result = visitProposition_term_2(ctx.proposition_term_2(0));
		for(int i = 0; i < ctx.PROPOSITION_SYMBOL_3().size(); i++){
			return_result = new CDataEntity(
					new CDeduceExpr(
							DeduceDef.OR, 
							return_result.expr, 
							visitProposition_term_2(ctx.proposition_term_2(i + 1)).expr));
		}
		return return_result; 
	}
}
	