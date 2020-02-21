package com.lc.tank;

import java.awt.Graphics;

public class Tank {

	// 坦克坐标
	private int x, y;
	// 坦克方向
	private Dir dir = Dir.RIGHT;
	// 坦克速度
	private static final int SPEED = 5;
	// 是否移动
	private boolean moving = false;
	
	private TankFrame tf;

	// 上下左右操作
	public void paint(Graphics g) {
		g.fillRect(x, y, 50, 50);
		
		move();
		
	}
	
	private void move(){
		// 默认停止
		if (!moving) {
			return ;
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
	}

	public void fire() {
		tf.b = new Bullet(x, y, dir);
	}
	
	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Tank() {
		super();
	}

	public Tank(int x, int y, Dir dir, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
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
