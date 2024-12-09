package com.chess.view.components;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GameButton extends JButton {

    private static final int ICON_TEXT_GAP = 26;

    private final ButtonVariant buttonVariant;

    public GameButton(String text, Icon icon, ButtonVariant variant) {
        super(text, icon);

        this.buttonVariant = variant;

        initUI();

    }

    public GameButton(String text, ButtonVariant variant) {
        this(text, null, variant);
    }

    public GameButton(Icon icon, ButtonVariant variant) {
        this("", icon, variant);
    }

    private void initUI() {
        buttonVariant.applyStyle(this);

        if(getIcon() != null){
            setIconTextGap(ICON_TEXT_GAP);
            setHorizontalTextPosition(SwingConstants.RIGHT); // Position text to the right of the icon
        }

    }

    public int getBorderRadius() {
        return buttonVariant.getBorderRadius();
    }

    // Custom button painting
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        FontMetrics fm = g2.getFontMetrics();

        // Button properties
        String buttonText = getText();
        int buttonWidth = getWidth();
        int buttonHeight = getHeight();
        int buttonTextIconGap = getIconTextGap();

        // Draw background
        g2.setColor(getBackground());
        g2.fillRect(0, 0, buttonWidth, buttonHeight);

        // Draw icon
        if(getIcon() != null) {

            ImageIcon icon = (ImageIcon) getIcon();

            // Calculate icon position
            int iconWidth = icon.getIconWidth();
            int iconHeight = icon.getIconHeight();
            int iconX = (buttonWidth - iconWidth) / 2;
            int iconY = (buttonHeight - iconHeight) / 2;

            icon.paintIcon(this, g2, iconX, iconY); // Draw icon


            // Calculate text position
            int totalWidth = iconWidth + buttonTextIconGap + fm.stringWidth(buttonText);
            int startX = (buttonWidth - totalWidth) / 2;
            int textX = startX + iconWidth + buttonTextIconGap;
            int textY = ((buttonHeight - fm.getHeight()) / 2) + fm.getAscent();

            // Draw text
            g2.setColor(getForeground());
            g2.drawString(buttonText, textX, textY);

        }
        else {
            // If no icon, just center the text
            int textX = (buttonWidth - fm.stringWidth(buttonText)) / 2;
            int textY = ((buttonHeight - fm.getHeight()) / 2) + fm.getAscent();

            g2.drawString(buttonText, textX, textY);

        }

    }

    @Override
    public String toString() {

        return getSize().width + " row " + getSize().height;

    }

}