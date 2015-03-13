package com.makoware.framework.GUI.View;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.makoware.framework.GUI.Camera.MWCamera;

/**
 * Created by Derek Arner on 3/2/15.
 */
public class ViewSystem extends EntitySystem {

    private MWCamera camera;

    private World world;
    private Box2DDebugRenderer debugRenderer;

    public ViewSystem() {
        this.camera = new MWCamera();
        this.world = new World(new Vector2(0f,-1f),true);
        this.debugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        this.debugRenderer.render(this.world, this.camera.combined);


    }
}
