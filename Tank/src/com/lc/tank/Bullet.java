package com.lc.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private static final int SPEED = 10;
	private static final int WIDTH = 10, HEIGHT = 10;
	// 存活
	private boolean live = true;

	private int x, y;
	private Dir dir;
	private TankFrame tf = null;

	// 子弹形状
	public void paint(Graphics g) {
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletL, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletU, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.bulletR, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletD, x, y, null);
			break;
		default:
			break;
		}
		move();
	}

	// 子弹移动轨迹
	private void move() {
		if (!live) {
			tf.bullets.remove(this);
		}
		switch (dir) {
		case LEFT:
			x -= SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;

		default:
			break;
		}
		if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
			live = false;
		}
	}

	public Bullet(int x, int y, Dir dir, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	public Bullet() {
		super();
	}
}
