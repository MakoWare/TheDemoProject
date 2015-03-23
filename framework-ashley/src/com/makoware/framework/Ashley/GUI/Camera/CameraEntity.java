package com.makoware.framework.Ashley.GUI.Camera;

import com.badlogic.ashley.core.Entity;

/**
 * Created by Derek Arner on 3/2/15.
 */
public class CameraEntity extends Entity{

    public CameraEntity() {
        this.add(new CameraComponent());
    }
}
