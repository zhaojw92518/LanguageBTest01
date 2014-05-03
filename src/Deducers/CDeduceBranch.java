package Deducers;
import Defines.DeduceDef;


/**
 * left_data is false
 * right_data is true
 * @author zhao
 *
 */
public class CDeduceBranch extends CDeduceExpr {
	private CDeduceExpr cond = null;
	public CDeduceBranch(CDeduceExpr in_cond, CDeduceExpr in_false_expr, CDeduceExpr in_true_expr){
		super(DeduceDef.IF, in_false_expr, in_true_expr);
		cond = in_cond;
	}
	
	public String toString(){
		return "!(" + cond.toString() + ") -> (" + left_data.toString() + ") /\\ ("
				+ cond.toString() + ") -> (" + right_data.toString() + ")";
	}
}
