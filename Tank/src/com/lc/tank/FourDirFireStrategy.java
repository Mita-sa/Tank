package com.lc.tank;

public class FourDirFireStrategy implements FireStrategy {

	@Override
	public void fire(Tank t) {
		int bX = t.getX() + Tank.WIDTH - 24 - Bullet.WIDTH;
		int bY = t.getY() + Tank.HEIGHT - 17 - Bullet.HEIGHT;

		Dir[] dirs = Dir.values();
		for (Dir dir : dirs) {
			new Bullet(bX, bY, dir, t.getTf(), t.getGroup());
		}
	}
	
}
