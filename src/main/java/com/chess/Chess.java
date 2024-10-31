package com.chess;

import java.awt.Graphics2D;
import java.awt.Color;

public class Chess {
    public static final int totalCol = 8;
    public static final int totalRow = 8;

    GamePanel gp;

    public Chess(GamePanel gp){
        this.gp = gp;

    }
    public void game(){
        
    }
    public void draw(Graphics2D g2) {
        boolean turnTales = true;
        for (int y = 0; y < Chess.totalCol; y++) {
            for (int x = 0; x < Chess.totalRow; x++) {
                g2.setColor(turnTales ? Color.BLACK : Color.WHITE);
                g2.fillRect(x * gp.tileSize, y * gp.tileSize, gp.tileSize,
                gp.tileSize);
                turnTales = !turnTales;
            }
            turnTales = !turnTales;
        }
        
    }
}
