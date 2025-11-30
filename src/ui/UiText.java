package ui;

import core.Size;
import game.state.State;
import gfx.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UiText extends UiComponent{

    private String text;
    private int fontSize;
    private int fontStyle;
    private String fontFamily;
    private Color color;

    private boolean dropShadow;
    private int dropShadowOffset;
    private Color shadowColor;

    private Font font;

    public UiText(String text) {
        this.text = text;
        this.fontSize = 24;
        this.fontStyle = Font.BOLD;
        this.fontFamily = "Joystix Monospace";
        this.color = Color.white;

        this.dropShadow = true;
        this.dropShadowOffset = 2;
        this.shadowColor = Color.DARK_GRAY;
    }

    @Override
    public Image getSprite() {
        BufferedImage image = (BufferedImage) ImageUtils.createCompatibleImage(size, ImageUtils.ALPHA_BIT_MASKED);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(font);

        if(dropShadow) {
            graphics.setColor(shadowColor);
            graphics.drawString(text, padding.getLeft() + dropShadowOffset, fontSize + padding.getTop() + dropShadowOffset);
        }

        graphics.setColor(color);
        graphics.drawString(text,  padding.getLeft(),  fontSize + padding.getTop());

        graphics.dispose();
        return image;
    }

    @Override
    public void update(State state) {
        createFont();
        calculateSize();
    }

    private void calculateSize() {
        FontMetrics fontMetrics = new Canvas().getFontMetrics(font);
        size = new Size(
                fontMetrics.stringWidth(text)  + padding.getHorizotal(),
                fontMetrics.getHeight() + padding.getVertical()
        );
    }

    public void createFont() {
        font = new Font(fontFamily, fontStyle, fontSize);
    }
}
