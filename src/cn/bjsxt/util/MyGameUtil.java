package cn.bjsxt.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 游戏开发中的工具类 比如图片加载
 * @author lenovo
 *
 */
public class MyGameUtil {
	
	private MyGameUtil(){}	// 构造函数私有 类不需要创建实例。
	
	// 加载图片
	public static Image getImage(String path) {
//		URL u = MyGameUtil.class.getClassLoader().getResource(path);
//		BufferedImage image = null;
//		
//		try {
//			image = ImageIO.read(u);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// 返回参数
//		return image;
		
		// 加载图片
		return Toolkit.getDefaultToolkit().getImage(MyGameUtil.class.getClassLoader().getResource(path));
	}
}
