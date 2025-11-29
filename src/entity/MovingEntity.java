package entity;

import controller.Controller;
import core.Direction;
import core.Motion;
import entity.effect.Effect;
import game.state.State;
import gfx.AnimationManager;
import gfx.SpriteLib;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class MovingEntity extends GameObject{


    protected Controller controller;
    protected Motion motion;
    protected AnimationManager animationManager;
    protected Direction direction;
    protected List<Effect> effects;

    public MovingEntity(Controller controller, SpriteLib spriteLib) {
        super();
        this.controller = controller;
        this.motion = new Motion(3);
        this.direction = Direction.RIGHT;
        this.animationManager = new AnimationManager(spriteLib.getUnit("wizard"));
        effects = new ArrayList<>();
    }

    @Override
    public void update(State state) {
        motion.update(controller);
        animationManager.update(direction);
        effects.forEach(effect -> effect.update(state, this));

        manageDirection();
        changeAnimation();

        position.apply(motion);

        cleanUp();
    }

    private void cleanUp() {
        List.copyOf(effects).stream().filter(Effect::shouldDelete).forEach(effects::remove);
    }

    private void changeAnimation() {
        if(motion.isMoving()) {
            animationManager.playAnimation("walk");
        } else {
            animationManager.playAnimation("stand");
        }
    }

    private void manageDirection() {
        if(motion.isMoving()) {
            this.direction = Direction.fromMotion(motion);
        }
    }

    @Override
    public Image getSprite() {
        return animationManager.getSprite();
    }

    public Controller getController() {
        return controller;
    }

    public void multiplySpeed(double multiplier) {
         motion.multiply(multiplier);
    }
}
