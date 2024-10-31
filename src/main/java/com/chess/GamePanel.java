package com.chess;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	
	final int originalSize = 16;
	final int scale = 6;
	
	public final int tileSize = scale * originalSize;
	public final int maxCol = 8;
	public final int maxRow = 8;
	final int screenWith = tileSize * maxCol;
	final int screenHeight = tileSize * maxRow;

	Thread gameThread;

	public Chess chess;

	public GamePanel() {
		chess = new Chess(this);
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

