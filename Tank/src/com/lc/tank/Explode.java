package com.lc.tank;

import java.awt.Graphics;

public class Explode {
	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
	// 存活
	private boolean liveing = true;

	private int x, y;
	private TankFrame tf = null;
	private int step = 0;

	public void paint(Graphics g) {
		
		g.drawImage(ResourceMgr.explodes[step++], x, y, null);
		// 如果超出了图片总数量，那就停止
		if (step >= ResourceMgr.explodes.length) {
			step = 0;
		}
	}

	public Explode(int x, int y, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.tf = tf;
	}

	public Explode() {
		super();
	}
	
}
