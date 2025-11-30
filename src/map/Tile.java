package map;

import gfx.SpriteLib;

import java.awt.*;

public class Tile {

    private Image sprite;

    public Tile(SpriteLib spriteLib) {
        this.sprite = spriteLib.getTile("stoneFloor");
    }

    public Image getSprite() {
        return sprite;
    }

}
