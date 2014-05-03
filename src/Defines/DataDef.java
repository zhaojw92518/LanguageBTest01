package Defines;

import Parsers.GrammarBParser;

public enum DataDef {
	NO_USE,
	INT,
	DOUBLE,
	ID,
	CHAR,
	SPEC,
	SET,
	VALUE,//值变量
	TYPE;
	
	public String toString(){
		return super.toString().toLowerCase();
	}
	
	public static DataDef get_data_def_from_parser(int in_type){
		DataDef return_result = null;
		if(in_type == GrammarBParser.INT_TYPE){
			return_result = INT;
		}
		else if(in_type == GrammarBParser.SET_TYPE){
			return_result = SET;
		}
		return return_result;
	}
}
