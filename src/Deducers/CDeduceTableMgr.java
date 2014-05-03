package Deducers;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;

import Defines.DeduceDef;
import PackageMsg.COptionMsg;


public class CDeduceTableMgr {
	private CDeduceTable global_table = new CDeduceTable();
	private LinkedList<CDeduceTable> local_tables = new LinkedList<CDeduceTable>();
	private LinkedList<String> function_names = new LinkedList<String>();
	
	/*
	 * Private Funcitions
	 */
	
	private void set_local_term(String in_id, DeduceDef in_type, CDeduceExpr in_left_expr, CDeduceExpr in_right_expr){
		local_tables.getLast().set_term(in_id, in_type, in_left_expr, in_right_expr);
	}
	
	private void set_local_term(String in_id, String in_data){
		local_tables.getLast().set_term(in_id, new CDeduceExpr(in_data));
	}
	
	private void set_global_term(String in_id, DeduceDef in_type, CDeduceExpr in_left_expr, CDeduceExpr in_right_expr){
		global_table.set_term(in_id, in_type, in_left_expr, in_right_expr);
	}
	
	private void set_global_term(String in_id, String in_data){
		global_table.set_term(in_id, new CDeduceExpr(in_data));
	}
	
	/*
	 * Constructors
	 */
	
	public CDeduceTableMgr(){
		
	}
	
	public CDeduceTableMgr(CDeduceTableMgr in_magr){
		this.global_table = new CDeduceTable(in_magr.global_table);
		for(CDeduceTable cur_table: in_magr.local_tables){
			this.local_tables.add(new CDeduceTable(cur_table));
		}
		for(String cur_name: in_magr.function_names){
			this.function_names.add(new String(cur_name));
		}
	}
	
	/*
	 * Interfaces
	 */
	
	/*
	 * groups of judge
	 */
	
	public boolean global_if_have_term(String in_id){
		return global_table.if_have_term(in_id);
	}
	
	public boolean local_if_have_term(String in_id){
		boolean return_result = false;
		if(!local_tables.isEmpty()){
			return_result = local_tables.getLast().if_have_term(in_id);
		}
		return return_result;
	}
	
	//if there is the term in list, return is the list(global or local),
	//else return is null
	public CDeduceTable if_have_term(String in_id){
		CDeduceTable return_result = null;
		if(global_if_have_term(in_id)){
			return_result = global_table;
		}
		else if(local_if_have_term(in_id)){
			return_result = local_tables.getLast();
		}
		return return_result;
	}
	
	/*
	 * groups of get
	 */
	
	public CDeduceTerm get_term(String in_id){
		CDeduceTerm return_result = null;
		if(local_tables.getLast().if_have_term(in_id)){
			return_result = local_tables.getLast().get_term(in_id);
		}
		else if(global_table.if_have_term(in_id)){
			return_result = global_table.get_term(in_id);
		}
		return return_result;
	}
	
	public CDeduceTerm get_term(CData in_id_data){
		return this.get_term(in_id_data.data_str);
	}
	
	public CDeduceExpr get_cur_expr(String in_id){
		CDeduceExpr return_result = null;
		CDeduceTerm cur_term = this.get_term(in_id);
		if(cur_term != null){
			return_result = cur_term.get_cur_data();
		}
		return return_result;
	}
	
	public String get_cur_func_name(){
		return function_names.getLast();
	}
	
	public String get_cur_deduce_str(CData in_id_data){
		//内部处理，不做检查
		CDeduceTable cur_table = get_table_across_id(in_id_data);
		return cur_table.get_deduce_str(in_id_data.data_str);
	}
	
	/**
	 * 若为临时变量且未声明，则声明，返回当前符号表
	 * @param in_data
	 * @return
	 */
	public CDeduceTable get_table_across_id(CData in_id_data){
		CDeduceTable return_result = this.if_have_term(in_id_data.data_str);
		if(return_result == null && CData.judge_temp(in_id_data)){
			this.create_local_term(in_id_data);
			return_result = this.local_tables.getLast();
		}
		else if(return_result == null){
			//TODO 对未声明变量的处理
		}
		return return_result;
	}
	
	/*
	 * group of set
	 */
	
