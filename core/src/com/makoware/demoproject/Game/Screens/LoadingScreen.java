package com.makoware.demoproject.Game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.makoware.framework.Core.GameManager;

/**
 * Created by Derek Arner on 3/10/15.
 */
public class LoadingScreen extends ScreenAdapter {
    public static String tag = "LoadingScreen";

    private String filePath;
    private AssetManager am;

    private float timeToWait = 0.5f;
    private float totalWaitTime = 0.0f;

    private LevelScreen level;

    public LoadingScreen(String filePath) {
        super();
        this.filePath = filePath;
        this.am = GameManager.getAssetManager();

        this.level = new LevelScreen(this.filePath);


    }

    public LoadingScreen(String filePath, float timeToWait){
        this(filePath);
        this.timeToWait = timeToWait;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0f, 0f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        totalWaitTime += delta;

        if(!this.am.update() || totalWaitTime<=timeToWait){
            // TODO: present loading view
            Gdx.app.log(tag, "loading... "+totalWaitTime);
            return;
        } else {
            // get the loaded screen
            Gdx.app.log(tag, "COMPLETE!");
            GameManager.setScreen(level);
        }
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
