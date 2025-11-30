package entity;

import controller.Controller;
import gfx.SpriteLib;

public class Spook extends MovingEntity {

    public Spook(Controller controller, SpriteLib spriteLib) {
        super(controller, spriteLib);
    }

    @Override
    protected void handleCollision(GameObject other) {

    }
}
