package com.makoware.demoproject.Game.Ashley.Rube;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.rube.RubeImage;
import com.badlogic.gdx.rube.RubeScene;
import com.badlogic.gdx.rube.graphics.g2d.RubeSprite;
import com.makoware.framework.Core.GameManager;

/**
 * Created by Derek Arner on 3/12/15.
 */
public class AshleyRubeScene extends RubeScene {
    public static String tag = "AshleyRubeScene";

    public static String filePath = "data/";

    protected Engine engine;

    public AshleyRubeScene() {
        super();

        this.engine = new Engine();
    }

    public Engine getEngine(){
        return this.engine;
    }

    @Override
    public void onLoadComplete() {
        super.onLoadComplete();
        Gdx.app.log(tag, "onLoadComplete");

        for(RubeImage image : this.images){
            if(this.usesAtlas()){
                Gdx.app.log(tag, "UsesAtlas");
            } else {
//                Gdx.app.log(tag, "image " + image.file);

                AssetManager am = GameManager.getAssetManager();

                Entity ent = new Entity();

                Sprite sprite = new RubeSprite(am.get(filePath + image.file, Texture.class),image);
                ent.add(new SpriteComponent(sprite));

                if(image.body != null){
                    ent.add(new BodyComponent(image.body));
                }

                engine.addEntity(ent);
            }
        }


    }
}
