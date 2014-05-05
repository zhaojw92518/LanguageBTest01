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
import Parsers.CDataEntity;
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
		
		CDataEntity data_entity = temp_inputor.get_expr("{1,2,3} \\-/ {x | x > 1 /\\ x < 10}");
		System.out.println(data_entity.toString());
		
		
		File file = new File("./src/Example.txt");
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			ANTLRInputStream input = new ANTLRInputStream(in);
			GrammarBLexer lexer = new GrammarBLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        GrammarBParser parser = new GrammarBParser(tokens);
	        ParseTree tree = parser.abstact_machine();  // parse
	        
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
