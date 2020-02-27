package com.lc.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Tank {

	// 初始化坦克速度-配置文件
	final int SPEED = Integer.parseInt(PropertyMgr.get("TankSpeed"));
	
	// 坦克坐标
	private int x, y;
	// 坦克方向
	private Dir dir = Dir.RIGHT;
	// 坦克速度
//	private static final int SPEED = 8;

	public static int WIDTH = ResourceMgr.goodtankD.getWidth();
	public static int HEIGHT = ResourceMgr.goodtankD.getHeight();
	
	Rectangle rect = new Rectangle();

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
		}	
		
		if (group == Group.BAD && random.nextInt(100) > 95) {
			this.fire();
		}
		if (group == Group.BAD && random.nextInt(100) > 95) {
			randomDir();
		}
		
		// 边界检测
		boundsCheck();

		// 更新 rect
		rect.x = this.x;
		rect.y = this.y;
		
	}
	
	private void boundsCheck() {
		if (x < 3) x = 3;
		if (y < 33) y = 33;
		if (x > TankFrame.GAME_WIDTH - Tank.WIDTH - 3) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 3;
		if (y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 3) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 3;
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
		
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
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

	public void die() {
		this.living = false;
	}
}
