package ContextUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;

import Defines.DeduceResultDef;
import PackageMsg.COptionMsg;

public class CContextFrame extends JFrame {
	private static final int preferred_width = 1000;
	
	private CContextUI context = new CContextUI();
	public JTextField input_text_field = new JTextField();;
	private JButton input_button = new JButton("Input"),
					 again_button = new JButton("Again"),
					 next_button = new JButton("Next"),
					 confirm_button = new JButton("Confirm"),
					 option_button = new JButton("Option");
	private CStrGetButtonListener listener;
	private CInOutIdPanel in_out_id_panel;
	private CCodeTextArea code_text_area;
	private CDeduceTextArea deduce_text_area;
	private COptionFrame option_frame = new COptionFrame();
	
	public JSplitPane center_pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	public JSplitPane left_pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	public JSplitPane right_pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	public JPanel top_pane;
	public JPanel input_panel = new JPanel();;
	
	public CContextFrame(){
		super("Context");
			
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(preferred_width, 525));
		
		BoxLayout box_layout = new BoxLayout(input_panel, BoxLayout.X_AXIS);
		input_panel.setLayout(box_layout);
		input_panel.setPreferredSize(new Dimension(preferred_width, 30));
		
		input_text_field.setPreferredSize(new Dimension(preferred_width - 200, 30));
		
		input_button.setPreferredSize(new Dimension(100, 30));
		again_button.setPreferredSize(new Dimension(100, 30));
		next_button.setPreferredSize(new Dimension(100, 30));
		confirm_button.setPreferredSize(new Dimension(100, 30));
		option_button.setPreferredSize(new Dimension(100, 30));
		
		listener = new CStrGetButtonListener(input_text_field);
		input_button.addActionListener(listener);
		again_button.addActionListener(listener);
		confirm_button.addActionListener(listener);
		next_button.addActionListener(listener);
		option_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				set_option_frame_visible();
			}
		});
		option_frame.add_button_listener(listener);
		
		input_panel.add(input_text_field);
		input_panel.add(input_button);
		input_panel.add(again_button);
		input_panel.add(confirm_button);
		input_panel.add(next_button);
		input_panel.add(option_button);
		
		//this.add(input_panel, BorderLayout.CENTER);
		
		JSplitPane split_pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split_pane.setDividerLocation(0.9);
		
		top_pane = new JPanel();
		top_pane.setLayout(new BorderLayout());
				
		center_pane.setDividerLocation(0.5);
		left_pane.setDividerLocation(0.8);
		right_pane.setDividerLocation(0.5);
		
		left_pane.setLeftComponent(context);
		
		in_out_id_panel = new CInOutIdPanel();
		JScrollPane in_out_id_scroll = new JScrollPane(in_out_id_panel);
		left_pane.setRightComponent(in_out_id_scroll);
		
		code_text_area = new CCodeTextArea();
		right_pane.setLeftComponent(code_text_area);
		
		deduce_text_area = new CDeduceTextArea();
		right_pane.setRightComponent(deduce_text_area);
		
		center_pane.setLeftComponent(left_pane);
		center_pane.setRightComponent(right_pane);
		
		top_pane.setPreferredSize(new Dimension(preferred_width, 450));
		top_pane.add(center_pane);

		this.add(top_pane);
		this.add(input_panel);
		
		this.add(split_pane);
		
		this.validate();
		this.setSize(preferred_width, 500);
		
		CWinStateListener win_state_listener = new CWinStateListener(this);
		this.addWindowStateListener(win_state_listener);
		CCompListener comp_listener = new CCompListener(this);
		this.addComponentListener(comp_listener);
		CWinListener win_listener = new CWinListener(this);
		this.addWindowListener(win_listener);
		
		this.setVisible(true);
	}
	
	public void update(LinkedList<DefaultMutableTreeNode> in_list){
		context.update(in_list);
		this.repaint();
	}
	
	public void update_ids(String[] in_input_array, String[] in_output_array, int in_input_size, int in_output_size){
		in_out_id_panel.update(in_input_array, in_output_array, in_input_size, in_output_size);
	}
	
	public void update_iterations(String in_iterations_count, String in_iterations_input){
		in_out_id_panel.update_iterations(in_iterations_count, in_iterations_input);
	}
	
	public String get_text_str(){
		return listener.get_text_ter();
	}
	
	public DeduceResultDef get_deduce_result(){
		return listener.get_deduce_result();
	}
	
	public void set_code_text(String in_text){
		code_text_area.set_code_text(in_text);
	}
	
	public void highlight_code(int begin_line_index, int end_line_index){
		code_text_area.highlight_code(begin_line_index, end_line_index);
	}
	
	public void set_deduce_text(String in_text){
		deduce_text_area.set_text(in_text);
	}
	
	public void set_deduce_text(LinkedList<String> in_text_list){
		String temp_str = "";
		for(String cur_str: in_text_list){
			temp_str += cur_str + CGlobalStaticSource.endl_str;
		}
		deduce_text_area.set_text(temp_str);
	}
	
	public void set_output_id_value(String in_value){
		in_out_id_panel.set_selected_id_value(in_value);
	}
	
	public HashMap<String, String> get_id_value_map(){
		return in_out_id_panel.get_id_value_map();
	}
	
	public COptionMsg get_option_msg(){
		return option_frame.get_option_msg();
	}
	
	public void set_option_frame_invisible(){
		option_frame.setVisible(false);
	}
	
	public void set_option_frame_visible(){
		option_frame.setVisible(true);
	}
	
	public String get_iterations_input_str(){
		return in_out_id_panel.get_iterations_input();
	}
	
	public void update_output_values(HashMap<String, String> in_map){
		in_out_id_panel.update_output_values(in_map);
	}
}
