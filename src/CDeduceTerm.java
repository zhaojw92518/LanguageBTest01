import java.util.LinkedList;


public class CDeduceTerm {
	private LinkedList<CDeduceExpr> data_family = new LinkedList<CDeduceExpr>();
	
	public CDeduceTerm(String in_data){
		this.add_data(new CDeduceExpr(DeduceDef.DATA, in_data, null, null));
	}
	
	public CDeduceTerm(){
		data_family.add(new CDeduceExpr());
	}
	
	public CDeduceTerm(CDeduceTerm in_term){
		for(CDeduceExpr cur_expr: in_term.data_family){
			data_family.add(new CDeduceExpr(cur_expr));
		}
	}
	
	public CDeduceExpr get_cur_data(){
		CDeduceExpr return_result = null;
		if(!data_family.isEmpty()){
			return_result = data_family.getLast();
		}
		return return_result;
	}
	
	public void add_data(DeduceDef in_type, CDeduceExpr left_value, CDeduceExpr right_value){
		CDeduceExpr cur_data = new CDeduceExpr(in_type, left_value, right_value);
		data_family.add(cur_data);
	}
	
	public void add_data(CDeduceExpr in_expr){
		data_family.add(in_expr);
	}
	
	public String toString(){
		String return_result = new String();
		for(CDeduceExpr cur_expr: data_family){
			return_result += cur_expr.toString() + ", "; 
		}
		return return_result;
	}
	
	public Integer get_cur_age(){
		return new Integer(data_family.size());
	}
}
