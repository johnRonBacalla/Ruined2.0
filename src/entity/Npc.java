package entity;

import ai.AiManager;
import controller.Controller;
import game.state.State;
import gfx.AnimationManager;
import gfx.SpriteLib;

public class Npc extends MovingEntity {

    private AiManager manager;

    public Npc(Controller controller, SpriteLib spriteLib) {
        super(controller, spriteLib);
        animationManager = new AnimationManager(spriteLib.getUnit("ember"));
        manager = new AiManager();
    }

    @Override
    public void update(State state) {
        super.update(state);
        manager.update(state, this);
    }
}
