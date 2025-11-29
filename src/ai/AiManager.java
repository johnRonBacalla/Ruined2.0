package ai;

import ai.state.AiState;
import ai.state.Stand;
import ai.state.Wander;
import entity.Npc;
import game.state.State;

public class AiManager {

    private AiState currentAIState;

    public AiManager() {
        transitionTo("stand");
    }

    public void update(State state, Npc currentCharacter) {
        currentAIState.update(state,  currentCharacter);

        if(currentAIState.shouldTransition(state, currentCharacter)) {
            transitionTo(currentAIState .getNextState());
        }
    }

    private void transitionTo(String nextState) {
        switch(nextState){
            case "wander":
                currentAIState = new Wander();
                return;
            case "stand":
            default:
                currentAIState = new Stand();
        }
    }
}
