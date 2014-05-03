package ContextUI;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CDeduceTextArea extends JScrollPane {
	private JTextArea deduce_text_area = new JTextArea();
	
	public CDeduceTextArea(){
		super();
		deduce_text_area.setLineWrap(false);
		deduce_text_area.setEditable(false);
		deduce_text_area.setTabSize(2);
		this.getViewport().add(deduce_text_area);
		this.setVisible(true);
	}
	
	public void set_text(String in_deduce_strs){
		deduce_text_area.setText(in_deduce_strs);
	}
}
