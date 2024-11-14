package com.chess;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

    private boolean fromToTurnstale = true;
    public int xFrom;
    public int yFrom;
    public int xTo;
    public int yTo;
    public boolean clicked = false;
    public boolean selected = false;

    @Override
    public void mouseClicked(MouseEvent e) {
        if (fromToTurnstale) {
            xFrom = e.getX();
            yFrom = e.getY();
            selected = true;
        } else {
            selected = false;
            xTo = e.getX();
            yTo = e.getY();
            clicked = true;
        }
        fromToTurnstale = !fromToTurnstale;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
