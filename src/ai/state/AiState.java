package ai.state;

import ai.AiTransition;
import entity.Npc;
import game.state.State;

public abstract class AiState {

    private AiTransition transition;

    public AiState() {
        this.transition = initializeTransition();
    }

    protected abstract AiTransition initializeTransition();
    public abstract void update(State state, Npc currentCharacter);

    public boolean shouldTransition(State state, Npc currentCharacter) {
        return transition.shouldTransition(state, currentCharacter);
    }

    public String getNextState() {
        return transition.getNextState();
    }
}
