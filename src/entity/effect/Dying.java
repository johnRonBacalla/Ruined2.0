package entity.effect;

import entity.GameObject;
import entity.MovingEntity;
import entity.action.Death;
import game.GameLoop;
import game.state.State;

public class Dying extends Effect{

    private static final double cycleRate = 1d/ GameLoop.UPDATES_PER_SECOND / 10;

    public Dying() {
        super(Integer.MAX_VALUE);
    }

    @Override
    public void update(State state, MovingEntity entity) {
        super.update(state, entity);

        if(Math.random() < cycleRate) {
            entity.perform(new Death());
        }
    }
}
