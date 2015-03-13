package com.makoware.demoproject.Game.Ashley.Rube;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by Derek Arner on 3/12/15.
 */
public class Box2DSpriteComponent extends SpriteComponent {
    public Body body;

    public Box2DSpriteComponent(Sprite sprite, Body body) {
        super(sprite);
        this.body = body;
    }
}
