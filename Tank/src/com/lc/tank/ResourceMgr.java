package com.lc.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * load图片
 * @author LiuChuang
 *
 */
public class ResourceMgr {
	public static BufferedImage tankL, tankU, tankR, tankD;
	public static BufferedImage bulletL, bulletU, bulletR, bulletD;
	static {
		try {
			tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/tankL.gif"));
			tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/tankU.gif"));
			tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/tankR.gif"));
			tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/tankD.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/bulletL.gif"));
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/bulletU.gif"));
			bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/bulletR.gif"));
			bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/bulletD.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
