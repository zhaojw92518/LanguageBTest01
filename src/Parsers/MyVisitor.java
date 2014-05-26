package Parsers;
import org.antlr.v4.runtime.misc.NotNull;

import Deducers.CData;
import Deducers.CQuaManager;
import Deducers.CQuaternion;
import Defines.DataDef;
import Defines.QuaDef;


public class MyVisitor extends GrammarBBaseVisitor<String> {
	private Integer temp_value_count = 0, label_count = 0;
	
	private CQuaManager qua_manager = new CQuaManager();
	
	private String int_to_str(int in_int){
		Integer temp_integer = new Integer(in_int);
		return temp_integer.toString();
	}
	
	private QuaDef set_symbol_to_qua(String in_symbol){
		QuaDef return_result = null;
		if(in_symbol.equals("/-\\") ){
			return_result = QuaDef.INT;
		}
		else if(in_symbol.equals("\\-/")){
			return_result = QuaDef.UNI;
		}
		return return_result;
	}
	
	public CQuaManager get_qua_manager(){
		return qua_manager;
	}
	
	private String get_current_temp_value(){
		String return_result = "@" + temp_value_count.toString();
		temp_value_count++;
		return return_result;
	}
	
	private CQuaternion get_current_label(){
		CQuaternion return_result = 
				new CQuaternion(
						QuaDef.LABEL, 
						new CData(DataDef.INT, label_count.toString()),
						CQuaternion.NO_USE_LINE_NUM
						);
		label_count++;
		return return_result;
	}
	
	private void printQuaternion(String in_str){
		//System.out.println(in_str);
	}
		
	private QuaDef addsub_to_type(int in_index){
		QuaDef return_result = null;
		if(in_index == GrammarBParser.ADD){
			return_result = QuaDef.ADD;
		}
		else if(in_index == GrammarBParser.SUB){
			return_result = QuaDef.SUB;
		}
		return return_result;
	}
	
