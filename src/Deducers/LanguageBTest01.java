package Deducers;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;

import ContextUI.CGlobalStaticSource;
import ContextUI.COptionFrame;
import Defines.DeduceDef;
import Parsers.GrammarBLexer;
import Parsers.GrammarBParser;
import Parsers.MyVisitor;

public class LanguageBTest01 {

	public static void main(String[] args) throws InterruptedException {
		
		
		//DeduceDef initialization
		DeduceDef.level_array_init();
		//Font initialization
		CGlobalStaticSource.init_font();
		
		CExprInputor temp_inputor = new CExprInputor();
		
		CDeduceExpr temp_expr = temp_inputor.get_expr("z + x * (20 -x) + 0.5 * ((20 - x) - 1) * (20 - x)");
		System.out.println(CValueGen.map_to_str(temp_expr.adv_toString()));
		
		
		File file = new File("./src/Example.txt");
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			ANTLRInputStream input = new ANTLRInputStream(in);
			GrammarBLexer lexer = new GrammarBLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        GrammarBParser parser = new GrammarBParser(tokens);
	        ParseTree tree = parser.abstact_machine();  // parse
	        
	        /*String temp_str = new String("(x + y * z) / ( 4.0 * t + t + x - 2 * t)");
	        ANTLRInputStream input_stream = new ANTLRInputStream(temp_str);
	        GrammarBLexer lexer_2 = new GrammarBLexer(input_stream);
	        CommonTokenStream tokens_2 = new CommonTokenStream(lexer_2);
	        GrammarBParser parser_2 = new GrammarBParser(tokens_2);
	        ParseTree tree_2 = parser_2.expression();
	        System.out.println(tree_2.toStringTree(parser_2));
	        
	        ExprVisitor expr_visitor = new ExprVisitor();
	        expr_visitor.visit(tree_2);
	        CDeduceExpr cur_expr = expr_visitor.get_expr();
	        CValueGen cur_gen = new CValueGen(cur_expr);
	        System.out.println(cur_gen.toString());*/
	        MyVisitor eval = new MyVisitor();
	        eval.visit(tree);
	        CQuaManager cur_manager = eval.get_qua_manager();
	        //cur_manager.print_all_quaternions();
	        cur_manager.file_out_all_quaternions("qua_debug.txt");
	        System.out.println(tree.toStringTree(parser));
	        
	        CQuaAnalyzer cur_analyzer = new CQuaAnalyzer(cur_manager.get_quaternions());
	        cur_analyzer.set_code_text(input.getText(new Interval(0, input.size())));
	        while(true){
	        	if(!cur_analyzer.top_brench()){
	        		break;
	        	}
	        }    
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		}
	}

}
