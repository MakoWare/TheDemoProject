package com.makoware.demoproject.Game.Ashley.Rube;

import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.RubeSceneAbstractLoader;

/**
 * Created by Derek Arner on 3/12/15.
 */
public class AshleyRubeSceneLoader extends RubeSceneAbstractLoader<AshleyRubeScene> {


    public AshleyRubeSceneLoader(FileHandleResolver resolver) {
        super(AshleyRubeScene.class, resolver);
    }
}
