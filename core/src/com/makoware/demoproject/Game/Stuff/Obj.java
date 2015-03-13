package com.makoware.demoproject.Game.Stuff;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Created by Derek Arner on 3/2/15.
 */
public class Obj extends Entity {

    public Obj() {
        // create the sprite
//        ViewComponent vc = new ViewComponent()
    }

    private void createBody(){
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.StaticBody;
//        def.position.set(sprite.getX(), sprite.getY());
        def.fixedRotation = true;

        // create the body and add it to the entity
        PhysicsComponent pc = null;
//        pc = new PhysicsComponent(world.createBody(def));
        this.add(pc);

        PolygonShape shape = new PolygonShape();
//        shape.setAsBox(sprite.getWidth()/2f,sprite.getHeight()/2f);
        shape.setAsBox(1.7f,0.35f);
//		shape.set(new float[]{0f,0.05f,0.025f,0.025f,0.225f,0.025f,0.3f,0.05f,0.3f,0.7f,0.25f,0.75f,0.05f,0.75f,0f,0.7f});

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        fdef.friction = 0.0f;
        fdef.restitution = 0.0f;
        fdef.density = 1f;
//        fdef.filter.categoryBits = this.category;
//        fdef.filter.maskBits = this.mask;

        pc.body.createFixture(fdef);
        pc.body.setLinearDamping(0f);
        pc.body.setUserData(this);
        shape.dispose();
    }
}
