package Deducers;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Defines.DeduceDef;


public class CDeduceExpr {
	public DeduceDef type = null;
	public String data = null;
	public CDeduceExpr left_data = null, right_data = null;
	
	public CDeduceExpr(DeduceDef in_type, String in_data, CDeduceExpr in_left_data, CDeduceExpr in_right_data){
		type = in_type;
		data = in_data;
		left_data = in_left_data;
		right_data = in_right_data;
	}
	
	public CDeduceExpr(DeduceDef in_type, CDeduceExpr in_left_data, CDeduceExpr in_right_data){
		type = in_type;
		left_data = in_left_data;
		right_data = in_right_data;
	}
	
	public CDeduceExpr(String in_data){
		type = DeduceDef.DATA;
		data = in_data;
	}
	
	public CDeduceExpr(CDeduceExpr in_expr){
		type = in_expr.type;
		if(in_expr.data != null){
			data = new String(in_expr.data);
		}
		if(in_expr.left_data != null){
			left_data = new CDeduceExpr(in_expr.left_data);
		}
		if(in_expr.right_data != null){
			right_data = new CDeduceExpr(in_expr.right_data);
		}
	}
	
	public CDeduceExpr(){
		type = DeduceDef.DATA;
		data = "0";
	}
	
	public CDeduceExpr dup(){
		CDeduceExpr return_result = new CDeduceExpr();
		if(this.data != null){
			return_result.data = new String(this.data);
		}
		return_result.type = this.type;
		if(this.left_data != null){
			return_result.left_data = this.left_data.dup();
		}
		if(this.right_data != null){
			return_result.right_data = this.right_data.dup();
		}
		return return_result;
	}
	
	public void assign(CDeduceExpr in_expr){
		this.type = in_expr.type;
		this.data = in_expr.data;
		this.left_data = in_expr.left_data;
		this.right_data = in_expr.right_data;
	}
	
	private String get_data_str(CDeduceExpr in_data){
		String return_result = null;
		if(in_data.type == DeduceDef.DATA){
			return_result = in_data.toString();
		}
		else if(in_data.type.get_level() > this.type.get_level()){
			return_result = in_data.toString();
		}
		else if(in_data.type.get_level() == this.type.get_level()){
			
		}
		else{
			return_result = "(" + in_data.toString() + ")";
		}
		return return_result;
	}
	
	public String toString(){
		String return_result = null;
		if(type == DeduceDef.DATA){
			return_result = data;
		}
		else{
			if(right_data == null){
				//TODO 符号等级修改
				return_result = type.toString() + left_data.toString();
			}
			else{
				String 	left_str  = get_data_str(left_data), 
						right_str = get_data_str(right_data);
				return_result = left_str + this.type.toString() + right_str;
			}
		}
		return return_result;
	}
	
	/**
	 * 加法合并
	 * 将in_map_b合并入in_map_a中
	 * @param in_map_a
	 * @param in_map_b
	 */
	private void TreeMap_add_merge(TreeMap<String, Double> in_map_a, TreeMap<String, Double> in_map_b){
		for(Map.Entry<String, Double> cur_entry: in_map_b.entrySet()){
			if(in_map_a.containsKey(cur_entry.getKey())){
				in_map_a.put(
						cur_entry.getKey(), 
						in_map_a.get(cur_entry.getKey()) + cur_entry.getValue()
						);
			}
			else{
				in_map_a.put(cur_entry.getKey(), cur_entry.getValue());
			}
		}
	}
	
	/**
	 * 减法合并
	 * in_map_a -= in_map_b
	 * @param in_map_a
	 * @param in_map_b
	 */
	private void TreeMap_sub_merge(TreeMap<String, Double> in_map_a, TreeMap<String, Double> in_map_b){
		for(Map.Entry<String, Double> cur_entry: in_map_b.entrySet()){
			if(in_map_a.containsKey(cur_entry.getKey())){
				in_map_a.put(
						cur_entry.getKey(), 
						in_map_a.get(cur_entry.getKey()) - cur_entry.getValue()
						);
			}
			else{
				in_map_a.put(cur_entry.getKey(), -cur_entry.getValue());
			}
		}
	}
	
	/**
	 * 乘法合并
	 * return = in_map_a * in_map_b
	 * @param in_map_a
	 * @param in_map_b
	 */
	private TreeMap<String, Double> TreeMap_mul_merge(TreeMap<String, Double> in_map_a, TreeMap<String, Double> in_map_b){
		TreeMap<String, Double> cur_map = new TreeMap<String, Double>();
		for(Map.Entry<String, Double> left_entry: in_map_a.entrySet()){
			for(Map.Entry<String, Double> right_entry: in_map_b.entrySet()){
				String cur_str = null;
				if(left_entry.getKey() == "1"){
					cur_str = right_entry.getKey();
				}
				else if(right_entry.getKey() == "1"){
					cur_str = left_entry.getKey();
				}
				else if(left_entry.getKey().hashCode() < right_entry.getKey().hashCode()){
					cur_str = left_entry.getKey() + "*" + right_entry.getKey();
				}
				else{
					cur_str = right_entry.getKey() + "*" + left_entry.getKey();
				}
				Double temp_double = new Double(0.0);
				if(cur_map.containsKey(cur_str)){
					temp_double = cur_map.get(cur_str);
				}
				cur_map.put(cur_str, temp_double + left_entry.getValue() * right_entry.getValue());
			}
		}
		return cur_map;
	}
	
