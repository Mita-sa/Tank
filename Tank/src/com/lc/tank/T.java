package com.lc.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {

	public static void main(String[] args) {
		Frame f = new Frame();
		// 可见
		f.setVisible(true);
		// 大小
		f.setSize(800,600);
		//  标题
		f.setTitle("TankWar");
		// 縮放
		f.setResizable(false);
		
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				// 退出
				System.exit(0);
			}
		});
		
	}
	
}
