package com.makoware.demoproject.Game.Stuff;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by Derek Arner on 3/2/15.
 */
public class PhysicsComponent extends Component {
    public Body body;

    public PhysicsComponent(Body body) {
        this.body = body;
    }
}
