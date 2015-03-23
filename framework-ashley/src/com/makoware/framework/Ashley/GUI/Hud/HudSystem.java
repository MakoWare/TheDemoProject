package com.makoware.framework.Ashley.GUI.Hud;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.makoware.framework.GUI.Camera.MWCamera;
import com.makoware.framework.GUI.HUD.HUD;
import com.makoware.framework.GUI.HUD.Overlay;
import com.makoware.framework.GUI.HUD.OverlayParam;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Derek Arner on 3/13/15.
 */
public class HudSystem extends IteratingSystem {
    private String tag = "HudSystem";

    private ArrayList<Entity> engineQueue;

    private ArrayList<String> renderList;
    private Array<Entity> renderQueue;

    private Engine engine;
    private ComponentMapper<OverlayComponent> ocm = ComponentMapper.getFor(OverlayComponent.class);

    private MWCamera camera;
    private SpriteBatch batch;
    private HUD hud;

    private Comparator<Entity> comparator;


    public HudSystem(MWCamera camera, SpriteBatch batch) {
        super(Family.all(OverlayComponent.class).get());

        this.camera = camera;
        this.batch = batch;
        this.priority = 50;

        this.engineQueue = new ArrayList<Entity>();

        this.hud = new HUD(camera);
        this.renderList = this.hud.getRenderList();
        this.renderQueue = new Array<Entity>();

        this.comparator = new Comparator<Entity>() {
            @Override
            public int compare(Entity entityA, Entity entityB) {
                int aIndex = HudSystem.this.renderList.indexOf(ocm.get(entityA).keyName);
                int bIndex = HudSystem.this.renderList.indexOf(ocm.get(entityB).keyName);
                return (int)Math.signum(bIndex - aIndex);
            }
        };
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
        this.engine = engine;
        if(!this.engineQueue.isEmpty()){
            for(Entity e : this.engineQueue){
                this.engine.addEntity(e);
            }
            this.engineQueue.clear();
        }
    }

    @Override
    public void removedFromEngine(Engine engine) {
        super.removedFromEngine(engine);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        this.renderQueue.sort(this.comparator);

        // begin the hud camera matrix
        HUD.begin(this.batch);
        for(Entity entity : this.renderQueue){
            Overlay overlay = this.ocm.get(entity).overlay;

            overlay.draw(this.batch, deltaTime);
        }
        HUD.end(this.batch);



        this.renderQueue.clear();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        OverlayComponent oc = this.ocm.get(entity);
        Overlay o = oc.overlay;

        boolean inRenderList = this.renderList.contains(oc.keyName);

        // check current visibility
        if(o.isVisible()){
            if(inRenderList){
                // add it to the queue to be drawn
                this.renderQueue.add(entity);
            } else {
                // not sure if this condition is possible
                throw new GdxRuntimeException("Overlay: '"+oc.keyName+"' is visible but not in renderList?");
            }
        } else {
            if(inRenderList){ // occurs when the overlay manually sets itself to visible=false
                // needs to be hidden;
                this.hide(oc.keyName); // will remove from render list
            }
        }

    }

    @Override
    public boolean checkProcessing() {
        return true; // always be processing
    }

    ///////////////////////////////////
    // hud methods
    ///////////////////////////////////


    public void addOverlay(String key, Overlay overlay){
        this.hud.addOverlay(key, overlay);

        Entity ent = new Entity();
        ent.add(new OverlayComponent(key, overlay));

        if(this.engine!=null){
            this.engine.addEntity(ent);
        } else {
            this.engineQueue.add(ent);
        }
    }

    public void show(String key){
        this.hud.show(key);
    }

    public void show(String key, OverlayParam param){
        this.hud.show(key,param);
    }

    public void hide(String key){
        this.hud.hide(key);
    }

    public void resize(int width, int height){
        this.hud.resize();
    }


}
