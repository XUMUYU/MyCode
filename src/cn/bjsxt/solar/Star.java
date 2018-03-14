package cn.bjsxt.solar;

import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.MyGameUtil;

public class Star {
	
	// 图片资源
	public Image img;
	
	// 图片资源坐标
	public double PIC_POSITION_X;
	public double PIC_POSITION_Y;
	
	// 图片的长和宽
	public int pic_width;
	public int pic_height;
	
	// 构造函数0   减少不必要的代码
	public Star(Image img) {
		this.img = img;
		
		// 获取图片高度与宽度
		this.pic_width = img.getWidth(null);
		this.pic_height = img.getHeight(null);		
	}
	
	
	// 构造函数1
	public Star(Image img, double x, double y) {
		
		this(img);
		 
		this.PIC_POSITION_X = x;
		this.PIC_POSITION_Y = y;
		
		
	}
	
//	// 构造函数2
//	public Star(String imgPath, double x, double y) {
//		this.img = MyGameUtil.getImage(imgPath);
//		this.POSITION_X = x;
//		this.POSITION_Y = y;
//		
//		// 获取图片高度与宽度
//		this.width = img.getWidth(null);
//		this.height = img.getHeight(null);
//		
//		
//	}
	
	// 重构构造函数2 避免了复制粘贴
	public Star(String imgPath, double x, double y) {
		this(MyGameUtil.getImage(imgPath), x, y);	// 通过this函数调用另一个构造方法
	}
	
	// 构造函数3
	public Star() {
		System.out.println("Func -> constructor:无参数构造函数");
	}
	
	// 画图函数
	public void draw(Graphics g) {
		g.drawImage(img, (int)PIC_POSITION_X, (int)PIC_POSITION_Y, null);
	}	
}
