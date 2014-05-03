import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;


public class CQuaAnalyzer {
	private QuaDef cur_state = QuaDef.GLO_DEC;
	private int cur_qua_index = 0;
	private CDeduceTableMagr deduce_table_magr = new CDeduceTableMagr();
	
	//snapshot list
	private LinkedList<CDeduceTableMagr> magr_list = new LinkedList<CDeduceTableMagr>();
	private LinkedList<String> snapshot_label_list = new LinkedList<String>();//存储着每个ifnot对应的结束的label
	private LinkedList<String> condition_label_list = new LinkedList<String>();//存储每个ifnot对应的条件结果
	//snapshot end
	
	//loop推演处理
	private LinkedList<Integer> loop_indexes = new LinkedList<Integer>(); 
	//loop end
	
	private LinkedList<CQuaternion> quaternions = null;
	private CQuaternion cur_qua = null;
	
	private void save_cur_magr(){
		magr_list.add(new CDeduceTableMagr(deduce_table_magr));
	}
	
	private void load_last_magr(){
		deduce_table_magr = magr_list.pollLast();
	}
	
	private void get_cur_qua(){
		cur_qua = quaternions.get(cur_qua_index);
	}
	
	private boolean check_cur_qua_type(QuaDef in_type){
		return cur_qua.type == in_type;
	}
	
	private boolean check_cur_state(QuaDef in_state){
		return cur_state == in_state;
	}
	
