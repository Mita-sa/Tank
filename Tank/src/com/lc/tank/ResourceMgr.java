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
	// 坦克图片
	public static BufferedImage tankL, tankU, tankR, tankD;
	// 子弹图片
	public static BufferedImage bulletL, bulletU, bulletR, bulletD;
	// 爆炸图片
	public static BufferedImage[] explodes = new BufferedImage[16];
	
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
		
			for (int i = 0; i < 8; i++) {
				explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/blast_"+(i+1)+".gif"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