	/**
	 * 将所有的值全部初始化为自己的变量名
	 */
	public void loop_init_all_tables(){
		global_table.loop_init();
		for(CDeduceTable cur_table: local_tables){
			cur_table.loop_init();
		}
	}
	
	public void set_term(CData in_id_data, CDeduceExpr in_expr){
		CDeduceTable cur_table = get_table_across_id(in_id_data);
		if(cur_table != null){
			cur_table.set_term(in_id_data.data_str, in_expr);
		}
	}
	
	/**
	 * 由于in_id_data必定源自于符号表中存在的值，所以在此不检查
	 * @param in_id_data
	 * @param in_expr
	 */
	public void set_cir_term(CData in_id_data, CDeduceExpr in_expr){
		CDeduceTable cur_table = get_table_across_id(in_id_data);
		cur_table.set_cir_term(in_id_data.data_str, in_expr);
	}
	
	/*
	 * group of create
	 */
	
	public void create_global_term(String in_id){
		global_table.create_new_term(in_id);
	}
	
	public void create_global_term(CData in_data){
		this.create_global_term(in_data.data_str);
	}
	
	public void create_local_term(String in_id){
		if(global_if_have_term(in_id)){
			//TODO 处理声明局部变量时与全局变量重名
		}
		else{
			local_tables.getLast().create_new_term(in_id);
		}
	}
	
	public void create_local_term(CData in_data){
		this.create_local_term(in_data.data_str);
	}
	
	/*
	 * group of add
	 */
	
	public void add_table(){
		local_tables.add(new CDeduceTable());
	}
	
	public void add_func_name(String in_name){
		function_names.add(in_name);
	}
	
	/*
	 * group of pop
	 */
	
	public void pop_table(){
		local_tables.getLast().clear_list();
		local_tables.pollLast();
	}
	
	public void pop_func_name(){
		function_names.pollLast();
	}
	
	/*
	 * Debug Code
	 */
	
	private void print_line(){
		for(int i = 0; i < 20; i++){
			System.out.print("=");
		}
		System.out.println();
	}
	
	public void print_all_value(){
		LinkedList<String> temp_list = null;
		print_line();
		System.out.println("Global Table");
		print_line();
		temp_list = global_table.get_terms_list();
		for(String cur_str: temp_list){
			System.out.println(cur_str);
		}
		print_line();
		for(int i = 0; i < local_tables.size(); i++){
			System.out.println(i);
			print_line();
			temp_list = local_tables.get(i).get_terms_list();
			for(String cur_str: temp_list){
				System.out.println(cur_str);
			}
			print_line();
		}
	}
	
	public String get_deduce_str(CData in_id_data){
		String return_result = null;
		CDeduceTerm cur_term = get_term(in_id_data);
		if(cur_term != null){
			return_result = 
					in_id_data.data_str + 
					"[" + cur_term.get_cur_age().toString() + "] = " + 
					cur_term.get_cur_data().toString();
		}
		return return_result;
	}
	
	/*
	 * UI
	 */
	
	private void list_to_node(LinkedList<DefaultMutableTreeNode> in_list, DefaultMutableTreeNode in_node){
		for(DefaultMutableTreeNode cur_node: in_list){
			in_node.add(cur_node);
		}
	}
	
	public LinkedList<DefaultMutableTreeNode> get_tree_nodes(COptionMsg in_option_msg){
		LinkedList<DefaultMutableTreeNode> return_result = new LinkedList<DefaultMutableTreeNode>();
		DefaultMutableTreeNode global_node = new DefaultMutableTreeNode("Global");
		LinkedList<DefaultMutableTreeNode> global_list = global_table.get_tree_nodes(in_option_msg);
		list_to_node(global_list, global_node);
		return_result.add(global_node);
		for(int i = 0; i < local_tables.size(); i++){
			DefaultMutableTreeNode cur_local_node = new DefaultMutableTreeNode(i);
			LinkedList<DefaultMutableTreeNode> cur_local_list = local_tables.get(i).get_tree_nodes(in_option_msg);
			list_to_node(cur_local_list, cur_local_node);
			return_result.add(cur_local_node);
		}
		return return_result;
	}
}
