package Deducers;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import Parsers.CDataEntity;
import Parsers.ExprVisitor;
import Parsers.GrammarBLexer;
import Parsers.GrammarBParser;


public class CExprInputor {
	private ExprVisitor expr_visitor = new ExprVisitor();
	
	public CExprInputor(){
		
	}
	
	public CDataEntity get_expr(String in_expr_str){
		ANTLRInputStream input_stream = new ANTLRInputStream(in_expr_str);
		GrammarBLexer lexer = new GrammarBLexer(input_stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GrammarBParser parser = new GrammarBParser(tokens);
		// TODO 输入错误处理
		expr_visitor.visit(parser.expression());
		return expr_visitor.get_entity();
	}
}
