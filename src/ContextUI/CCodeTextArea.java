package ContextUI;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Element;
import javax.swing.text.Highlighter;

public class CCodeTextArea extends JScrollPane{
	private JTextArea code_text_area = new JTextArea();
	private JTextArea line_num = new JTextArea("1");
	
	public CCodeTextArea(){
		super();
		code_text_area.setLineWrap(false);//禁止自动换行
		code_text_area.setEditable(false);
		code_text_area.setTabSize(4);
		line_num.setLineWrap(false);
		line_num.setEditable(false);
		line_num.setBackground(Color.LIGHT_GRAY);
		
		this.getViewport().add(code_text_area);
		this.setRowHeaderView(line_num);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	public void set_code_text(String in_text){
		code_text_area.setText(in_text);
		update_line_num();
	}
	
	private void update_line_num(){
		int caret_position = code_text_area.getDocument().getLength();
		Element root = code_text_area.getDocument().getDefaultRootElement();
		String line_num_text = "1" + CGlobalStaticSource.endl_str;
		for(int i = 2; i < root.getElementIndex(caret_position) + 2; i++){
			line_num_text += i + CGlobalStaticSource.endl_str;
		}
		line_num.setText(line_num_text);
	}
	
	public void highlight_code(int begin_line_index, int end_line_index){
		try {
			int begin_char_index = code_text_area.getLineStartOffset(begin_line_index);
			int end_char_index = code_text_area.getLineEndOffset(end_line_index);
			Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
			code_text_area.getHighlighter().removeAllHighlights();
			code_text_area.getHighlighter().addHighlight(begin_char_index, end_char_index, painter);
			
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
