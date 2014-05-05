package Parsers;

import Deducers.CDeduceExpr;
import Deducers.CSetStruct;
import Deducers.CValueGen;
import Defines.DataDef;

public class CDataEntity {
	public DataDef type = null;
	public CDeduceExpr expr = null;
	public CSetStruct set_struct = null;
	
	public CDataEntity(){

	}
	
	public CDataEntity(CDeduceExpr in_expr){
		this.expr = in_expr;
		this.type = DataDef.VALUE;
	}
	
	public CDataEntity(CSetStruct in_set_struct){
		this.set_struct = in_set_struct;
		this.type = DataDef.SET;
	}
	
	public CDataEntity(CDataEntity in_entity){
		this.type = in_entity.type;
		if(in_entity.expr != null){
			this.expr = in_entity.expr.dup();
		}
		if(in_entity.set_struct != null){
			this.set_struct = in_entity.set_struct.dup();
		}
	}
	
	public String toString(){
		String return_result = null;
		if(type == DataDef.VALUE){
			return_result = CValueGen.map_to_str(expr.adv_toString());
		}
		else if(type == DataDef.SET){
			return_result = set_struct.toString();
		}
		return return_result;
	}
}
