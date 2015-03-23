package com.makoware.framework.GUI.HUD;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.makoware.framework.Core.GameManager;
import com.makoware.framework.Core.Messenger;
import com.makoware.framework.GUI.Camera.MWCamera;
import com.makoware.framework.Input.Handlers.InputHandler;

import java.util.ArrayList;
import java.util.HashMap;

public class HUD {
	private String tag = "HUD";

	private HashMap<String,Overlay> overlays;
	
	private ArrayList<String> renderList;

	public static OrthographicCamera hudCam;
	public static MWCamera camera;
	
	public static int x; 
	public static int y;
	public static int width;
	public static int height;
	
	private int pauseCount = 0;

	private int iter;
	
	public HUD(){
		this.overlays = new HashMap<String,Overlay>();
		this.renderList = new ArrayList<String>();

//        this.am = new AssetManager();

//		border = new NinePatch(AssetManager.get("border"), 5,5,5,5);
		
//		arrow = AssetManager.get("arrow");
//		arrow.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
//		fontTex = AssetManager.get("silkscreen_25");
//		fontTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
//		font = new BitmapFont(Gdx.files.internal("data/font/silkscreen_25.fnt"), new TextureRegion(fontTex), false);
//		this.font.setScale(0.1f);
//		font.setScale(0.1f, 0.1f);
//		font.setColor(Color.WHITE);
        this.resize();
	}
	
	public HUD(MWCamera cam){
		this();
		camera = cam;
	}
	
	public void draw(SpriteBatch batch, float deltaTime){
		
//		Iterator<String> itr = renderList.iterator();
//		while(itr.hasNext()){
//			String key = itr.next();
//			Overlay o = overlays.get(key);
//			if(o.isVisible()){
//				o.draw(batch);
//			} else {
////				o.onHide();
//				hide(key);
//				itr.remove();
//			}
//		}
		iter = 0;
		while(iter< renderList.size()){
			String key = renderList.get(iter);
			if(key==null)
				continue;
			
			Overlay o = overlays.get(key);
			if(o.isVisible()){
				o.draw(batch, deltaTime);
			} else {
//				o.onHide();
				hide(key);
//				renderList.remove(iter);
			}
			
			iter++;
		}
	}
	
	public void addOverlay(String key, Overlay o){
		overlays.put(key, o);
	}
	
	public void show(String key){
		show(key, null);
	}
	
	public void show(String key, OverlayParam p){
		Overlay o = overlays.get(key);
		if(!o.isVisible())
			renderList.add(key);
		if(o.shouldPause()){
//			Gdx.app.log(tag, "should pause");
            if(pauseCount==0) {
                Messenger.postMessage(Messenger.PAUSE_KEY, null);
            }
			pauseCount++;
		}

		o.setVisible(true);
		if(o.requestsInput() && o instanceof InputHandler){
			GameManager.getInput().pushHandler((InputHandler)o);
		}

		o.onShow(p);
	}
	
	public void hide(String key){
//		renderList.remove(key);
		Overlay o = overlays.get(key);
		if(o.shouldPause()){
//			Gdx.app.log(tag, "should unpause");
			pauseCount--;
            if(pauseCount==0) {
                Messenger.postMessage(Messenger.UNPAUSE_KEY, null);
            }
		}

		o.setVisible(false);
		if(o.requestsInput() && o instanceof InputHandler){
			GameManager.getInput().popHandler();
		}

		o.onHide();
		renderList.remove(key);
	}

	public static void begin(SpriteBatch batch) {
		batch.setProjectionMatrix(HUD.hudCam.combined);
		batch.begin();
	}

	public static void end(SpriteBatch batch) {
		batch.end();
		batch.setProjectionMatrix(HUD.camera.combined);
	}

	public void resize() {
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		x = 0;
		y = 0;
		if(hudCam==null)
			hudCam = new OrthographicCamera();
		hudCam.setToOrtho(false, width-x, height-y);
//		hudMatrix.setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	public static int width(){
		return Gdx.graphics.getWidth();
	}
	
	public static int height(){
		return Gdx.graphics.getHeight();
	}

    public ArrayList<String> getRenderList() {
        return renderList;
    }
}

