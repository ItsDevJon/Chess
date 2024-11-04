package com.chess;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	
	static final int originalSize = 16;
	static final int scale = 6;
	
	public static final int tileSize = scale * originalSize;
	public final int maxCol = 8;
	public final int maxRow = 8;
	final int screenWith = tileSize * maxCol;
	final int screenHeight = tileSize * maxRow;

	Thread gameThread;

	public MouseHandler mHandler;
	public Chess chess;

	public GamePanel() {
		mHandler = new MouseHandler();
		this.addMouseListener(mHandler);
		chess = new Chess(this, mHandler);
		this.setPreferredSize(new Dimension(screenWith, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		while (gameThread != null) {
			repaint();
			update();
		}
	}

	private void update() {
		chess.game();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Toolkit.getDefaultToolkit().sync();
		Graphics2D g2 = (Graphics2D) g;
		chess.draw(g2);
		g2.dispose();
	}
}

