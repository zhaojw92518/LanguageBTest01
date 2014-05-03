
public class CSymbolTerm {
	public SymbolType symbol_type = SymbolType.NO_INIT;
	public double data = 0.0;
	
	public CSymbolTerm(SymbolType in_type){
		symbol_type = in_type;
	}
	
	public CSymbolTerm(SymbolType in_type, String in_data){
		symbol_type = in_type;
		data = Double.parseDouble(in_data);
	}
}
