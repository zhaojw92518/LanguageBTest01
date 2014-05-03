package Deducers;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

import ContextUI.CContextFrame;
import ContextUI.CGlobalSemp;
import ContextUI.CGlobalStaticSource;
import Defines.DataDef;
import Defines.DeduceDef;
import Defines.DeduceResultDef;
import Defines.LoopStackDef;
import Defines.QuaDef;
import Parsers.CDataEntity;



public class CQuaAnalyzer {
	private QuaDef cur_state = QuaDef.GLO_DEC;
	private int cur_qua_index = 0;
	private CDeduceTableMgr cur_table_magr = new CDeduceTableMgr();
	
	private CLoopBlockMgr loop_block_mgr = new CLoopBlockMgr();
	private int loop_back_index = -1; // 保存着函数body部分起始的地址
	private CDeduceTableMgr loop_context_backup = null;
	
	private LinkedList<CQuaternion> quaternions = null;
	private CQuaternion cur_qua = null;
	
	private CContextFrame context_frame = new CContextFrame();
	public String code_str;
	
	private boolean in_out_id_panel_update_ctrl = true;
	private boolean if_confirm = false;
	
	private LinkedList<String> result_deduce_strs = new LinkedList<String>();
	private CConditionMgr condition_mgr = new CConditionMgr();
	
	private HashMap<String, Integer> label_to_qua_index = new HashMap<String, Integer>();
	
	private int completed_loop_count = 1;
	
	private void get_cur_qua(){
		cur_qua = quaternions.get(cur_qua_index);
	}
	
	/*
	 * Group of add
	 */
	
	private void add_result_deduce_str(String in_str){
		result_deduce_strs.add(condition_mgr.get_indent_str() + in_str);
		loop_block_mgr.add_deduce_str(condition_mgr.get_indent_str() + in_str);
	}
	
	private void add_loop_deduce_str(String in_str){
		loop_block_mgr.add_deduce_str(condition_mgr.get_indent_str() + in_str);
	}
	
	/*
	 * Group of add end
	 */
	
	/*
	 * Group of judge
	 */
	
	private boolean check_cur_qua_type(QuaDef in_type){
		return cur_qua.type == in_type;
	}
	
	private boolean check_cur_state(QuaDef in_state){
		return cur_state == in_state;
	}
	
	private boolean check_temp(String in_id_str){
		return (!in_id_str.isEmpty()) && in_id_str.charAt(0) == '@';
	}
	
	/*
	 * Group of judge end
	 */
	
	/*
	 * Group of get
	 */
	
	
	private CValueGen get_cur_gen(CData in_id_data){
		return get_cur_gen(in_id_data.data_str);
	}
	
	private CValueGen get_cur_gen(String in_id_str){
		return get_term(in_id_str).get_cur_gen();
	}
	
	private CDeduceTerm get_term(CData in_id_data){
		return get_term(in_id_data.data_str);
	}
	
	private CDeduceTerm get_term(String in_id_str){
		return cur_table_magr.get_term(in_id_str);
	}
	
	private CDeduceExpr get_cur_expr(String in_id_str){
		CValueGen gen_result = get_cur_gen(in_id_str);
		CDeduceExpr return_result = null;
		if(gen_result != null){
			return_result = gen_result.get_expr();
		}
		if(cur_state == QuaDef.LOOP_GEN && !check_temp(in_id_str) && !if_confirm){
			DataDef in_id_type = cur_table_magr.get_id_type(new CData(DataDef.ID, in_id_str));
			if(in_id_type != DataDef.SET){
				in_id_type = DataDef.VALUE;
			}
			loop_block_mgr.add_input_arg(in_id_str, in_id_type);
		}
		return return_result;
	}
	
	private CDeduceExpr get_cur_expr(CData in_id_data){
		return get_cur_expr(in_id_data.data_str);
	}
	
	private CDeduceExpr get_expr_from_cdata(CData in_data){
		CDeduceExpr return_result = null;
		if(in_data.type == DataDef.ID){
			return_result = get_cur_expr(in_data);
		}
		else{
			return_result = new CDeduceExpr(in_data.data_str);
		}
		return return_result;
	}
	
	/*
	 * Group of get end
	 */
	
	/*
	 * Group of set
	 */
	
	private void set_term(CData in_id_data, String in_data){
		this.set_term(in_id_data, new CDeduceExpr(in_data));
		
	}
	
