package ContextUI;

import java.util.concurrent.Semaphore;

public class CGlobalSemp {
	private static Semaphore semp = new Semaphore(0);
	
	public static final void acquire() throws InterruptedException{
		semp.acquire();
	}
	
	public static final void release() throws InterruptedException{
		semp.release();
	}
}
