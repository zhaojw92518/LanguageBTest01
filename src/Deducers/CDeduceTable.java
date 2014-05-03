package Deducers;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;

import Defines.DataDef;
import Defines.DeduceDef;
import PackageMsg.COptionMsg;

public class CDeduceTable {
	private HashMap<String, CDeduceTerm> term_list = new HashMap<String, CDeduceTerm>();
	private HashMap<String, DataDef> type_list = new HashMap<String, DataDef>();
	/*
	 * Private Functions
	 */

	private void add_term(String in_id, CDeduceTerm in_term){
		term_list.put(in_id, in_term);
	}
	
	/*
	 * Consturcotr
	 */
	
	public CDeduceTable(){
		
	}
	
	public CDeduceTable(CDeduceTable in_table){
		for(Map.Entry<String, CDeduceTerm> cur_entry: in_table.term_list.entrySet()){
			term_list.put(cur_entry.getKey(), new CDeduceTerm(cur_entry.getValue()));
		}
	}
	
	public void clear_list(){
		term_list.clear();
	}
	
	/*
	 * Interfaces 
	 */
	
	public void create_new_term(String in_id, DataDef in_type){
		this.add_term(in_id, new CDeduceTerm(in_type));
	}
	
	public boolean if_have_term(String in_id){
		return term_list.containsKey(in_id);
	}
	
	public void set_term(String in_id, CDeduceExpr in_expr){
		CDeduceTerm temp_term = term_list.get(in_id);
		temp_term.add_data(in_expr);
	}
	
	public void set_term(String in_id, CSetStruct in_set_struct){
		CDeduceTerm temp_term = term_list.get(in_id);
		temp_term.add_data(in_set_struct);
	}
	
	public void set_term(String in_id, DeduceDef in_type, CDeduceExpr in_left_expr, CDeduceExpr in_right_expr){
		CDeduceTerm temp_term = term_list.get(in_id);
		temp_term.add_data(in_type, in_left_expr, in_right_expr);
	}
	
	public void set_cir_term(String in_id, CDeduceExpr in_expr){
		CDeduceTerm temp_term = term_list.get(in_id);
		temp_term.add_cir_data(in_expr);
	}
	
	public void set_cir_term(String in_id, CSetStruct in_set_struct){
		CDeduceTerm temp_term = term_list.get(in_id);
		temp_term.add_cir_data(in_set_struct);
	}
	
	public CDeduceTerm get_term(String in_id){
		return term_list.get(in_id);
	}
	
	public DataDef get_term_type(String in_id){
		return term_list.get(in_id).get_type();
	}
	
	public LinkedList<String> get_terms_list(){
		LinkedList<String> return_result = new LinkedList<String>();
		for(Map.Entry<String, CDeduceTerm> cur_entry: term_list.entrySet()){
			return_result.add(cur_entry.getKey() + " : " + cur_entry.getValue().toString());
		}
		return return_result;
	}
	
	/**
	 * 将所有的值全部初始化为自己的变量名
	 */
	public void loop_init(){
		for(Map.Entry<String, CDeduceTerm> cur_entry: term_list.entrySet()){
			if(cur_entry.getValue().get_type() == DataDef.VALUE){
				cur_entry.setValue(new CDeduceTerm(cur_entry.getKey()));
			}
			else if(cur_entry.getValue().get_type() == DataDef.SET){
				CSetStruct cur_set_struct = new CSetStruct(cur_entry.getKey());
				cur_entry.setValue(new CDeduceTerm(cur_set_struct));
			}
		}
	}
	
	public String get_deduce_str(String in_id){
		CDeduceTerm cur_term = get_term(in_id);
		return in_id + "[" + cur_term.get_cur_gen_age_str() + "] = " + cur_term.get_cur_gen_data_str();
	}
	
	/*
	 * UI
	 */
	
	public LinkedList<DefaultMutableTreeNode> get_tree_nodes(COptionMsg in_option_msg){
		LinkedList<DefaultMutableTreeNode> return_result = new LinkedList<DefaultMutableTreeNode>();
		for(Map.Entry<String, CDeduceTerm> cur_entry: term_list.entrySet()){
			if(!CData.judge_temp(cur_entry.getKey())){
				DefaultMutableTreeNode cur_node = new DefaultMutableTreeNode(cur_entry.getKey());
				cur_node.add(cur_entry.getValue().get_change_map_tree_nodes(in_option_msg));
				LinkedList<DefaultMutableTreeNode> cur_list = cur_entry.getValue().get_tree_nodes();
				for(DefaultMutableTreeNode cur_sub_node: cur_list){
					cur_node.add(cur_sub_node);
				}
				return_result.add(cur_node);
			}
		}
		return return_result;
	}
}
