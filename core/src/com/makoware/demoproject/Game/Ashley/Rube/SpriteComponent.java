package com.makoware.demoproject.Game.Ashley.Rube;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Derek Arner on 3/12/15.
 */
public class SpriteComponent extends Component {
    public Sprite sprite;

    public SpriteComponent(Sprite sprite) {
        this.sprite = sprite;
    }

    public SpriteComponent(Texture texture){
        this.sprite = new Sprite(texture);
    }
}
