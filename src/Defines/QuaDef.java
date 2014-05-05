package Defines;
import Parsers.GrammarBParser;


public enum QuaDef {
	//No use
	INIT_TYPE,
	EMPTY,
	//Special ID
	GLO_DEC,
	GLO_DEC_END,
	GLO_ARG,
	GLO_ARG_END,
	GLO_INV,
	GLO_INV_END,
	GLO_ATT,
	GLO_ATT_END,
	GLO_CON_DEC,
	GLO_CON_DEC_END,
	GLO_VAL_DEC,
	GLO_VAL_DEC_END,
	FUNC_DEC,
	FUNC_DEC_END,
	FUNC_DEF,
	FUNC_DEF_END,
	FUNC,
	FUNC_END,
	FUNC_ARG,
	FUNC_ARG_END,
	FUNC_CON_DEC,
	FUNC_CON_DEC_END,
	FUNC_VAL_DEC,
	FUNC_VAL_DEC_END,
	LABEL,
	LOOP,
	LOOP_END,
	//Op
	DEC,
	ARG,
	ADD,
	SUB,
	MUL,
	DIV,
	REV,
	IFNOT,
	IFNOT_L,//while stat
	GOTO_I,//if stat
	GOTO_L,//while stat
	GRE,
	EGRE,
	LES,
	ELES,
	EQU,
	UEQU,
	RET,
	ASS,
	NAME,
	//Set
	UNI,//并集
	INT,//交集
	SUB_S,//集合减
	//State 
	FUNC_BODY,
	
	//Scane
	FUNC_SCANE,
	//Loop
	LOOP_GEN,
	LOOP_CHANGE,
	LOOP_INPUT,
	LOOP_CONFIRM,
	//loop_block的替代语句
	LOOP_BLOCK,
	JUMP;//专门做循环替代的跳转
	
	public String toString(){
		return super.toString().toLowerCase();
	}
	
	public static QuaDef math_relationship_to_quadef(int in_index){
		QuaDef return_result = null;
		switch (in_index) {
		case GrammarBParser.GRE:
			return_result = QuaDef.GRE;
			break;
		case GrammarBParser.EGRE:
			return_result = QuaDef.EGRE;
			break;
		case GrammarBParser.LES:
			return_result = QuaDef.LES;
			break;
		case GrammarBParser.ELES:
			return_result = QuaDef.ELES;
			break;
		case GrammarBParser.EQU:
			return_result = QuaDef.EQU;
			break;
		case GrammarBParser.UEQU:
			return_result = QuaDef.UEQU;
			break;
		default:
			break;
		}
		return return_result;
	}
}
