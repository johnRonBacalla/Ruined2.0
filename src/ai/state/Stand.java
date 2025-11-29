package ai.state;

import ai.AiTransition;
import entity.Npc;
import game.state.State;

public class Stand extends AiState
{
    private int updatesAlive;

    @Override
    protected AiTransition initializeTransition() {
        return new AiTransition("wander", ((state,  currentCharacter) -> updatesAlive >= state.getTime().getUpdatesFromSeconds(3)));
    }

    @Override
    public void update(State state, Npc currentCharacter) {
        updatesAlive++;
    }
}
