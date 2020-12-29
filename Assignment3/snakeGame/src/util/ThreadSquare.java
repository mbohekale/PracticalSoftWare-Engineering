package util;
/**
 * 
 * @author Ekale
 *
 */

public class ThreadSquare extends Thread{
	 private final Object GUI_INITIALIZATION_MONITOR = new Object();
	  
	  private boolean pauseThreadFlag = false;
	  public DataOfSquare square;
	  
	 public ThreadSquare(DataOfSquare c) { this.square = c; }

	  
	  public void run() {
	    while (true) {
	      synchronized (this.GUI_INITIALIZATION_MONITOR) {
	        while (this.pauseThreadFlag) {
	          try {
	            this.GUI_INITIALIZATION_MONITOR.wait();
	          } catch (Exception exception) {}
	        } 
	      } 
	      this.square.lightMeUp(0);
	      pauseThread();
	    } 
	  }
	  
	  public void pauseThread() { this.pauseThreadFlag = true; }
	  
	  public void resumeThread() {
	    synchronized (this.GUI_INITIALIZATION_MONITOR) {
	      this.pauseThreadFlag = false;
	      this.GUI_INITIALIZATION_MONITOR.notify();
	    } 
	  }

}
