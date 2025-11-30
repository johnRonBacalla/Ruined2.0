package ui;

import core.Position;
import core.Size;
import game.state.State;
import gfx.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class UiContainer extends UiComponent {

    protected Color backgroundColor;

    protected List<UiComponent> children;

    public UiContainer() {
        super();
        backgroundColor = Color.RED;
        margin = new Spacing(5);
        children = new ArrayList<>();
        calculateSize();
        calculatePosition();
    }

    protected abstract Size calculateContentSize();
    protected abstract void calculateContentPosition();

    public void calculateSize() {
        Size calculateContentSize = calculateContentSize();
        size = new Size(
                padding.getHorizotal() + calculateContentSize.getWidth(),
                padding.getVertical() + calculateContentSize.getHeight());
    }

    public void calculatePosition(){
        position = new Position(margin.getLeft(), margin.getRight());
        calculateContentPosition();
    }

    @Override
    public Image getSprite() {
        BufferedImage image = (BufferedImage) ImageUtils.createCompatibleImage(size, ImageUtils.ALPHA_BIT_MASKED);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(backgroundColor);
        graphics.fillRect(0, 0, size.getWidth(), size.getHeight());

        for(UiComponent uiComponent : children) {
            graphics.drawImage(
                    uiComponent.getSprite(),
                    uiComponent.getPosition().intX(),
                    uiComponent.getPosition().intY(),
                    null
            );
        }

        graphics.dispose();
        return image;
    }

    @Override
    public void update(State state) {
        children.forEach(uiComponent -> uiComponent.update(state));
        calculateSize();
        calculatePosition();
    }

    public void addUiComponent(UiComponent uiComponent) {
        children.add(uiComponent);
    }

    public void setBackgroundColor(Color color) {
        backgroundColor = color;
    }
}
