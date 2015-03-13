package com.makoware.demoproject.Game.Ashley.Rube;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Derek Arner on 3/12/15.
 */
public class SpriteRenderingSystem extends IteratingSystem {

    private ComponentMapper<SpriteComponent> sm = ComponentMapper.getFor(SpriteComponent.class);

    private SpriteBatch batch;
    private Camera cam;


    public SpriteRenderingSystem(Camera cam, SpriteBatch batch) {
        super(Family.all(SpriteComponent.class).get());
        this.batch = batch;
        this.cam = cam;
    }

    public void processEntity(Entity entity, float deltaTime) {
        SpriteComponent spriteComponent = sm.get(entity);

        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        spriteComponent.sprite.draw(batch);
        batch.end();
    }
}
