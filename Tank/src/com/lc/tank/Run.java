package com.lc.tank;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = new TankFrame();

		// 初始化坦克数量-配置文件
		int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
		
		// 初始化地方坦克*5
		for (int i = 0; i < initTankCount; i++) {
			tf.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, tf, Group.BAD));
		}

			while (true) {
				Thread.sleep(50);
				tf.repaint();
			}
	}
}
