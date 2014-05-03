package ContextUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import Defines.DeduceResultDef;

public class CStrGetButtonListener implements ActionListener {
	private String text_str;
	private JTextField the_text_field;
	private DeduceResultDef deduce_result;
	
	public CStrGetButtonListener(JTextField in_TextField){
		the_text_field = in_TextField;
	}
	
	public void actionPerformed(ActionEvent e) 
    { 
		String buttonName = e.getActionCommand(); 
		try {
			if (buttonName.equals("Input")){ 
				text_str = the_text_field.getText();
				deduce_result = DeduceResultDef.INPUT;
				CGlobalSemp.release();
			}
			else if(buttonName.equals("Again")){
				deduce_result = DeduceResultDef.AGAIN;
				CGlobalSemp.release();
			}
			else if(buttonName.equals("Next")){
				deduce_result = DeduceResultDef.NEXT;
				CGlobalSemp.release();
			}
			else if(buttonName.equals("Confirm")){
				deduce_result = DeduceResultDef.CONFIRM;
				CGlobalSemp.release();
			}
			else if(buttonName.equals("Option")){
				deduce_result = DeduceResultDef.OPTION;
				
			}
			else if(buttonName.equals("Enter")){
				deduce_result = DeduceResultDef.ENTER;
				CGlobalSemp.release();
			}
		} 
        catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
	
	public String get_text_ter(){
		return text_str;
	}
	
	public DeduceResultDef get_deduce_result(){
		return deduce_result;
	}
}
