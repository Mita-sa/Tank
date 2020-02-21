package com.lc.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

	Tank t = new Tank(350, 250, Dir.RIGHT, this);
	Bullet b = new Bullet(300, 300, Dir.DOWN);
	static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

	public TankFrame() {
		// 可见
		setVisible(true);
		// 大小
		setSize(GAME_WIDTH, GAME_HEIGHT);
		// 标题
		setTitle("TankWar");
		// 縮放
		setResizable(false);
		addKeyListener(new MyKeyListener());
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				// 退出
				System.exit(0);
			}
		});
	}
	
	// 双缓冲解决：
	Image offScreenImage = null;
	@Override
	public void update(Graphics g){
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	// 窗口被重新绘制的时候被调用
	@Override
	public void paint(Graphics g) {
		t.paint(g);
		b.paint(g);
	}

	// 键盘处理类
	class MyKeyListener extends KeyAdapter {

		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;

		// 键盘按下
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				// System.out.println("VK_LEFT");
				break;
			case KeyEvent.VK_UP:
				bU = true;
				// System.out.println("VK_UP");
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				// System.out.println("VK_RIGHT");
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				// System.out.println("VK_DOWN");
				break;
			// 开火
			case KeyEvent.VK_CONTROL:
				t.fire();
				break;
			default:
				break;
			}
			setMainTankDir();
		}

		// 键盘弹起
		@Override
		public void keyReleased(KeyEvent e) {
			super.keyReleased(e);
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;
			default:
				break;
			}
			setMainTankDir();
		}

		private void setMainTankDir() {
			// 不属于任意一个方向就停止
			if (!bL && !bU && !bR && !bD) {
				t.setMoving(false);
			} else {
				// 否则开始移动
				t.setMoving(true);
				if (bL)
					t.setDir(Dir.LEFT);
				if (bU)
					t.setDir(Dir.UP);
				if (bR)
					t.setDir(Dir.RIGHT);
				if (bD)
					t.setDir(Dir.DOWN);
			}
		}

	}

}
