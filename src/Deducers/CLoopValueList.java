package Deducers;
import java.util.HashMap;
import java.util.Map;

import Defines.DataDef;

public class CLoopValueList {
	public HashMap<CData, String> values = new HashMap<CData, String>();
	
	public void create_value(CData in_id_data){
		if(!values.containsKey(in_id_data) && !CData.judge_temp(in_id_data)){
			values.put(in_id_data, null);
		}
	}
	
	public void set_value(String in_id, String in_data){
		CData temp_cdata = new CData(DataDef.ID, in_id);
		if(values.containsKey(temp_cdata)){
			values.put(temp_cdata, in_data);
		}
	}
}