	private void set_term(CData in_id_data, DeduceDef in_type, CDeduceExpr left_expr, CDeduceExpr right_expr){
		this.set_term(in_id_data, new CDeduceExpr(in_type, left_expr, right_expr));
	}
	
	private void set_term(CData in_id_data, CSetStruct in_set_struct){
		cur_table_magr.set_term(in_id_data, in_set_struct);
		loop_and_deduce_str_after_set(in_id_data);
	}
	
	private void loop_and_deduce_str_after_set(CData in_id_data){
		if(!CData.judge_temp(in_id_data)){
			if(cur_state == QuaDef.LOOP_GEN){
				if(!if_confirm){
					loop_block_mgr.add_output_arg(in_id_data.data_str);
				}
				String cur_deduce_str = cur_table_magr.get_cur_deduce_str(in_id_data);
				this.add_loop_deduce_str(cur_deduce_str);
			}
			else if(cur_state == QuaDef.FUNC_BODY){
				this.add_result_deduce_str(cur_table_magr.get_cur_deduce_str(in_id_data));
			}
		}
	}
	
	private void set_term(CData in_id_data, CDeduceExpr in_expr){
		cur_table_magr.set_term(in_id_data, in_expr);
		loop_and_deduce_str_after_set(in_id_data);
	}
	
	private void set_cir_term(CData in_id_data, CDeduceExpr in_expr){
		cur_table_magr.set_cir_term(in_id_data, in_expr);
		loop_and_deduce_str_after_set(in_id_data);
	}
	
	private void set_cir_term(CData in_id_data, CSetStruct in_set_struct){
		cur_table_magr.set_cir_term(in_id_data, in_set_struct);
		loop_and_deduce_str_after_set(in_id_data);
	}
	
