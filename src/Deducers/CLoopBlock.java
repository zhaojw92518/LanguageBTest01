package Deducers;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import ContextUI.CGlobalStaticSource;
import Defines.DataDef;
import Defines.DeduceDef;
import Parsers.CDataEntity;

public class CLoopBlock {
	public static final int INIT = -1;
	
	public HashMap<String, CDataEntity> 
		input_args = new HashMap<String, CDataEntity>(), 
		output_args = new HashMap<String, CDataEntity>();
	public LinkedList<CDeduceExpr> logical_stats = new LinkedList<CDeduceExpr>();
	public int begin_qua = CLoopBlock.INIT, end_qua = CLoopBlock.INIT;
	
	public CDeduceExpr iterations_count = null;
	
	public CDeduceExpr iterations_input = null;
	
	public CDeduceExpr initial_condition = null;
	
	public CDeduceTerm condition;
	
	public String[] get_input_strs(){
		String[] return_result = new String[input_args.size()];
		int i = 0;
		for(Map.Entry<String, CDataEntity> cur_entry: input_args.entrySet()){
			return_result[i] = cur_entry.getKey();
			++i;
		}
		
		return return_result;
	}
	
	public String[] get_output_strs(){
		String[] return_result = new String[output_args.size()];
		int i = 0;
		for(Map.Entry<String, CDataEntity> cur_entry: output_args.entrySet()){
			return_result[i] = cur_entry.getKey();
			++i;
		}
		
		return return_result;
	}
	/**
	 * 将input_args中包含的expr替换到output_args中，不替换_
	 * @param in_expr
	 */
	private void expr_replace(CDeduceExpr in_expr){
		if(in_expr.left_data != null){
			if(in_expr.left_data.type == DeduceDef.DATA &&
					input_args.containsKey(in_expr.left_data.data) &&
					input_args.get(in_expr.left_data.data).type == DataDef.VALUE){
				in_expr.left_data = input_args.get(in_expr.left_data.data).expr;
			}
			else{
				expr_replace(in_expr.left_data);
			}
		}
		
		if(in_expr.right_data != null){
			if(in_expr.right_data.type == DeduceDef.DATA &&
					input_args.containsKey(in_expr.right_data.data) && 
					input_args.get(in_expr.right_data.data).type == DataDef.VALUE){
				in_expr.right_data = input_args.get(in_expr.right_data.data).expr;
			}
			else{
				expr_replace(in_expr.right_data);
			}
		}
	}
	
	private void expr_replace(CSetStruct in_set_struct){
		if(in_set_struct.left_set_struct != null){
			if(in_set_struct.left_set_struct.type == DeduceDef.DATA){
				if(in_set_struct.left_set_struct.set_id != null && 
						input_args.containsKey(in_set_struct.left_set_struct.set_id)){
					in_set_struct.left_set_struct = 
							input_args.get(in_set_struct.left_set_struct).set_struct;
				}
				else{
					for(CDeduceTerm cur_term: in_set_struct.left_set_struct.term_set){
						expr_replace(cur_term.get_cur_expr());
					}
				}
			}
			expr_replace(in_set_struct.left_set_struct);
		}
		if(in_set_struct.right_set_struct != null){
			if(in_set_struct.right_set_struct.type == DeduceDef.DATA){
				if(in_set_struct.right_set_struct.set_id != null && 
						input_args.containsKey(in_set_struct.right_set_struct.set_id)){
					in_set_struct.right_set_struct = 
							input_args.get(in_set_struct.right_set_struct).set_struct;
				}
				else{
					for(CDeduceTerm cur_term: in_set_struct.right_set_struct.term_set){
						expr_replace(cur_term.get_cur_expr());
					}
				}
			}
			expr_replace(in_set_struct.right_set_struct);
		}
	}
	
	private void expr_replace(CDataEntity in_entity){
		if(in_entity.type == DataDef.VALUE){
			expr_replace(in_entity.expr);
		}
		else if(in_entity.type == DataDef.SET){
			expr_replace(in_entity.set_struct);
		}
	}
	
