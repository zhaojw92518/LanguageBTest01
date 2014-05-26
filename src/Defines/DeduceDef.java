package Defines;

import java.util.LinkedList;

public enum DeduceDef {
	DATA,
	IF,
	ASS,
	
	REV,
	RET,
	
	//元组
	ELEMENT_GROUP,
	ELEMENT_GROUP_DATA,
	
	//集合不定数量元素表示
	SET_ELE,
	SET_LEFT_ARG,
	
	//集合运算
	UNI,
	INT,
	SUB_S,
	
	//level 2
	MUL,
	DIV,
	
	//level 1
	ADD,
	SUB,
	
	//level 0
	LES,
	ELES,
	EQU,
	GRE,
	EGRE,
	UEQU,
	
	
	NOT,
	AND,
	OR,
	ENT;//蕴含
	
	private static int[] level_array = new int[100];
	public static void level_array_init(){
		level_array[MUL.ordinal()] = 2;
		level_array[DIV.ordinal()] = 2;
		
		level_array[ADD.ordinal()] = 1;
		level_array[SUB.ordinal()] = 1;
		
		level_array[LES.ordinal()] = 0;
		level_array[ELES.ordinal()] = 0;
		level_array[EQU.ordinal()] = 0;
		level_array[GRE.ordinal()] = 0;
		level_array[EGRE.ordinal()] = 0;
		level_array[UEQU.ordinal()] = 0;
		
		level_array[NOT.ordinal()] = -1;
		level_array[AND.ordinal()] = -1;
		level_array[OR.ordinal()] = -1;
		level_array[ENT.ordinal()] = -1;
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
		else if(equals(ELES)){
			return_result = " <= ";
		}
		else if(equals(GRE)){
			return_result = " > ";
		}
		else if(equals(EGRE)){
			return_result = " >= ";
		}
		else if(equals(EQU)){
			return_result = " == ";
		}
		else if(equals(UEQU)){
			return_result = " != ";
		}
		else if(equals(UNI)){
			return_result = " \\-/ ";
		}
		else if(equals(INT)){
			return_result = " /-\\ ";
		}
		else if(equals(SUB_S)){
			return_result = " -- ";
		}
		else if(equals(NOT)){
			return_result = " ~ ";
		}
		else if(equals(AND)){
			return_result = " /\\ ";
		}
		else if(equals(OR)){
			return_result = " \\/ ";
		}
		else if(equals(ENT)){
			return_result = " -> ";
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
