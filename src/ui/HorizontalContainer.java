package ui;

import core.Position;
import core.Size;

public class HorizontalContainer extends UiContainer {

    @Override
    protected Size calculateContentSize() {
        int combinedChildWidth = 0;
        int tallestChildHeight = 0;

        for(UiComponent uiComponent : children){
            combinedChildWidth += uiComponent.getSize().getWidth() + uiComponent.getMargin().getHorizotal();

            if(uiComponent.getSize().getHeight() > tallestChildHeight) {
                tallestChildHeight = uiComponent.getSize().getHeight();
            }
        }
        return new Size(combinedChildWidth, tallestChildHeight);
    }

    @Override
    protected void calculateContentPosition() {
        int currentX = padding.getLeft();

        for(UiComponent uiComponent : children) {
            currentX += uiComponent.getMargin().getLeft();
            uiComponent.setPosition(new Position(currentX, padding.getTop()));
            currentX += uiComponent.getSize().getWidth();
            currentX += uiComponent.getMargin().getRight();
        }
    }
}
