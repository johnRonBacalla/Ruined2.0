package ai;

import entity.Npc;
import game.state.State;

public class AiTransition {

    private String nextState;
    private AiCondition condition;

    public AiTransition(String nextState, AiCondition condition) {
        this.nextState = nextState;
        this.condition = condition;
    }

    public boolean shouldTransition(State state, Npc currentCharacter) {
        return condition.isMet(state, currentCharacter);
    }

    public String getNextState() {
        return nextState;
    }
}
