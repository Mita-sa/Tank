package com.lc.tank;

public class T {

	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = new TankFrame();

		// 初始化地方坦克*5
		for (int i = 0; i < 5; i++) {
			tf.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, tf, Group.BAD));
		}

			while (true) {
				Thread.sleep(50);
				tf.repaint();
			}
	}
}
