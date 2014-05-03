grammar GrammarB;

//parse
abstact_machine:	MACHINE ID LEFT_BRACKET (argument_list)? RIGHT_BRACKET 
					INVARIANT (proposition)? 
					ATTRIBUTE const_interupt valuable_interupt 
					OPERATIONS ( function_declare )* ( function_define )*
					END	;

function_declare: 	have_return_declare | no_return_declare	;
function_define:	have_return_define | no_return_define	;

valuable_declare:	type ID(COMMA ID)*	;
valuable_interupt:	(valuable_declare SEMICOLON)*	;
const_declare:	INT_TYPE 			ID ASSIGN_SYMBOL signed_integer			(COMMA ID ASSIGN_SYMBOL signed_integer)* 		|
				DOUBLE_TYPE 		ID ASSIGN_SYMBOL signed_real 			(COMMA ID ASSIGN_SYMBOL signed_real)* 			|
				CHAR_TYPE 			ID ASSIGN_SYMBOL CHAR 				(COMMA ID ASSIGN_SYMBOL CHAR)* 			|
				STRING_TYPE 		ID ASSIGN_SYMBOL STRING 			(COMMA ID ASSIGN_SYMBOL STRING)* 		|
				SET_TYPE 			ID ASSIGN_SYMBOL set 				(COMMA ID ASSIGN_SYMBOL set)* 			|
				TUPLE_TYPE 			ID ASSIGN_SYMBOL element_group		(COMMA ID ASSIGN_SYMBOL element_group)* |
				BOOL_TYPE 			ID ASSIGN_SYMBOL BOOL 				(COMMA ID ASSIGN_SYMBOL BOOL)* 			|
				PROPOSITION_TYPE 	ID ASSIGN_SYMBOL proposition 		(COMMA ID ASSIGN_SYMBOL proposition)	;
const_interupt:	(CONST const_declare SEMICOLON)*	;

argument_list:	type ID (COMMA type ID)*	;
value_argument_list:	( element (COMMA element)* )?	;
have_return_call:	ID LEFT_BRACKET value_argument_list RIGHT_BRACKET	;
no_return_call:		ID LEFT_BRACKET value_argument_list RIGHT_BRACKET	;

element:	expression | element_group | BOOL | INTEGER | REAL | CHAR | STRING | ID | NIL | proposition	;
element_group:	LEFT_ANGLE_BRACKET element (COMMA element)* RIGHT_ANGLE_BRACKET	;

//expression part
expression:			(addsub)? term expression_expand ;
expression_expand:	(addsub term)*					 ;
term:				factor (muldiv factor)*			 ;

factor:	ID 										| 
		LEFT_BRACKET expression RIGHT_BRACKET 	| 
		INTEGER 								| 
		REAL 									| 
		CHAR 									| 
		have_return_call						|
		set;

//proposition part

math_relation_symbol:	GRE | EGRE | LES | ELES | EQU | UEQU	;
math_relation_proposition:	expression math_relation_symbol expression;

proposition_term_0:		ID 										|
						BOOL 									| 
						have_return_call 						| 
						LEFT_BRACKET proposition RIGHT_BRACKET 	| 
						element_set_relation_proposition 		|	
						math_relation_proposition				;

proposition_term_1:		(PROPOSITION_SYMBOL_1)* proposition_term_0	;
proposition_term_2:		proposition_term_1 (PROPOSITION_SYMBOL_2 proposition_term_1)*	;
proposition_term_3:		proposition_term_2 (PROPOSITION_SYMBOL_3 proposition_term_2)*	;
proposition:			change_1 change_4	;

change_1:	(PROPOSITION_SYMBOL_1)* change_1_temp_1 change_2  	|
			(PROPOSITION_SYMBOL_1)*	change_1_temp_2 change_3 	| 
			('~')+ proposition;
change_1_temp_1:ID 											|  
				BOOL 										|
				have_return_call 							|
				LEFT_BRACKET proposition RIGHT_BRACKET 		|
				expression 									|
				math_relation_proposition;
				
change_1_temp_2:BOOL 			|
				INTEGER 		|
				REAL 			|
				CHAR 			|
				STRING 			|
				expression 		|
				element_group 	|
				set 			|
				ID 				|
				NIL ;
change_2:	(PROPOSITION_SYMBOL_2 proposition_term_1)* 
			(PROPOSITION_SYMBOL_3 proposition_term_2)* 
			(PROPOSITION_SYMBOL_4 proposition_term_3)* ;
change_3:	ELEMENT_SET_SYMBOL set change_2	;
change_4:	(
				proposition change_3 	|
				change_3
			)?	;

