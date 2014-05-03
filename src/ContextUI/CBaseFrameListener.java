package ContextUI;

import java.awt.Dimension;

public class CBaseFrameListener {
	private CContextFrame own_frame;
	
	public CBaseFrameListener(CContextFrame in_frame){
		own_frame = in_frame;
	}
	
	public void adjust_frame(){
		own_frame.center_pane.setPreferredSize(new Dimension(own_frame.getWidth(), own_frame.getHeight() - 80));
		own_frame.top_pane.setPreferredSize(new Dimension(own_frame.getWidth(), own_frame.getHeight() - 80));
		own_frame.input_text_field.setPreferredSize(new Dimension(own_frame.getWidth() - 520, 30));
		own_frame.input_panel.setPreferredSize(new Dimension(own_frame.getWidth() -20, 30));
		
		own_frame.center_pane.setDividerLocation(own_frame.getWidth() / 2);
		own_frame.left_pane.setDividerLocation(0.5);
		own_frame.right_pane.setDividerLocation(0.5);
	}
}
