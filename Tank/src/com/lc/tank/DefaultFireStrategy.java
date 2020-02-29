package com.lc.tank;

public class DefaultFireStrategy implements FireStrategy {

	@Override
	public void fire(Tank t) {
		int bX = t.getX() + Tank.WIDTH - 24 - Bullet.WIDTH;
		int bY = t.getY() + Tank.HEIGHT - 17 - Bullet.HEIGHT;

		new Bullet(bX, bY, t.getDir(), t.getTf(), t.getGroup());
	}

	
}
