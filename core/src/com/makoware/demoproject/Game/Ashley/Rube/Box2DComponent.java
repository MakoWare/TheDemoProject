package com.makoware.demoproject.Game.Ashley.Rube;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by Derek Arner on 3/12/15.
 */
public class Box2DComponent extends Component {
    public Body body;

    public Box2DComponent(Body body) {
        this.body = body;
    }
}
