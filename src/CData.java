
class CData {
		
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
	
	public boolean if_temp(){
		return type == DataDef.ID && (!data_str.isEmpty()) && data_str.charAt(0) == '@';
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
