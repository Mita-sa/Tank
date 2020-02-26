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
	public static BufferedImage goodtankL, goodtankU, goodtankR, goodtankD;
	public static BufferedImage badtankL, badtankU, badtankR, badtankD;
	// 子弹图片
	public static BufferedImage bulletL, bulletU, bulletR, bulletD;
	// 爆炸图片
	public static BufferedImage[] explodes = new BufferedImage[16];
	
	static {
		try {
			goodtankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/tankL.gif"));
			goodtankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/tankU.gif"));
			goodtankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/tankR.gif"));
			goodtankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/tankD.gif"));
			
			badtankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/tank_2_l.gif"));
			badtankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/tank_2_u.gif"));
			badtankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/tank_2_r.gif"));
			badtankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/lc/images/tank_2_d.gif"));
			

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
