package ContextUI;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CWinListener implements WindowListener{
	private CContextFrame own_frame;
	
	public CWinListener(CContextFrame in_frame) {
		// TODO Auto-generated constructor stub
		super();
		own_frame = in_frame;
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		own_frame.center_pane.setDividerLocation(own_frame.getWidth() / 2);
		own_frame.left_pane.setDividerLocation(0.5);
		own_frame.right_pane.setDividerLocation(0.5);
	}

}
