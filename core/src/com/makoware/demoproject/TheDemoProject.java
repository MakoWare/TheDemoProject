package com.makoware.demoproject;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.makoware.demoproject.Game.Ashley.Rube.AshleyRubeScene;
import com.makoware.demoproject.Game.Ashley.Rube.AshleyRubeSceneLoader;
import com.makoware.demoproject.Game.Screens.LoadingScreen;
import com.makoware.framework.Core.GameManager;
import com.makoware.framework.Core.MWGame;
import com.makoware.framework.Input.DefaultInputMethodAdapter;

public class TheDemoProject extends MWGame {
	
	@Override
	public void create () {
        super.create();

        // TODO: logic for determining input method based on app type.


        AssetManager assetManager = new AssetManager();
        assetManager.setLoader(AshleyRubeScene.class, new AshleyRubeSceneLoader(new InternalFileHandleResolver()));

        // debug logs
//        assetManager.getLogger().setLevel(Application.LOG_DEBUG);
//        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        // set up the GameManager
        GameManager.setInput(new DefaultInputMethodAdapter());
        GameManager.setAssetManager(assetManager);


        String filePath = "data/palm.json";
        this.setScreen(new LoadingScreen(filePath));
    }
}
