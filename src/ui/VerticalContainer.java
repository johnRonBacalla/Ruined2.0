package ui;

import core.Position;
import core.Size;

public class VerticalContainer extends UiContainer {

    @Override
    protected Size calculateContentSize() {
        int combinedChildHeight = 0;
        int widestChildWidth = 0;

        for(UiComponent uiComponent : children){
            combinedChildHeight += uiComponent.getSize().getHeight() + uiComponent.getMargin().getVertical()    ;

            if(uiComponent.getSize().getWidth() > widestChildWidth) {
                widestChildWidth = uiComponent.getSize().getWidth();
            }
        }
        return new Size(widestChildWidth, combinedChildHeight);
    }

    @Override
    protected void calculateContentPosition() {
        int currentY = padding.getTop();

        for(UiComponent uiComponent : children) {
            currentY += uiComponent.getMargin().getTop();
            uiComponent.setPosition(new Position(padding.getLeft(), currentY));
            currentY += uiComponent.getSize().getHeight();
            currentY += uiComponent.getMargin().getBottom();
        }
    }
}
