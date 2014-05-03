package Deducers;
import java.util.LinkedList;

import javax.swing.tree.DefaultMutableTreeNode;

import Defines.DataDef;
import Defines.DeduceDef;
import PackageMsg.COptionMsg;


public class CDeduceTerm {
	private DataDef type = null;
	private LinkedList<CValueGen> data_family = new LinkedList<CValueGen>();
	/*
	 * Private Functions
	 */
	private void add_value_gen(CValueGen in_value_gen){
		this.data_family.add(in_value_gen);
	}
	
	private void add_value_gen(CDeduceExpr in_expr){
		this.add_value_gen(new CValueGen(in_expr));
	}
	
	private void add_value_gen(CSetStruct in_set_struct){
		this.add_value_gen(new CValueGen(in_set_struct));
	}
	
	private void add_value_gen(int in_cir_gen, int in_ass_gen, CDeduceExpr in_expr){
		this.add_value_gen(new CValueGen(in_cir_gen, in_ass_gen, in_expr));
	}
	
	private void add_value_gen(int in_cir_gen, int in_ass_gen, CSetStruct in_set_struct){
		this.add_value_gen(new CValueGen(in_cir_gen, in_ass_gen, in_set_struct));
	}
	
	
	
	/*
	 * Constructors
	 */
		
	public CDeduceTerm(DataDef in_type){
		if(in_type == DataDef.VALUE){
			this.add_data(new CDeduceExpr());
			this.type = DataDef.VALUE;
		}
		else if(in_type == DataDef.SET){
			this.add_data(new CSetStruct(DeduceDef.DATA));
			this.type = DataDef.SET;
		}
	}
	public CDeduceTerm(String in_data){
		this.add_data(new CDeduceExpr(DeduceDef.DATA, in_data, null, null));
		this.type = DataDef.VALUE;
	}
	
	public CDeduceTerm(CSetStruct in_set_struct){
		this.add_data(in_set_struct);
		this.type = DataDef.SET;
	}
	
	public CDeduceTerm(CDeduceExpr in_expr){
		this.add_data(in_expr);
		this.type = DataDef.VALUE;
	}
	
	//Copy Constructor
	public CDeduceTerm(CDeduceTerm in_term){
		this.type = in_term.type;
		for(CValueGen cur_gen: in_term.data_family){
			this.add_value_gen(new CValueGen(cur_gen));
		}
	}

	/*
	 * Interfaces
	 */
		
	public void add_data(CSetStruct in_set_struct){
		if(data_family.isEmpty()){
			this.add_value_gen(in_set_struct);
		}
		else{
			this.add_value_gen(
					get_cur_gen().cir_gen,
					get_cur_gen().ass_gen + 1,
					in_set_struct
					);
		}
	}
	
	public void add_data(CDeduceExpr in_expr){
		if(data_family.isEmpty()){
			this.add_value_gen(in_expr);
		}
		else{
			this.add_value_gen(
					get_cur_gen().cir_gen,
					get_cur_gen().ass_gen + 1,
					in_expr
					);
		}
	}
	
	public void add_cir_data(CDeduceExpr in_expr){
		if(data_family.isEmpty()){
			this.add_value_gen(1, 0, in_expr);
		}
		else{
			this.add_value_gen(
					get_cur_gen().cir_gen + 1,
					0,
					in_expr
					);
		}
	}
	
	public void add_cir_data(CSetStruct in_set_struct){
		if(data_family.isEmpty()){
			this.add_value_gen(1, 0, in_set_struct);
		}
		else{
			this.add_value_gen(
					get_cur_gen().cir_gen + 1,
					0,
					in_set_struct
					);
		}
	}
	
	public CValueGen get_cur_gen(){
		CValueGen return_result = null;
		if(!data_family.isEmpty()){
			return_result = data_family.getLast();
		}
		return return_result;
	}
	
	public CDeduceExpr get_cur_expr(){
		CValueGen cur_gen = get_cur_gen();
		CDeduceExpr return_result = null;
		if(cur_gen != null){
			return_result = cur_gen.expr;
		}
		return return_result;
	}
	
	public CSetStruct get_cur_set(){
		CValueGen cur_gen = get_cur_gen();
		CSetStruct return_result = null;
		if(cur_gen != null){
			return_result = cur_gen.set_struct;
		}
		return return_result;
	}
	
	public void add_data(DeduceDef in_type, CDeduceExpr left_value, CDeduceExpr right_value){
		CDeduceExpr cur_expr = new CDeduceExpr(in_type, left_value, right_value);
		this.add_data(cur_expr);
	}
	
	public void add_cir_data(DeduceDef in_type, CDeduceExpr left_value, CDeduceExpr right_value){
		CDeduceExpr cur_expr = new CDeduceExpr(in_type, left_value, right_value);
		this.add_cir_data(cur_expr);
	}
		
	public String get_cur_age(){
		CValueGen cur_gen = get_cur_gen();
		String return_result = null;
		if(cur_gen != null){
			return_result = cur_gen.get_age_str();
		}
		return return_result;
	}
	
	public DataDef get_type(){
		return type;
	}
	
	/*
	 * To String
	 */
	
	
	public String get_cur_gen_data_str(){
		return get_cur_gen().get_data_str();
	}
	
	public String get_cur_gen_age_str(){
		return get_cur_gen().get_age_str();
	}
	
	public String toString(){
		String return_result = new String();
		for(CValueGen cur_gen: data_family){
			return_result += cur_gen.get_data_str(); 
		}
		return return_result;
	}
	
	/*
	 * UI
	 */
	
	public LinkedList<DefaultMutableTreeNode> get_tree_nodes(){
		LinkedList<DefaultMutableTreeNode> return_result = new LinkedList<DefaultMutableTreeNode>();
		for(CValueGen cur_gen: data_family){
			return_result.add(cur_gen.get_tree_node());
		}
		return return_result;
	}
	
	public DefaultMutableTreeNode get_change_map_tree_nodes(COptionMsg in_option_msg){
		DefaultMutableTreeNode return_result = new DefaultMutableTreeNode("change map");
		if(in_option_msg != null){
			for(int i = 1; i < data_family.size(); i++){
				CValueGen cur_gen = data_family.get(i);
				CValueGen last_gen = data_family.get(i - 1);
				if(this.type == DataDef.VALUE){
					return_result.add(new DefaultMutableTreeNode(
						CValueGen.get_change_map_age(cur_gen, last_gen, in_option_msg) + " = " +
						CValueGen.get_change_map_result(cur_gen, last_gen, in_option_msg)
						));
				}
			}
		}
		return return_result;
	}
	
	public DefaultMutableTreeNode get_sub_tree_nodes(){
		DefaultMutableTreeNode return_result = new DefaultMutableTreeNode("change map");
		for(int i = 1; i < data_family.size(); i++){
			CValueGen cur_gen = data_family.get(i);
			CValueGen last_gen = data_family.get(i - 1);
			return_result.add(new DefaultMutableTreeNode(
					"[" + cur_gen.get_age_str() + "] - [" +   
					last_gen.get_age_str() + "]" + 
					cur_gen.get_sub_result(last_gen)
					));
		}
		return return_result;
	}
	
	/*
	 * 重载公共接口
	 */
	
	@Override public boolean equals(Object in_term){
		if(this.type == DataDef.VALUE){
			return this.toString().equals(((CDeduceTerm)in_term).toString());
		}
		else{
			return super.equals(in_term);
		}
	}
	@Override public int hashCode(){
		if(this.type == DataDef.VALUE){
			return this.toString().hashCode();
		}
		else{
			return super.hashCode();
		}
	}
}
