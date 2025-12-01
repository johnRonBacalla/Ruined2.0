package game.state;

import controller.NpcController;
import controller.PlayerController;
import core.Size;
import entity.Npc;
import entity.Player;
import Input.Input;
import entity.effect.Dying;
import map.GameMap;
import ui.*;

import java.awt.*;

public class GameState extends State{

    public GameState(Size windowSize, Input input) {
        super(windowSize, input);
        gameMap = new GameMap(new Size(20, 20), spriteLib);
        initializeCharacters();
        initializeUi();
    }

    private void initializeUi() {
        UiContainer container = new VerticalContainer();
        container.setPadding(new Spacing(20));
        container.setBackgroundColor(Color.GRAY);
        container.addUiComponent(new HorizontalContainer());
        container.addUiComponent(new HorizontalContainer());
        container.addUiComponent(new HorizontalContainer());
        uiContainers.add(container);
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
            npc.addEffect(new Dying());
            gameObjects.add(npc);
        }
    }
}
