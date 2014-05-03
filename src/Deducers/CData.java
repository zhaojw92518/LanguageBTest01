package Deducers;
import Defines.DataDef;


public class CData {
	public DataDef type = DataDef.NO_USE;
	public String data_str = null;
	
	public CData() {}
	
	public CData(DataDef in_type, String in_data_str) {
		type = in_type;
		data_str = in_data_str;
	}
	
	public String toString(){
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
}
