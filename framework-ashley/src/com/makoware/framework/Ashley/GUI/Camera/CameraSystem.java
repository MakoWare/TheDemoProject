package com.makoware.framework.Ashley.GUI.Camera;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

/**
 * Created by Derek Arner on 3/2/15.
 */
public class CameraSystem extends IteratingSystem{

//    private ComponentMapper<CameraComponent>

    public CameraSystem() {
        super(Family.all(CameraComponent.class).get());

    }


    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}
