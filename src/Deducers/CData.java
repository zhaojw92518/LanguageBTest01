package Deducers;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;

import Defines.DataDef;


public class CData {
	public DataDef type = DataDef.NO_USE, type_data = DataDef.NO_USE;
	public String data_str = null;
	
	public HashSet<CData> set_list = new HashSet<CData>();
	public LinkedList<CData> element_group = new LinkedList<>();
	
	public CData() {}
	
	public CData(DataDef in_type, DataDef in_type_data){
		type = in_type;
		type_data = in_type_data;
	}
	
	public CData(DataDef in_type, String in_data_str) {
		type = in_type;
		data_str = in_data_str;
	}
	
	public String toString(){
		if(type == DataDef.SET){
			return set_list.toString();
		}
		else if(type == DataDef.TYPE){
			return type_data.toString();
		}
		else 
			return data_str;
	}
	
	public String get_type_str(){
		return type.toString();
	}
	
	public static final boolean judge_temp(String in_id_str){
		return (!in_id_str.isEmpty()) && in_id_str.charAt(0) == '@';
	}
	
	public static final boolean judge_temp(CData in_id_data){
		return in_id_data.type == DataDef.ID && (!in_id_data.data_str.isEmpty()) && in_id_data.data_str.charAt(0) == '@';
	}
	
	public int hashCode(){
		return data_str.hashCode();
	}
	
	public boolean equals(Object in_data){
		return (in_data instanceof CData) 
				&& this.data_str.equals(((CData)in_data).data_str)
				&& this.type.equals(((CData)in_data).type);
	}
	
	public void add_set_element(CData in_data){
		set_list.add(in_data);
	}
	
	public void add_element_group(CData in_data){
		element_group.add(in_data);
	}
}
