package ai.state;

import ai.AiTransition;
import controller.NpcController;
import core.Position;
import entity.Npc;
import game.state.State;

import java.util.ArrayList;
import java.util.List;

public class Wander extends AiState{

    private List<Position> targets;

    public Wander() {
        super();
        targets = new ArrayList<>();
    }

    @Override
    protected AiTransition initializeTransition() {
        return new AiTransition("stand", ((state, currentCharacter) -> arrived(currentCharacter)));
    }

    @Override
    public void update(State state, Npc currentCharacter) {
        if(targets.isEmpty()) {
            targets.add(state.getRandomPosition());
        }

        NpcController controller = (NpcController) currentCharacter.getController();
        controller.moveToTarget(targets.getFirst(), currentCharacter.getPosition());

        if(arrived(currentCharacter)) {
            controller.stop();
        }
    }

    private boolean arrived(Npc currentCharacter) {
        return currentCharacter.getPosition().isRangeOf(targets.getFirst());
    }
}
