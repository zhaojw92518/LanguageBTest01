import java.util.HashMap;

public class CSymbolTable {
	private HashMap<String, CSymbolTerm> global_list = new HashMap<String, CSymbolTerm>(),
								 local_list  = new HashMap<String, CSymbolTerm>();
			
	public void push_back_global(String in_id, CSymbolTerm in_term){
		global_list.put(in_id, in_term);
	}
	
	public boolean global_if_have(String in_id){
		return global_list.containsKey(in_id);
	}
	
	public void push_back_local(String in_id, CSymbolTerm in_term){
		local_list.put(in_id, in_term);
	}
	
	public boolean local_if_have(String in_id){
		return local_list.containsKey(in_id);
	}
	
	public boolean all_if_have(String in_id){
		return local_if_have(in_id) || global_if_have(in_id);
	}
	
	public void set_id_data(String in_id, String in_data){
		if(local_if_have(in_id)){
			
		}
	}
}
