import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import TreeUI.CPaintData;
import TreeUI.CShowFrame;


public class LanguageBTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("./src/Example.txt");
		InputStream in = null;
		try {
			
			CPaintData test_data = new CPaintData();
			test_data.generate_canvas_size();
			test_data.generate_node_location();
			CShowFrame test_frame = new CShowFrame(test_data);
			test_frame.repaint();
			
			
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