	/**
	 * 除法合并
	 * return = in_map_a / in_map_b
	 * @param in_map_a
	 * @param in_map_b
	 */
	private TreeMap<String, Double> TreeMap_div_merge(TreeMap<String, Double> in_map_a, TreeMap<String, Double> in_map_b){
		TreeMap<String, Double> cur_map = null;
		if(in_map_b.size() == 1 && in_map_b.containsKey("1")){
			cur_map = in_map_a;
			for(Map.Entry<String, Double> cur_entry: in_map_a.entrySet()){
				cur_map.put(cur_entry.getKey(), cur_entry.getValue() / in_map_b.get("1"));
			}
		}
		else{
			cur_map = new TreeMap<String, Double>();
			String right_str = CValueGen.map_to_str(in_map_b);
			for(Map.Entry<String, Double> cur_entry: in_map_a.entrySet()){
				cur_map.put(cur_entry.getKey() + "/(" + right_str + ")", cur_entry.getValue());
			}
		}
		return cur_map;
	}
	
	private void check_treemap(TreeMap<String, Double> in_map){
		//处理0
		if(in_map.size() == 1 && in_map.containsKey("0")){
			in_map.put("0", 0.0);
		}
		else if(in_map.size() > 1 && in_map.containsKey("0")){
			in_map.remove("0");
		}
		else if(in_map.containsValue(0.0)){
			LinkedList<String> need_to_remove = new LinkedList<String>();
			for(Map.Entry<String, Double> cur_entry: in_map.entrySet()){
				if(cur_entry.getValue() == 0.0){
					need_to_remove.add(cur_entry.getKey());
				}
			}
			for(String cur_key: need_to_remove){
				in_map.remove(cur_key);
			}
		}
		
		if(in_map.isEmpty()){
			in_map.put("0", 0.0);
		}
	}
	
	private String get_set_left_arg_str(CDeduceExpr in_expr){
		String return_result = null;
		if(in_expr.type == DeduceDef.SET_LEFT_ARG){
			if(in_expr.right_data == null){
				return_result = in_expr.left_data.data;
			}
			else if(in_expr.right_data.type == DeduceDef.SET_LEFT_ARG){
				return_result = in_expr.left_data.data + "," + get_set_left_arg_str(in_expr.right_data);
			}
		}
		return return_result;
	}
	
	public TreeMap<String, Double> adv_toString(){
		TreeMap<String, Double> return_result = null;
		if(this.type == DeduceDef.DATA){
			return_result = new TreeMap<String, Double>();
			if(this.data.charAt(0) >= '0' && this.data.charAt(0) <= '9'){
				return_result.put("1", new Double(this.data));
			}
			else{
				return_result.put(this.data, 1.0);
			}
		}
		else if(this.type == DeduceDef.REV){
			return_result = left_data.adv_toString();
			for(Map.Entry<String, Double> cur_entry: return_result.entrySet()){
				cur_entry.setValue(-cur_entry.getValue());
			}
		}
		else if(this.type == DeduceDef.SET_ELE){
			return_result = new TreeMap<String, Double>();
			String cur_str = get_set_left_arg_str(this.left_data) + " | ";
			cur_str += CValueGen.map_to_str(this.right_data.adv_toString());
			return_result.put(cur_str, 1.0);
		}
		else if(this.type.get_level() == 0 || this.type.get_level() == -1){
			//如果是条件语句
			return_result = new TreeMap<String, Double>();
			return_result.put(
					"(" +
					CValueGen.map_to_str(left_data.adv_toString()) + 
					")" +
					this.type.toString() + 
					"(" +
					CValueGen.map_to_str(right_data.adv_toString()) +
					")", 
					1.0);
		}
		else{
			TreeMap<String, Double> left_map = left_data.adv_toString(),
					right_map = right_data.adv_toString();
			if(this.type == DeduceDef.ADD){
				TreeMap_add_merge(left_map, right_map);
				return_result = left_map;
			}
			else if(this.type == DeduceDef.SUB){
				TreeMap_sub_merge(left_map, right_map);
				return_result = left_map;
			}
			else if(this.type == DeduceDef.MUL){
				return_result = TreeMap_mul_merge(left_map, right_map);
			}
			else if(this.type == DeduceDef.DIV){
				return_result = TreeMap_div_merge(left_map, right_map);
			}
			
		}
		check_treemap(return_result);
		return return_result;
	}
}
