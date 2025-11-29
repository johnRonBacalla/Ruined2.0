package ai;

import entity.Npc;
import game.state.State;

public interface AiCondition {
    boolean isMet(State state, Npc currentCharacter);
}
