package com.chess;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

    private boolean fromToTurnstale = true;
    int xFrom;
    int yFrom;
    int xTo;
    int yTo;
    boolean clicked = false;
    boolean selected = false;

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
        // TODO Auto-generated method stub
        return;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        return;    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        return;    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        return;    }
    
}
