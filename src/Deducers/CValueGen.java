package Deducers;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.tree.DefaultMutableTreeNode;

import Defines.DataDef;
import Defines.DeduceDef;
import PackageMsg.COptionMsg;


//A generation of value
public class CValueGen {
	public int cir_gen = 0,//循环代数 
				ass_gen = 0;//赋值代数
	public CDeduceExpr expr = null;
	public CSetStruct set_struct = null;
	
	/*
	 * Constructor
	 */
	public CValueGen(CDeduceExpr in_expr){
		this.expr = in_expr;
	}
	
	public CValueGen(CSetStruct in_set){
		this.set_struct = in_set;
	}
	
	public CValueGen(int in_cir_gen, int in_ass_gen, CDeduceExpr in_expr){
		this.cir_gen = in_cir_gen;
		this.ass_gen = in_ass_gen;
		this.expr = in_expr;
	}
	
	public CValueGen(int in_cir_gen, int in_ass_gen, CSetStruct in_set){
		this.cir_gen = in_cir_gen;
		this.ass_gen = in_ass_gen;
		this.set_struct = in_set;
	}
	
	/*
	 * Copy Constructor
	 */
	
	public CValueGen(CValueGen in_gen){
		this.cir_gen = in_gen.cir_gen;
		this.ass_gen = in_gen.ass_gen;
		if(in_gen.expr != null){
			this.expr = in_gen.expr.dup();
		}
		if(in_gen.set_struct != null){
			this.set_struct = in_gen.set_struct.dup();
		}
	}
	
	public String get_age_str(){
		return (new Integer(cir_gen)).toString() + 
				", " + 
				(new Integer(ass_gen)).toString();
	}
	
	public static String map_to_str(TreeMap<String, Double> in_map){
		String return_result = "";
		for(Map.Entry<String, Double> cur_entry: in_map.entrySet()){
			if(cur_entry.getKey().equals("1")){
				if(cur_entry.getValue() > 0){
					return_result += " + " + cur_entry.getValue().toString();
				}
				else if(cur_entry.getValue() < 0){
					return_result += cur_entry.getValue().toString();
				}
			}
			else if(cur_entry.getValue() > 0){
				if(cur_entry.getValue() == 1){
					return_result += " + " + cur_entry.getKey();
				}
				else{
					return_result += " + " + cur_entry.getValue().toString() + "*" + cur_entry.getKey();
				}
			}
			else if(cur_entry.getValue() < 0){
				return_result += cur_entry.getValue().toString() + "*" + cur_entry.getKey();
			}
			else{
				if(in_map.size() == 1){
					return_result = "0";
				}
			}
		}
		return return_result;
	}
	
	public String toString(){
		return "[" + 
				get_age_str() +
				"]" +
				get_data_str();
	}
	
	public String get_data_str(){
		String return_result = null;
		if(expr != null){
			return_result = get_expr_data();
		}
		else if(set_struct != null){
			return_result = set_struct.toString();
		}
		return return_result;
	}
	
	public String get_expr_data(){
		return map_to_str(expr.adv_toString());
	}
	
	public CDeduceExpr get_expr(){
		return expr;
	}
	
	/**
	 * 获得this.expr减去in_gen.expr的结果
	 * @param in_gen
	 * @return
	 */
	public String get_sub_result(CValueGen in_gen){
		CDeduceExpr cur_expr = new CDeduceExpr(DeduceDef.SUB, this.expr, in_gen.expr);
		return map_to_str(cur_expr.adv_toString());
	}
	
	public static String get_change_map_result(CValueGen cur_gen, CValueGen last_gen, COptionMsg in_option_msg){
		CValueGen left_gen = null, right_gen = null;
		if(in_option_msg.left_factor == "Current"){
			left_gen = cur_gen;
		}
		else{
			left_gen = last_gen;
		}
		
		if(in_option_msg.right_factor == "Current"){
			right_gen = cur_gen;
		}
		else{
			right_gen = last_gen;
		}
		
		return map_to_str((new CDeduceExpr(in_option_msg.method, left_gen.expr, right_gen.expr)).adv_toString());
	}
	
	public static String get_change_map_age(CValueGen cur_gen, CValueGen last_gen, COptionMsg in_option_msg){
		CValueGen left_gen = null, right_gen = null;
		if(in_option_msg.left_factor == "Current"){
			left_gen = cur_gen;
		}
		else{
			left_gen = last_gen;
		}
		
		if(in_option_msg.right_factor == "Current"){
			right_gen = cur_gen;
		}
		else{
			right_gen = last_gen;
		}
		
		return "[" + left_gen.get_age_str() + "]" + 
				in_option_msg.method.toString()+ "[" +   
				right_gen.get_age_str() + "]";
	}
	
	/*
	 * UI
	 */
	
	public DefaultMutableTreeNode get_tree_node(){
		DefaultMutableTreeNode return_result = new DefaultMutableTreeNode(this.toString());
		if(set_struct != null){
			LinkedList<DefaultMutableTreeNode> cur_list = set_struct.get_tree_nodes();
			for(DefaultMutableTreeNode cur_node: cur_list){
				return_result.add(cur_node);
			}
		}
		return return_result;
	}
}
