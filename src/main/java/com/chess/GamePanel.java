package com.chess;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	
	static final int ORIGINAL_SIZE = 16;
	static final int SCALE = 6;
	
	public static final int TILE_SIZE = SCALE * ORIGINAL_SIZE;
	public final int MAX_COL = 8;
	public final int MAX_ROW = 8;
	private final int SCREEN_WITH = TILE_SIZE * MAX_COL;
	private final int SCREEN_HEIGHT = TILE_SIZE * MAX_ROW;

	Thread gameThread;
	private boolean gamaHasFinish;

	public MouseHandler mHandler;
	public Chess chess;

	public GamePanel() {
		gamaHasFinish = false;
		mHandler = new MouseHandler();
		this.addMouseListener(mHandler);
		chess = new Chess(this, mHandler);
		this.setPreferredSize(new Dimension(SCREEN_WITH, SCREEN_HEIGHT));
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
		while (gameThread != null && !gamaHasFinish) {
			repaint();
			gamaHasFinish = update();
		}
		gameThread.interrupt();
		
	}

	private boolean update() {
		return chess.game();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Toolkit.getDefaultToolkit().sync();
		Graphics2D g2 = (Graphics2D) g;
		chess.draw(g2);
		g2.dispose();
	}
}

