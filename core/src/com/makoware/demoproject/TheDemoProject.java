package com.makoware.demoproject;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.makoware.demoproject.Game.Ashley.Rube.AshleyRubeScene;
import com.makoware.demoproject.Game.Ashley.Rube.AshleyRubeSceneLoader;
import com.makoware.demoproject.Game.Screens.LoadingScreen;
import com.makoware.framework.Assets.Loaders.NinePatchLoader;
import com.makoware.framework.Core.GameManager;
import com.makoware.framework.Core.MWGame;
import com.makoware.framework.Input.Methods.Adapters.DefaultInputMethodAdapter;

public class TheDemoProject extends MWGame {
	
	@Override
	public void create () {
        super.create();

        // TODO: logic for determining input method based on app type.


        AssetManager assetManager = new AssetManager();
        assetManager.setLoader(AshleyRubeScene.class, new AshleyRubeSceneLoader(new InternalFileHandleResolver()));
        assetManager.setLoader(NinePatch.class, new NinePatchLoader(new InternalFileHandleResolver()));

        // debug logs
//        assetManager.getLogger().setLevel(Application.LOG_DEBUG);
//        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        DefaultInputMethodAdapter.KeyMapperConfig k = new DefaultInputMethodAdapter.KeyMapperConfig();
        k.MENU = Input.Keys.ESCAPE;

        // set up the GameManager
        GameManager.setInput(new DefaultInputMethodAdapter(k));
        GameManager.setAssetManager(assetManager);


        // load some assets
//        assetManager.load("data/images/border.png", NinePatch.class, new NinePatchLoader.NinePatchParameter(new Rectangle(5f,5f,5f,5f)));




        String filePath = "data/palm.json";
        this.setScreen(new LoadingScreen(filePath));
    }
}
