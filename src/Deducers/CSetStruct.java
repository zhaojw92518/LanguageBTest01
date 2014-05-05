package Deducers;

import java.util.LinkedList;

import javax.swing.tree.DefaultMutableTreeNode;



import Defines.DataDef;
import Defines.DeduceDef;

public class CSetStruct {
	public CTermTreeSet term_set = null;
	public String set_id = null;
	public DeduceDef type = null;
	public CSetStruct left_set_struct = null,
					   right_set_struct = null;
	
	public CSetStruct(String in_id){
		type = DeduceDef.DATA;
		set_id = in_id;
		term_set = new CTermTreeSet();
	}
	
	public CSetStruct(DeduceDef in_type){
		if(in_type == DeduceDef.DATA){
			term_set = new CTermTreeSet();
			type = DeduceDef.DATA;
		}
		else{
			type = in_type;
		}
	}
	
	public CSetStruct(DeduceDef in_type, CSetStruct in_left_set_struct, CSetStruct in_right_set_struct){
		this.type = in_type;
		this.left_set_struct = in_left_set_struct;
		this.right_set_struct = in_right_set_struct;
	}
	
	public CSetStruct dup(){
		CSetStruct return_result = null;
		if(this.type == DeduceDef.DATA){
			return_result = new CSetStruct(DeduceDef.DATA);
			if(this.set_id != null){
				return_result.set_id = new String(this.set_id);
			}
			else{
				for(CDeduceTerm cur_term: this.term_set){
					return_result.term_set.add(new CDeduceTerm(cur_term));
				}
			}
		}
		else{
			return_result = new CSetStruct(this.type);
			return_result.left_set_struct = this.left_set_struct.dup();
			return_result.right_set_struct = this.right_set_struct.dup();
		}
		return return_result;
	}
	
	public void assign(CSetStruct in_set_struct){
		this.type = in_set_struct.type;
		this.set_id = in_set_struct.set_id;
		this.left_set_struct = in_set_struct.left_set_struct;
		this.right_set_struct = in_set_struct.right_set_struct;
		this.term_set = in_set_struct.term_set;
	}
	
	public void add(CDeduceTerm in_term){
		term_set.add(in_term);
	}
	
	public boolean if_contain(CDeduceTerm in_term){
		return term_set.contains(in_term);
	}
	
	public void sub(CDeduceTerm in_term){
		term_set.remove(in_term);
	}
	
	private static final void treeset_add_all(CTermTreeSet src_set, CTermTreeSet dst_set){
		for(CDeduceTerm cur_term: src_set){
			dst_set.add(cur_term);
		}
	}
	
	public static final CTermTreeSet set_uni(CTermTreeSet left_set, CTermTreeSet right_set){
		CTermTreeSet return_result = new CTermTreeSet();
		treeset_add_all(left_set, return_result);
		treeset_add_all(right_set, return_result);
		return return_result;
	}
	
	public static final CTermTreeSet set_int(CTermTreeSet left_set, CTermTreeSet right_set){
		CTermTreeSet return_result = new CTermTreeSet();
		for(CDeduceTerm cur_term: left_set){
			if(right_set.contains(cur_term)){
				return_result.add(cur_term);
			}
		}
		return return_result;
	}
	
	public static final CTermTreeSet set_sub(CTermTreeSet left_set, CTermTreeSet right_set){
		CTermTreeSet return_result = new CTermTreeSet();
		for(CDeduceTerm cur_term: left_set){
			if(!right_set.contains(cur_term)){
				return_result.add(cur_term);
			}
		}
		return return_result;
	}
	
	public CTermTreeSet get_set_result(){
		CTermTreeSet return_result = null;
		if(this.type == DeduceDef.UNI){
			return_result = set_uni(left_set_struct.get_set_result(), right_set_struct.get_set_result());
		}
		else if(this.type == DeduceDef.INT){
			return_result = set_int(left_set_struct.get_set_result(), right_set_struct.get_set_result());
		}
		else if(this.type == DeduceDef.SUB_S){
			return_result = set_sub(left_set_struct.get_set_result(), right_set_struct.get_set_result());
		}
		else if(this.type == DeduceDef.DATA){
			return_result = this.term_set;
		}
		return return_result;
	}
	
	public String set_to_str(CTermTreeSet in_set){
		String return_result = new String("{");
		for(CDeduceTerm cur_term: in_set){
			return_result += cur_term.toString();
			return_result += ", ";
		}
		if(return_result.length() > 2){
			return_result = return_result.substring(0, return_result.length() - 2);
		}
		return_result += "}";
		return return_result;
	}
	
	public String get_set_result_str(){
		return set_to_str(get_set_result());
	}
	
	public String toString(){
		String return_result = null;
		if(this.type == DeduceDef.DATA){
			if(set_id == null)
				return_result = set_to_str(this.term_set);
			else
				return_result = set_id;
		}
		else{
			return_result = 
					"(" + left_set_struct.toString() + ")" + 
					this.type.toString() + 
					"(" + right_set_struct.toString() + ")";
		}
		return return_result;
	}
	
	public DeduceDef get_type(){
		return this.type;
	}
	
	/*
	 * UI
	 */
	
	public LinkedList<DefaultMutableTreeNode> get_tree_nodes(){
		LinkedList<DefaultMutableTreeNode> return_result = new LinkedList<DefaultMutableTreeNode>();
		for(CDeduceTerm cur_term: this.get_set_result()){
			return_result.add(new DefaultMutableTreeNode(cur_term.get_cur_gen().get_data_str()));
		}
		return return_result;
	}
	
	
}
