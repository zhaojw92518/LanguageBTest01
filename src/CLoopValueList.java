import java.util.HashMap;
import java.util.Map;

public class CLoopValueList {
	public HashMap<CData, String> values = new HashMap<CData, String>();
	
	public void assign_to_deduce_magr(CDeduceTableMagr in_magr){
		for(Map.Entry<CData, String> cur_entry: values.entrySet()){
			in_magr.set_term(cur_entry.getKey(), cur_entry.getValue());
		}
	}
	
	public void create_value(CData in_id_data){
		if(!values.containsKey(in_id_data) && !in_id_data.if_temp()){
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
