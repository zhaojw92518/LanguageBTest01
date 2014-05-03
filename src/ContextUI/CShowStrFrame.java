package ContextUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CShowStrFrame extends JFrame{
	public CShowStrFrame(String in_str){
		super("Show Str");
		setLayout(new BorderLayout());
		JTextArea text_area = new JTextArea();
		text_area.setLineWrap(false);
		text_area.setText(in_str);
		JScrollPane scroll_pane = new JScrollPane(text_area);
		this.add(scroll_pane);
		this.setPreferredSize(new Dimension(500, 300));
		this.setSize(300, 500);
		this.setResizable(false);
		this.setVisible(true);
	}
}
