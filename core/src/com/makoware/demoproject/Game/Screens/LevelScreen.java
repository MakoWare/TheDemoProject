package com.makoware.demoproject.Game.Screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
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
import com.makoware.demoproject.Game.Ashley.Rube.SpriteComponent;
import com.makoware.demoproject.Game.Ashley.Rube.SpriteRenderingSystem;
import com.makoware.demoproject.Game.Stuff.PauseMenu;
import com.makoware.framework.Ashley.Box2D.Box2DSystem;
import com.makoware.framework.Ashley.GUI.Hud.HudSystem;
import com.makoware.framework.Ashley.GUI.View.Box2DDebugRenderingSystem;
import com.makoware.framework.Core.GameManager;
import com.makoware.framework.Core.Messenger;
import com.makoware.framework.GUI.Camera.MWCamera;
import com.makoware.framework.Input.Handlers.Adapters.InputHandlerAdapter;
import com.makoware.framework.Input.Handlers.Adapters.TouchInputHandlerAdapter;
import com.makoware.framework.Input.Utils.Inputs;

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

    // systems
    private SpriteRenderingSystem renderingSystem;
    private HudSystem hudSystem;
    private Box2DSystem b2dSystem;

    private TouchInputHandlerAdapter input;

    SpriteBatch batch;
    Texture img;

    public LevelScreen(String filePath) {
        this.levelFilePath = filePath;
        this.rend = new Box2DDebugRenderer();
        this.cam = new MWCamera(10f);

        this.assetManager = GameManager.getAssetManager();
        this.assetManager.load(this.levelFilePath, AshleyRubeScene.class, new RubeSceneLoadedCallback());

        this.batch = new SpriteBatch();
//        img = new Texture("badlogic.jpg");

        // init systems
        this.renderingSystem = new SpriteRenderingSystem(cam, batch);
        this.hudSystem = new HudSystem(cam, batch);
        this.hudSystem.addOverlay("pause", new PauseMenu());


        this.input = new TouchInputHandlerAdapter();
        GameManager.pushInputHandler(this.input);

        this.input.addCallback(Inputs.MENU, new InputHandlerAdapter.InputCallback() {
            @Override
            public void action(Inputs.KeyDirection direction) {
                if(direction== Inputs.KeyDirection.DOWN){
                    LevelScreen.this.hudSystem.show("pause");
                }
            }
        });

    }

    @Override
    public void show() {
        super.show();
        Gdx.app.log("levelScreen", "show");

        this.scene = this.assetManager.get(this.levelFilePath, AshleyRubeScene.class);
        this.world = this.scene.getWorld();
        this.engine = this.scene.getEngine();

        this.cam.setWorldUnit(100f);

        this.engine.addSystem((this.b2dSystem=new Box2DSystem(this.world)));
        this.engine.addSystem(this.renderingSystem);
        this.engine.addSystem(this.hudSystem);
        this.engine.addSystem(new Box2DDebugRenderingSystem(this.world,this.cam));

        this.img = this.assetManager.get("data/images/toyzrockinghorse.png",Texture.class);
        Entity ent = new Entity();
        SpriteComponent sc = new SpriteComponent(this.img);
        sc.sprite.setPosition(120, 50);
        sc.sprite.setSize(20, 20);
        ent.add(sc);
        this.engine.addEntity(ent);


    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        this.engine.update(delta);



        this.cam.onUpdate();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        Gdx.app.log("levelScreen","resize");

        this.cam.resize(width,height);
        this.hudSystem.resize(width,height);

        Messenger.postMessage(Messenger.RESIZE_KEY,null);

//        cam.onUpdate();
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
        this.hudSystem.show("pause");
    }

    @Override
    public void resume() {
        super.resume();
        Gdx.app.log("levelScreen","resume");
        this.hudSystem.hide("pause");
    }

    @Override
    public void dispose() {
        super.dispose();
        Gdx.app.log("levelScreen","dispose");
        this.assetManager.unload(this.levelFilePath);
    }
}