	/*
	 * Group of set end
	 */
	
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
		++cur_qua_index;
		return return_result;
	}
	
	private void glo_arg_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.GLO_ARG_END)){
			cur_state = QuaDef.GLO_DEC;
		}
		else if(check_cur_qua_type(QuaDef.ARG)){
			if(cur_qua.data_0.type_data == DataDef.SET){
				cur_table_magr.create_global_term(cur_qua.data_1, DataDef.SET);
			}
			else{
				cur_table_magr.create_global_term(cur_qua.data_1, DataDef.VALUE);
				set_term(cur_qua.data_1, cur_qua.data_1.data_str);
			}
		}
		++cur_qua_index;
	}
	
	private void glo_inv_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.GLO_INV_END)){
			cur_state = QuaDef.GLO_DEC;
		}
		++cur_qua_index;
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
		++cur_qua_index;
	}
	
	private void glo_con_dec_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.GLO_CON_DEC_END)){
			cur_state = QuaDef.GLO_ATT;
		}
		++cur_qua_index;
	}
	
	private void glo_val_dec_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.GLO_VAL_DEC_END)){
			cur_state = QuaDef.GLO_ATT;
		}
		++cur_qua_index;
	}
	
	private void func_dec_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.FUNC_DEC_END)){
			cur_state = QuaDef.GLO_DEC;
		}
		++cur_qua_index;
	}
	
	private void func_def_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.FUNC_DEF_END)){
			cur_state = QuaDef.GLO_DEC;
		}
		else if(check_cur_qua_type(QuaDef.FUNC)){
			cur_state = QuaDef.FUNC;
			cur_table_magr.add_table();
		}
		++cur_qua_index;
	}
	
	private void func_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.FUNC_END)){
			cur_state = QuaDef.FUNC_DEF;
			cur_table_magr.pop_table();
			cur_table_magr.pop_func_name();
		}
		else if(check_cur_qua_type(QuaDef.NAME)){
			cur_table_magr.add_func_name(cur_qua.data_0.data_str);
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
		++cur_qua_index;
	}
	
	private void func_arg_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.FUNC_ARG_END)){
			cur_state = QuaDef.FUNC;
		}
		else if(check_cur_qua_type(QuaDef.ARG)){
			if(cur_qua.data_0.type_data == DataDef.SET){
				cur_table_magr.create_local_term(cur_qua.data_1, DataDef.SET);
				set_term(cur_qua.data_1, new CSetStruct(cur_qua.data_1.data_str));
			}
			else{
				cur_table_magr.create_local_term(cur_qua.data_1, DataDef.VALUE);
				set_term(cur_qua.data_1, cur_qua.data_1.data_str);
			}
		}
		++cur_qua_index;
	}
	
	private void func_con_dec_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.FUNC_CON_DEC_END)){
			cur_state = QuaDef.FUNC;
		}
		else if(check_cur_qua_type(QuaDef.ARG)){
			if(cur_qua.data_0.type_data == DataDef.SET){
				cur_table_magr.create_local_term(cur_qua.data_1, DataDef.SET);
				set_term(cur_qua.data_1, qua_set_to_term_set(cur_qua.data_2.set_list));
			}
			else{
				cur_table_magr.create_local_term(cur_qua.data_1, DataDef.VALUE);
				set_term(cur_qua.data_1, cur_qua.data_2.data_str);
			}
		}
		++cur_qua_index;
	}
	
	private void func_val_dec_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.FUNC_VAL_DEC_END)){
			cur_state = QuaDef.FUNC_SCANE;
			loop_back_index = cur_qua_index;
		}
		else if(check_cur_qua_type(QuaDef.DEC)){
			if(cur_qua.data_0.type_data == DataDef.SET){
				cur_table_magr.create_local_term(cur_qua.data_1, DataDef.SET);
			}
			else{
				cur_table_magr.create_local_term(cur_qua.data_1, DataDef.VALUE);
			}
		}
		++cur_qua_index;
	}
	
	private void func_body_state(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.FUNC_END)){
			cur_state = QuaDef.FUNC_DEF;
			context_frame.set_deduce_text(result_deduce_strs);
			++cur_qua_index;
		}
		else if(check_cur_qua_type(QuaDef.GOTO_I)){
			func_body_goto_i();
			++cur_qua_index;
		}
		else if(check_cur_qua_type(QuaDef.GOTO_L)){
			++cur_qua_index;
		}
		else if(check_cur_qua_type(QuaDef.LABEL)){
			func_body_label();
			++cur_qua_index;
		}
		else if(check_cur_qua_type(QuaDef.JUMP)){
			//专门做循环替换的跳转
			func_body_jump();
		}
		else{
			//布尔运算
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
			//循环与分支
			else if(check_cur_qua_type(QuaDef.IFNOT)){
				func_body_ifnot();
			}
			else if(check_cur_qua_type(QuaDef.IFNOT_L)){
				func_body_ifnot_l();
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
			else if(check_cur_qua_type(QuaDef.LOOP_BLOCK)){
				func_body_loop_block();
			}
			//集合运算
			else if(check_cur_qua_type(QuaDef.UNI)){
				func_body_uni();
			}
			else if(check_cur_qua_type(QuaDef.INT)){
				func_body_int();
			}
			else if(check_cur_qua_type(QuaDef.SUB_S)){
				func_body_set_sub();
			}
			//返回值语句
			else if(check_cur_qua_type(QuaDef.RET)){
				func_body_ret();
			}
			++cur_qua_index;
		}
	}

	
	private void deal_ternary_qua(DeduceDef in_type){
		this.set_term(
				cur_qua.data_2, 
				in_type, 
				get_expr_from_cdata(cur_qua.data_0), 
				get_expr_from_cdata(cur_qua.data_1)
				);
	}
	
	private void deal_duality_qua(DeduceDef in_type){
		this.set_term(
				cur_qua.data_1, 
				in_type, 
				get_expr_from_cdata(cur_qua.data_0), 
				null
				);
	}
	
	private void func_body_condition_end(){
		cur_table_magr = condition_mgr.get_cur_condition_context();
		cur_qua_index = condition_mgr.get_cur_condition_index();
		completed_loop_count = condition_mgr.get_cur_completed_loop_count();
		
		CDeduceExpr cur_condition_value = condition_mgr.get_cur_condition_value();
		condition_mgr.terminate_cur_condition();
		this.add_result_deduce_str("!(" + CValueGen.map_to_str(cur_condition_value.adv_toString()) + ") ->");
		condition_mgr.inc_level();
		
	}
	
	private void func_body_ret(){
		this.add_result_deduce_str(cur_table_magr.get_cur_func_name() + " = " + 
				CValueGen.map_to_str(get_expr_from_cdata(cur_qua.data_0).adv_toString())
				);
		if(completed_loop_count < condition_mgr.get_cur_loop_count()){
			cur_qua_index = loop_block_mgr.get_cur_loop_block_begin();
		}
		else if(!condition_mgr.if_empty()){
			func_body_condition_end();
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
	
	private CSetStruct get_set_data(CData in_id_data){
		CSetStruct return_result = null;
		if(in_id_data.type == DataDef.SET){
			return_result = qua_set_to_term_set(in_id_data.set_list);
		}
		else if(in_id_data.type == DataDef.ID && cur_table_magr.get_id_type(in_id_data) == DataDef.SET){
			return_result = get_cur_gen(in_id_data).set_struct;
		}
		return return_result;
	}
	
	private void func_body_set_duality(DeduceDef in_type){
		CSetStruct 	left_set  = get_set_data(cur_qua.data_0),
					right_set = get_set_data(cur_qua.data_1);
		if(left_set != null && right_set != null){
			if(CData.judge_temp(cur_qua.data_2)){
				cur_table_magr.create_local_term(cur_qua.data_2, DataDef.SET);
			}
			if(cur_table_magr.get_id_type(cur_qua.data_2) == DataDef.SET){
				set_term(cur_qua.data_2, new CSetStruct(in_type, left_set, right_set));
			}
		}
	}
	
	private void func_body_set_sub(){
		func_body_set_duality(DeduceDef.SUB_S);
	}
	
	private void func_body_uni(){
		func_body_set_duality(DeduceDef.UNI);
	}
	
	private void func_body_int(){
		func_body_set_duality(DeduceDef.INT);
	}
	
	private CSetStruct qua_set_to_term_set(HashSet<CData> in_set){
		CSetStruct return_result = new CSetStruct(DeduceDef.DATA);
		for(CData cur_data: in_set){
			if(cur_data.type == DataDef.INT){
				return_result.add(new CDeduceTerm(cur_data.data_str));
			}
			else if(cur_data.type == DataDef.ID){
				return_result.add(new CDeduceTerm(get_cur_expr(cur_data)));
			}
		}
		return return_result;
	}
	
	private void func_body_ass(){
		DataDef dst_type = cur_table_magr.get_id_type(cur_qua.data_1),
				src_type = cur_qua.data_0.type;
		
		if(dst_type == DataDef.VALUE){
			this.set_term(cur_qua.data_1, get_expr_from_cdata(cur_qua.data_0));
		}
		else if(dst_type == DataDef.SET){
			if(src_type == DataDef.SET){
				this.set_term(cur_qua.data_1, qua_set_to_term_set(cur_qua.data_0.set_list));
			}
			else if(src_type == DataDef.ID){
				this.set_term(cur_qua.data_1, get_cur_gen(cur_qua.data_0).set_struct);
			}
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
		CDeduceExpr cur_condition_expr = get_expr_from_cdata(cur_qua.data_0);
		this.add_result_deduce_str("(" + CValueGen.map_to_str(cur_condition_expr.adv_toString()) + ") ->");
		condition_mgr.add_conditions(cur_condition_expr, label_to_qua_index.get(cur_qua.data_1.data_str), cur_table_magr, completed_loop_count);
		condition_mgr.start_condition_mgr();
	}
	
	private void func_body_goto_i(){
		cur_qua_index = label_to_qua_index.get(cur_qua.data_0.data_str);
	}
	
	private void func_body_label(){

	}
	
	private void func_body_ifnot_l(){
		CDeduceTerm condition_term = get_term(cur_qua.data_0);
		if(loop_block_mgr.get_cur_block().initial_condition == null){
			loop_block_mgr.get_cur_block().initial_condition = condition_term.get_cur_expr().dup();
		}
		loop_block_mgr.get_cur_block().condition = condition_term;
	}
	
	private void func_body_loop_block(){
		for(Map.Entry<String, CDataEntity> cur_entry: cur_qua.loop_block.input_args.entrySet()){
			CDeduceTerm cur_term = get_term(cur_entry.getKey());
			if(cur_term != null){
				//将结果赋值给输入参数
				if(cur_term.get_type() == DataDef.VALUE){
					cur_entry.getValue().expr.assign(cur_term.get_cur_expr());
				}
				else if(cur_term.get_type() == DataDef.SET){
					cur_entry.getValue().set_struct.assign(cur_term.get_cur_set());
				}
			}
		}
		for(Map.Entry<String, CDataEntity> cur_entry: cur_qua.loop_block.output_args.entrySet()){
			if(cur_table_magr.if_have_term(cur_entry.getKey()) != null){
				if(cur_entry.getValue().type == DataDef.VALUE){
					set_cir_term(
							new CData(DataDef.ID, cur_entry.getKey()), 
							cur_entry.getValue().expr.dup());
				}
				else if(cur_entry.getValue().type == DataDef.SET){
					set_cir_term(
							new CData(DataDef.ID, cur_entry.getKey()), 
							cur_entry.getValue().set_struct.dup());
				}
			}
		}
	}
	
	private void func_body_scane(){
		get_cur_qua();
		if(check_cur_qua_type(QuaDef.FUNC_END)){
			cur_state = QuaDef.LOOP_CHANGE;
			loop_context_backup = cur_table_magr;
		}
		else if(check_cur_qua_type(QuaDef.LOOP)){
			loop_block_mgr.add_begin_index(cur_qua_index);
		}
		else if(check_cur_qua_type(QuaDef.LOOP_END)){
			loop_block_mgr.add_end_index(cur_qua_index);
		}
		else if(check_cur_qua_type(QuaDef.LABEL)){
			label_to_qua_index.put(cur_qua.data_0.data_str, new Integer(cur_qua_index));
		}
		++cur_qua_index;
	}
	
	private void init_deduce_context(){
		cur_qua_index = loop_block_mgr.get_cur_loop_block_begin();
		cur_table_magr.loop_init_all_tables();
		loop_block_mgr.clear_deduce_strs();
		loop_block_mgr.get_cur_block().init_iterations();
		in_out_id_panel_update_ctrl = true;
		condition_mgr.close_condition_mgr();
	}
	
	private void func_body_loop_change(){
		LoopStackDef result = loop_block_mgr.update();
		//初始化语境
		cur_table_magr = new CDeduceTableMgr(loop_context_backup);
			
		if(result == LoopStackDef.COMPLETED){
			//全部循环处理完毕
			cur_qua_index = loop_back_index;
			condition_mgr.init_loop_count();
			cur_state = QuaDef.FUNC_BODY;
		}
		else if(result == LoopStackDef.UNCOMPLETED){
			init_deduce_context();
			condition_mgr.init_loop_count();
			cur_state = QuaDef.LOOP_GEN;
			context_frame.highlight_code(
					quaternions.get(loop_block_mgr.get_cur_loop_block_begin()).line_num - 1, 
					quaternions.get(loop_block_mgr.get_cur_loop_block_end()).line_num - 1);	
		}
		else{
			//TODO 错误处理
		}
	}
	
	private void func_body_loop_gen(){
		if(cur_qua_index == loop_block_mgr.get_cur_loop_block_end()){
			//如果当前循环块处理完毕
			if(if_confirm){
				cur_state = QuaDef.LOOP_CONFIRM;
				if_confirm = false;
			}
			else if(completed_loop_count < condition_mgr.get_cur_loop_count()){
				cur_qua_index = loop_block_mgr.get_cur_loop_block_begin();
				completed_loop_count++;
			}
			else if(!condition_mgr.if_empty()){
				func_body_condition_end();
			}
			else{
				cur_state = QuaDef.LOOP_INPUT;
			}
		}
		else{
			func_body_state();
		}
	}
	
	private void update_context_frame(){
		context_frame.update(cur_table_magr.get_tree_nodes(context_frame.get_option_msg()));

		context_frame.set_deduce_text(loop_block_mgr.get_deduce_strs() + loop_block_mgr.get_cur_loop_block_condition_str());
		context_frame.update_iterations(loop_block_mgr.get_cur_block().get_iterations_count_str(), loop_block_mgr.get_cur_block().get_iterations_input_str());
		
		if(in_out_id_panel_update_ctrl){
			context_frame.update_ids(
					loop_block_mgr.get_cur_block().get_input_strs(), 
					loop_block_mgr.get_cur_block().get_output_strs(), 
					loop_block_mgr.get_cur_block().input_args.size(),
					loop_block_mgr.get_cur_block().output_args.size()
					);
			in_out_id_panel_update_ctrl = false;
		}
	}
	
	private void func_body_loop_input() throws InterruptedException{
		update_context_frame();
		//等待前端输入
		CGlobalSemp.acquire();
		DeduceResultDef deduce_result = context_frame.get_deduce_result();
		if(deduce_result == DeduceResultDef.AGAIN){
			//未看出来，需要重来
			cur_qua_index = loop_block_mgr.get_cur_loop_block_begin();
			loop_block_mgr.get_cur_block().increase_iterations();
			condition_mgr.inc_loop_count();
			loop_block_mgr.clear_deduce_strs();
			condition_mgr.init_level();
			completed_loop_count = 1;
			cur_state = QuaDef.LOOP_GEN;
		}
		else if(deduce_result == DeduceResultDef.INPUT){
			context_frame.set_output_id_value(context_frame.get_text_str());
		}
		else if(deduce_result == DeduceResultDef.CONFIRM){
			HashMap<String, String> n_plus_one_map = loop_block_mgr.input_output_args(context_frame.get_id_value_map(), context_frame.get_iterations_input_str());
			context_frame.update_output_values(n_plus_one_map);
			for(Map.Entry<String, CDataEntity> cur_entry: loop_block_mgr.get_cur_block().output_args.entrySet()){
				if(cur_entry.getValue().type == DataDef.VALUE){
					set_term(new CData(DataDef.ID, cur_entry.getKey()), cur_entry.getValue().expr);
				}
				else if(cur_entry.getValue().type == DataDef.SET){
					set_term(new CData(DataDef.ID, cur_entry.getKey()), cur_entry.getValue().set_struct);
				}
				
			}
			cur_state = QuaDef.LOOP_GEN;
			cur_qua_index = loop_block_mgr.get_cur_loop_block_begin();
			if_confirm = true;
		}
		else if(deduce_result == DeduceResultDef.ENTER){
			
		}
	}
	
	private void func_body_loop_confirm() throws InterruptedException{
		update_context_frame();
		
		//等待前端输入
		CGlobalSemp.acquire();
		DeduceResultDef deduce_result = context_frame.get_deduce_result();
		if(deduce_result == DeduceResultDef.AGAIN){
			//推导错误，重来
			init_deduce_context();
			cur_state = QuaDef.LOOP_GEN;
		}
		else if(deduce_result == DeduceResultDef.CONFIRM){
			//再迭代一遍
			cur_qua_index = loop_block_mgr.get_cur_loop_block_begin();
			cur_state = QuaDef.LOOP_GEN;
			if_confirm = true;
		}
		else if(deduce_result == DeduceResultDef.NEXT){
			//推导正确，滚动到下一个循环块
			cur_state = QuaDef.LOOP_CHANGE;
			//处理循环入口条件
			loop_block_mgr.get_cur_block().replace_initial_condition();
			//做四元式替换
			func_body_loop_block_replace(loop_block_mgr.get_cur_block());
		}
	}
	
	private void func_body_loop_block_replace(CLoopBlock in_loop_block){
		CQuaternion loop_qua = new CQuaternion();
		loop_qua.type = QuaDef.LOOP_BLOCK;
		loop_qua.loop_block = in_loop_block;
		quaternions.set(in_loop_block.begin_qua, loop_qua);
		CQuaternion jump_qua = new CQuaternion();
		jump_qua.type = QuaDef.JUMP;
		jump_qua.data_0 = new CData(DataDef.INT, 
				(new Integer(in_loop_block.end_qua + 1).toString()));
		quaternions.set(in_loop_block.begin_qua + 1, jump_qua);
	}
	
	private void func_body_jump(){
		cur_qua_index = (new Integer(cur_qua.data_0.data_str)).intValue();
	}
	/*
	 * Constructors
	 */
	
	public CQuaAnalyzer(LinkedList<CQuaternion> in_quaternions){
		quaternions = in_quaternions;
	}
	
	/*
	 * Interfaces
	 */
	
	public boolean top_brench() throws IOException, InterruptedException{
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
		else if(check_cur_state(QuaDef.FUNC_SCANE)){
			func_body_scane();
		}
		else if(check_cur_state(QuaDef.LOOP_CHANGE)){
			func_body_loop_change();
		}
		else if(check_cur_state(QuaDef.LOOP_GEN)){
			func_body_loop_gen();
		}
		else if(check_cur_state(QuaDef.LOOP_INPUT)){
			func_body_loop_input();
		}
		else if(check_cur_state(QuaDef.LOOP_CONFIRM)){
			func_body_loop_confirm();
		}
		//CGlobalStaticSource.cout_endl(cur_qua.toString());
		
		return return_result;
	}
	
	public void set_code_text(String in_text){
		code_str = in_text;
		context_frame.set_code_text(in_text);
	}
	
	public void print_all_deduce_str(){
		for(CQuaternion cur_quaternion: quaternions){
			if(cur_quaternion.deduce_str != null){
				System.out.println(cur_quaternion.deduce_str);
			}
		}
	}
}
