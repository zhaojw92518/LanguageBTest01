
class CQuaternion {
	public static final int NO_USE_LINE_NUM = 0;
	
	public QuaDef type = QuaDef.INIT_TYPE;
	public int line_num = NO_USE_LINE_NUM;
	public CData data_0 = null, data_1 = null, data_2 = null;
	public String deduce_str = null;
	
	
	public CQuaternion(){}
	
	public CQuaternion(QuaDef in_type, int in_line_num){
		type = in_type;
		line_num = in_line_num;
	}
	
	public CQuaternion(QuaDef in_type, CData in_data_0, int in_line_num){
		type = in_type;
		data_0 = in_data_0;
		line_num = in_line_num;
	}
	
	public CQuaternion(QuaDef in_type, CData in_data_0, CData in_data_1, int in_line_num){
		type = in_type;
		data_0 = in_data_0;
		data_1 = in_data_1;
		line_num = in_line_num;
	}
	
	public CQuaternion(QuaDef in_type, CData in_data_0, CData in_data_1, CData in_data_2, int in_line_num){
		type = in_type;
		data_0 = in_data_0;
		data_1 = in_data_1;
		data_2 = in_data_2;
		line_num = in_line_num;
	}
	
	public String toString(){
		char[] return_result = new char[101];
		for(int i = 0; i < 101; i++){
			return_result[i] = ' ';
		}
		return_result[100] = '\0';
		
		String type_str = type.toString();
		for(int i = 0; i < type_str.length(); i++){
			return_result[i] = type_str.charAt(i);
		}

		if(data_0 != null){
			String data_0_str = data_0.toString();
			for(int i = 0; i < data_0_str.length(); i++){
				return_result[20 + i] = data_0_str.charAt(i);
			}
		}
		if(data_1 != null){
			String data_1_str = data_1.toString();
			for(int i = 0; i < data_1_str.length(); i++){
				return_result[40 + i] = data_1_str.charAt(i);
			}
		}
		if(data_2 != null){
			String data_2_str = data_2.toString();
			for(int i = 0; i < data_2_str.length(); i++){
				return_result[60 + i] = data_2_str.charAt(i);
			}
		}
		Integer temp_line = new Integer(line_num);
		String line_str = temp_line.toString();
		for(int i = 0; i < line_str.length(); i++){
			return_result[80 + i] = line_str.charAt(i);
		}
		
		return new String(return_result);
	}
}
