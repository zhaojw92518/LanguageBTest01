import java.util.LinkedList;
import java.util.Map;


public class CDeduceTableMagr {
	private CDeduceTable global_table = new CDeduceTable();
	private LinkedList<CDeduceTable> local_tables = new LinkedList<CDeduceTable>();
	private LinkedList<String> function_names = new LinkedList<String>();
	
	
	public CDeduceTableMagr(){
		
	}
	
	public CDeduceTableMagr(CDeduceTableMagr in_magr){
		this.global_table = new CDeduceTable(in_magr.global_table);
		for(CDeduceTable cur_table: in_magr.local_tables){
			this.local_tables.add(new CDeduceTable(cur_table));
		}
		for(String cur_name: in_magr.function_names){
			this.function_names.add(new String(cur_name));
		}
	}
	
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
	
	public void create_global_term(String in_id){
		global_table.create_new_term(in_id);
	}
	
	public void create_global_term(CData in_data){
		this.create_global_term(in_data.data_str);
	}
	
	public void create_local_term(String in_id){
		if(global_if_have_term(in_id)){
			//To-do: 全局变量与局部变量重名
		}
		else{
			local_tables.getLast().create_new_term(in_id);
		}
	}
	
	public void create_local_term(CData in_data){
		this.create_local_term(in_data.data_str);
	}
	
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
	
	//做变量赋值时使用，若参数表示的是临时变量，且改变量未创建，则创建，返回当前本地变量表
	public CDeduceTable get_table_across_id(CData in_data){
		CDeduceTable return_result = this.if_have_term(in_data.data_str);
		if(return_result == null && in_data.if_temp()){
			this.create_local_term(in_data);
			return_result = this.local_tables.getLast();
		}
		else{
			//To-do 未定义变量错误处理
		}
		return return_result;
	}
	
	
	
	public void push_back_table(){
		local_tables.add(new CDeduceTable());
	}
	
	public void pop_back_table(){
		local_tables.getLast().clear_list();
		local_tables.pollLast();
	}
	
	public void push_back_func_name(String in_name){
		function_names.add(in_name);
	}
	
	public void pop_back_func_name(){
		function_names.pollLast();
	}
	
	public String get_cur_func_name(){
		return function_names.getLast();
	}
	
	public boolean if_have_label(int in_label){
		return local_tables.getLast().if_have_label(in_label);
	}
	
	public int get_lable_qua_num(int in_label){
		return local_tables.getLast().get_label_qua_num(in_label);
	}
	
	public void add_lable(int in_label, int in_qua_num){
		local_tables.getLast().add_label(in_label, in_qua_num);
	}
	
	public void set_local_term(String in_id, DeduceDef in_type, CDeduceExpr in_left_expr, CDeduceExpr in_right_expr){
		local_tables.getLast().set_term(in_id, in_type, in_left_expr, in_right_expr);
	}
	
	public void set_local_term(String in_id, String in_data){
		local_tables.getLast().set_term(in_id, new CDeduceExpr(in_data));
	}
	
	public void set_global_term(String in_id, DeduceDef in_type, CDeduceExpr in_left_expr, CDeduceExpr in_right_expr){
		global_table.set_term(in_id, in_type, in_left_expr, in_right_expr);
	}
	
	public void set_global_term(String in_id, String in_data){
		global_table.set_term(in_id, new CDeduceExpr(in_data));
	}
	
	public void set_term(CData in_id_data, String in_data){
		this.set_term(in_id_data, new CDeduceExpr(in_data));
	}
	
	public void set_term(CData in_id_data, DeduceDef in_type, CDeduceExpr left_expr, CDeduceExpr right_expr){
		this.set_term(in_id_data, new CDeduceExpr(in_type, left_expr, right_expr));
	}
	
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
		if(if_loop){
			System.out.println("Loop Values");
			print_line();
			for(Map.Entry<CData, String> cur_entry: loop_value_list.values.entrySet()){
				System.out.print(cur_entry.getKey().data_str);
				System.out.print(" : ");
				System.out.println(this.get_term(cur_entry.getKey()).get_cur_data().toString());
			}
			print_line();
		}
	}
	
	public void set_term(CData in_id_data, CDeduceExpr in_expr){
		CDeduceTable cur_table = get_table_across_id(in_id_data);
		if(cur_table != null){
			cur_table.set_term(in_id_data.data_str, in_expr);
			if(if_loop && !in_id_data.if_temp()){
				loop_value_list.create_value(in_id_data);
			}
		}
	}
	
	//处理推演表达式的生成
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
	
	//处理循环推演
	private boolean if_loop = false;
	private CLoopValueList loop_value_list = new CLoopValueList();
	
	public void start_loop_mode(){
		if_loop = true;
	}
	
	public void close_loop_mode(){
		if_loop = false;
	}
	
	public void set_loop_value_list(String in_id, String in_data){
		loop_value_list.set_value(in_id, in_data);
	}
	
	public CLoopValueList get_cur_loop_value_list(){
		return loop_value_list;
	}
	
	public boolean get_if_loop(){
		return if_loop;
	}
}
