package com.makoware.demoproject.Game.Screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.RubeSceneLoadedCallback;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.makoware.demoproject.Game.Ashley.Rube.AshleyRubeScene;
import com.makoware.demoproject.Game.Ashley.Rube.SpriteRenderingSystem;
import com.makoware.framework.Core.GameManager;
import com.makoware.framework.GUI.Camera.MWCamera;

/**
 * Created by Derek Arner on 3/2/15.
 */
public class LevelScreen extends ScreenAdapter {
    public static String tag = "LevelScreen";

    private World world;
    private Box2DDebugRenderer rend;
    private MWCamera cam;
    private Engine engine;

    private AssetManager assetManager;
    private String levelFilePath;

    private AshleyRubeScene scene;

    private SpriteRenderingSystem renderingSystem;

    SpriteBatch batch;
    Texture img;

    public LevelScreen(String filePath) {
        super();
        this.levelFilePath = filePath;
        this.rend = new Box2DDebugRenderer();
        this.cam = new MWCamera(100f);

        this.assetManager = GameManager.getAssetManager();
        this.assetManager.load(this.levelFilePath, AshleyRubeScene.class, new RubeSceneLoadedCallback());

        batch = new SpriteBatch();
//        img = new Texture("badlogic.jpg");

        this.renderingSystem = new SpriteRenderingSystem(cam, batch);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        batch.setProjectionMatrix(this.cam.combined);
//        batch.begin();
//        batch.draw(img,120f,60f,20f,20f);
//        batch.end();

//        Gdx.app.log("levelScreen","render");

        // while loading, present loading overlay


        this.world.step(delta,6,2);
        this.engine.update(delta);

//        this.rend.render(this.world,this.cam.combined);
        this.cam.onUpdate();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        Gdx.app.log("levelScreen","resize");
        cam.resize(width,height);

//		fontMatrix.setToOrtho2D(0, 0, width, height);
//        this.cam.setMarioStyle(true);
//        cam.calculateParallaxMatrix(0.2f, 0.2f);

        cam.onUpdate();
    }

    @Override
    public void show() {
        super.show();
        Gdx.app.log("levelScreen","show");

        this.scene = this.assetManager.get(this.levelFilePath, AshleyRubeScene.class);
        this.world = this.scene.getWorld();
        this.engine = this.scene.getEngine();

//        this.img = this.assetManager.get("data/images/toyzrockinghorse.png",Texture.class);

        this.engine.addSystem(this.renderingSystem);
    }

    @Override
    public void hide() {
        super.hide();
        this.dispose();
        Gdx.app.log("levelScreen","hide");
    }

    @Override
    public void pause() {
        super.pause();
        Gdx.app.log("levelScreen","pause");
    }

    @Override
    public void resume() {
        super.resume();
        Gdx.app.log("levelScreen","resume");
    }

    @Override
    public void dispose() {
        super.dispose();
        Gdx.app.log("levelScreen","dispose");
        this.assetManager.unload(this.levelFilePath);
    }
}
