import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CDeduceTable {
	private HashMap<String, CDeduceTerm> term_list = new HashMap<String, CDeduceTerm>();
	private HashMap<Integer, Integer> label_list = new HashMap<Integer, Integer>();
	
	public CDeduceTable(){
		
	}
	
	public CDeduceTable(CDeduceTable in_table){
		for(Map.Entry<String, CDeduceTerm> cur_entry: in_table.term_list.entrySet()){
			term_list.put(cur_entry.getKey(), cur_entry.getValue());
		}
		
		for(Map.Entry<Integer, Integer> cur_entry: in_table.label_list.entrySet()){
			label_list.put(cur_entry.getKey(), cur_entry.getValue());
		}
	}
	
	private void push_back_term(String in_id, CDeduceTerm in_term){
		term_list.put(in_id, in_term);
	}
	
	public void create_new_term(String in_id){
		this.push_back_term(in_id, new CDeduceTerm());
	}
	
	public boolean if_have_term(String in_id){
		return term_list.containsKey(in_id);
	}
	
	public void set_term(String in_id, CDeduceExpr in_expr){
		CDeduceTerm temp_term = term_list.get(in_id);
		temp_term.add_data(in_expr);
	}
	
	public void set_term(String in_id, DeduceDef in_type, CDeduceExpr in_left_expr, CDeduceExpr in_right_expr){
		CDeduceTerm temp_term = term_list.get(in_id);
		temp_term.add_data(in_type, in_left_expr, in_right_expr);
	}
	
	public void clear_list(){
		term_list.clear();
		label_list.clear();
	}
	
	public CDeduceTerm get_term(String in_id){
		return term_list.get(in_id);
	}
	
	public boolean if_have_label(int in_label){
		return label_list.containsKey(new Integer(in_label));
	}
	
	public int get_label_qua_num(int in_label){
		return label_list.get(new Integer(in_label)).intValue();
	}
	
	public void add_label(int in_label, int in_qua_num){
		label_list.put(new Integer(in_label), new Integer(in_qua_num));
	}
	
	public LinkedList<String> get_terms_list(){
		LinkedList<String> return_result = new LinkedList<String>();
		for(Map.Entry<String, CDeduceTerm> cur_entry: term_list.entrySet()){
			return_result.add(cur_entry.getKey() + " : " + cur_entry.getValue().toString());
		}
		return return_result;
	}
}
