package Deducers;
import java.util.HashMap;
import java.util.LinkedList;

import ContextUI.CGlobalStaticSource;
import Defines.DataDef;
import Defines.LoopStackDef;
import Parsers.CDataEntity;

public class CLoopBlockMgr {
	private LinkedList<CLoopBlockStack> loop_block_stacks = new LinkedList<CLoopBlockStack>();
	
	private CLoopBlockStack temp_stack = null;
	private CLoopBlock cur_loop_block = null;
	private LinkedList<String> deduce_strs = new LinkedList<String>();
	
	
	public void add_begin_index(int in_index){
		if(temp_stack == null){
			temp_stack = new CLoopBlockStack();
		}
		temp_stack.add_begin_index(in_index);
	}
	
	public void add_end_index(int in_index){
		temp_stack.add_end_index(in_index);
		LoopStackDef result = temp_stack.get_stack_state();
		if(result == LoopStackDef.CLOSED){
			loop_block_stacks.add(temp_stack);
			temp_stack = null;
		}
	}
	
	public LoopStackDef update(){
		//Debug
		if(cur_loop_block != null){
			cur_loop_block.print_all_input_args();
			cur_loop_block.print_all_output_args();
		}
		//Debug end
		LoopStackDef return_result = LoopStackDef.ERROR;
		//清空推演字符串组
		deduce_strs.clear();
		
		if(loop_block_stacks.isEmpty()){
			//如果没有栈，则返回完成
			return_result = LoopStackDef.COMPLETED;
		}
		else{
			//如果当前有栈
			CLoopBlock temp_loop_block = loop_block_stacks.getFirst().get_cur_loop_block();
			if(temp_loop_block == null){
				//如果当前的栈已经空了
				loop_block_stacks.pollFirst();//弹出当前栈
				if(loop_block_stacks.isEmpty()){
					//如果弹出栈后栈空
					return_result = LoopStackDef.COMPLETED;
				}
				else{
					//如果弹出后依旧有栈
					cur_loop_block = loop_block_stacks.getFirst().get_cur_loop_block();
					return_result = LoopStackDef.UNCOMPLETED;
				}
			}
			else{
				//如果当前的栈没有空
				return_result = LoopStackDef.UNCOMPLETED;
				cur_loop_block = temp_loop_block;
			}
		}
		return return_result;
	}
	
	public int get_cur_loop_block_begin(){
		int return_result = -1;
		if(cur_loop_block != null){
			return_result = cur_loop_block.begin_qua;
		}
		return return_result;
	}
	
	public int get_cur_loop_block_end(){
		int return_result = -1;
		if(cur_loop_block != null){
			return_result = cur_loop_block.end_qua;
		}
		return return_result;
	}
	
	public void add_input_arg(String in_input_arg, DataDef in_type){
		if(cur_loop_block != null){
			if(in_type == DataDef.VALUE){
				cur_loop_block.input_args.put(in_input_arg, 
						new CDataEntity(new CDeduceExpr(in_input_arg)));
			}
			else if(in_type == DataDef.SET){
				cur_loop_block.input_args.put(in_input_arg,
						new CDataEntity(new CSetStruct(in_input_arg)));
			}
		}
	}
	
	public void add_output_arg(String in_output_arg){
		if(cur_loop_block != null){
			cur_loop_block.output_args.put(in_output_arg, null);
		}
	}
	
	public CLoopBlock get_cur_block(){
		return cur_loop_block;
	}
	
	public void add_loop_condition_deduce_str(String in_str){
		deduce_strs.add(in_str);
	}
	
	public void add_deduce_str(String in_str){
		deduce_strs.add(in_str);
	}
	
	public void add_deduce_split_str(){
		deduce_strs.add("======split line======");
	}
	
	public void clear_deduce_strs(){
		deduce_strs.clear();
	}
	
	public String get_deduce_strs(){
		String return_result = new String();
		for(String cur_str: deduce_strs){
			return_result += cur_str + CGlobalStaticSource.endl_str;
		}
		return return_result;
	}
	
	/**
	 * 
	 * @param in_id_value_map 循环块输出变量的公式
	 * @param in_iterations_input 循环块代数的公式
	 * @return 迭代到N + 1步的循环块输出变量的公式
	 */
	public HashMap<String, String> input_output_args(HashMap<String, String> in_id_value_map, String in_iterations_input){
		HashMap<String, String> return_result = null;
		if(cur_loop_block != null){
			cur_loop_block.input_iterations(in_iterations_input);
			HashMap<String, String> n_plus_one_map = cur_loop_block.input_output_args(in_id_value_map);
			return_result = n_plus_one_map;
		}
		return return_result;
	}
	
	public String get_cur_loop_block_condition_str(){
		String return_result = new String();
		if(cur_loop_block != null){
			 return_result = cur_loop_block.get_cur_condition_deduce_str();
		}
		return return_result;
	}
	
	public String get_cur_loop_block_latter_condition_str(){
		String return_result = new String();
		if(cur_loop_block != null){
			 return_result = cur_loop_block.get_latter_condition_deduce_str();
		}
		return return_result;
	}
}
