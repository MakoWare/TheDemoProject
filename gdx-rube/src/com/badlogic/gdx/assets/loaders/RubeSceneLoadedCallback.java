package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.rube.RubeScene;

/**
 * Created by Derek Arner on 3/12/15.
 */
public class RubeSceneLoadedCallback extends RubeSceneAbstractLoader.RubeSceneParameter {

    public RubeSceneLoadedCallback() {
        this(new AssetLoaderParameters.LoadedCallback() {
            @Override
            public void finishedLoading(AssetManager assetManager, String fileName, Class type) {
                Gdx.app.log("RubeSceneLoadedCallback", "finishedLoadingAsset: "+fileName);
                RubeScene scene = (RubeScene)assetManager.get(fileName, type);
                scene.onLoadComplete();
            }
        });
    }

    public RubeSceneLoadedCallback(LoadedCallback callback){
        this(true, callback);
    }

    public RubeSceneLoadedCallback(boolean loadImages, LoadedCallback callback){
        this(loadImages);
        this.loadedCallback = callback;
    }

    public RubeSceneLoadedCallback(boolean loadImages) {
        super(loadImages);
    }
}