	private boolean glo_dec_state(){
		boolean return_result = true;
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.GLO_DEC_END)){
			return_result = false;
		}
		else if(check_cur_qua_type(QuaDef.GLO_ARG)){
			cur_state = QuaDef.GLO_ARG;
		}
		else if(check_cur_qua_type(QuaDef.GLO_INV)){
			cur_state = QuaDef.GLO_INV;
		}
		else if(check_cur_qua_type(QuaDef.GLO_ATT)){
			cur_state = QuaDef.GLO_ATT;
		}
		else if(check_cur_qua_type(QuaDef.FUNC_DEC)){
			cur_state = QuaDef.FUNC_DEC;
		}
		else if(check_cur_qua_type(QuaDef.FUNC_DEF)){
			cur_state = QuaDef.FUNC_DEF;
		}
		cur_qua_index++;
		return return_result;
	}
	
	private void glo_arg_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.GLO_ARG_END)){
			cur_state = QuaDef.GLO_DEC;
		}
		else if(check_cur_qua_type(QuaDef.ARG)){
			deduce_table_magr.create_global_term(cur_qua.data_1);
			deduce_table_magr.set_term(cur_qua.data_1, cur_qua.data_1.data_str);
		}
		cur_qua_index++;
	}
	
	private void glo_inv_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.GLO_INV_END)){
			cur_state = QuaDef.GLO_DEC;
		}
		cur_qua_index++;
	}
	
	private void glo_att_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.GLO_ATT_END)){
			cur_state = QuaDef.GLO_DEC;
		}
		else if(check_cur_qua_type(QuaDef.GLO_CON_DEC)){
			cur_state = QuaDef.GLO_CON_DEC;
		}
		else if(check_cur_qua_type(QuaDef.GLO_VAL_DEC)){
			cur_state = QuaDef.GLO_VAL_DEC;
		}
		cur_qua_index++;
	}
	
	private void glo_con_dec_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.GLO_CON_DEC_END)){
			cur_state = QuaDef.GLO_ATT;
		}
		cur_qua_index++;
	}
	
	private void glo_val_dec_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.GLO_VAL_DEC_END)){
			cur_state = QuaDef.GLO_ATT;
		}
		cur_qua_index++;
	}
	
	private void func_dec_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.FUNC_DEC_END)){
			cur_state = QuaDef.GLO_DEC;
		}
		cur_qua_index++;
	}
	
	private void func_def_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.FUNC_DEF_END)){
			cur_state = QuaDef.GLO_DEC;
		}
		else if(check_cur_qua_type(QuaDef.FUNC)){
			cur_state = QuaDef.FUNC;
			deduce_table_magr.push_back_table();
		}
		cur_qua_index++;
	}
	
	private void func_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.FUNC_END)){
			cur_state = QuaDef.FUNC_DEF;
			deduce_table_magr.pop_back_table();
			deduce_table_magr.pop_back_func_name();
		}
		else if(check_cur_qua_type(QuaDef.NAME)){
			deduce_table_magr.push_back_func_name(cur_qua.data_0.data_str);
		}
		else if(check_cur_qua_type(QuaDef.FUNC_ARG)){
			cur_state = QuaDef.FUNC_ARG;
		}
		else if(check_cur_qua_type(QuaDef.FUNC_CON_DEC)){
			cur_state = QuaDef.FUNC_CON_DEC;
		}
		else if(check_cur_qua_type(QuaDef.FUNC_VAL_DEC)){
			cur_state = QuaDef.FUNC_VAL_DEC;
		}
		cur_qua_index++;
	}
	
	private void func_arg_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.FUNC_ARG_END)){
			cur_state = QuaDef.FUNC;
		}
		else if(check_cur_qua_type(QuaDef.ARG)){
			deduce_table_magr.create_local_term(cur_qua.data_1);
			deduce_table_magr.set_term(cur_qua.data_1, cur_qua.data_1.data_str);
		}
		cur_qua_index++;
	}
	
	private void func_con_dec_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.FUNC_CON_DEC_END)){
			cur_state = QuaDef.FUNC;
		}
		else if(check_cur_qua_type(QuaDef.ARG)){
			deduce_table_magr.create_local_term(cur_qua.data_1);
			deduce_table_magr.set_term(cur_qua.data_1, cur_qua.data_1.data_str);
			
		}
		cur_qua_index++;
	}
	
	private void func_val_dec_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.FUNC_VAL_DEC_END)){
			cur_state = QuaDef.FUNC_BODY;
		}
		else if(check_cur_qua_type(QuaDef.DEC)){
			deduce_table_magr.create_local_term(cur_qua.data_1);
		}
		cur_qua_index++;
	}
	
	private void func_body_state() throws IOException{
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.FUNC_END)){
			cur_state = QuaDef.FUNC_DEF;
			cur_qua_index++;
		}
		else if(check_cur_qua_type(QuaDef.GOTO_I)){
			func_body_goto_i();
			cur_qua_index++;
		}
		else if(check_cur_qua_type(QuaDef.GOTO_L)){
			cur_qua_index++;
		}
		else if(check_cur_qua_type(QuaDef.LABEL)){
			func_body_label();
			cur_qua_index++;
		}
		else{
			//关系符号
			if(check_cur_qua_type(QuaDef.LES)){
				func_body_les();
			}
			else if(check_cur_qua_type(QuaDef.EQU)){
				func_body_equ();
			}
			
			else if(check_cur_qua_type(QuaDef.GRE)){
				func_body_gre();
			}
			else if(check_cur_qua_type(QuaDef.UEQU)){
				func_body_uequ();
			}
			//特定标号
			else if(check_cur_qua_type(QuaDef.LOOP)){
				func_body_loop();
			}
			else if(check_cur_qua_type(QuaDef.LOOP_END)){
				func_body_loop_end();
			}
			else if(check_cur_qua_type(QuaDef.IFNOT)){
				func_body_ifnot();
			}
			else if(check_cur_qua_type(QuaDef.RET)){
				cur_qua.deduce_str = deduce_table_magr.get_cur_func_name() + " = " + 
						get_expr_from_cdata(cur_qua.data_0).toString();
			}
			//赋值语句
			else if(check_cur_qua_type(QuaDef.ASS)){
				func_body_ass();
			}
			//数学运算
			else if(check_cur_qua_type(QuaDef.REV)){
				func_body_rev();
			}
			else if(check_cur_qua_type(QuaDef.ADD)){
				func_body_add();
			}
			else if(check_cur_qua_type(QuaDef.SUB)){
				func_body_sub();
			}
			else if(check_cur_qua_type(QuaDef.MUL)){
				func_body_mul();
			}
			cur_qua_index++;
			if(deduce_table_magr.get_if_loop()){
				char cur_input_char = (char)System.in.read();
				if(cur_input_char == '1'){
					temp_function();
				}
			}
		}
		
		deduce_table_magr.print_all_value();
	}
	
	private CDeduceExpr get_expr_from_cdata(CData in_data){
		CDeduceExpr return_result = null;
		if(in_data.type == DataDef.ID){
			return_result = deduce_table_magr.get_cur_expr(in_data.data_str);
		}
		else{
			return_result = new CDeduceExpr(in_data.data_str);
		}
		return return_result;
	}
	
	private void deal_ternary_qua(DeduceDef in_type){
		deduce_table_magr.set_term(
				cur_qua.data_2, 
				in_type, 
				get_expr_from_cdata(cur_qua.data_0), 
				get_expr_from_cdata(cur_qua.data_1)
				);
		if(!cur_qua.data_2.if_temp() && !deduce_table_magr.get_if_loop()){
			cur_qua.deduce_str = deduce_table_magr.get_deduce_str(cur_qua.data_2);
		}
	}
	
	private void deal_duality_qua(DeduceDef in_type){
		deduce_table_magr.set_term(
				cur_qua.data_1, 
				in_type, 
				get_expr_from_cdata(cur_qua.data_0), 
				null
				);
		if(!cur_qua.data_1.if_temp() && !deduce_table_magr.get_if_loop()){
			cur_qua.deduce_str = deduce_table_magr.get_deduce_str(cur_qua.data_1);
		}
	}
	
	private void func_body_les(){
		deal_ternary_qua(DeduceDef.LES);
	}
	
	private void func_body_rev(){
		deal_duality_qua(DeduceDef.REV);
	}
	
	private void func_body_equ(){
		deal_ternary_qua(DeduceDef.EQU);
	}
	
	private void func_body_gre(){
		deal_ternary_qua(DeduceDef.GRE);
	}
	
	private void func_body_add(){
		deal_ternary_qua(DeduceDef.ADD);
	}
	
	private void func_body_ass(){
		deduce_table_magr.set_term(cur_qua.data_1, get_expr_from_cdata(cur_qua.data_0));
		if(!cur_qua.data_1.if_temp() && !deduce_table_magr.get_if_loop()){
			cur_qua.deduce_str = deduce_table_magr.get_deduce_str(cur_qua.data_1);
		}
	}
	
	private void func_body_uequ(){
		deal_ternary_qua(DeduceDef.UEQU);
	}
	
	private void func_body_sub(){
		deal_ternary_qua(DeduceDef.SUB);
	}
	
	private void func_body_mul(){
		deal_ternary_qua(DeduceDef.MUL);
	}
	
	private void func_body_ifnot(){
		String cur_expr_str = get_expr_from_cdata(cur_qua.data_0).toString();
		cur_qua.deduce_str = "(" + cur_expr_str +") \\/";
		save_cur_magr();
		this.snapshot_label_list.add(cur_qua.data_1.data_str);
		this.condition_label_list.add(cur_expr_str);
	}
	
	private void func_body_goto_i(){
		CQuaternion temp_goto_i_qua = cur_qua;
		CQuaternion temp_next_qua = quaternions.get(cur_qua_index + 1);
		if(temp_next_qua.data_0.data_str == snapshot_label_list.getLast()){
			//生成else部分语句块的条件前提
			cur_qua.deduce_str = "!(" + condition_label_list.getLast() + ")\\/";
			//恢复if部分语句前的语境
			load_last_magr();
			//弹出队尾label标号，但是保持条件结果不变
			snapshot_label_list.pollLast();
			//将当前goto_i的语句压入快照标号队列			
			snapshot_label_list.add(temp_goto_i_qua.data_0.data_str);
			//保存当前语境的快照
			save_cur_magr();
			//跳过当前goto_i语句
			cur_qua_index++;
		}
	}
	
	private void func_body_label(){
		//如果当前label标号等于快照标号栈的第一个，则做现场恢复处理
		if(cur_qua.data_0.data_str == snapshot_label_list.getLast()){
			//恢复语境
			load_last_magr();
			//弹出label队尾
			snapshot_label_list.pollLast();
			//弹出条件结果队尾
			condition_label_list.pollLast();
		}
	}
	
	private void func_body_loop(){
		//保存现场
		save_cur_magr();
		//保存循环开始地方
		loop_indexes.add(new Integer(cur_qua_index + 1));
		//将magr置为循环模式
		deduce_table_magr.start_loop_mode();
	}
	
	private void func_body_loop_end(){
		//返回循环开始
		cur_qua_index = loop_indexes.getLast().intValue();
	}
	
	private void temp_function() throws IOException{
		deduce_table_magr.set_loop_value_list("z", "result of z");
		deduce_table_magr.set_loop_value_list("y", "result of y");
		finish_loop();
		cur_qua_index++;
		print_all_deduce_str();
	}
	
	//结束对一个loop的处理
	private void finish_loop(){
		//获得完成的循环结果表
		CLoopValueList cur_loop_value_list = deduce_table_magr.get_cur_loop_value_list();
		//恢复现场
		load_last_magr();
		//将完成的循环表覆盖到原始语境中
		cur_loop_value_list.assign_to_deduce_magr(deduce_table_magr);
		//弹出循环开始地方的记录
		loop_indexes.pollLast();
		//走出当前循环部分
		while(!check_cur_qua_type(QuaDef.LOOP_END)){
			cur_qua_index++;
			get_cur_qua();
		}
		//检查是否还有未完成的循环部分，如果没有，则将magr置为非循环模式
		if(loop_indexes.isEmpty()){
			deduce_table_magr.close_loop_mode();
		}
	}
	
	public CQuaAnalyzer(LinkedList<CQuaternion> in_quaternions){
		quaternions = in_quaternions;
	}
	
	public boolean top_brench() throws IOException{
		boolean return_result = true;
		if(check_cur_state(QuaDef.GLO_DEC)){
			return_result = glo_dec_state();
		}
		else if(check_cur_state(QuaDef.GLO_ARG)){
			glo_arg_state();
		}
		else if(check_cur_state(QuaDef.GLO_INV)){
			glo_inv_state();
		}
		else if(check_cur_state(QuaDef.GLO_ATT)){
			glo_att_state();
		}
		else if(check_cur_state(QuaDef.GLO_CON_DEC)){
			glo_con_dec_state();
		}
		else if(check_cur_state(QuaDef.GLO_VAL_DEC)){
			glo_val_dec_state();
		}
		else if(check_cur_state(QuaDef.FUNC_DEC)){
			func_dec_state();
		}
		else if(check_cur_state(QuaDef.FUNC_DEF)){
			func_def_state();
		}
		else if(check_cur_state(QuaDef.FUNC)){
			func_state();
		}
		else if(check_cur_state(QuaDef.FUNC_ARG)){
			func_arg_state();
		}
		else if(check_cur_state(QuaDef.FUNC_CON_DEC)){
			func_con_dec_state();
		}
		else if(check_cur_state(QuaDef.FUNC_VAL_DEC)){
			func_val_dec_state();
		}
		else if(check_cur_state(QuaDef.FUNC_BODY)){
			func_body_state();
		}
		return return_result;
	}
	
	public void print_all_deduce_str(){
		for(CQuaternion cur_quaternion: quaternions){
			if(cur_quaternion.deduce_str != null){
				System.out.println(cur_quaternion.deduce_str);
			}
		}
	}
}
