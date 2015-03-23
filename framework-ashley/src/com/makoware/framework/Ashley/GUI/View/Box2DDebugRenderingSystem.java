package com.makoware.framework.Ashley.GUI.View;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Derek Arner on 3/2/15.
 */
public class Box2DDebugRenderingSystem extends EntitySystem {

    private OrthographicCamera camera;

    private World world;
    private Box2DDebugRenderer debugRenderer;

    public Box2DDebugRenderingSystem(World world, OrthographicCamera camera) {
        this.priority = 45;
        this.world = world;
        this.camera = camera;
        this.debugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        this.debugRenderer.render(this.world, this.camera.combined);


    }

    public void toggleDebug(){
        this.setProcessing(!this.checkProcessing());
    }
}
