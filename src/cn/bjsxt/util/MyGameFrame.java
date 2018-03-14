package cn.bjsxt.util;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class MyGameFrame extends Frame{
	
	/**
	 * 加载窗口
	 */
	public void launchFrame() {
		  setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		  setLocation(Constant.WINDOW_LOCATION_X, Constant.WINDOW_LOCATION_Y);
		  setVisible(true);
		  
		  new PaintThread().start(); // 启动重画线程
		              
		  // 窗口监听器 关闭窗口
		  addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
				  System.exit(0);
			  };
		  });
	}
	
	
	/**
	 * 线程函数类  内部类，方便访问外部属性
	 */
	class PaintThread extends Thread{
		
		// 代码执行体 
		public void run() {
			while(true) { 
				
				// 重画 调用paint()方法
				repaint();
				
				try {
					Thread.sleep(100);	// 1s = 1000ms
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
			}
		}  
	}
	
	

}