	/**
	 * 替换in_expr中的_
	 * @param in_iterations_expr
	 */
	private void iterations_replace(CDeduceExpr in_expr){
		if(in_expr.left_data != null){
			if(in_expr.left_data.type == DeduceDef.DATA && in_expr.left_data.data.equals("_")){
				in_expr.left_data = iterations_input;
			}
			else{
				iterations_replace(in_expr.left_data);
			}
		}
		
		if(in_expr.right_data != null){
			if(in_expr.right_data.type == DeduceDef.DATA && in_expr.right_data.data.equals("_")){
				in_expr.right_data = iterations_input;
			}
			else{
				iterations_replace(in_expr.right_data);
			}
		}
	}
	
	private void iterations_replace(CSetStruct in_set_struct){
		if(in_set_struct.type == DeduceDef.DATA){
			for(CDeduceTerm cur_term: in_set_struct.term_set){
				iterations_replace(cur_term.get_cur_expr());
			}
		}
		else{
			if(in_set_struct.left_set_struct != null){
				iterations_replace(in_set_struct.left_set_struct);
			}
			if(in_set_struct.right_set_struct != null){
				iterations_replace(in_set_struct.right_set_struct);
			}
		}
	}
	
	private void iterations_replace(CDataEntity in_entity){
		if(in_entity.type == DataDef.VALUE){
			iterations_replace(in_entity.expr);
		}
		else if(in_entity.type == DataDef.SET){
			iterations_replace(in_entity.set_struct);
		}
	}
	
	/**
	 * 代入第N代的结果
	 * @param in_id_value_map
	 * @return 返回第N+1代的结果
	 */
	public HashMap<String, String> input_output_args(HashMap<String, String> in_id_value_map){
		HashMap<String, String> return_result = new HashMap<String, String>();
		CExprInputor expr_inputor = new CExprInputor();
		for(Map.Entry<String, String> cur_entry: in_id_value_map.entrySet()){
			CDataEntity cur_entity = expr_inputor.get_expr(cur_entry.getValue());
			iterations_replace(cur_entity);
			
			CDeduceExpr iterations_backup = new CDeduceExpr(iterations_input);//备份原始的input
			iterations_input.assign(new CDeduceExpr(DeduceDef.ADD, iterations_backup, new CDeduceExpr("1")));//添加N + 1代
			String temp_str = cur_entity.toString();
			return_result.put(cur_entry.getKey(), temp_str);//将N+1代的值求出
			iterations_input.assign(iterations_backup);//还原为第N代
			
			expr_replace(cur_entity);
			output_args.put(cur_entry.getKey(), cur_entity);
		}
		return return_result;
	}

	public String get_condition_deduce_str(){
		String return_result = new String();
		return_result += "{" + condition.get_cur_gen().get_expr_data() + "}->";
		return_result += CGlobalStaticSource.endl_str;
		return_result += "{ next loop }" + CGlobalStaticSource.endl_str;
		return return_result;
	}
	
	public void init_iterations(){
		iterations_count = new CDeduceExpr("1");
		iterations_input = new CDeduceExpr("0");
	}
	
	public void increase_iterations(){
		iterations_count = new CDeduceExpr(DeduceDef.ADD, iterations_count, new CDeduceExpr("1"));
	}
	
	public String get_iterations_count_str(){
		return CValueGen.map_to_str(iterations_count.adv_toString());
	}
	
	public String get_iterations_input_str(){
		return CValueGen.map_to_str(iterations_input.adv_toString());
	}
	
	public void set_confirm_iterations_count(){
		iterations_count = new CDeduceExpr("_");
	}
	
	public void input_iterations(String in_iterations_input){
		CExprInputor expr_inputor = new CExprInputor();
		iterations_input = expr_inputor.get_expr(in_iterations_input).expr;
	}
	
	public void replace_initial_condition(){
		expr_replace(initial_condition);
	}
	
	/*
	 * Debug
	 */
	public void print_all_input_args(){
		System.out.print("input: ");
		for(Map.Entry<String, CDataEntity> cur_entry: input_args.entrySet()){
			System.out.print(cur_entry.getKey());
			System.out.print("  ");
		}
		System.out.println();
	}
	
	public void print_all_output_args(){
		System.out.print("output: ");
		for(Map.Entry<String, CDataEntity> cur_entry: output_args.entrySet()){
			System.out.print(cur_entry.getKey());
			System.out.print("  ");
		}
		System.out.println();
	}
	
}