//set part
set_term_0:		ID 															|
				have_return_call 											| 
				LEFT_BRACKET set RIGHT_BRACKET 								| 
				LEFT_BRACE (element (COMMA element)*)? RIGHT_BRACE 			| 
				LEFT_BRACE (ID | element_group) '|' proposition RIGHT_BRACE	;
				
set_term_1:		set_term_0 (SET_SYMBOL_1 set_term_0)*	;
set:			set_term_1 (SET_SYMBOL_2 set_term_1)*	;
element_set_relation_proposition:	element ELEMENT_SET_SYMBOL set | expression	;

//stat part
multi_stat:	(INVARIANT proposition)? (ATTRIBUTE const_interupt valuable_interupt)? (stat)+	;
stat:	condition_stat 				|
		circulate_stat 				| 
		have_return_call SEMICOLON 	| 
		no_return_call SEMICOLON 	| 
		assign_stat SEMICOLON 		| 
		return_stat SEMICOLON 		;
assign_stat:	ID ASSIGN_SYMBOL element 	;
return_stat:	'return' (element)?	;
condition_stat:	'if' LEFT_BRACKET condition RIGHT_BRACKET LEFT_BRACE (stat)* RIGHT_BRACE (else_stat)?	;
else_stat: 'else' LEFT_BRACE (stat)* RIGHT_BRACE	;
condition:	proposition 	;
circulate_stat:	'while' LEFT_BRACKET condition RIGHT_BRACKET LEFT_BRACE (stat)+ RIGHT_BRACE	;

have_return_define:		type return_define	;
no_return_define:		VOID return_define	;
return_define:			ID LEFT_BRACKET (argument_list)? RIGHT_BRACKET LEFT_BRACE multi_stat RIGHT_BRACE	;

have_return_declare:	type return_declare		;
no_return_declare:		VOID return_declare	;
return_declare:			ID LEFT_BRACKET (argument_list)? RIGHT_BRACKET SEMICOLON	;


//other part
//get_element_in_group:	(element_group | ID) '\[' INTEGER '\]'	;
type:	INT_TYPE | DOUBLE_TYPE | CHAR_TYPE | STRING_TYPE | PROPOSITION_TYPE | SET_TYPE | TUPLE_TYPE	| BOOL_TYPE;
signed_integer: (addsub)?INTEGER	;
signed_real: (addsub)?REAL			;

addsub:	ADD | SUB;
muldiv:	MUL | DIV;

//lex
INT_TYPE: 			'int'			;
DOUBLE_TYPE: 		'double'		;
CHAR_TYPE:			'char'			;
STRING_TYPE:		'string'		;
PROPOSITION_TYPE:	'proposition'	;
SET_TYPE:			'set'			;
TUPLE_TYPE:			'tuple'			;
BOOL_TYPE:			'bool'			;

ASSIGN_SYMBOL:	'='		;
LEFT_BRACKET:	'('		;
RIGHT_BRACKET:	')'		;
COMMA:			','		;
SEMICOLON:		';'		;
LEFT_BRACE:		'{'		;
RIGHT_BRACE:	'}'		;
LEFT_ANGLE_BRACKET:	'<<'	;
RIGHT_ANGLE_BRACKET:'>>'	;

CONST: 'const'	;
MACHINE: 'MACHINE'	;
INVARIANT:	'INVARIANT'	;
ATTRIBUTE:	'ATTRIBUTE'	;
OPERATIONS:	'OPERATIONS';
END:	'END'	;

VOID:	'void'	;
BOOL:	'TRUE'|'FALSE'	;
CHAR:	'\''CHARACTER'\''	;
STRING:	'"'(CHARACTER)*'"'	;
NIL:	'nil'	;
INTEGER:	(NO_ZERO_NUM(NUM)*) | '0'	;
REAL: INTEGER ('.'NUM(NUM)*)?	;

PROPOSITION_SYMBOL_1:	'~'		;
PROPOSITION_SYMBOL_2:	'/\\'	;
PROPOSITION_SYMBOL_3:	'\\/'	;
PROPOSITION_SYMBOL_4:	'->'	;
ELEMENT_SET_SYMBOL:	':' | '!:'	;
//SET_RELATION_SYMBOL:	'<' | '<=' | '>=' | '>' | '==' | '!='	;
SET_SYMBOL_1:	'/-\\' | '\\-/'	;
SET_SYMBOL_2:	'--'	;

GRE:	'>'		;
EGRE:	'>='	;
LES:	'<'		;
ELES:	'<='	;
EQU:	'=='	;
UEQU:	'!='	;

ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';

ID:	LETTER(LETTER|NUM)*;

WS : [ \t\r\n]+ -> skip ;


// fragments 
fragment LETTER: ['_'a-zA-Z];
fragment NO_ZERO_NUM:	[1-9];
fragment NUM: '0'|NO_ZERO_NUM;
fragment CHARACTER:	LETTER|NUM;