	private QuaDef muldiv_to_type(int in_index){
		QuaDef return_result = null;
		if(in_index == GrammarBParser.MUL){
			return_result = QuaDef.MUL;
		}
		else if(in_index == GrammarBParser.DIV){
			return_result = QuaDef.DIV;
		}
		return return_result;
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitValuable_declare(@NotNull GrammarBParser.Valuable_declareContext ctx) { 
		int cur_type = ctx.type().start.getType();
		for(int i = 0; i < ctx.ID().size(); i++){
			qua_manager.push_back_quaternion(
				QuaDef.DEC,
				new CData(DataDef.TYPE, DataDef.get_data_def_from_parser(cur_type)),
				new CData(DataDef.ID, ctx.ID(i).getText()),
				ctx.ID(i).getSymbol().getLine()
			);
		}
		return null; 
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitValue_argument_list(@NotNull GrammarBParser.Value_argument_listContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitProposition_term_3(@NotNull GrammarBParser.Proposition_term_3Context ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitProposition_term_2(@NotNull GrammarBParser.Proposition_term_2Context ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitSet(@NotNull GrammarBParser.SetContext ctx) { return visitChildren(ctx); }
	
	public CData visitSetRD(@NotNull GrammarBParser.SetContext ctx){
		CData return_result = null;
		if(ctx.SET_SYMBOL_2() != null && ctx.SET_SYMBOL_2().size() != 0){
			return_result = new CData(DataDef.ID, get_current_temp_value());
			qua_manager.push_back_quaternion(QuaDef.SUB_S, visitSet_term_1RD(ctx.set_term_1(0)), visitSet_term_1RD(ctx.set_term_1(1)), return_result, 0);
			for(int i = 1; i < ctx.SET_SYMBOL_2().size(); i++){
				qua_manager.push_back_quaternion(
						QuaDef.SUB_S, 
						return_result, 
						visitSet_term_1RD(ctx.set_term_1(i + 1)), 
						return_result, 
						0);
			}
		}
		else{
			return_result = visitSet_term_1RD(ctx.set_term_1(0));
		}
		return return_result;
	}
	
	public CData visitSet_term_0RD(@NotNull GrammarBParser.Set_term_0Context ctx){
		CData return_result = null;
		if(ctx.ID() != null){
			return_result = new CData(DataDef.ID, ctx.ID().getText());
		}
		else if(ctx.element() != null && ctx.element().size() != 0){
			return_result = new CData();
			return_result.type = DataDef.SET;
			for(int i = 0; i < ctx.element().size(); i++){
				CData temp_data = visitElementRD(ctx.element(i));
				return_result.add_set_element(temp_data);
			}
		}
		return return_result;
	}
	
	public CData visitSet_term_1RD(@NotNull GrammarBParser.Set_term_1Context ctx){
		CData return_result = null;
		if(ctx.SET_SYMBOL_1() != null && ctx.SET_SYMBOL_1().size() != 0){
			return_result = new CData(DataDef.ID, get_current_temp_value());
			qua_manager.push_back_quaternion(
					set_symbol_to_qua(ctx.SET_SYMBOL_1(0).getText()), 
					visitSet_term_0RD(ctx.set_term_0(0)), 
					visitSet_term_0RD(ctx.set_term_0(1)), 
					return_result, 
					0);
			for(int i = 1; i < ctx.SET_SYMBOL_1().size(); i++){
				qua_manager.push_back_quaternion(
						set_symbol_to_qua(ctx.SET_SYMBOL_1(i).getText()), 
						return_result, 
						visitSet_term_0RD(ctx.set_term_0(i + 1)), 
						return_result, 
						0);
			}
		}
		else{
			return_result = visitSet_term_0RD(ctx.set_term_0(0));
		}
		return return_result;
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitProposition_term_1(@NotNull GrammarBParser.Proposition_term_1Context ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitProposition_term_0(@NotNull GrammarBParser.Proposition_term_0Context ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitType(@NotNull GrammarBParser.TypeContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitProposition(@NotNull GrammarBParser.PropositionContext ctx) { 
		String 	change_1_result = visitChange_1(ctx.change_1()),
				change_4_result = visitChange_4(ctx.change_4());
		
		if(change_1_result != null && change_4_result == null){
			return change_1_result;
		}
		else
			return null; 
	}
	
	public CData visitPropositionRD(@NotNull GrammarBParser.PropositionContext ctx) {
		CData 	change_1_result = visitChange_1RD(ctx.change_1()),
				change_4_result = visitChange_4RD(ctx.change_4());
		
		if(change_1_result != null && change_4_result == null){
			return change_1_result;
		}
		else
			return null; 
	}

	
	public CData visitMath_relation_propositionRD(@NotNull GrammarBParser.Math_relation_propositionContext ctx) {
		CData expr_0_result = visitExpressionRD(ctx.expression(0)),
			  expr_1_result = visitExpressionRD(ctx.expression(1)),
			  math_result	= new CData(DataDef.ID, get_current_temp_value());
		qua_manager.push_back_quaternion(
			QuaDef.math_relationship_to_quadef(ctx.math_relation_symbol().start.getType()),
			expr_0_result,
			expr_1_result,
			math_result,
			ctx.math_relation_symbol().start.getLine()
		);
		return math_result;
			  
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitHave_return_declare(@NotNull GrammarBParser.Have_return_declareContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitNo_return_define(@NotNull GrammarBParser.No_return_defineContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitReturn_stat(@NotNull GrammarBParser.Return_statContext ctx) { 
		CData qua_return = null;
		if(ctx.element() != null){
			qua_return = visitElementRD(ctx.element());
		}
		qua_manager.push_back_quaternion(
				QuaDef.RET,
				qua_return,
				ctx.start.getLine()
				);
		return null; 
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitConst_declare(@NotNull GrammarBParser.Const_declareContext ctx) { 
		//String cur_type_str = ctx.start.getText();
		int cur_type = ctx.start.getType();
		switch (cur_type) {
		case GrammarBParser.INT_TYPE:
			for(int i = 0; i < ctx.ID().size(); i++){
				qua_manager.push_back_quaternion(
						QuaDef.DEC,
						new CData(DataDef.TYPE, DataDef.get_data_def_from_parser(cur_type)),
						new CData(DataDef.ID, ctx.ID(i).getText()),
						new CData(DataDef.INT, ctx.signed_integer(i).getText()),
						ctx.ID(i).getSymbol().getLine()
				);
			}
			break;
		case GrammarBParser.SET_TYPE:
			for(int i = 0; i < ctx.ID().size(); i++){
				qua_manager.push_back_quaternion(
						QuaDef.DEC,
						new CData(DataDef.TYPE, DataDef.get_data_def_from_parser(cur_type)),
						new CData(DataDef.ID, ctx.ID(i).getText()),
						visitSetRD(ctx.set(i)),
						ctx.ID(i).getSymbol().getLine()
				);
			}
			break;
		/*case GrammarBParser.DOUBLE_TYPE:
			for(int i = 0; i < ctx.ID().size(); i++){
				printQuaternion("del " + cur_type_str + " " + ctx.ID(i) + " " + ctx.signed_real(i).getText());
			}
			break;
		case GrammarBParser.CHAR_TYPE:
			for(int i = 0; i < ctx.ID().size(); i++){
				printQuaternion("del " + cur_type_str + " " + ctx.ID(i) + " " + ctx.CHAR(i).getText());
			}
			break;
		case GrammarBParser.STRING_TYPE:
			for(int i = 0; i < ctx.ID().size(); i++){
				printQuaternion("del " + cur_type_str + " " + ctx.ID(i) + " " + ctx.STRING(i).getText());
			}
			break;*/
		
		/*case GrammarBParser.TUPLE_TYPE:
			for(int i = 0; i < ctx.ID().size(); i++){
				printQuaternion("del " + cur_type_str + " " + ctx.ID(i) + " " + ctx.element_group(i).getText());
			}
			break;
		case GrammarBParser.BOOL_TYPE:
			for(int i = 0; i < ctx.ID().size(); i++){
				printQuaternion("del " + cur_type_str + " " + ctx.ID(i) + " " + ctx.BOOL(i).getText());
			}
			break;
		case GrammarBParser.PROPOSITION_TYPE:
			for(int i = 0; i < ctx.ID().size(); i++){
				printQuaternion("del " + cur_type_str + " " + ctx.ID(i) + " " + ctx.proposition(i).getText());
			}
			break;*/
		default:
			break;
		}
		
		return null;
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitElement_set_relation_proposition(@NotNull GrammarBParser.Element_set_relation_propositionContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitConst_interupt(@NotNull GrammarBParser.Const_interuptContext ctx) { 
		for(int i = 0; i < ctx.const_declare().size(); i++){
			visitConst_declare(ctx.const_declare(i));
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitNo_return_declare(@NotNull GrammarBParser.No_return_declareContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitElement(@NotNull GrammarBParser.ElementContext ctx) { 
		return visitChildren(ctx); 
	}
	
	public CData visitElementRD(@NotNull GrammarBParser.ElementContext ctx){
		CData return_result = null;
		if(ctx.expression() != null){
			return_result = visitExpressionRD(ctx.expression());
		}
		else if(ctx.element_group() != null){
			return_result = visitElement_groupRD(ctx.element_group());
		}
		else if(ctx.BOOL() != null){
			
		}
		else if(ctx.INTEGER() != null){
			return_result = new CData(DataDef.INT, ctx.INTEGER().getText());
		}
		else if(ctx.REAL() != null){
			return_result = new CData(DataDef.DOUBLE, ctx.REAL().getText());
		}
		else if(ctx.CHAR() != null){
			
		}
		else if(ctx.ID() != null){
			return_result = new CData(DataDef.ID, ctx.ID().getText());
		}
		else if(ctx.proposition() != null){
			return_result = visitPropositionRD(ctx.proposition());
		}
		return return_result;
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitHave_return_call(@NotNull GrammarBParser.Have_return_callContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitValuable_interupt(@NotNull GrammarBParser.Valuable_interuptContext ctx) { 
		if(ctx != null){
			for(int i = 0; i < ctx.valuable_declare().size(); i++){
				visitValuable_declare(ctx.valuable_declare(i));
			}
		}
		return null; 
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitCondition(@NotNull GrammarBParser.ConditionContext ctx) { 
		return visitProposition(ctx.proposition()); 
	}
	
	public CData visitConditionRD(@NotNull GrammarBParser.ConditionContext ctx) {
		return visitPropositionRD(ctx.proposition());
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitNo_return_call(@NotNull GrammarBParser.No_return_callContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitHave_return_define(@NotNull GrammarBParser.Have_return_defineContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitCirculate_stat(@NotNull GrammarBParser.Circulate_statContext ctx) { 
		qua_manager.push_back_quaternion(QuaDef.LOOP, ctx.condition().start.getLine());
		CQuaternion begin_label = get_current_label(),
					end_label	= get_current_label();
		qua_manager.push_back_quaternion(begin_label);
		qua_manager.push_back_quaternion(
				QuaDef.IFNOT_L,
				visitConditionRD(ctx.condition()),
				end_label.data_0,
				ctx.condition().start.getLine()
				);
		if(ctx.stat() != null){
			for(int i = 0; i < ctx.stat().size(); i++){
				visitStat(ctx.stat(i));
			}
		}
		qua_manager.push_back_quaternion(
				QuaDef.GOTO_L,
				begin_label.data_0,
				CQuaternion.NO_USE_LINE_NUM
				);
		qua_manager.push_back_quaternion(end_label);
		qua_manager.push_back_quaternion(QuaDef.LOOP_END, ctx.RIGHT_BRACE().getSymbol().getLine());
		return null; 
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitChange_1_temp_2(@NotNull GrammarBParser.Change_1_temp_2Context ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitAssign_stat(@NotNull GrammarBParser.Assign_statContext ctx) { 
		qua_manager.push_back_quaternion(
				QuaDef.ASS,
				visitElementRD(ctx.element()),
				new CData(DataDef.ID, ctx.ID().getText()),
				ctx.ASSIGN_SYMBOL().getSymbol().getLine()
				);
		return null; 
	}
	
	//RD means return type is CData
	public CData visitFactorRD(@NotNull GrammarBParser.FactorContext ctx){
		CData return_result = null;
		if(ctx.ID() != null){
			return_result = new CData(DataDef.ID, ctx.ID().getText());
		}
		else if(ctx.expression() != null){
			return_result = visitExpressionRD(ctx.expression());
		}
		else if(ctx.INTEGER() != null){
			return_result = new CData(DataDef.INT, ctx.INTEGER().getText());
		}
		else if(ctx.REAL() != null){
			return_result = new CData(DataDef.DOUBLE, ctx.REAL().getText());
		}
		else if(ctx.CHAR() != null){
			return_result = new CData(DataDef.CHAR, ctx.CHAR().getText());
		}
		else if(ctx.set() != null){
			return_result = visitSetRD(ctx.set());
		}
		return return_result;
	}
	
	public CData visitExpressionRD(@NotNull GrammarBParser.ExpressionContext ctx){
		CData term_0_result = visitTermRD(ctx.term());
		if(ctx.addsub() != null && ctx.addsub().start.getType() == GrammarBParser.SUB){
			CData new_term_0_result = new CData(DataDef.ID, get_current_temp_value());
			qua_manager.push_back_quaternion(
				QuaDef.REV,
				term_0_result,
				new_term_0_result,
				ctx.addsub().start.getLine()
			);
			term_0_result = new_term_0_result;
		}
		return visitExpression_expandRD(ctx.expression_expand(), term_0_result);
	}
	
	public CData visitExpression_expandRD(@NotNull GrammarBParser.Expression_expandContext ctx, CData left_term){
		CData return_result = null;
		if(ctx.term() == null || ctx.term().size() == 0){
			return_result = left_term;
		}
		else{
			CData term_0_result = visitTermRD(ctx.term(0)),
				  cur_temp_result = new CData(DataDef.ID, get_current_temp_value());
			qua_manager.push_back_quaternion(
				addsub_to_type(ctx.addsub(0).start.getType()),
				left_term,
				term_0_result,
				cur_temp_result,
				ctx.addsub(0).start.getLine()
			);
			return_result = cur_temp_result;
			for(int i = 1; i < ctx.term().size(); i++){
				CData temp_term_result = visitTermRD(ctx.term(i));
				qua_manager.push_back_quaternion(
					addsub_to_type(ctx.addsub(i).start.getType()),
					cur_temp_result,
					temp_term_result,
					cur_temp_result,
					ctx.addsub(i).start.getLine()
				);
			}
		}
		return return_result;
	}
	
	public CData visitTermRD(@NotNull GrammarBParser.TermContext ctx){
		CData return_result = null;
		if(ctx.factor().size() == 1){
			return_result = visitFactorRD(ctx.factor(0));
		}
		else{
			CData temp_result = new CData(DataDef.ID, get_current_temp_value()),
				  factor_0_result = visitFactorRD(ctx.factor(0)),
				  factor_1_result = visitFactorRD(ctx.factor(1));
			qua_manager.push_back_quaternion(
				muldiv_to_type(ctx.muldiv(0).start.getType()),
				factor_0_result,
				factor_1_result,
				temp_result,
				ctx.muldiv(0).start.getLine()
			);
			return_result = temp_result;
			for(int i = 1; i < ctx.muldiv().size(); i++){
				qua_manager.push_back_quaternion(
					muldiv_to_type(ctx.muldiv(1).start.getType()),
					temp_result,
					visitFactorRD(ctx.factor(i + 1)),
					temp_result,
					ctx.muldiv(i).start.getLine()
				);
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
	@Override public String visitMulti_stat(@NotNull GrammarBParser.Multi_statContext ctx) {
		if(ctx != null){	
			qua_manager.push_back_quaternion(QuaDef.FUNC_CON_DEC);
			if(ctx.const_interupt() != null){
				qua_manager.set_last_qua_line_num(ctx.const_interupt().start.getLine());
				visitConst_interupt(ctx.const_interupt());
			}
			qua_manager.push_back_quaternion(QuaDef.FUNC_CON_DEC_END);
			qua_manager.push_back_quaternion(QuaDef.FUNC_VAL_DEC);
			
			if(ctx.valuable_interupt() != null){
				qua_manager.set_last_qua_line_num(ctx.valuable_interupt().start.getLine());
				visitValuable_interupt(ctx.valuable_interupt());
			}
			qua_manager.push_back_quaternion(QuaDef.FUNC_VAL_DEC_END);
			if(ctx.stat() != null){
				for(int i = 0; i < ctx.stat().size(); i++){
					visitStat(ctx.stat(i));
				}
			}
		}
		return null; 
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitChange_1_temp_1(@NotNull GrammarBParser.Change_1_temp_1Context ctx) { 
		if(ctx.math_relation_proposition() != null){
			return visitMath_relation_proposition(ctx.math_relation_proposition());
		}
		else{
			return null;
		} 
	}
	
	public CData visitChange_1_temp_1RD(@NotNull GrammarBParser.Change_1_temp_1Context ctx) {
		if(ctx.math_relation_proposition() != null){
			return visitMath_relation_propositionRD(ctx.math_relation_proposition());
		}
		else{
			return null;
		} 
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitStat(@NotNull GrammarBParser.StatContext ctx) { 
		if(ctx.condition_stat() != null){
			visitCondition_stat(ctx.condition_stat());
		}
		else if(ctx.circulate_stat() != null){
			visitCirculate_stat(ctx.circulate_stat());
		}
		else if(ctx.assign_stat() != null){
			visitAssign_stat(ctx.assign_stat());
		}
		else if(ctx.return_stat() != null){
			visitReturn_stat(ctx.return_stat());
		}
		return null; 
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitElement_group(@NotNull GrammarBParser.Element_groupContext ctx) { return visitChildren(ctx); }
	
	public CData visitElement_groupRD(@NotNull GrammarBParser.Element_groupContext ctx) { 
		CData return_result = new CData(DataDef.ELEMENT_GROUP, "0");
		for(int i = 0; i < ctx.element().size(); i++){
			return_result.add_element_group(visitElementRD(ctx.element(i)));
		}
		return return_result;
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitAbstact_machine(@NotNull GrammarBParser.Abstact_machineContext ctx) { 
		qua_manager.push_back_quaternion(QuaDef.GLO_DEC, ctx.MACHINE().getSymbol().getLine());
		qua_manager.push_back_quaternion(QuaDef.GLO_ARG, ctx.LEFT_BRACKET().getSymbol().getLine());
		
		visitArgument_list(ctx.argument_list());
		
		qua_manager.push_back_quaternion(QuaDef.GLO_ARG_END, ctx.RIGHT_BRACKET().getSymbol().getLine());
		qua_manager.push_back_quaternion(QuaDef.GLO_INV, ctx.INVARIANT().getSymbol().getLine());
		qua_manager.push_back_quaternion(QuaDef.GLO_INV_END, ctx.ATTRIBUTE().getSymbol().getLine() - 1);
		qua_manager.push_back_quaternion(QuaDef.GLO_ATT, ctx.ATTRIBUTE().getSymbol().getLine());
		
		qua_manager.push_back_quaternion(QuaDef.GLO_CON_DEC);
		if(ctx.const_interupt() != null){
			qua_manager.set_last_qua_line_num(ctx.const_interupt().getStart().getLine());
			visitConst_interupt(ctx.const_interupt());
		}
		
		qua_manager.push_back_quaternion(QuaDef.GLO_CON_DEC_END);
		qua_manager.push_back_quaternion(QuaDef.GLO_VAL_DEC);
		if(ctx.valuable_interupt() != null){
			qua_manager.set_last_qua_line_num(ctx.valuable_interupt().getStart().getLine());
			visitValuable_interupt(ctx.valuable_interupt());
		}
		qua_manager.push_back_quaternion(QuaDef.GLO_VAL_DEC_END);
		qua_manager.push_back_quaternion(QuaDef.GLO_ATT_END);
		
		qua_manager.push_back_quaternion(QuaDef.FUNC_DEC);
		if(ctx.function_declare() != null){
			for(int i = 0; i < ctx.function_declare().size(); i++){
				visitFunction_declare(ctx.function_declare(i));
			}
		}
		qua_manager.push_back_quaternion(QuaDef.FUNC_DEC_END);
		qua_manager.push_back_quaternion(QuaDef.FUNC_DEF);
		if(ctx.function_define() != null){
			for(int i = 0; i < ctx.function_define().size(); i++){
				visitFunction_define(ctx.function_define(i));
			}
		}
		qua_manager.push_back_quaternion(QuaDef.FUNC_DEF_END);
		qua_manager.push_back_quaternion(QuaDef.GLO_DEC_END);
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitFunction_declare(@NotNull GrammarBParser.Function_declareContext ctx) {
		String cur_return_type;
		if(ctx.start.getType() != GrammarBParser.VOID){
			cur_return_type = ctx.have_return_declare().type().getText();
			printQuaternion("func " + cur_return_type);
			visitReturn_declare(ctx.have_return_declare().return_declare());
		}
		else{
			cur_return_type = "void";
			printQuaternion("func " + cur_return_type);
			visitReturn_declare(ctx.no_return_declare().return_declare());
		}
		printQuaternion("func end");
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitReturn_declare(@NotNull GrammarBParser.Return_declareContext ctx) {
		String func_name = ctx.ID().getText();
		printQuaternion("name " + func_name);
		visitArgument_list(ctx.argument_list());
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitArgument_list(@NotNull GrammarBParser.Argument_listContext ctx) { 
		if(ctx != null){
			for(int i = 0; i < ctx.type().size(); i++){
				qua_manager.push_back_quaternion(
						QuaDef.ARG,
						new CData(DataDef.TYPE, DataDef.get_data_def_from_parser(ctx.type(i).start.getType())),
						new CData(DataDef.ID, ctx.ID(i).getText()),
						ctx.ID(i).getSymbol().getLine()
						);
			}
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitFunction_define(@NotNull GrammarBParser.Function_defineContext ctx) { 
		if(ctx.start.getType() != GrammarBParser.VOID){
			qua_manager.push_back_quaternion(
				QuaDef.FUNC,
				new CData(DataDef.INT, int_to_str(ctx.have_return_define().type().start.getType())),
				ctx.have_return_define().type().start.getLine()
			);
			visitReturn_define(ctx.have_return_define().return_define());
			qua_manager.push_back_quaternion(QuaDef.FUNC_END, 
					ctx.have_return_define().return_define().RIGHT_BRACE().getSymbol().getLine());
		}
		else{
			qua_manager.push_back_quaternion(
				QuaDef.FUNC,
				new CData(DataDef.INT, int_to_str(ctx.no_return_define().VOID().getSymbol().getType())),
				ctx.have_return_define().type().start.getLine()
			);
			visitReturn_define(ctx.no_return_define().return_define());
			qua_manager.push_back_quaternion(QuaDef.FUNC_END, 
					ctx.no_return_define().return_define().RIGHT_BRACE().getSymbol().getLine());
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitReturn_define(@NotNull GrammarBParser.Return_defineContext ctx) { 
		String func_name = ctx.ID().getText();
		qua_manager.push_back_quaternion(
			QuaDef.NAME,
			new CData(DataDef.ID, func_name),
			ctx.ID().getSymbol().getLine()
		);
		qua_manager.push_back_quaternion(QuaDef.FUNC_ARG, ctx.LEFT_BRACKET().getSymbol().getLine());
		visitArgument_list(ctx.argument_list());
		qua_manager.push_back_quaternion(QuaDef.FUNC_ARG_END, ctx.RIGHT_BRACKET().getSymbol().getLine());
		visitMulti_stat(ctx.multi_stat());
		return null;
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitCondition_stat(@NotNull GrammarBParser.Condition_statContext ctx) { 
		CQuaternion	else_stat_label = get_current_label();
		CData cur_condition_result = visitConditionRD(ctx.condition());
		
		qua_manager.push_back_quaternion(
				QuaDef.IFNOT,
				cur_condition_result,
				else_stat_label.data_0,
				ctx.condition().start.getLine()
				);
		
		//deal stats between if and else
		if(ctx.stat() != null){
			for(int i = 0; i < ctx.stat().size(); i++){
				visitStat(ctx.stat(i));
			}
		}
		
		if(ctx.else_stat() != null){
			//if have else
			CQuaternion out_stat_lable = get_current_label();
			//go out of condition stat
			qua_manager.push_back_quaternion(
					QuaDef.GOTO_I,
					out_stat_lable.data_0,
					CQuaternion.NO_USE_LINE_NUM
					);
			
			//deal stats after else
			qua_manager.push_back_quaternion(else_stat_label);
			visitElse_stat(ctx.else_stat());
			qua_manager.push_back_quaternion(out_stat_lable);
		}
		else{
			//if have no else
			qua_manager.push_back_quaternion(else_stat_label);
		}
		return null; 
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitElse_stat(@NotNull GrammarBParser.Else_statContext ctx) { 
		if(ctx.stat() != null){
			for(int i = 0; i < ctx.stat().size(); i++){
				visitStat(ctx.stat(i));
			}
		}
		return null; 
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitChange_1(@NotNull GrammarBParser.Change_1Context ctx) { 
		if(ctx.change_2() != null){
			String 	temp_1_result 		= visitChange_1_temp_1(ctx.change_1_temp_1()),
					change_2_result 	= visitChange_2(ctx.change_2());
			if(change_2_result == null){
				return temp_1_result;
			}
			else{
				return null;
			}
		}
		else if(ctx.change_3() != null){
			return null;
		}
		else if(ctx.proposition() != null){
			return null;
		} 
		return null;
	}
	
	public CData visitChange_1RD(@NotNull GrammarBParser.Change_1Context ctx) {
		if(ctx.change_2() != null){
			CData 	temp_1_result 		= visitChange_1_temp_1RD(ctx.change_1_temp_1()),
					change_2_result 	= visitChange_2RD(ctx.change_2());
			if(change_2_result == null){
				return temp_1_result;
			}
			else{
				return null;
			}
		}
		else if(ctx.change_3() != null){
			return null;
		}
		else if(ctx.proposition() != null){
			return null;
		} 
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitChange_2(@NotNull GrammarBParser.Change_2Context ctx) { return visitChildren(ctx); }
	
	public CData visitChange_2RD(@NotNull GrammarBParser.Change_2Context ctx) {
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitChange_3(@NotNull GrammarBParser.Change_3Context ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public String visitChange_4(@NotNull GrammarBParser.Change_4Context ctx) { return visitChildren(ctx); }
	
	public CData visitChange_4RD(@NotNull GrammarBParser.Change_4Context ctx) {
		return null;
	}
}
