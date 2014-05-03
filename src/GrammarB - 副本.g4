grammar GrammarB;

//parse
abstact_machine:	'MACHINE' ID '(' argument_list ')' 
					'INVARIANT' (proposition)? 
					'ATTRIBUTE' (const_interupt)? (valuable_interupt)? 
					'OPERATIONS' ( have_return_declare | no_return_declare )* (have_return_define | no_return_define)*
					'END'	;

valuable_declare:	TYPE ID(','TYPE ID)*	;
valuable_interupt:	(valuable_declare';')+	;
const_declare:	'int' 			ID '=' INTEGER			(',' ID '=' INTEGER)* 		|
				'double' 		ID '=' REAL 			(',' ID '=' REAL)* 			|
				'char' 			ID '=' CHAR 			(',' ID '=' CHAR)* 			|
				'string' 		ID '=' STRING 			(',' ID '=' STRING)* 		|
				'set' 			ID '=' set 				(',' ID '=' set)* 			|
				'tuple' 		ID '=' element_group	(',' ID '=' element_group)* |
				'bool' 			ID '=' BOOL 			(',' ID '=' BOOL)* 			|
				'proposition' 	ID '=' proposition 		(',' ID '=' proposition)	;
const_interupt:	('const' const_declare ';')+	;

argument_list:	( TYPE ID (',' TYPE ID)* )?	;
value_argument_list:	( element (',' element)* )?	;
have_return_call:	ID '(' value_argument_list ')'	;
no_return_call:		ID '(' value_argument_list ')'	;

element:	BOOL | INTEGER | REAL | CHAR | STRING | expression | element_group | set | ID | proposition | NIL	;
element_group:	'<' element (element)* '>'	;

//expression part
expression:	('+' | '-')? term (ADDSUB term)*	;
term:	factor (MULDIV factor)*	;
factor:	ID | '(' expression ')' | INTEGER | REAL | CHAR | have_return_call;

//proposition part
proposition_term_0:		ID | BOOL | have_return_call | '(' proposition ')' | set_relation_proposition | element_set_relation_proposition	;
proposition_term_1:		(PROPOSITION_SYMBOL_1)* proposition_term_0	;
proposition_term_2:		proposition_term_1 (PROPOSITION_SYMBOL_2 proposition_term_1)*	;
proposition_term_3:		proposition_term_2 (PROPOSITION_SYMBOL_3 proposition_term_2)*	;
proposition:			proposition_term_3 (PROPOSITION_SYMBOL_4 proposition_term_3)*	;

//set part
set_term_0:		ID | have_return_call | '(' set ')' | '{' element '}' | '{' (ID | element_group) '|' proposition '}'	;
set_term_1:		set_term_0 (SET_SYMBOL_1 set_term_0)*	;
set:			set_term_1 (SET_SYMBOL_2 set_term_1)*	;
element_set_relation_proposition:	element ELEMENT_SET_SYMBOL set | expression	;
set_relation_proposition:	set SET_RELATION_SYMBOL set 	;

//stat part
multi_stat:	('INVARIANT' proposition)? ('ATTRIBUTE' (const_interupt)? (valuable_interupt)?)? (stat)*	;
stat:	condition_stat | circulate_stat | have_return_call ';' | no_return_call ';' | assign_stat ';' | return_stat ';' 	;
assign_stat:	ID '=' element 	;
return_stat:	'return' (element)?	;
condition_stat:	'if' '(' condition ')' '{' (stat)* '}' ('else' '{' (stat)* '}')*	;
condition:	proposition 	;
circulate_stat:	'while' '(' condition ')' '{' (stat)+ '}'	;
have_return_declare:	TYPE ID '(' argument_list ')' ';'	;
have_return_define:		TYPE ID '(' argument_list ')' '{' multi_stat '}'	;
no_return_declare:		'void' ID '(' argument_list ')' ';'	;
no_return_define:		'void' ID '(' argument_list ')' '{' multi_stat '}'	;

//other part
//get_element_in_group:	(element_group | ID) '\[' INTEGER '\]'	;

//lex
ID:	LETTER(LETTER|NUM)*;
TYPE:	'int'|'double'|'char'|'string'|'proposition'|'set'|'tuple';
BOOL:	'TRUE'|'FALSE'	;
CHAR:	'\''CHARACTER'\''	;
STRING:	'"'(CHARACTER)*'"'	;
NIL:	'nil'	;
INTEGER:	('+'|'-')? (NO_ZERO_NUM(NUM)*) | '0'	;
REAL: ('+'|'-')? INTEGER ('.'NUM(NUM)*)?	;
ADDSUB:	'+' | '-'	;
MULDIV:	'*' | '\\'	;
PROPOSITION_SYMBOL_1:	'~'		;
PROPOSITION_SYMBOL_2:	'/\\'	;
PROPOSITION_SYMBOL_3:	'\\/'	;
PROPOSITION_SYMBOL_4:	'->'	;
MATH_RELATION_SYMBOL:	'<' | '<=' | '>=' | '>' | '==' | '!='	;
ELEMENT_SET_SYMBOL:	':' | '!:'	;
SET_RELATION_SYMBOL:	'<' | '<=' | '>=' | '>' | '==' | '!='	;
SET_SYMBOL_1:	'/-\\' | '\\-/'	;
SET_SYMBOL_2:	'--'	;




// fragments 
fragment LETTER: ['_'a-zA-Z];
fragment NO_ZERO_NUM:	[1-9];
fragment NUM: '0'|NO_ZERO_NUM;
fragment CHARACTER:	LETTER|NUM;

