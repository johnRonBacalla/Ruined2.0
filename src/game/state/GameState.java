package game.state;

import controller.NpcController;
import controller.PlayerController;
import core.Position;
import core.Size;
import entity.Npc;
import entity.Player;
import Input.Input;
import game.Game;
import map.GameMap;

import java.util.List;

public class GameState extends State{

    public GameState(Size windowSize, Input input) {
        super(windowSize, input);
        gameMap = new GameMap(new Size(20, 20), spriteLib);
        initializeCharacters();
    }

    private void initializeCharacters() {
        Player player = new Player(new PlayerController(input), spriteLib);
        gameObjects.add(player);
        camera.focusOn(player);

        initializeNpcs(500);
    }

    private void initializeNpcs(int noOfNpcs) {

        for(int i = 0; i < noOfNpcs; i++){
            Npc npc = new Npc(new NpcController(), spriteLib);
            npc.setPosition(gameMap.getRandomPosition());
            gameObjects.add(npc);
        }
    }
}
