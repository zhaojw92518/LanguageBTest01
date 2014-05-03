package Deducers;

import java.util.LinkedList;
import java.util.logging.Level;

public class CConditionMgr {
	private LinkedList<CConditionGroup> conditions = new LinkedList<CConditionGroup>();
	private int cur_level = 0;
	
	private int cur_loop_count = 1;
	
	private boolean if_have_condition_qua = false;
	
	public CConditionMgr() {
		// TODO Auto-generated constructor stub
	}
	
	public void add_conditions(CDeduceExpr in_condition, int in_index, CDeduceTableMgr in_context, int in_loop_count){
		conditions.add(new CConditionGroup(in_condition, in_index, in_context, cur_level, in_loop_count));
		cur_level++;
	}
	public boolean if_empty(){
		return conditions.isEmpty();
	}
	
	public CDeduceExpr get_cur_condition_value(){
		return conditions.getLast().condition_value;
	}
	
	public int get_cur_condition_index(){
		return conditions.getLast().begin_qua_index;
	}
	
	public int get_cur_completed_loop_count(){
		return conditions.getLast().completed_loop_count;
	}
	
	public void terminate_cur_condition(){
		cur_level = conditions.getLast().condition_level;
		conditions.pollLast();
	}
	
	public void inc_level(){
		cur_level++;
	}
	
	public void init_level(){
		cur_level = 0;
	}
	
	public void dec_level(){
		cur_level--;
	}
	
	public int get_conditions_count(){
		return conditions.size();
	}
	
	public CDeduceTableMgr get_cur_condition_context(){
		return conditions.getLast().condition_context;
	}
	
	public String get_indent_str(){
		String return_result = new String();
		for(int i = 0; i < cur_level; i++){
			return_result += "    ";
		}
		return return_result;
	}
	
	public void init_loop_count(){
		cur_loop_count = 1;
	}
	
	public void inc_loop_count(){
		if(if_have_condition_qua){
			cur_loop_count++;
		}
	}
	
	public int get_cur_loop_count(){
		return cur_loop_count;
	}
	
	public void start_condition_mgr(){
		if_have_condition_qua = true;
	}
	
	public void close_condition_mgr(){
		if_have_condition_qua = false;
	}
	
	class CConditionGroup{
		CDeduceExpr condition_value = null;
		int begin_qua_index = -1, condition_level = -1;
		CDeduceTableMgr condition_context = null;
		int completed_loop_count = 1;
		
		public CConditionGroup(CDeduceExpr in_condition, int in_index, CDeduceTableMgr in_context, int in_level, int in_loop_count){
			condition_value = in_condition.dup();
			begin_qua_index = in_index;
			condition_context = new CDeduceTableMgr(in_context);
			condition_level = in_level;
			completed_loop_count = in_loop_count;
		}
	}
}
