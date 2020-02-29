package com.lc.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	
	// 初始化子弹速度-配置文件
	final int SPEED = Integer.parseInt(PropertyMgr.get("BulletSpeed"));
	
//	private static final int SPEED = 13;
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();

	Rectangle rect = new Rectangle();
	
	// 存活
	private boolean liveing = true;
	private Group group = Group.BAD;

	private int x, y;
	private Dir dir;
	private TankFrame tf = null;

	// 子弹显示效果
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
		// 判断是否存活
		if (!liveing) {
			// 移除子弹-防止内存泄漏
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
		}
		
		if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
			liveing = false;
		}
		
		// 更新 rect
		rect.x = this.x;
		rect.y = this.y;
	}

	public Bullet(int x, int y, Dir dir, TankFrame tf, Group group) {
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
		
		tf.bullets.add(this);
	}
	
	public Bullet() {
		super();
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	// 碰撞检测
	public void collideWith(Tank tank) {
		// 判断是否是一队的
		if (this.group == tank.getGroup()) {
			return;
		} else {
			
			//TODO: 用一个rect来记录子弹的位置
			// 获得子弹本身矩形
//			Rectangle rect1 = new Rectangle(x, y, WIDTH, HEIGHT);
//			Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), tank.WIDTH, tank.HEIGHT);
			// 判断是否相交
			if (rect.intersects(tank.rect)) {
				int eX = tank.getX() + Tank.WIDTH - 24 - Explode.WIDTH / 2;
				int eY = tank.getY() + Tank.HEIGHT - 17 - Explode.HEIGHT / 2;
				tank.die();
				this.die();
				tf.explodes.add(new Explode(eX, eY, tf));
			}
		}
	}

	private void die() {
		this.liveing = false;
	}

	public TankFrame getTf() {
		return tf;
	}

	public void setTf(TankFrame tf) {
		this.tf = tf;
	}
	
}
