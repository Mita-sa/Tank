package com.lc.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Tank {

	// 坦克坐标
	private int x, y;
	// 坦克方向
	private Dir dir = Dir.RIGHT;
	// 坦克速度
	private static final int SPEED = 5;

	public static int WIDTH = ResourceMgr.goodtankD.getWidth();
	public static int HEIGHT = ResourceMgr.goodtankD.getHeight();

	private Random random = new Random();
	private Group group = Group.BAD;

	// 是否移动
	private boolean moving = true;

	private TankFrame tf;

	private boolean living = true;

	public void paint(Graphics g) {
		// 判断是否存活
		if (!living) {
			// 移除坦克-防止内存泄漏
			tf.tanks.remove(this);
		}
		// 坦克显示效果
		switch (dir) {
		case LEFT:
			g.drawImage(group == Group.GOOD ? ResourceMgr.goodtankL : ResourceMgr.badtankL, x, y, null);
			break;
		case UP:
			g.drawImage(group == Group.GOOD ? ResourceMgr.goodtankU : ResourceMgr.badtankU, x, y, null);
			break;
		case RIGHT:
			g.drawImage(group == Group.GOOD ? ResourceMgr.goodtankR : ResourceMgr.badtankR, x, y, null);
			break;
		case DOWN:
			g.drawImage(group == Group.GOOD ? ResourceMgr.goodtankD : ResourceMgr.badtankD, x, y, null);
			break;
		default:
			break;
		}
		// g.drawImage(ResourceMgr.tankL, x, y, null);

		move();
	}

	// 上下左右操作
	private void move() {
		// 默认停止
		if (!moving) {
			return;
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
		if (group == Group.BAD && random.nextInt(100) > 95) {
			this.fire();
		}
		if (group == Group.BAD && random.nextInt(100) > 95) {
			randomDir();
		}
	}
	
	private void randomDir() {
		this.dir = Dir.values()[random.nextInt(4)];
	}

	public void fire() {
		int bX = this.x + Tank.WIDTH - 24 - Bullet.WIDTH;
		int bY = this.y + Tank.HEIGHT - 17 - Bullet.HEIGHT;

		tf.bullets.add(new Bullet(bX, bY, dir, tf, group));
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
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

	public Tank(int x, int y, Dir dir, TankFrame tf, Group group) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
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

	public void die() {
		this.living = false;
	}
}
