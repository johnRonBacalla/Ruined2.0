package map;

import gfx.SpriteLib;

import java.awt.*;

public class Tile {

    private Image sprite;

    public Tile(SpriteLib spriteLib) {
        this.sprite = spriteLib.getTile("default");
    }

    public Image getSprite() {
        return sprite;
    }

}
