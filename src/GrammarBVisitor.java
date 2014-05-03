// Generated from .\GrammarB.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarBParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarBVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarBParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull GrammarBParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#valuable_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuable_declare(@NotNull GrammarBParser.Valuable_declareContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#proposition_term_3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProposition_term_3(@NotNull GrammarBParser.Proposition_term_3Context ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#proposition_term_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProposition_term_2(@NotNull GrammarBParser.Proposition_term_2Context ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#proposition_term_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProposition_term_1(@NotNull GrammarBParser.Proposition_term_1Context ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#proposition_term_0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProposition_term_0(@NotNull GrammarBParser.Proposition_term_0Context ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull GrammarBParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#proposition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProposition(@NotNull GrammarBParser.PropositionContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#math_relation_proposition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_relation_proposition(@NotNull GrammarBParser.Math_relation_propositionContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#have_return_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHave_return_declare(@NotNull GrammarBParser.Have_return_declareContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#no_return_define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNo_return_define(@NotNull GrammarBParser.No_return_defineContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#set_term_0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_term_0(@NotNull GrammarBParser.Set_term_0Context ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#set_term_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_term_1(@NotNull GrammarBParser.Set_term_1Context ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(@NotNull GrammarBParser.ElementContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#have_return_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHave_return_call(@NotNull GrammarBParser.Have_return_callContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#valuable_interupt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuable_interupt(@NotNull GrammarBParser.Valuable_interuptContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull GrammarBParser.ConditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#no_return_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNo_return_call(@NotNull GrammarBParser.No_return_callContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#set_relation_proposition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_relation_proposition(@NotNull GrammarBParser.Set_relation_propositionContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#circulate_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCirculate_stat(@NotNull GrammarBParser.Circulate_statContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#have_return_define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHave_return_define(@NotNull GrammarBParser.Have_return_defineContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#expression_expand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_expand(@NotNull GrammarBParser.Expression_expandContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#function_define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_define(@NotNull GrammarBParser.Function_defineContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#multi_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulti_stat(@NotNull GrammarBParser.Multi_statContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#element_group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement_group(@NotNull GrammarBParser.Element_groupContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#return_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_declare(@NotNull GrammarBParser.Return_declareContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#argument_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument_list(@NotNull GrammarBParser.Argument_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#value_argument_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_argument_list(@NotNull GrammarBParser.Value_argument_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(@NotNull GrammarBParser.SetContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#math_relation_symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_relation_symbol(@NotNull GrammarBParser.Math_relation_symbolContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#return_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stat(@NotNull GrammarBParser.Return_statContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#const_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_declare(@NotNull GrammarBParser.Const_declareContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#muldiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMuldiv(@NotNull GrammarBParser.MuldivContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#element_set_relation_proposition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement_set_relation_proposition(@NotNull GrammarBParser.Element_set_relation_propositionContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#const_interupt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_interupt(@NotNull GrammarBParser.Const_interuptContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#return_define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_define(@NotNull GrammarBParser.Return_defineContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#signed_real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSigned_real(@NotNull GrammarBParser.Signed_realContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#no_return_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNo_return_declare(@NotNull GrammarBParser.No_return_declareContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#change_1_temp_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChange_1_temp_2(@NotNull GrammarBParser.Change_1_temp_2Context ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(@NotNull GrammarBParser.FactorContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#assign_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stat(@NotNull GrammarBParser.Assign_statContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#signed_integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSigned_integer(@NotNull GrammarBParser.Signed_integerContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#change_1_temp_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChange_1_temp_1(@NotNull GrammarBParser.Change_1_temp_1Context ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull GrammarBParser.StatContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#addsub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddsub(@NotNull GrammarBParser.AddsubContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#abstact_machine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstact_machine(@NotNull GrammarBParser.Abstact_machineContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull GrammarBParser.TermContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#change_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChange_1(@NotNull GrammarBParser.Change_1Context ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#condition_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_stat(@NotNull GrammarBParser.Condition_statContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#function_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_declare(@NotNull GrammarBParser.Function_declareContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#change_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChange_2(@NotNull GrammarBParser.Change_2Context ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#change_3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChange_3(@NotNull GrammarBParser.Change_3Context ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#change_4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChange_4(@NotNull GrammarBParser.Change_4Context ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarBParser#else_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_stat(@NotNull GrammarBParser.Else_statContext ctx);
}