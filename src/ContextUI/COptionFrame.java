/**
 * 
 */
package ContextUI;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import Defines.DeduceDef;
import PackageMsg.COptionMsg;

/**
 * @author Zhao
 *
 */
public class COptionFrame extends JFrame {
	private JComboBox<String> 	left_box = new JComboBox<String>(),
								right_box = new JComboBox<String>();
	private JComboBox<DeduceDef> method_box = new JComboBox<DeduceDef>();
	
	private JButton enter_button = new JButton("Enter");
	
	public COptionFrame(){
		super("Option");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLayout(null);
		
		left_box.addItem("Current");
		left_box.addItem("Last");
		
		left_box.setSelectedIndex(0);
		
		right_box.addItem("Current");
		right_box.addItem("Last");
		
		right_box.setSelectedIndex(1);
		
		for(DeduceDef cur_def: DeduceDef.get_math_symbols()){
			method_box.addItem(cur_def);
		}
		
		method_box.setSelectedIndex(1);
		
		this.add(left_box);
		this.add(method_box);
		this.add(right_box);
		this.add(enter_button);
		
		left_box.setBounds(10, 20, 100, 30);
		method_box.setBounds(120, 20, 60, 30);
		right_box.setBounds(190, 20, 100, 30);
		enter_button.setBounds(100, 100, 100, 30);
		
		this.setSize(300, 200);
		this.setResizable(false);
		this.setVisible(false);
	}
	
	public void add_button_listener(CStrGetButtonListener in_listener){
		enter_button.addActionListener(in_listener);
	}
	
	public void update(){
		
	}
	public COptionMsg get_option_msg(){
		return new COptionMsg(
				(String)left_box.getSelectedItem(), 
				(String)right_box.getSelectedItem(), 
				(DeduceDef)method_box.getSelectedItem());
	}
}
