package entity;

import controller.Controller;
import entity.effect.Sprint;
import gfx.SpriteLib;

public class Player extends MovingEntity {

    public Player(Controller controller, SpriteLib spriteLib) {
        super(controller, spriteLib);
        //effects.add(new Sprint());
    }

    @Override
    protected void handleCollision(GameObject other) {
        if(other instanceof Npc){
            Npc npc = (Npc) other;

            npc.clearEffects();
        }
    }

}
