package com.lc.tank;

import java.awt.Graphics;

public class Tank {

	private int x, y;
	private Dir dir = Dir.RIGHT;
	private static final int SPEED = 10;

	// 上下左右操作
	public void paint(Graphics g) {
		g.fillRect(x, y, 50, 50);
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
	}
	
	public Tank() {
		super();
	}

	public Tank(int x, int y, Dir dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public static int getSpeed() {
		return SPEED;
	}
}
