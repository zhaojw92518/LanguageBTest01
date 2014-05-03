// Generated from .\GrammarB.g4 by ANTLR 4.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarBParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, INT_TYPE=6, DOUBLE_TYPE=7, CHAR_TYPE=8, 
		STRING_TYPE=9, PROPOSITION_TYPE=10, SET_TYPE=11, TUPLE_TYPE=12, BOOL_TYPE=13, 
		ASSIGN_SYMBOL=14, LEFT_BRACKET=15, RIGHT_BRACKET=16, COMMA=17, SEMICOLON=18, 
		LEFT_BRACE=19, RIGHT_BRACE=20, LEFT_ANGLE_BRACKET=21, RIGHT_ANGLE_BRACKET=22, 
		CONST=23, MACHINE=24, INVARIANT=25, ATTRIBUTE=26, OPERATIONS=27, END=28, 
		VOID=29, BOOL=30, CHAR=31, STRING=32, NIL=33, INTEGER=34, REAL=35, PROPOSITION_SYMBOL_1=36, 
		PROPOSITION_SYMBOL_2=37, PROPOSITION_SYMBOL_3=38, PROPOSITION_SYMBOL_4=39, 
		ELEMENT_SET_SYMBOL=40, SET_SYMBOL_1=41, SET_SYMBOL_2=42, GRE=43, EGRE=44, 
		LES=45, ELES=46, EQU=47, UEQU=48, ADD=49, SUB=50, MUL=51, DIV=52, ID=53, 
		WS=54;
	public static final String[] tokenNames = {
		"<INVALID>", "'while'", "'if'", "'else'", "'return'", "'|'", "'int'", 
		"'double'", "'char'", "'string'", "'proposition'", "'set'", "'tuple'", 
		"'bool'", "'='", "'('", "')'", "','", "';'", "'{'", "'}'", "'<<'", "'>>'", 
		"'const'", "'MACHINE'", "'INVARIANT'", "'ATTRIBUTE'", "'OPERATIONS'", 
		"'END'", "'void'", "BOOL", "CHAR", "STRING", "'nil'", "INTEGER", "REAL", 
		"'~'", "'/\\'", "'\\/'", "'->'", "ELEMENT_SET_SYMBOL", "SET_SYMBOL_1", 
		"'--'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'+'", "'-'", "'*'", 
		"'/'", "ID", "WS"
	};
	public static final int
		RULE_abstact_machine = 0, RULE_function_declare = 1, RULE_function_define = 2, 
		RULE_valuable_declare = 3, RULE_valuable_interupt = 4, RULE_const_declare = 5, 
		RULE_const_interupt = 6, RULE_argument_list = 7, RULE_value_argument_list = 8, 
		RULE_have_return_call = 9, RULE_no_return_call = 10, RULE_element = 11, 
		RULE_element_group = 12, RULE_expression = 13, RULE_expression_expand = 14, 
		RULE_term = 15, RULE_factor = 16, RULE_math_relation_symbol = 17, RULE_math_relation_proposition = 18, 
		RULE_proposition_term_0 = 19, RULE_proposition_term_1 = 20, RULE_proposition_term_2 = 21, 
		RULE_proposition_term_3 = 22, RULE_proposition = 23, RULE_change_1 = 24, 
		RULE_change_1_temp_1 = 25, RULE_change_1_temp_2 = 26, RULE_change_2 = 27, 
		RULE_change_3 = 28, RULE_change_4 = 29, RULE_set_term_0 = 30, RULE_set_term_1 = 31, 
		RULE_set = 32, RULE_element_set_relation_proposition = 33, RULE_set_relation_proposition = 34, 
		RULE_multi_stat = 35, RULE_stat = 36, RULE_assign_stat = 37, RULE_return_stat = 38, 
		RULE_condition_stat = 39, RULE_else_stat = 40, RULE_condition = 41, RULE_circulate_stat = 42, 
		RULE_have_return_define = 43, RULE_no_return_define = 44, RULE_return_define = 45, 
		RULE_have_return_declare = 46, RULE_no_return_declare = 47, RULE_return_declare = 48, 
		RULE_type = 49, RULE_signed_integer = 50, RULE_signed_real = 51, RULE_addsub = 52, 
		RULE_muldiv = 53;
	public static final String[] ruleNames = {
		"abstact_machine", "function_declare", "function_define", "valuable_declare", 
		"valuable_interupt", "const_declare", "const_interupt", "argument_list", 
		"value_argument_list", "have_return_call", "no_return_call", "element", 
		"element_group", "expression", "expression_expand", "term", "factor", 
		"math_relation_symbol", "math_relation_proposition", "proposition_term_0", 
		"proposition_term_1", "proposition_term_2", "proposition_term_3", "proposition", 
		"change_1", "change_1_temp_1", "change_1_temp_2", "change_2", "change_3", 
		"change_4", "set_term_0", "set_term_1", "set", "element_set_relation_proposition", 
		"set_relation_proposition", "multi_stat", "stat", "assign_stat", "return_stat", 
		"condition_stat", "else_stat", "condition", "circulate_stat", "have_return_define", 
		"no_return_define", "return_define", "have_return_declare", "no_return_declare", 
		"return_declare", "type", "signed_integer", "signed_real", "addsub", "muldiv"
	};

	@Override
	public String getGrammarFileName() { return "GrammarB.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarBParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Abstact_machineContext extends ParserRuleContext {
		public TerminalNode INVARIANT() { return getToken(GrammarBParser.INVARIANT, 0); }
		public TerminalNode ID() { return getToken(GrammarBParser.ID, 0); }
		public List<Function_declareContext> function_declare() {
			return getRuleContexts(Function_declareContext.class);
		}
		public Function_declareContext function_declare(int i) {
			return getRuleContext(Function_declareContext.class,i);
		}
		public TerminalNode MACHINE() { return getToken(GrammarBParser.MACHINE, 0); }
		public TerminalNode ATTRIBUTE() { return getToken(GrammarBParser.ATTRIBUTE, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(GrammarBParser.RIGHT_BRACKET, 0); }
		public List<Function_defineContext> function_define() {
			return getRuleContexts(Function_defineContext.class);
		}
		public TerminalNode OPERATIONS() { return getToken(GrammarBParser.OPERATIONS, 0); }
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public Valuable_interuptContext valuable_interupt() {
			return getRuleContext(Valuable_interuptContext.class,0);
		}
		public PropositionContext proposition() {
			return getRuleContext(PropositionContext.class,0);
		}
		public Function_defineContext function_define(int i) {
			return getRuleContext(Function_defineContext.class,i);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(GrammarBParser.LEFT_BRACKET, 0); }
		public Const_interuptContext const_interupt() {
			return getRuleContext(Const_interuptContext.class,0);
		}
		public TerminalNode END() { return getToken(GrammarBParser.END, 0); }
		public Abstact_machineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstact_machine; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitAbstact_machine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Abstact_machineContext abstact_machine() throws RecognitionException {
		Abstact_machineContext _localctx = new Abstact_machineContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_abstact_machine);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(108); match(MACHINE);
			setState(109); match(ID);
			setState(110); match(LEFT_BRACKET);
			setState(112);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << CHAR_TYPE) | (1L << STRING_TYPE) | (1L << PROPOSITION_TYPE) | (1L << SET_TYPE) | (1L << TUPLE_TYPE) | (1L << BOOL_TYPE))) != 0)) {
				{
				setState(111); argument_list();
				}
			}

			setState(114); match(RIGHT_BRACKET);
			setState(115); match(INVARIANT);
			setState(117);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << LEFT_ANGLE_BRACKET) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << NIL) | (1L << INTEGER) | (1L << REAL) | (1L << PROPOSITION_SYMBOL_1) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
				{
				setState(116); proposition();
				}
			}

			setState(119); match(ATTRIBUTE);
			setState(120); const_interupt();
			setState(121); valuable_interupt();
			setState(122); match(OPERATIONS);
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(123); function_declare();
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << CHAR_TYPE) | (1L << STRING_TYPE) | (1L << PROPOSITION_TYPE) | (1L << SET_TYPE) | (1L << TUPLE_TYPE) | (1L << BOOL_TYPE) | (1L << VOID))) != 0)) {
				{
				{
				setState(129); function_define();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135); match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_declareContext extends ParserRuleContext {
		public Have_return_declareContext have_return_declare() {
			return getRuleContext(Have_return_declareContext.class,0);
		}
		public No_return_declareContext no_return_declare() {
			return getRuleContext(No_return_declareContext.class,0);
		}
		public Function_declareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_declare; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitFunction_declare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_declareContext function_declare() throws RecognitionException {
		Function_declareContext _localctx = new Function_declareContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function_declare);
		try {
			setState(139);
			switch (_input.LA(1)) {
			case INT_TYPE:
			case DOUBLE_TYPE:
			case CHAR_TYPE:
			case STRING_TYPE:
			case PROPOSITION_TYPE:
			case SET_TYPE:
			case TUPLE_TYPE:
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(137); have_return_declare();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(138); no_return_declare();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_defineContext extends ParserRuleContext {
		public No_return_defineContext no_return_define() {
			return getRuleContext(No_return_defineContext.class,0);
		}
		public Have_return_defineContext have_return_define() {
			return getRuleContext(Have_return_defineContext.class,0);
		}
		public Function_defineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_define; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitFunction_define(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_defineContext function_define() throws RecognitionException {
		Function_defineContext _localctx = new Function_defineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function_define);
		try {
			setState(143);
			switch (_input.LA(1)) {
			case INT_TYPE:
			case DOUBLE_TYPE:
			case CHAR_TYPE:
			case STRING_TYPE:
			case PROPOSITION_TYPE:
			case SET_TYPE:
			case TUPLE_TYPE:
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(141); have_return_define();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(142); no_return_define();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Valuable_declareContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(GrammarBParser.COMMA); }
		public List<TerminalNode> ID() { return getTokens(GrammarBParser.ID); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode COMMA(int i) {
			return getToken(GrammarBParser.COMMA, i);
		}
		public TerminalNode ID(int i) {
			return getToken(GrammarBParser.ID, i);
		}
		public Valuable_declareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valuable_declare; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitValuable_declare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Valuable_declareContext valuable_declare() throws RecognitionException {
		Valuable_declareContext _localctx = new Valuable_declareContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_valuable_declare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); type();
			setState(146); match(ID);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(147); match(COMMA);
				setState(148); match(ID);
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Valuable_interuptContext extends ParserRuleContext {
		public List<TerminalNode> SEMICOLON() { return getTokens(GrammarBParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(GrammarBParser.SEMICOLON, i);
		}
		public List<Valuable_declareContext> valuable_declare() {
			return getRuleContexts(Valuable_declareContext.class);
		}
		public Valuable_declareContext valuable_declare(int i) {
			return getRuleContext(Valuable_declareContext.class,i);
		}
		public Valuable_interuptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valuable_interupt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitValuable_interupt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Valuable_interuptContext valuable_interupt() throws RecognitionException {
		Valuable_interuptContext _localctx = new Valuable_interuptContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_valuable_interupt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << CHAR_TYPE) | (1L << STRING_TYPE) | (1L << PROPOSITION_TYPE) | (1L << SET_TYPE) | (1L << TUPLE_TYPE) | (1L << BOOL_TYPE))) != 0)) {
				{
				{
				setState(154); valuable_declare();
				setState(155); match(SEMICOLON);
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Const_declareContext extends ParserRuleContext {
		public TerminalNode INT_TYPE() { return getToken(GrammarBParser.INT_TYPE, 0); }
		public List<Element_groupContext> element_group() {
			return getRuleContexts(Element_groupContext.class);
		}
		public TerminalNode STRING(int i) {
			return getToken(GrammarBParser.STRING, i);
		}
		public TerminalNode STRING_TYPE() { return getToken(GrammarBParser.STRING_TYPE, 0); }
		public TerminalNode BOOL_TYPE() { return getToken(GrammarBParser.BOOL_TYPE, 0); }
		public TerminalNode CHAR_TYPE() { return getToken(GrammarBParser.CHAR_TYPE, 0); }
		public TerminalNode TUPLE_TYPE() { return getToken(GrammarBParser.TUPLE_TYPE, 0); }
		public List<TerminalNode> CHAR() { return getTokens(GrammarBParser.CHAR); }
		public List<Signed_integerContext> signed_integer() {
			return getRuleContexts(Signed_integerContext.class);
		}
		public TerminalNode ID(int i) {
			return getToken(GrammarBParser.ID, i);
		}
		public List<TerminalNode> ASSIGN_SYMBOL() { return getTokens(GrammarBParser.ASSIGN_SYMBOL); }
		public List<TerminalNode> ID() { return getTokens(GrammarBParser.ID); }
		public TerminalNode COMMA(int i) {
			return getToken(GrammarBParser.COMMA, i);
		}
		public TerminalNode CHAR(int i) {
			return getToken(GrammarBParser.CHAR, i);
		}
		public List<TerminalNode> BOOL() { return getTokens(GrammarBParser.BOOL); }
		public SetContext set(int i) {
			return getRuleContext(SetContext.class,i);
		}
		public TerminalNode DOUBLE_TYPE() { return getToken(GrammarBParser.DOUBLE_TYPE, 0); }
		public TerminalNode ASSIGN_SYMBOL(int i) {
			return getToken(GrammarBParser.ASSIGN_SYMBOL, i);
		}
		public Element_groupContext element_group(int i) {
			return getRuleContext(Element_groupContext.class,i);
		}
		public TerminalNode PROPOSITION_TYPE() { return getToken(GrammarBParser.PROPOSITION_TYPE, 0); }
		public PropositionContext proposition(int i) {
			return getRuleContext(PropositionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrammarBParser.COMMA); }
		public List<PropositionContext> proposition() {
			return getRuleContexts(PropositionContext.class);
		}
		public TerminalNode SET_TYPE() { return getToken(GrammarBParser.SET_TYPE, 0); }
		public Signed_realContext signed_real(int i) {
			return getRuleContext(Signed_realContext.class,i);
		}
		public TerminalNode BOOL(int i) {
			return getToken(GrammarBParser.BOOL, i);
		}
		public List<Signed_realContext> signed_real() {
			return getRuleContexts(Signed_realContext.class);
		}
		public Signed_integerContext signed_integer(int i) {
			return getRuleContext(Signed_integerContext.class,i);
		}
		public List<TerminalNode> STRING() { return getTokens(GrammarBParser.STRING); }
		public List<SetContext> set() {
			return getRuleContexts(SetContext.class);
		}
		public Const_declareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_declare; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitConst_declare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const_declareContext const_declare() throws RecognitionException {
		Const_declareContext _localctx = new Const_declareContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_const_declare);
		int _la;
		try {
			setState(262);
			switch (_input.LA(1)) {
			case INT_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(162); match(INT_TYPE);
				setState(163); match(ID);
				setState(164); match(ASSIGN_SYMBOL);
				setState(165); signed_integer();
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(166); match(COMMA);
					setState(167); match(ID);
					setState(168); match(ASSIGN_SYMBOL);
					setState(169); signed_integer();
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DOUBLE_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(175); match(DOUBLE_TYPE);
				setState(176); match(ID);
				setState(177); match(ASSIGN_SYMBOL);
				setState(178); signed_real();
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(179); match(COMMA);
					setState(180); match(ID);
					setState(181); match(ASSIGN_SYMBOL);
					setState(182); signed_real();
					}
					}
					setState(187);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case CHAR_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(188); match(CHAR_TYPE);
				setState(189); match(ID);
				setState(190); match(ASSIGN_SYMBOL);
				setState(191); match(CHAR);
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(192); match(COMMA);
					setState(193); match(ID);
					setState(194); match(ASSIGN_SYMBOL);
					setState(195); match(CHAR);
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STRING_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(201); match(STRING_TYPE);
				setState(202); match(ID);
				setState(203); match(ASSIGN_SYMBOL);
				setState(204); match(STRING);
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(205); match(COMMA);
					setState(206); match(ID);
					setState(207); match(ASSIGN_SYMBOL);
					setState(208); match(STRING);
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case SET_TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(214); match(SET_TYPE);
				setState(215); match(ID);
				setState(216); match(ASSIGN_SYMBOL);
				setState(217); set();
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(218); match(COMMA);
					setState(219); match(ID);
					setState(220); match(ASSIGN_SYMBOL);
					setState(221); set();
					}
					}
					setState(226);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case TUPLE_TYPE:
				enterOuterAlt(_localctx, 6);
				{
				setState(227); match(TUPLE_TYPE);
				setState(228); match(ID);
				setState(229); match(ASSIGN_SYMBOL);
				setState(230); element_group();
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(231); match(COMMA);
					setState(232); match(ID);
					setState(233); match(ASSIGN_SYMBOL);
					setState(234); element_group();
					}
					}
					setState(239);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 7);
				{
				setState(240); match(BOOL_TYPE);
				setState(241); match(ID);
				setState(242); match(ASSIGN_SYMBOL);
				setState(243); match(BOOL);
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(244); match(COMMA);
					setState(245); match(ID);
					setState(246); match(ASSIGN_SYMBOL);
					setState(247); match(BOOL);
					}
					}
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case PROPOSITION_TYPE:
				enterOuterAlt(_localctx, 8);
				{
				setState(253); match(PROPOSITION_TYPE);
				setState(254); match(ID);
				setState(255); match(ASSIGN_SYMBOL);
				setState(256); proposition();
				{
				setState(257); match(COMMA);
				setState(258); match(ID);
				setState(259); match(ASSIGN_SYMBOL);
				setState(260); proposition();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Const_interuptContext extends ParserRuleContext {
		public List<TerminalNode> SEMICOLON() { return getTokens(GrammarBParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(GrammarBParser.SEMICOLON, i);
		}
		public List<Const_declareContext> const_declare() {
			return getRuleContexts(Const_declareContext.class);
		}
		public Const_declareContext const_declare(int i) {
			return getRuleContext(Const_declareContext.class,i);
		}
		public TerminalNode CONST(int i) {
			return getToken(GrammarBParser.CONST, i);
		}
		public List<TerminalNode> CONST() { return getTokens(GrammarBParser.CONST); }
		public Const_interuptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_interupt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitConst_interupt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const_interuptContext const_interupt() throws RecognitionException {
		Const_interuptContext _localctx = new Const_interuptContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_const_interupt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST) {
				{
				{
				setState(264); match(CONST);
				setState(265); const_declare();
				setState(266); match(SEMICOLON);
				}
				}
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Argument_listContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(GrammarBParser.COMMA); }
		public List<TerminalNode> ID() { return getTokens(GrammarBParser.ID); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(GrammarBParser.COMMA, i);
		}
		public TerminalNode ID(int i) {
			return getToken(GrammarBParser.ID, i);
		}
		public Argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitArgument_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Argument_listContext argument_list() throws RecognitionException {
		Argument_listContext _localctx = new Argument_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273); type();
			setState(274); match(ID);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(275); match(COMMA);
				setState(276); type();
				setState(277); match(ID);
				}
				}
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_argument_listContext extends ParserRuleContext {
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrammarBParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrammarBParser.COMMA, i);
		}
		public Value_argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_argument_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitValue_argument_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Value_argument_listContext value_argument_list() throws RecognitionException {
		Value_argument_listContext _localctx = new Value_argument_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_value_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << LEFT_ANGLE_BRACKET) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << NIL) | (1L << INTEGER) | (1L << REAL) | (1L << PROPOSITION_SYMBOL_1) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
				{
				setState(284); element();
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(285); match(COMMA);
					setState(286); element();
					}
					}
					setState(291);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Have_return_callContext extends ParserRuleContext {
		public Value_argument_listContext value_argument_list() {
			return getRuleContext(Value_argument_listContext.class,0);
		}
		public TerminalNode ID() { return getToken(GrammarBParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(GrammarBParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(GrammarBParser.RIGHT_BRACKET, 0); }
		public Have_return_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_have_return_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitHave_return_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Have_return_callContext have_return_call() throws RecognitionException {
		Have_return_callContext _localctx = new Have_return_callContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_have_return_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294); match(ID);
			setState(295); match(LEFT_BRACKET);
			setState(296); value_argument_list();
			setState(297); match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_return_callContext extends ParserRuleContext {
		public Value_argument_listContext value_argument_list() {
			return getRuleContext(Value_argument_listContext.class,0);
		}
		public TerminalNode ID() { return getToken(GrammarBParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(GrammarBParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(GrammarBParser.RIGHT_BRACKET, 0); }
		public No_return_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_return_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitNo_return_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final No_return_callContext no_return_call() throws RecognitionException {
		No_return_callContext _localctx = new No_return_callContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_no_return_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299); match(ID);
			setState(300); match(LEFT_BRACKET);
			setState(301); value_argument_list();
			setState(302); match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementContext extends ParserRuleContext {
		public Element_groupContext element_group() {
			return getRuleContext(Element_groupContext.class,0);
		}
		public TerminalNode BOOL() { return getToken(GrammarBParser.BOOL, 0); }
		public TerminalNode NIL() { return getToken(GrammarBParser.NIL, 0); }
		public TerminalNode ID() { return getToken(GrammarBParser.ID, 0); }
		public PropositionContext proposition() {
			return getRuleContext(PropositionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode REAL() { return getToken(GrammarBParser.REAL, 0); }
		public TerminalNode STRING() { return getToken(GrammarBParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(GrammarBParser.CHAR, 0); }
		public TerminalNode INTEGER() { return getToken(GrammarBParser.INTEGER, 0); }
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_element);
		try {
			setState(315);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(304); expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(305); element_group();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(306); set();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(307); match(BOOL);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(308); match(INTEGER);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(309); match(REAL);
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(310); match(CHAR);
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(311); match(STRING);
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(312); match(ID);
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(313); match(NIL);
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(314); proposition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Element_groupContext extends ParserRuleContext {
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public TerminalNode RIGHT_ANGLE_BRACKET() { return getToken(GrammarBParser.RIGHT_ANGLE_BRACKET, 0); }
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public TerminalNode LEFT_ANGLE_BRACKET() { return getToken(GrammarBParser.LEFT_ANGLE_BRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(GrammarBParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrammarBParser.COMMA, i);
		}
		public Element_groupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element_group; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitElement_group(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Element_groupContext element_group() throws RecognitionException {
		Element_groupContext _localctx = new Element_groupContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_element_group);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317); match(LEFT_ANGLE_BRACKET);
			setState(318); element();
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(319); match(COMMA);
				setState(320); element();
				}
				}
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(326); match(RIGHT_ANGLE_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public AddsubContext addsub() {
			return getRuleContext(AddsubContext.class,0);
		}
		public Expression_expandContext expression_expand() {
			return getRuleContext(Expression_expandContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			_la = _input.LA(1);
			if (_la==ADD || _la==SUB) {
				{
				setState(328); addsub();
				}
			}

			setState(331); term();
			setState(332); expression_expand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expression_expandContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public List<AddsubContext> addsub() {
			return getRuleContexts(AddsubContext.class);
		}
		public AddsubContext addsub(int i) {
			return getRuleContext(AddsubContext.class,i);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public Expression_expandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_expand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitExpression_expand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression_expandContext expression_expand() throws RecognitionException {
		Expression_expandContext _localctx = new Expression_expandContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expression_expand);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(334); addsub();
					setState(335); term();
					}
					} 
				}
				setState(341);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public List<MuldivContext> muldiv() {
			return getRuleContexts(MuldivContext.class);
		}
		public MuldivContext muldiv(int i) {
			return getRuleContext(MuldivContext.class,i);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342); factor();
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(343); muldiv();
				setState(344); factor();
				}
				}
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public Have_return_callContext have_return_call() {
			return getRuleContext(Have_return_callContext.class,0);
		}
		public TerminalNode ID() { return getToken(GrammarBParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode REAL() { return getToken(GrammarBParser.REAL, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(GrammarBParser.LEFT_BRACKET, 0); }
		public TerminalNode CHAR() { return getToken(GrammarBParser.CHAR, 0); }
		public TerminalNode INTEGER() { return getToken(GrammarBParser.INTEGER, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(GrammarBParser.RIGHT_BRACKET, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_factor);
		try {
			setState(360);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(351); match(ID);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(352); match(LEFT_BRACKET);
				setState(353); expression();
				setState(354); match(RIGHT_BRACKET);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(356); match(INTEGER);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(357); match(REAL);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(358); match(CHAR);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(359); have_return_call();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Math_relation_symbolContext extends ParserRuleContext {
		public TerminalNode ELES() { return getToken(GrammarBParser.ELES, 0); }
		public TerminalNode LES() { return getToken(GrammarBParser.LES, 0); }
		public TerminalNode EGRE() { return getToken(GrammarBParser.EGRE, 0); }
		public TerminalNode GRE() { return getToken(GrammarBParser.GRE, 0); }
		public TerminalNode EQU() { return getToken(GrammarBParser.EQU, 0); }
		public TerminalNode UEQU() { return getToken(GrammarBParser.UEQU, 0); }
		public Math_relation_symbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_relation_symbol; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitMath_relation_symbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_relation_symbolContext math_relation_symbol() throws RecognitionException {
		Math_relation_symbolContext _localctx = new Math_relation_symbolContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_math_relation_symbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GRE) | (1L << EGRE) | (1L << LES) | (1L << ELES) | (1L << EQU) | (1L << UEQU))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Math_relation_propositionContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Math_relation_symbolContext math_relation_symbol() {
			return getRuleContext(Math_relation_symbolContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public Math_relation_propositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_relation_proposition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitMath_relation_proposition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_relation_propositionContext math_relation_proposition() throws RecognitionException {
		Math_relation_propositionContext _localctx = new Math_relation_propositionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_math_relation_proposition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364); expression();
			setState(365); math_relation_symbol();
			setState(366); expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Proposition_term_0Context extends ParserRuleContext {
		public Set_relation_propositionContext set_relation_proposition() {
			return getRuleContext(Set_relation_propositionContext.class,0);
		}
		public TerminalNode BOOL() { return getToken(GrammarBParser.BOOL, 0); }
		public Element_set_relation_propositionContext element_set_relation_proposition() {
			return getRuleContext(Element_set_relation_propositionContext.class,0);
		}
		public Math_relation_propositionContext math_relation_proposition() {
			return getRuleContext(Math_relation_propositionContext.class,0);
		}
		public Have_return_callContext have_return_call() {
			return getRuleContext(Have_return_callContext.class,0);
		}
		public TerminalNode ID() { return getToken(GrammarBParser.ID, 0); }
		public PropositionContext proposition() {
			return getRuleContext(PropositionContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(GrammarBParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(GrammarBParser.RIGHT_BRACKET, 0); }
		public Proposition_term_0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proposition_term_0; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitProposition_term_0(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Proposition_term_0Context proposition_term_0() throws RecognitionException {
		Proposition_term_0Context _localctx = new Proposition_term_0Context(_ctx, getState());
		enterRule(_localctx, 38, RULE_proposition_term_0);
		try {
			setState(378);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(368); match(ID);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(369); match(BOOL);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(370); have_return_call();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(371); match(LEFT_BRACKET);
				setState(372); proposition();
				setState(373); match(RIGHT_BRACKET);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(375); set_relation_proposition();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(376); element_set_relation_proposition();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(377); math_relation_proposition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Proposition_term_1Context extends ParserRuleContext {
		public TerminalNode PROPOSITION_SYMBOL_1(int i) {
			return getToken(GrammarBParser.PROPOSITION_SYMBOL_1, i);
		}
		public Proposition_term_0Context proposition_term_0() {
			return getRuleContext(Proposition_term_0Context.class,0);
		}
		public List<TerminalNode> PROPOSITION_SYMBOL_1() { return getTokens(GrammarBParser.PROPOSITION_SYMBOL_1); }
		public Proposition_term_1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proposition_term_1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitProposition_term_1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Proposition_term_1Context proposition_term_1() throws RecognitionException {
		Proposition_term_1Context _localctx = new Proposition_term_1Context(_ctx, getState());
		enterRule(_localctx, 40, RULE_proposition_term_1);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(380); match(PROPOSITION_SYMBOL_1);
					}
					} 
				}
				setState(385);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(386); proposition_term_0();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Proposition_term_2Context extends ParserRuleContext {
		public List<TerminalNode> PROPOSITION_SYMBOL_2() { return getTokens(GrammarBParser.PROPOSITION_SYMBOL_2); }
		public Proposition_term_1Context proposition_term_1(int i) {
			return getRuleContext(Proposition_term_1Context.class,i);
		}
		public List<Proposition_term_1Context> proposition_term_1() {
			return getRuleContexts(Proposition_term_1Context.class);
		}
		public TerminalNode PROPOSITION_SYMBOL_2(int i) {
			return getToken(GrammarBParser.PROPOSITION_SYMBOL_2, i);
		}
		public Proposition_term_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proposition_term_2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitProposition_term_2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Proposition_term_2Context proposition_term_2() throws RecognitionException {
		Proposition_term_2Context _localctx = new Proposition_term_2Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_proposition_term_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388); proposition_term_1();
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROPOSITION_SYMBOL_2) {
				{
				{
				setState(389); match(PROPOSITION_SYMBOL_2);
				setState(390); proposition_term_1();
				}
				}
				setState(395);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Proposition_term_3Context extends ParserRuleContext {
		public List<TerminalNode> PROPOSITION_SYMBOL_3() { return getTokens(GrammarBParser.PROPOSITION_SYMBOL_3); }
		public TerminalNode PROPOSITION_SYMBOL_3(int i) {
			return getToken(GrammarBParser.PROPOSITION_SYMBOL_3, i);
		}
		public List<Proposition_term_2Context> proposition_term_2() {
			return getRuleContexts(Proposition_term_2Context.class);
		}
		public Proposition_term_2Context proposition_term_2(int i) {
			return getRuleContext(Proposition_term_2Context.class,i);
		}
		public Proposition_term_3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proposition_term_3; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitProposition_term_3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Proposition_term_3Context proposition_term_3() throws RecognitionException {
		Proposition_term_3Context _localctx = new Proposition_term_3Context(_ctx, getState());
		enterRule(_localctx, 44, RULE_proposition_term_3);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396); proposition_term_2();
			setState(401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROPOSITION_SYMBOL_3) {
				{
				{
				setState(397); match(PROPOSITION_SYMBOL_3);
				setState(398); proposition_term_2();
				}
				}
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropositionContext extends ParserRuleContext {
		public Change_4Context change_4() {
			return getRuleContext(Change_4Context.class,0);
		}
		public Change_1Context change_1() {
			return getRuleContext(Change_1Context.class,0);
		}
		public PropositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proposition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitProposition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropositionContext proposition() throws RecognitionException {
		PropositionContext _localctx = new PropositionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_proposition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404); change_1();
			setState(405); change_4();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Change_1Context extends ParserRuleContext {
		public TerminalNode PROPOSITION_SYMBOL_1(int i) {
			return getToken(GrammarBParser.PROPOSITION_SYMBOL_1, i);
		}
		public Change_1_temp_1Context change_1_temp_1() {
			return getRuleContext(Change_1_temp_1Context.class,0);
		}
		public Change_3Context change_3() {
			return getRuleContext(Change_3Context.class,0);
		}
		public Change_1_temp_2Context change_1_temp_2() {
			return getRuleContext(Change_1_temp_2Context.class,0);
		}
		public PropositionContext proposition() {
			return getRuleContext(PropositionContext.class,0);
		}
		public Change_2Context change_2() {
			return getRuleContext(Change_2Context.class,0);
		}
		public List<TerminalNode> PROPOSITION_SYMBOL_1() { return getTokens(GrammarBParser.PROPOSITION_SYMBOL_1); }
		public Change_1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_change_1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitChange_1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Change_1Context change_1() throws RecognitionException {
		Change_1Context _localctx = new Change_1Context(_ctx, getState());
		enterRule(_localctx, 48, RULE_change_1);
		int _la;
		try {
			int _alt;
			setState(431);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PROPOSITION_SYMBOL_1) {
					{
					{
					setState(407); match(PROPOSITION_SYMBOL_1);
					}
					}
					setState(412);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(413); change_1_temp_1();
				setState(414); change_2();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PROPOSITION_SYMBOL_1) {
					{
					{
					setState(416); match(PROPOSITION_SYMBOL_1);
					}
					}
					setState(421);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(422); change_1_temp_2();
				setState(423); change_3();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(426); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(425); match(PROPOSITION_SYMBOL_1);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(428); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				setState(430); proposition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Change_1_temp_1Context extends ParserRuleContext {
		public Set_relation_propositionContext set_relation_proposition() {
			return getRuleContext(Set_relation_propositionContext.class,0);
		}
		public TerminalNode BOOL() { return getToken(GrammarBParser.BOOL, 0); }
		public Math_relation_propositionContext math_relation_proposition() {
			return getRuleContext(Math_relation_propositionContext.class,0);
		}
		public Have_return_callContext have_return_call() {
			return getRuleContext(Have_return_callContext.class,0);
		}
		public TerminalNode ID() { return getToken(GrammarBParser.ID, 0); }
		public PropositionContext proposition() {
			return getRuleContext(PropositionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(GrammarBParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(GrammarBParser.RIGHT_BRACKET, 0); }
		public Change_1_temp_1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_change_1_temp_1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitChange_1_temp_1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Change_1_temp_1Context change_1_temp_1() throws RecognitionException {
		Change_1_temp_1Context _localctx = new Change_1_temp_1Context(_ctx, getState());
		enterRule(_localctx, 50, RULE_change_1_temp_1);
		try {
			setState(443);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(433); match(ID);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(434); match(BOOL);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(435); have_return_call();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(436); match(LEFT_BRACKET);
				setState(437); proposition();
				setState(438); match(RIGHT_BRACKET);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(440); set_relation_proposition();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(441); expression();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(442); math_relation_proposition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Change_1_temp_2Context extends ParserRuleContext {
		public Element_groupContext element_group() {
			return getRuleContext(Element_groupContext.class,0);
		}
		public TerminalNode BOOL() { return getToken(GrammarBParser.BOOL, 0); }
		public TerminalNode NIL() { return getToken(GrammarBParser.NIL, 0); }
		public TerminalNode ID() { return getToken(GrammarBParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode REAL() { return getToken(GrammarBParser.REAL, 0); }
		public TerminalNode STRING() { return getToken(GrammarBParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(GrammarBParser.CHAR, 0); }
		public TerminalNode INTEGER() { return getToken(GrammarBParser.INTEGER, 0); }
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public Change_1_temp_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_change_1_temp_2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitChange_1_temp_2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Change_1_temp_2Context change_1_temp_2() throws RecognitionException {
		Change_1_temp_2Context _localctx = new Change_1_temp_2Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_change_1_temp_2);
		try {
			setState(455);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(445); match(BOOL);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(446); match(INTEGER);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(447); match(REAL);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(448); match(CHAR);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(449); match(STRING);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(450); expression();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(451); element_group();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(452); set();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(453); match(ID);
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(454); match(NIL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Change_2Context extends ParserRuleContext {
		public List<TerminalNode> PROPOSITION_SYMBOL_3() { return getTokens(GrammarBParser.PROPOSITION_SYMBOL_3); }
		public List<TerminalNode> PROPOSITION_SYMBOL_2() { return getTokens(GrammarBParser.PROPOSITION_SYMBOL_2); }
		public Proposition_term_3Context proposition_term_3(int i) {
			return getRuleContext(Proposition_term_3Context.class,i);
		}
		public TerminalNode PROPOSITION_SYMBOL_3(int i) {
			return getToken(GrammarBParser.PROPOSITION_SYMBOL_3, i);
		}
		public TerminalNode PROPOSITION_SYMBOL_4(int i) {
			return getToken(GrammarBParser.PROPOSITION_SYMBOL_4, i);
		}
		public List<TerminalNode> PROPOSITION_SYMBOL_4() { return getTokens(GrammarBParser.PROPOSITION_SYMBOL_4); }
		public List<Proposition_term_2Context> proposition_term_2() {
			return getRuleContexts(Proposition_term_2Context.class);
		}
		public Proposition_term_1Context proposition_term_1(int i) {
			return getRuleContext(Proposition_term_1Context.class,i);
		}
		public List<Proposition_term_1Context> proposition_term_1() {
			return getRuleContexts(Proposition_term_1Context.class);
		}
		public Proposition_term_2Context proposition_term_2(int i) {
			return getRuleContext(Proposition_term_2Context.class,i);
		}
		public TerminalNode PROPOSITION_SYMBOL_2(int i) {
			return getToken(GrammarBParser.PROPOSITION_SYMBOL_2, i);
		}
		public List<Proposition_term_3Context> proposition_term_3() {
			return getRuleContexts(Proposition_term_3Context.class);
		}
		public Change_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_change_2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitChange_2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Change_2Context change_2() throws RecognitionException {
		Change_2Context _localctx = new Change_2Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_change_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROPOSITION_SYMBOL_2) {
				{
				{
				setState(457); match(PROPOSITION_SYMBOL_2);
				setState(458); proposition_term_1();
				}
				}
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROPOSITION_SYMBOL_3) {
				{
				{
				setState(464); match(PROPOSITION_SYMBOL_3);
				setState(465); proposition_term_2();
				}
				}
				setState(470);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROPOSITION_SYMBOL_4) {
				{
				{
				setState(471); match(PROPOSITION_SYMBOL_4);
				setState(472); proposition_term_3();
				}
				}
				setState(477);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Change_3Context extends ParserRuleContext {
		public TerminalNode ELEMENT_SET_SYMBOL() { return getToken(GrammarBParser.ELEMENT_SET_SYMBOL, 0); }
		public Change_2Context change_2() {
			return getRuleContext(Change_2Context.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public Change_3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_change_3; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitChange_3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Change_3Context change_3() throws RecognitionException {
		Change_3Context _localctx = new Change_3Context(_ctx, getState());
		enterRule(_localctx, 56, RULE_change_3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478); match(ELEMENT_SET_SYMBOL);
			setState(479); set();
			setState(480); change_2();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Change_4Context extends ParserRuleContext {
		public Change_3Context change_3() {
			return getRuleContext(Change_3Context.class,0);
		}
		public PropositionContext proposition() {
			return getRuleContext(PropositionContext.class,0);
		}
		public Change_4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_change_4; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitChange_4(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Change_4Context change_4() throws RecognitionException {
		Change_4Context _localctx = new Change_4Context(_ctx, getState());
		enterRule(_localctx, 58, RULE_change_4);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(482); proposition();
				setState(483); change_3();
				}
				break;

			case 2:
				{
				setState(485); change_3();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_term_0Context extends ParserRuleContext {
		public Element_groupContext element_group() {
			return getRuleContext(Element_groupContext.class,0);
		}
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(GrammarBParser.RIGHT_BRACE, 0); }
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public Have_return_callContext have_return_call() {
			return getRuleContext(Have_return_callContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrammarBParser.COMMA); }
		public TerminalNode ID() { return getToken(GrammarBParser.ID, 0); }
		public PropositionContext proposition() {
			return getRuleContext(PropositionContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(GrammarBParser.LEFT_BRACE, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(GrammarBParser.LEFT_BRACKET, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(GrammarBParser.COMMA, i);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(GrammarBParser.RIGHT_BRACKET, 0); }
		public Set_term_0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_term_0; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitSet_term_0(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_term_0Context set_term_0() throws RecognitionException {
		Set_term_0Context _localctx = new Set_term_0Context(_ctx, getState());
		enterRule(_localctx, 60, RULE_set_term_0);
		int _la;
		try {
			setState(515);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(488); match(ID);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(489); have_return_call();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(490); match(LEFT_BRACKET);
				setState(491); set();
				setState(492); match(RIGHT_BRACKET);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(494); match(LEFT_BRACE);
				setState(503);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << LEFT_ANGLE_BRACKET) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << NIL) | (1L << INTEGER) | (1L << REAL) | (1L << PROPOSITION_SYMBOL_1) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
					{
					setState(495); element();
					setState(500);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(496); match(COMMA);
						setState(497); element();
						}
						}
						setState(502);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(505); match(RIGHT_BRACE);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(506); match(LEFT_BRACE);
				setState(509);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(507); match(ID);
					}
					break;
				case LEFT_ANGLE_BRACKET:
					{
					setState(508); element_group();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(511); match(5);
				setState(512); proposition();
				setState(513); match(RIGHT_BRACE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_term_1Context extends ParserRuleContext {
		public Set_term_0Context set_term_0(int i) {
			return getRuleContext(Set_term_0Context.class,i);
		}
		public List<Set_term_0Context> set_term_0() {
			return getRuleContexts(Set_term_0Context.class);
		}
		public List<TerminalNode> SET_SYMBOL_1() { return getTokens(GrammarBParser.SET_SYMBOL_1); }
		public TerminalNode SET_SYMBOL_1(int i) {
			return getToken(GrammarBParser.SET_SYMBOL_1, i);
		}
		public Set_term_1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_term_1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitSet_term_1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_term_1Context set_term_1() throws RecognitionException {
		Set_term_1Context _localctx = new Set_term_1Context(_ctx, getState());
		enterRule(_localctx, 62, RULE_set_term_1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517); set_term_0();
			setState(522);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SET_SYMBOL_1) {
				{
				{
				setState(518); match(SET_SYMBOL_1);
				setState(519); set_term_0();
				}
				}
				setState(524);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetContext extends ParserRuleContext {
		public List<Set_term_1Context> set_term_1() {
			return getRuleContexts(Set_term_1Context.class);
		}
		public List<TerminalNode> SET_SYMBOL_2() { return getTokens(GrammarBParser.SET_SYMBOL_2); }
		public TerminalNode SET_SYMBOL_2(int i) {
			return getToken(GrammarBParser.SET_SYMBOL_2, i);
		}
		public Set_term_1Context set_term_1(int i) {
			return getRuleContext(Set_term_1Context.class,i);
		}
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525); set_term_1();
			setState(530);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SET_SYMBOL_2) {
				{
				{
				setState(526); match(SET_SYMBOL_2);
				setState(527); set_term_1();
				}
				}
				setState(532);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Element_set_relation_propositionContext extends ParserRuleContext {
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public TerminalNode ELEMENT_SET_SYMBOL() { return getToken(GrammarBParser.ELEMENT_SET_SYMBOL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public Element_set_relation_propositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element_set_relation_proposition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitElement_set_relation_proposition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Element_set_relation_propositionContext element_set_relation_proposition() throws RecognitionException {
		Element_set_relation_propositionContext _localctx = new Element_set_relation_propositionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_element_set_relation_proposition);
		try {
			setState(538);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(533); element();
				setState(534); match(ELEMENT_SET_SYMBOL);
				setState(535); set();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(537); expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_relation_propositionContext extends ParserRuleContext {
		public SetContext set(int i) {
			return getRuleContext(SetContext.class,i);
		}
		public Math_relation_symbolContext math_relation_symbol() {
			return getRuleContext(Math_relation_symbolContext.class,0);
		}
		public List<SetContext> set() {
			return getRuleContexts(SetContext.class);
		}
		public Set_relation_propositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_relation_proposition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitSet_relation_proposition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_relation_propositionContext set_relation_proposition() throws RecognitionException {
		Set_relation_propositionContext _localctx = new Set_relation_propositionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_set_relation_proposition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540); set();
			setState(541); math_relation_symbol();
			setState(542); set();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multi_statContext extends ParserRuleContext {
		public TerminalNode INVARIANT() { return getToken(GrammarBParser.INVARIANT, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public Valuable_interuptContext valuable_interupt() {
			return getRuleContext(Valuable_interuptContext.class,0);
		}
		public PropositionContext proposition() {
			return getRuleContext(PropositionContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode ATTRIBUTE() { return getToken(GrammarBParser.ATTRIBUTE, 0); }
		public Const_interuptContext const_interupt() {
			return getRuleContext(Const_interuptContext.class,0);
		}
		public Multi_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multi_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitMulti_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multi_statContext multi_stat() throws RecognitionException {
		Multi_statContext _localctx = new Multi_statContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_multi_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			_la = _input.LA(1);
			if (_la==INVARIANT) {
				{
				setState(544); match(INVARIANT);
				setState(545); proposition();
				}
			}

			setState(552);
			_la = _input.LA(1);
			if (_la==ATTRIBUTE) {
				{
				setState(548); match(ATTRIBUTE);
				setState(549); const_interupt();
				setState(550); valuable_interupt();
				}
			}

			setState(555); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(554); stat();
				}
				}
				setState(557); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(GrammarBParser.SEMICOLON, 0); }
		public Have_return_callContext have_return_call() {
			return getRuleContext(Have_return_callContext.class,0);
		}
		public Return_statContext return_stat() {
			return getRuleContext(Return_statContext.class,0);
		}
		public Assign_statContext assign_stat() {
			return getRuleContext(Assign_statContext.class,0);
		}
		public No_return_callContext no_return_call() {
			return getRuleContext(No_return_callContext.class,0);
		}
		public Circulate_statContext circulate_stat() {
			return getRuleContext(Circulate_statContext.class,0);
		}
		public Condition_statContext condition_stat() {
			return getRuleContext(Condition_statContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_stat);
		try {
			setState(573);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(559); condition_stat();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(560); circulate_stat();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(561); have_return_call();
				setState(562); match(SEMICOLON);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(564); no_return_call();
				setState(565); match(SEMICOLON);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(567); assign_stat();
				setState(568); match(SEMICOLON);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(570); return_stat();
				setState(571); match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_statContext extends ParserRuleContext {
		public TerminalNode ASSIGN_SYMBOL() { return getToken(GrammarBParser.ASSIGN_SYMBOL, 0); }
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public TerminalNode ID() { return getToken(GrammarBParser.ID, 0); }
		public Assign_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitAssign_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_statContext assign_stat() throws RecognitionException {
		Assign_statContext _localctx = new Assign_statContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_assign_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575); match(ID);
			setState(576); match(ASSIGN_SYMBOL);
			setState(577); element();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_statContext extends ParserRuleContext {
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public Return_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitReturn_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_statContext return_stat() throws RecognitionException {
		Return_statContext _localctx = new Return_statContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_return_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579); match(4);
			setState(581);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << LEFT_ANGLE_BRACKET) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << NIL) | (1L << INTEGER) | (1L << REAL) | (1L << PROPOSITION_SYMBOL_1) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
				{
				setState(580); element();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Condition_statContext extends ParserRuleContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(GrammarBParser.RIGHT_BRACE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode LEFT_BRACE() { return getToken(GrammarBParser.LEFT_BRACE, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(GrammarBParser.LEFT_BRACKET, 0); }
		public Else_statContext else_stat() {
			return getRuleContext(Else_statContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(GrammarBParser.RIGHT_BRACKET, 0); }
		public Condition_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitCondition_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Condition_statContext condition_stat() throws RecognitionException {
		Condition_statContext _localctx = new Condition_statContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_condition_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583); match(2);
			setState(584); match(LEFT_BRACKET);
			setState(585); condition();
			setState(586); match(RIGHT_BRACKET);
			setState(587); match(LEFT_BRACE);
			setState(591);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << ID))) != 0)) {
				{
				{
				setState(588); stat();
				}
				}
				setState(593);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(594); match(RIGHT_BRACE);
			setState(596);
			_la = _input.LA(1);
			if (_la==3) {
				{
				setState(595); else_stat();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_statContext extends ParserRuleContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(GrammarBParser.RIGHT_BRACE, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode LEFT_BRACE() { return getToken(GrammarBParser.LEFT_BRACE, 0); }
		public Else_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitElse_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_statContext else_stat() throws RecognitionException {
		Else_statContext _localctx = new Else_statContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_else_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(598); match(3);
			setState(599); match(LEFT_BRACE);
			setState(603);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << ID))) != 0)) {
				{
				{
				setState(600); stat();
				}
				}
				setState(605);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(606); match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public PropositionContext proposition() {
			return getRuleContext(PropositionContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608); proposition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Circulate_statContext extends ParserRuleContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(GrammarBParser.RIGHT_BRACE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode LEFT_BRACE() { return getToken(GrammarBParser.LEFT_BRACE, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(GrammarBParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(GrammarBParser.RIGHT_BRACKET, 0); }
		public Circulate_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_circulate_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitCirculate_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Circulate_statContext circulate_stat() throws RecognitionException {
		Circulate_statContext _localctx = new Circulate_statContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_circulate_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610); match(1);
			setState(611); match(LEFT_BRACKET);
			setState(612); condition();
			setState(613); match(RIGHT_BRACKET);
			setState(614); match(LEFT_BRACE);
			setState(616); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(615); stat();
				}
				}
				setState(618); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << ID))) != 0) );
			setState(620); match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Have_return_defineContext extends ParserRuleContext {
		public Return_defineContext return_define() {
			return getRuleContext(Return_defineContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Have_return_defineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_have_return_define; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitHave_return_define(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Have_return_defineContext have_return_define() throws RecognitionException {
		Have_return_defineContext _localctx = new Have_return_defineContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_have_return_define);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622); type();
			setState(623); return_define();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_return_defineContext extends ParserRuleContext {
		public Return_defineContext return_define() {
			return getRuleContext(Return_defineContext.class,0);
		}
		public TerminalNode VOID() { return getToken(GrammarBParser.VOID, 0); }
		public No_return_defineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_return_define; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitNo_return_define(this);
			else return visitor.visitChildren(this);
		}
	}

	public final No_return_defineContext no_return_define() throws RecognitionException {
		No_return_defineContext _localctx = new No_return_defineContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_no_return_define);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625); match(VOID);
			setState(626); return_define();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_defineContext extends ParserRuleContext {
		public Multi_statContext multi_stat() {
			return getRuleContext(Multi_statContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(GrammarBParser.RIGHT_BRACE, 0); }
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public TerminalNode ID() { return getToken(GrammarBParser.ID, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(GrammarBParser.LEFT_BRACE, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(GrammarBParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(GrammarBParser.RIGHT_BRACKET, 0); }
		public Return_defineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_define; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitReturn_define(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_defineContext return_define() throws RecognitionException {
		Return_defineContext _localctx = new Return_defineContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_return_define);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628); match(ID);
			setState(629); match(LEFT_BRACKET);
			setState(631);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << CHAR_TYPE) | (1L << STRING_TYPE) | (1L << PROPOSITION_TYPE) | (1L << SET_TYPE) | (1L << TUPLE_TYPE) | (1L << BOOL_TYPE))) != 0)) {
				{
				setState(630); argument_list();
				}
			}

			setState(633); match(RIGHT_BRACKET);
			setState(634); match(LEFT_BRACE);
			setState(635); multi_stat();
			setState(636); match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Have_return_declareContext extends ParserRuleContext {
		public Return_declareContext return_declare() {
			return getRuleContext(Return_declareContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Have_return_declareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_have_return_declare; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitHave_return_declare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Have_return_declareContext have_return_declare() throws RecognitionException {
		Have_return_declareContext _localctx = new Have_return_declareContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_have_return_declare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(638); type();
			setState(639); return_declare();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_return_declareContext extends ParserRuleContext {
		public Return_declareContext return_declare() {
			return getRuleContext(Return_declareContext.class,0);
		}
		public TerminalNode VOID() { return getToken(GrammarBParser.VOID, 0); }
		public No_return_declareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_return_declare; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitNo_return_declare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final No_return_declareContext no_return_declare() throws RecognitionException {
		No_return_declareContext _localctx = new No_return_declareContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_no_return_declare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641); match(VOID);
			setState(642); return_declare();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_declareContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(GrammarBParser.SEMICOLON, 0); }
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public TerminalNode ID() { return getToken(GrammarBParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(GrammarBParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(GrammarBParser.RIGHT_BRACKET, 0); }
		public Return_declareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_declare; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitReturn_declare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_declareContext return_declare() throws RecognitionException {
		Return_declareContext _localctx = new Return_declareContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_return_declare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(644); match(ID);
			setState(645); match(LEFT_BRACKET);
			setState(647);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << CHAR_TYPE) | (1L << STRING_TYPE) | (1L << PROPOSITION_TYPE) | (1L << SET_TYPE) | (1L << TUPLE_TYPE) | (1L << BOOL_TYPE))) != 0)) {
				{
				setState(646); argument_list();
				}
			}

			setState(649); match(RIGHT_BRACKET);
			setState(650); match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT_TYPE() { return getToken(GrammarBParser.INT_TYPE, 0); }
		public TerminalNode DOUBLE_TYPE() { return getToken(GrammarBParser.DOUBLE_TYPE, 0); }
		public TerminalNode CHAR_TYPE() { return getToken(GrammarBParser.CHAR_TYPE, 0); }
		public TerminalNode PROPOSITION_TYPE() { return getToken(GrammarBParser.PROPOSITION_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(GrammarBParser.STRING_TYPE, 0); }
		public TerminalNode TUPLE_TYPE() { return getToken(GrammarBParser.TUPLE_TYPE, 0); }
		public TerminalNode SET_TYPE() { return getToken(GrammarBParser.SET_TYPE, 0); }
		public TerminalNode BOOL_TYPE() { return getToken(GrammarBParser.BOOL_TYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << CHAR_TYPE) | (1L << STRING_TYPE) | (1L << PROPOSITION_TYPE) | (1L << SET_TYPE) | (1L << TUPLE_TYPE) | (1L << BOOL_TYPE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_integerContext extends ParserRuleContext {
		public AddsubContext addsub() {
			return getRuleContext(AddsubContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(GrammarBParser.INTEGER, 0); }
		public Signed_integerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_integer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitSigned_integer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Signed_integerContext signed_integer() throws RecognitionException {
		Signed_integerContext _localctx = new Signed_integerContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_signed_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(655);
			_la = _input.LA(1);
			if (_la==ADD || _la==SUB) {
				{
				setState(654); addsub();
				}
			}

			setState(657); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_realContext extends ParserRuleContext {
		public AddsubContext addsub() {
			return getRuleContext(AddsubContext.class,0);
		}
		public TerminalNode REAL() { return getToken(GrammarBParser.REAL, 0); }
		public Signed_realContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_real; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitSigned_real(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Signed_realContext signed_real() throws RecognitionException {
		Signed_realContext _localctx = new Signed_realContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_signed_real);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(660);
			_la = _input.LA(1);
			if (_la==ADD || _la==SUB) {
				{
				setState(659); addsub();
				}
			}

			setState(662); match(REAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddsubContext extends ParserRuleContext {
		public TerminalNode SUB() { return getToken(GrammarBParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(GrammarBParser.ADD, 0); }
		public AddsubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addsub; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitAddsub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddsubContext addsub() throws RecognitionException {
		AddsubContext _localctx = new AddsubContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_addsub);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(664);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MuldivContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(GrammarBParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(GrammarBParser.DIV, 0); }
		public MuldivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_muldiv; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarBVisitor ) return ((GrammarBVisitor<? extends T>)visitor).visitMuldiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MuldivContext muldiv() throws RecognitionException {
		MuldivContext _localctx = new MuldivContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_muldiv);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			_la = _input.LA(1);
			if ( !(_la==MUL || _la==DIV) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\38\u029f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\2\3\2\5\2s\n\2\3\2\3\2\3\2"+
		"\5\2x\n\2\3\2\3\2\3\2\3\2\3\2\7\2\177\n\2\f\2\16\2\u0082\13\2\3\2\7\2"+
		"\u0085\n\2\f\2\16\2\u0088\13\2\3\2\3\2\3\3\3\3\5\3\u008e\n\3\3\4\3\4\5"+
		"\4\u0092\n\4\3\5\3\5\3\5\3\5\7\5\u0098\n\5\f\5\16\5\u009b\13\5\3\6\3\6"+
		"\3\6\7\6\u00a0\n\6\f\6\16\6\u00a3\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\7\7\u00ad\n\7\f\7\16\7\u00b0\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7"+
		"\u00ba\n\7\f\7\16\7\u00bd\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00c7"+
		"\n\7\f\7\16\7\u00ca\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00d4\n\7"+
		"\f\7\16\7\u00d7\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00e1\n\7\f\7"+
		"\16\7\u00e4\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00ee\n\7\f\7\16"+
		"\7\u00f1\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00fb\n\7\f\7\16\7\u00fe"+
		"\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0109\n\7\3\b\3\b\3\b\3"+
		"\b\7\b\u010f\n\b\f\b\16\b\u0112\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u011a"+
		"\n\t\f\t\16\t\u011d\13\t\3\n\3\n\3\n\7\n\u0122\n\n\f\n\16\n\u0125\13\n"+
		"\5\n\u0127\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u013e\n\r\3\16\3\16\3\16\3\16\7"+
		"\16\u0144\n\16\f\16\16\16\u0147\13\16\3\16\3\16\3\17\5\17\u014c\n\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\7\20\u0154\n\20\f\20\16\20\u0157\13\20\3"+
		"\21\3\21\3\21\3\21\7\21\u015d\n\21\f\21\16\21\u0160\13\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u016b\n\22\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u017d"+
		"\n\25\3\26\7\26\u0180\n\26\f\26\16\26\u0183\13\26\3\26\3\26\3\27\3\27"+
		"\3\27\7\27\u018a\n\27\f\27\16\27\u018d\13\27\3\30\3\30\3\30\7\30\u0192"+
		"\n\30\f\30\16\30\u0195\13\30\3\31\3\31\3\31\3\32\7\32\u019b\n\32\f\32"+
		"\16\32\u019e\13\32\3\32\3\32\3\32\3\32\7\32\u01a4\n\32\f\32\16\32\u01a7"+
		"\13\32\3\32\3\32\3\32\3\32\6\32\u01ad\n\32\r\32\16\32\u01ae\3\32\5\32"+
		"\u01b2\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u01be"+
		"\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u01ca\n\34"+
		"\3\35\3\35\7\35\u01ce\n\35\f\35\16\35\u01d1\13\35\3\35\3\35\7\35\u01d5"+
		"\n\35\f\35\16\35\u01d8\13\35\3\35\3\35\7\35\u01dc\n\35\f\35\16\35\u01df"+
		"\13\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\5\37\u01e9\n\37\3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \7 \u01f5\n \f \16 \u01f8\13 \5 \u01fa\n \3 \3 "+
		"\3 \3 \5 \u0200\n \3 \3 \3 \3 \5 \u0206\n \3!\3!\3!\7!\u020b\n!\f!\16"+
		"!\u020e\13!\3\"\3\"\3\"\7\"\u0213\n\"\f\"\16\"\u0216\13\"\3#\3#\3#\3#"+
		"\3#\5#\u021d\n#\3$\3$\3$\3$\3%\3%\5%\u0225\n%\3%\3%\3%\3%\5%\u022b\n%"+
		"\3%\6%\u022e\n%\r%\16%\u022f\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\5&\u0240\n&\3\'\3\'\3\'\3\'\3(\3(\5(\u0248\n(\3)\3)\3)\3)\3)\3)\7)\u0250"+
		"\n)\f)\16)\u0253\13)\3)\3)\5)\u0257\n)\3*\3*\3*\7*\u025c\n*\f*\16*\u025f"+
		"\13*\3*\3*\3+\3+\3,\3,\3,\3,\3,\3,\6,\u026b\n,\r,\16,\u026c\3,\3,\3-\3"+
		"-\3-\3.\3.\3.\3/\3/\3/\5/\u027a\n/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\61"+
		"\3\61\3\61\3\62\3\62\3\62\5\62\u028a\n\62\3\62\3\62\3\62\3\63\3\63\3\64"+
		"\5\64\u0292\n\64\3\64\3\64\3\65\5\65\u0297\n\65\3\65\3\65\3\66\3\66\3"+
		"\67\3\67\3\67\28\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjl\2\6\3\2-\62\3\2\b\17\3\2\63\64\3\2"+
		"\65\66\u02d2\2n\3\2\2\2\4\u008d\3\2\2\2\6\u0091\3\2\2\2\b\u0093\3\2\2"+
		"\2\n\u00a1\3\2\2\2\f\u0108\3\2\2\2\16\u0110\3\2\2\2\20\u0113\3\2\2\2\22"+
		"\u0126\3\2\2\2\24\u0128\3\2\2\2\26\u012d\3\2\2\2\30\u013d\3\2\2\2\32\u013f"+
		"\3\2\2\2\34\u014b\3\2\2\2\36\u0155\3\2\2\2 \u0158\3\2\2\2\"\u016a\3\2"+
		"\2\2$\u016c\3\2\2\2&\u016e\3\2\2\2(\u017c\3\2\2\2*\u0181\3\2\2\2,\u0186"+
		"\3\2\2\2.\u018e\3\2\2\2\60\u0196\3\2\2\2\62\u01b1\3\2\2\2\64\u01bd\3\2"+
		"\2\2\66\u01c9\3\2\2\28\u01cf\3\2\2\2:\u01e0\3\2\2\2<\u01e8\3\2\2\2>\u0205"+
		"\3\2\2\2@\u0207\3\2\2\2B\u020f\3\2\2\2D\u021c\3\2\2\2F\u021e\3\2\2\2H"+
		"\u0224\3\2\2\2J\u023f\3\2\2\2L\u0241\3\2\2\2N\u0245\3\2\2\2P\u0249\3\2"+
		"\2\2R\u0258\3\2\2\2T\u0262\3\2\2\2V\u0264\3\2\2\2X\u0270\3\2\2\2Z\u0273"+
		"\3\2\2\2\\\u0276\3\2\2\2^\u0280\3\2\2\2`\u0283\3\2\2\2b\u0286\3\2\2\2"+
		"d\u028e\3\2\2\2f\u0291\3\2\2\2h\u0296\3\2\2\2j\u029a\3\2\2\2l\u029c\3"+
		"\2\2\2no\7\32\2\2op\7\67\2\2pr\7\21\2\2qs\5\20\t\2rq\3\2\2\2rs\3\2\2\2"+
		"st\3\2\2\2tu\7\22\2\2uw\7\33\2\2vx\5\60\31\2wv\3\2\2\2wx\3\2\2\2xy\3\2"+
		"\2\2yz\7\34\2\2z{\5\16\b\2{|\5\n\6\2|\u0080\7\35\2\2}\177\5\4\3\2~}\3"+
		"\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0086"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0085\5\6\4\2\u0084\u0083\3\2\2\2\u0085"+
		"\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2"+
		"\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7\36\2\2\u008a\3\3\2\2\2\u008b\u008e"+
		"\5^\60\2\u008c\u008e\5`\61\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e"+
		"\5\3\2\2\2\u008f\u0092\5X-\2\u0090\u0092\5Z.\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0090\3\2\2\2\u0092\7\3\2\2\2\u0093\u0094\5d\63\2\u0094\u0099\7\67\2"+
		"\2\u0095\u0096\7\23\2\2\u0096\u0098\7\67\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\t\3\2\2\2"+
		"\u009b\u0099\3\2\2\2\u009c\u009d\5\b\5\2\u009d\u009e\7\24\2\2\u009e\u00a0"+
		"\3\2\2\2\u009f\u009c\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\13\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\7\b\2"+
		"\2\u00a5\u00a6\7\67\2\2\u00a6\u00a7\7\20\2\2\u00a7\u00ae\5f\64\2\u00a8"+
		"\u00a9\7\23\2\2\u00a9\u00aa\7\67\2\2\u00aa\u00ab\7\20\2\2\u00ab\u00ad"+
		"\5f\64\2\u00ac\u00a8\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u0109\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2\7\t"+
		"\2\2\u00b2\u00b3\7\67\2\2\u00b3\u00b4\7\20\2\2\u00b4\u00bb\5h\65\2\u00b5"+
		"\u00b6\7\23\2\2\u00b6\u00b7\7\67\2\2\u00b7\u00b8\7\20\2\2\u00b8\u00ba"+
		"\5h\65\2\u00b9\u00b5\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u0109\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7\n"+
		"\2\2\u00bf\u00c0\7\67\2\2\u00c0\u00c1\7\20\2\2\u00c1\u00c8\7!\2\2\u00c2"+
		"\u00c3\7\23\2\2\u00c3\u00c4\7\67\2\2\u00c4\u00c5\7\20\2\2\u00c5\u00c7"+
		"\7!\2\2\u00c6\u00c2\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u0109\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\7\13"+
		"\2\2\u00cc\u00cd\7\67\2\2\u00cd\u00ce\7\20\2\2\u00ce\u00d5\7\"\2\2\u00cf"+
		"\u00d0\7\23\2\2\u00d0\u00d1\7\67\2\2\u00d1\u00d2\7\20\2\2\u00d2\u00d4"+
		"\7\"\2\2\u00d3\u00cf\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\u0109\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9\7\r"+
		"\2\2\u00d9\u00da\7\67\2\2\u00da\u00db\7\20\2\2\u00db\u00e2\5B\"\2\u00dc"+
		"\u00dd\7\23\2\2\u00dd\u00de\7\67\2\2\u00de\u00df\7\20\2\2\u00df\u00e1"+
		"\5B\"\2\u00e0\u00dc\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u0109\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\7\16"+
		"\2\2\u00e6\u00e7\7\67\2\2\u00e7\u00e8\7\20\2\2\u00e8\u00ef\5\32\16\2\u00e9"+
		"\u00ea\7\23\2\2\u00ea\u00eb\7\67\2\2\u00eb\u00ec\7\20\2\2\u00ec\u00ee"+
		"\5\32\16\2\u00ed\u00e9\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2"+
		"\u00ef\u00f0\3\2\2\2\u00f0\u0109\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00f3"+
		"\7\17\2\2\u00f3\u00f4\7\67\2\2\u00f4\u00f5\7\20\2\2\u00f5\u00fc\7 \2\2"+
		"\u00f6\u00f7\7\23\2\2\u00f7\u00f8\7\67\2\2\u00f8\u00f9\7\20\2\2\u00f9"+
		"\u00fb\7 \2\2\u00fa\u00f6\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2"+
		"\2\2\u00fc\u00fd\3\2\2\2\u00fd\u0109\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff"+
		"\u0100\7\f\2\2\u0100\u0101\7\67\2\2\u0101\u0102\7\20\2\2\u0102\u0103\5"+
		"\60\31\2\u0103\u0104\7\23\2\2\u0104\u0105\7\67\2\2\u0105\u0106\7\20\2"+
		"\2\u0106\u0107\5\60\31\2\u0107\u0109\3\2\2\2\u0108\u00a4\3\2\2\2\u0108"+
		"\u00b1\3\2\2\2\u0108\u00be\3\2\2\2\u0108\u00cb\3\2\2\2\u0108\u00d8\3\2"+
		"\2\2\u0108\u00e5\3\2\2\2\u0108\u00f2\3\2\2\2\u0108\u00ff\3\2\2\2\u0109"+
		"\r\3\2\2\2\u010a\u010b\7\31\2\2\u010b\u010c\5\f\7\2\u010c\u010d\7\24\2"+
		"\2\u010d\u010f\3\2\2\2\u010e\u010a\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e"+
		"\3\2\2\2\u0110\u0111\3\2\2\2\u0111\17\3\2\2\2\u0112\u0110\3\2\2\2\u0113"+
		"\u0114\5d\63\2\u0114\u011b\7\67\2\2\u0115\u0116\7\23\2\2\u0116\u0117\5"+
		"d\63\2\u0117\u0118\7\67\2\2\u0118\u011a\3\2\2\2\u0119\u0115\3\2\2\2\u011a"+
		"\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\21\3\2\2"+
		"\2\u011d\u011b\3\2\2\2\u011e\u0123\5\30\r\2\u011f\u0120\7\23\2\2\u0120"+
		"\u0122\5\30\r\2\u0121\u011f\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3"+
		"\2\2\2\u0123\u0124\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0126"+
		"\u011e\3\2\2\2\u0126\u0127\3\2\2\2\u0127\23\3\2\2\2\u0128\u0129\7\67\2"+
		"\2\u0129\u012a\7\21\2\2\u012a\u012b\5\22\n\2\u012b\u012c\7\22\2\2\u012c"+
		"\25\3\2\2\2\u012d\u012e\7\67\2\2\u012e\u012f\7\21\2\2\u012f\u0130\5\22"+
		"\n\2\u0130\u0131\7\22\2\2\u0131\27\3\2\2\2\u0132\u013e\5\34\17\2\u0133"+
		"\u013e\5\32\16\2\u0134\u013e\5B\"\2\u0135\u013e\7 \2\2\u0136\u013e\7$"+
		"\2\2\u0137\u013e\7%\2\2\u0138\u013e\7!\2\2\u0139\u013e\7\"\2\2\u013a\u013e"+
		"\7\67\2\2\u013b\u013e\7#\2\2\u013c\u013e\5\60\31\2\u013d\u0132\3\2\2\2"+
		"\u013d\u0133\3\2\2\2\u013d\u0134\3\2\2\2\u013d\u0135\3\2\2\2\u013d\u0136"+
		"\3\2\2\2\u013d\u0137\3\2\2\2\u013d\u0138\3\2\2\2\u013d\u0139\3\2\2\2\u013d"+
		"\u013a\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013c\3\2\2\2\u013e\31\3\2\2"+
		"\2\u013f\u0140\7\27\2\2\u0140\u0145\5\30\r\2\u0141\u0142\7\23\2\2\u0142"+
		"\u0144\5\30\r\2\u0143\u0141\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3"+
		"\2\2\2\u0145\u0146\3\2\2\2\u0146\u0148\3\2\2\2\u0147\u0145\3\2\2\2\u0148"+
		"\u0149\7\30\2\2\u0149\33\3\2\2\2\u014a\u014c\5j\66\2\u014b\u014a\3\2\2"+
		"\2\u014b\u014c\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\5 \21\2\u014e\u014f"+
		"\5\36\20\2\u014f\35\3\2\2\2\u0150\u0151\5j\66\2\u0151\u0152\5 \21\2\u0152"+
		"\u0154\3\2\2\2\u0153\u0150\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2"+
		"\2\2\u0155\u0156\3\2\2\2\u0156\37\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u015e"+
		"\5\"\22\2\u0159\u015a\5l\67\2\u015a\u015b\5\"\22\2\u015b\u015d\3\2\2\2"+
		"\u015c\u0159\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f"+
		"\3\2\2\2\u015f!\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u016b\7\67\2\2\u0162"+
		"\u0163\7\21\2\2\u0163\u0164\5\34\17\2\u0164\u0165\7\22\2\2\u0165\u016b"+
		"\3\2\2\2\u0166\u016b\7$\2\2\u0167\u016b\7%\2\2\u0168\u016b\7!\2\2\u0169"+
		"\u016b\5\24\13\2\u016a\u0161\3\2\2\2\u016a\u0162\3\2\2\2\u016a\u0166\3"+
		"\2\2\2\u016a\u0167\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016b"+
		"#\3\2\2\2\u016c\u016d\t\2\2\2\u016d%\3\2\2\2\u016e\u016f\5\34\17\2\u016f"+
		"\u0170\5$\23\2\u0170\u0171\5\34\17\2\u0171\'\3\2\2\2\u0172\u017d\7\67"+
		"\2\2\u0173\u017d\7 \2\2\u0174\u017d\5\24\13\2\u0175\u0176\7\21\2\2\u0176"+
		"\u0177\5\60\31\2\u0177\u0178\7\22\2\2\u0178\u017d\3\2\2\2\u0179\u017d"+
		"\5F$\2\u017a\u017d\5D#\2\u017b\u017d\5&\24\2\u017c\u0172\3\2\2\2\u017c"+
		"\u0173\3\2\2\2\u017c\u0174\3\2\2\2\u017c\u0175\3\2\2\2\u017c\u0179\3\2"+
		"\2\2\u017c\u017a\3\2\2\2\u017c\u017b\3\2\2\2\u017d)\3\2\2\2\u017e\u0180"+
		"\7&\2\2\u017f\u017e\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0184\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u0185\5("+
		"\25\2\u0185+\3\2\2\2\u0186\u018b\5*\26\2\u0187\u0188\7\'\2\2\u0188\u018a"+
		"\5*\26\2\u0189\u0187\3\2\2\2\u018a\u018d\3\2\2\2\u018b\u0189\3\2\2\2\u018b"+
		"\u018c\3\2\2\2\u018c-\3\2\2\2\u018d\u018b\3\2\2\2\u018e\u0193\5,\27\2"+
		"\u018f\u0190\7(\2\2\u0190\u0192\5,\27\2\u0191\u018f\3\2\2\2\u0192\u0195"+
		"\3\2\2\2\u0193\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194/\3\2\2\2\u0195"+
		"\u0193\3\2\2\2\u0196\u0197\5\62\32\2\u0197\u0198\5<\37\2\u0198\61\3\2"+
		"\2\2\u0199\u019b\7&\2\2\u019a\u0199\3\2\2\2\u019b\u019e\3\2\2\2\u019c"+
		"\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019f\3\2\2\2\u019e\u019c\3\2"+
		"\2\2\u019f\u01a0\5\64\33\2\u01a0\u01a1\58\35\2\u01a1\u01b2\3\2\2\2\u01a2"+
		"\u01a4\7&\2\2\u01a3\u01a2\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a3\3\2"+
		"\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a8\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8"+
		"\u01a9\5\66\34\2\u01a9\u01aa\5:\36\2\u01aa\u01b2\3\2\2\2\u01ab\u01ad\7"+
		"&\2\2\u01ac\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae"+
		"\u01af\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b2\5\60\31\2\u01b1\u019c\3"+
		"\2\2\2\u01b1\u01a5\3\2\2\2\u01b1\u01ac\3\2\2\2\u01b2\63\3\2\2\2\u01b3"+
		"\u01be\7\67\2\2\u01b4\u01be\7 \2\2\u01b5\u01be\5\24\13\2\u01b6\u01b7\7"+
		"\21\2\2\u01b7\u01b8\5\60\31\2\u01b8\u01b9\7\22\2\2\u01b9\u01be\3\2\2\2"+
		"\u01ba\u01be\5F$\2\u01bb\u01be\5\34\17\2\u01bc\u01be\5&\24\2\u01bd\u01b3"+
		"\3\2\2\2\u01bd\u01b4\3\2\2\2\u01bd\u01b5\3\2\2\2\u01bd\u01b6\3\2\2\2\u01bd"+
		"\u01ba\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01bc\3\2\2\2\u01be\65\3\2\2"+
		"\2\u01bf\u01ca\7 \2\2\u01c0\u01ca\7$\2\2\u01c1\u01ca\7%\2\2\u01c2\u01ca"+
		"\7!\2\2\u01c3\u01ca\7\"\2\2\u01c4\u01ca\5\34\17\2\u01c5\u01ca\5\32\16"+
		"\2\u01c6\u01ca\5B\"\2\u01c7\u01ca\7\67\2\2\u01c8\u01ca\7#\2\2\u01c9\u01bf"+
		"\3\2\2\2\u01c9\u01c0\3\2\2\2\u01c9\u01c1\3\2\2\2\u01c9\u01c2\3\2\2\2\u01c9"+
		"\u01c3\3\2\2\2\u01c9\u01c4\3\2\2\2\u01c9\u01c5\3\2\2\2\u01c9\u01c6\3\2"+
		"\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01c8\3\2\2\2\u01ca\67\3\2\2\2\u01cb\u01cc"+
		"\7\'\2\2\u01cc\u01ce\5*\26\2\u01cd\u01cb\3\2\2\2\u01ce\u01d1\3\2\2\2\u01cf"+
		"\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d6\3\2\2\2\u01d1\u01cf\3\2"+
		"\2\2\u01d2\u01d3\7(\2\2\u01d3\u01d5\5,\27\2\u01d4\u01d2\3\2\2\2\u01d5"+
		"\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01dd\3\2"+
		"\2\2\u01d8\u01d6\3\2\2\2\u01d9\u01da\7)\2\2\u01da\u01dc\5.\30\2\u01db"+
		"\u01d9\3\2\2\2\u01dc\u01df\3\2\2\2\u01dd\u01db\3\2\2\2\u01dd\u01de\3\2"+
		"\2\2\u01de9\3\2\2\2\u01df\u01dd\3\2\2\2\u01e0\u01e1\7*\2\2\u01e1\u01e2"+
		"\5B\"\2\u01e2\u01e3\58\35\2\u01e3;\3\2\2\2\u01e4\u01e5\5\60\31\2\u01e5"+
		"\u01e6\5:\36\2\u01e6\u01e9\3\2\2\2\u01e7\u01e9\5:\36\2\u01e8\u01e4\3\2"+
		"\2\2\u01e8\u01e7\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9=\3\2\2\2\u01ea\u0206"+
		"\7\67\2\2\u01eb\u0206\5\24\13\2\u01ec\u01ed\7\21\2\2\u01ed\u01ee\5B\""+
		"\2\u01ee\u01ef\7\22\2\2\u01ef\u0206\3\2\2\2\u01f0\u01f9\7\25\2\2\u01f1"+
		"\u01f6\5\30\r\2\u01f2\u01f3\7\23\2\2\u01f3\u01f5\5\30\r\2\u01f4\u01f2"+
		"\3\2\2\2\u01f5\u01f8\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7"+
		"\u01fa\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f9\u01f1\3\2\2\2\u01f9\u01fa\3\2"+
		"\2\2\u01fa\u01fb\3\2\2\2\u01fb\u0206\7\26\2\2\u01fc\u01ff\7\25\2\2\u01fd"+
		"\u0200\7\67\2\2\u01fe\u0200\5\32\16\2\u01ff\u01fd\3\2\2\2\u01ff\u01fe"+
		"\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0202\7\7\2\2\u0202\u0203\5\60\31\2"+
		"\u0203\u0204\7\26\2\2\u0204\u0206\3\2\2\2\u0205\u01ea\3\2\2\2\u0205\u01eb"+
		"\3\2\2\2\u0205\u01ec\3\2\2\2\u0205\u01f0\3\2\2\2\u0205\u01fc\3\2\2\2\u0206"+
		"?\3\2\2\2\u0207\u020c\5> \2\u0208\u0209\7+\2\2\u0209\u020b\5> \2\u020a"+
		"\u0208\3\2\2\2\u020b\u020e\3\2\2\2\u020c\u020a\3\2\2\2\u020c\u020d\3\2"+
		"\2\2\u020dA\3\2\2\2\u020e\u020c\3\2\2\2\u020f\u0214\5@!\2\u0210\u0211"+
		"\7,\2\2\u0211\u0213\5@!\2\u0212\u0210\3\2\2\2\u0213\u0216\3\2\2\2\u0214"+
		"\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215C\3\2\2\2\u0216\u0214\3\2\2\2"+
		"\u0217\u0218\5\30\r\2\u0218\u0219\7*\2\2\u0219\u021a\5B\"\2\u021a\u021d"+
		"\3\2\2\2\u021b\u021d\5\34\17\2\u021c\u0217\3\2\2\2\u021c\u021b\3\2\2\2"+
		"\u021dE\3\2\2\2\u021e\u021f\5B\"\2\u021f\u0220\5$\23\2\u0220\u0221\5B"+
		"\"\2\u0221G\3\2\2\2\u0222\u0223\7\33\2\2\u0223\u0225\5\60\31\2\u0224\u0222"+
		"\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u022a\3\2\2\2\u0226\u0227\7\34\2\2"+
		"\u0227\u0228\5\16\b\2\u0228\u0229\5\n\6\2\u0229\u022b\3\2\2\2\u022a\u0226"+
		"\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u022d\3\2\2\2\u022c\u022e\5J&\2\u022d"+
		"\u022c\3\2\2\2\u022e\u022f\3\2\2\2\u022f\u022d\3\2\2\2\u022f\u0230\3\2"+
		"\2\2\u0230I\3\2\2\2\u0231\u0240\5P)\2\u0232\u0240\5V,\2\u0233\u0234\5"+
		"\24\13\2\u0234\u0235\7\24\2\2\u0235\u0240\3\2\2\2\u0236\u0237\5\26\f\2"+
		"\u0237\u0238\7\24\2\2\u0238\u0240\3\2\2\2\u0239\u023a\5L\'\2\u023a\u023b"+
		"\7\24\2\2\u023b\u0240\3\2\2\2\u023c\u023d\5N(\2\u023d\u023e\7\24\2\2\u023e"+
		"\u0240\3\2\2\2\u023f\u0231\3\2\2\2\u023f\u0232\3\2\2\2\u023f\u0233\3\2"+
		"\2\2\u023f\u0236\3\2\2\2\u023f\u0239\3\2\2\2\u023f\u023c\3\2\2\2\u0240"+
		"K\3\2\2\2\u0241\u0242\7\67\2\2\u0242\u0243\7\20\2\2\u0243\u0244\5\30\r"+
		"\2\u0244M\3\2\2\2\u0245\u0247\7\6\2\2\u0246\u0248\5\30\r\2\u0247\u0246"+
		"\3\2\2\2\u0247\u0248\3\2\2\2\u0248O\3\2\2\2\u0249\u024a\7\4\2\2\u024a"+
		"\u024b\7\21\2\2\u024b\u024c\5T+\2\u024c\u024d\7\22\2\2\u024d\u0251\7\25"+
		"\2\2\u024e\u0250\5J&\2\u024f\u024e\3\2\2\2\u0250\u0253\3\2\2\2\u0251\u024f"+
		"\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u0254\3\2\2\2\u0253\u0251\3\2\2\2\u0254"+
		"\u0256\7\26\2\2\u0255\u0257\5R*\2\u0256\u0255\3\2\2\2\u0256\u0257\3\2"+
		"\2\2\u0257Q\3\2\2\2\u0258\u0259\7\5\2\2\u0259\u025d\7\25\2\2\u025a\u025c"+
		"\5J&\2\u025b\u025a\3\2\2\2\u025c\u025f\3\2\2\2\u025d\u025b\3\2\2\2\u025d"+
		"\u025e\3\2\2\2\u025e\u0260\3\2\2\2\u025f\u025d\3\2\2\2\u0260\u0261\7\26"+
		"\2\2\u0261S\3\2\2\2\u0262\u0263\5\60\31\2\u0263U\3\2\2\2\u0264\u0265\7"+
		"\3\2\2\u0265\u0266\7\21\2\2\u0266\u0267\5T+\2\u0267\u0268\7\22\2\2\u0268"+
		"\u026a\7\25\2\2\u0269\u026b\5J&\2\u026a\u0269\3\2\2\2\u026b\u026c\3\2"+
		"\2\2\u026c\u026a\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u026e\3\2\2\2\u026e"+
		"\u026f\7\26\2\2\u026fW\3\2\2\2\u0270\u0271\5d\63\2\u0271\u0272\5\\/\2"+
		"\u0272Y\3\2\2\2\u0273\u0274\7\37\2\2\u0274\u0275\5\\/\2\u0275[\3\2\2\2"+
		"\u0276\u0277\7\67\2\2\u0277\u0279\7\21\2\2\u0278\u027a\5\20\t\2\u0279"+
		"\u0278\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027c\7\22"+
		"\2\2\u027c\u027d\7\25\2\2\u027d\u027e\5H%\2\u027e\u027f\7\26\2\2\u027f"+
		"]\3\2\2\2\u0280\u0281\5d\63\2\u0281\u0282\5b\62\2\u0282_\3\2\2\2\u0283"+
		"\u0284\7\37\2\2\u0284\u0285\5b\62\2\u0285a\3\2\2\2\u0286\u0287\7\67\2"+
		"\2\u0287\u0289\7\21\2\2\u0288\u028a\5\20\t\2\u0289\u0288\3\2\2\2\u0289"+
		"\u028a\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u028c\7\22\2\2\u028c\u028d\7"+
		"\24\2\2\u028dc\3\2\2\2\u028e\u028f\t\3\2\2\u028fe\3\2\2\2\u0290\u0292"+
		"\5j\66\2\u0291\u0290\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0293\3\2\2\2\u0293"+
		"\u0294\7$\2\2\u0294g\3\2\2\2\u0295\u0297\5j\66\2\u0296\u0295\3\2\2\2\u0296"+
		"\u0297\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u0299\7%\2\2\u0299i\3\2\2\2\u029a"+
		"\u029b\t\4\2\2\u029bk\3\2\2\2\u029c\u029d\t\5\2\2\u029dm\3\2\2\2>rw\u0080"+
		"\u0086\u008d\u0091\u0099\u00a1\u00ae\u00bb\u00c8\u00d5\u00e2\u00ef\u00fc"+
		"\u0108\u0110\u011b\u0123\u0126\u013d\u0145\u014b\u0155\u015e\u016a\u017c"+
		"\u0181\u018b\u0193\u019c\u01a5\u01ae\u01b1\u01bd\u01c9\u01cf\u01d6\u01dd"+
		"\u01e8\u01f6\u01f9\u01ff\u0205\u020c\u0214\u021c\u0224\u022a\u022f\u023f"+
		"\u0247\u0251\u0256\u025d\u026c\u0279\u0289\u0291\u0296";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}