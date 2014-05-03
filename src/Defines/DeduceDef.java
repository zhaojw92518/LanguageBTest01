package Defines;

import java.util.LinkedList;

public enum DeduceDef {
	DATA,
	IF,
	ASS,
	
	REV,
	RET,
	
	//level 2
	MUL,
	DIV,
	
	//level 1
	ADD,
	SUB,
	
	//level 0
	LES,
	EQU,
	GRE,
	UEQU;
	
	private static int[] level_array = new int[100];
	public static void level_array_init(){
		level_array[MUL.ordinal()] = 2;
		level_array[DIV.ordinal()] = 2;
		
		level_array[ADD.ordinal()] = 1;
		level_array[SUB.ordinal()] = 1;
		
		level_array[LES.ordinal()] = 0;
		level_array[EQU.ordinal()] = 0;
		level_array[GRE.ordinal()] = 0;
		level_array[UEQU.ordinal()] = 0;
	}
	
	public int get_level(){
		return level_array[this.ordinal()];
	}
	
	public String toString(){
		String return_result = null;
		if(equals(ADD)){
			return_result = " + ";
		}
		else if(equals(SUB)){
			return_result = " - ";
		}
		else if(equals(MUL)){
			return_result = " * ";
		}
		else if(equals(DIV)){
			return_result = " / ";
		}
		else if(equals(LES)){
			return_result = " < ";
		}
		else if(equals(GRE)){
			return_result = " > ";
		}
		else if(equals(EQU)){
			return_result = " == ";
		}
		else if(equals(UEQU)){
			return_result = " != ";
		}
		return return_result;
	}
	
	public static final LinkedList<DeduceDef> get_math_symbols(){
		LinkedList<DeduceDef> return_result = new LinkedList<>();
		return_result.add(ADD);
		return_result.add(SUB);
		return_result.add(MUL);
		return_result.add(DIV);
		return return_result;
	}
}
