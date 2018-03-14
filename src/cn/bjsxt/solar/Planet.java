package cn.bjsxt.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.MyGameUtil;

public class Planet extends Star{

	// 字段
	// 除了图片、坐标还有什么
	// 椭圆 长轴、短轴、速度、角度  绕着某个Star公转
	double longAxis;
	double shortAxis;
	double speed;
	Star centerStar;
	double degree;
	boolean satellite = false;
	
	
	// 构造函数0
	public Planet(Star centerStar, String imgPath, double longAxis, double shortAxis, double speed, boolean satellite) {
		this(centerStar, imgPath, longAxis, shortAxis, speed);
		this.satellite = satellite;
	}
	
	
	
	// 构造函数1
	public Planet(Star centerStar, String imgPath, double longAxis, double shortAxis, double speed) {
		
		// 调用父类构造函数第一语句
		super(MyGameUtil.getImage(imgPath));		
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.centerStar = centerStar;
		
				
		// Planet x坐标 y坐标     x坐标相加  y坐标不变
		this.PIC_POSITION_X = centerStar.PIC_POSITION_X + this.longAxis;
		this.PIC_POSITION_Y = centerStar.PIC_POSITION_Y;
	}

	// 构造函数2
	public Planet(Image img, double x, double y) {
		// 调用父类构造函数
		super(img, x, y);		
	}
	
	// 构造函数3
	public Planet(String imgPath, double x, double y) {
		// 调用父类构造函数
		super(imgPath, x, y);		
	}
	
	
	// 父类函数重写
	public void draw(Graphics g) {
		//g.drawImage(img, (int)POSITION_X, (int)POSITION_Y, null);
		super.draw(g);
		
		if(!satellite) {
			drawTrace(g);
		}
		
		move();
	}
	
	
	// 移动函数
	public void move() {
		
		// 沿着椭圆轨迹飞行
		this.PIC_POSITION_X = (centerStar.PIC_POSITION_X + centerStar.pic_width / 2) + longAxis * Math.cos(degree);
		this.PIC_POSITION_Y = (centerStar.PIC_POSITION_Y + centerStar.pic_height / 2) + shortAxis * Math.sin(degree);
		
		degree += speed;
	}
	
	// 画运动轨迹 椭圆
	public void drawTrace(Graphics g) {
		double oval_x, oval_y, oval_width, oval_height;
		
		// 矩形内切椭圆
		oval_x = (centerStar.PIC_POSITION_X + centerStar.pic_width / 2) - longAxis;
		oval_y = (centerStar.PIC_POSITION_Y + centerStar.pic_height / 2) - shortAxis;
		
		oval_width = longAxis * 2;
		oval_height = shortAxis * 2;
		
		Color c = g.getColor();
		g.setColor(Color.blue);
		
		// 画运动轨迹
		g.drawOval((int)oval_x, (int)oval_y, (int)oval_width, (int)oval_height);
		g.setColor(c);		
	}
	
}
