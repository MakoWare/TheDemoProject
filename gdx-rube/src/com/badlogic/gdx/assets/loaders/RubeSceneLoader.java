package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.rube.RubeScene;

/**
 * Created by Derek Arner on 3/12/15.
 */
public class RubeSceneLoader extends RubeSceneAbstractLoader<RubeScene> {
    public RubeSceneLoader(FileHandleResolver resolver) {
        super(RubeScene.class, resolver);
    }
}
