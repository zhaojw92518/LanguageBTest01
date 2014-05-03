package ContextUI;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
public class CWinStateListener extends CBaseFrameListener implements WindowStateListener {
	public CWinStateListener(CContextFrame in_frame) {
		super(in_frame);
	}
	
	
	@Override
	public void windowStateChanged(WindowEvent e) {
		adjust_frame();
	}
}
