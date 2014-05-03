package Deducers;
import java.util.LinkedList;

import Defines.LoopStackDef;


public class CLoopBlockStack {
	public LinkedList<CLoopBlock> loop_block_stack = new LinkedList<CLoopBlock>();
	private int completed_block_index = -1;
	
	public LoopStackDef get_stack_state(){
		LoopStackDef return_result = LoopStackDef.ERROR;
		if(loop_block_stack.isEmpty()){
			return_result = LoopStackDef.EMPTY;
		}
		else if(completed_block_index == -1){
			return_result = LoopStackDef.CLOSED;
		}
		else if(completed_block_index >= 0){
			return_result = LoopStackDef.UNCLOSED;
		}
		return return_result;
	}
	
	//正确性由CLoopBlockMgr保证
	public void add_begin_index(int in_index){
		CLoopBlock temp_block = new CLoopBlock();
		temp_block.begin_qua = in_index;
		loop_block_stack.add(temp_block);
		++completed_block_index;
	}
	
	//正确性由CLoopBlockMgr保证
	public void add_end_index(int in_index){
		loop_block_stack.get(completed_block_index).end_qua = in_index;
		--completed_block_index;
	}
	
	public CLoopBlock get_cur_loop_block(){
		CLoopBlock return_result = null;
		if(!loop_block_stack.isEmpty()){
			return_result = loop_block_stack.pollLast();
		}
		return return_result;
	}
}
