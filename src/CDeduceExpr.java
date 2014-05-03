
public class CDeduceExpr {
	public DeduceDef type = null;
	public String data = null;
	public CDeduceExpr left_data = null, right_data = null;
	
	public CDeduceExpr(DeduceDef in_type, String in_data, CDeduceExpr in_left_data, CDeduceExpr in_right_data){
		type = in_type;
		data = in_data;
		left_data = in_left_data;
		right_data = in_right_data;
	}
	
	public CDeduceExpr(DeduceDef in_type, CDeduceExpr in_left_data, CDeduceExpr in_right_data){
		type = in_type;
		left_data = in_left_data;
		right_data = in_right_data;
	}
	
	public CDeduceExpr(String in_data){
		type = DeduceDef.DATA;
		data = in_data;
	}
	
	public CDeduceExpr(CDeduceExpr in_expr){
		type = in_expr.type;
		data = in_expr.data;
		left_data = new CDeduceExpr(in_expr.left_data);
		right_data = new CDeduceExpr(in_expr.right_data);
	}
	
	public CDeduceExpr(){
		type = DeduceDef.DATA;
		data = "null";
	}
	
	public String toString(){
		String return_result = null;
		if(type == DeduceDef.DATA){
			return_result = data;
		}
		else{
			if(right_data == null){
				return_result = type.toString() + "(" + left_data.toString() + ")";
			}
			else{
				return_result = type.toString() + "(" + left_data.toString() + "," 
						+ right_data.toString() + ")"; 
			}
		}
		return return_result;
	}
}
