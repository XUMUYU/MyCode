package cn.bjsxt.solar;

import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.Constant;
import cn.bjsxt.util.MyGameFrame;
import cn.bjsxt.util.MyGameUtil;

/**
 * 程序主窗口
 * @author lenovo
 *
 */
public class SolarFrame extends MyGameFrame{
	
	// 生成对象
	Image bg = MyGameUtil.getImage("images/bg.jpg");
	Star sun = new Star("images/sun.jpg", Constant.GAME_WIDTH / 2, Constant.GAME_HEIGHT / 2);
	Planet earth = new Planet(sun, "images/Earth.jpg", 120, 80, 0.1);	// 1
	Planet mars = new Planet(sun, "images/Mars.jpg", 150, 120, 0.1);	// 2
	Planet moon = new Planet(earth, "images/moon.jpg", 40, 20, 0.2, true); // 1.1
	Planet jupiter = new Planet(sun, "images/jupiter.jpg", 170, 140, 0.3); // 3
	Planet mercury = new Planet(sun, "images/Mercury.jpg", 200, 160, 0.31);	// 4
	Planet neptune = new Planet(sun, "images/Neptune.jpg", 230, 190, 0.33);	// 5
	Planet saturn = new Planet(sun, "images/Saturn.jpg", 250, 210, 0.37);	// 6
	Planet uranus = new Planet(sun, "images/Uranus.jpg", 280, 230, 0.39);	// 7
	Planet venus = new Planet(sun, "images/Venus.jpg", 300, 260, 0.4);	// 8
	
	
	// 画图 回调函数
	public void paint(Graphics g) {
		
		// 画背景以及行星
		g.drawImage(bg, 0, 0, null);
		sun.draw(g);
		earth.draw(g);
		mars.draw(g);
		moon.draw(g);
		jupiter.draw(g);
		mercury.draw(g);
		neptune.draw(g);
		saturn.draw(g);
		uranus.draw(g);
		venus.draw(g);
	}
	
	
	public static void main(String[] args) {
		System.out.println("Func -> main:Program begining...");
		new SolarFrame().launchFrame();
	}
}
