package com.makoware.framework.GUI.HUD;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.makoware.framework.Core.GameManager;
import com.makoware.framework.Input.InputHandler;

public abstract class Overlay {
	
	
	
	protected boolean requestInput = false;
//	protected InputHandler oldInput;
//	protected InputMethod input = (InputMethod) Gdx.input.getInputProcessor();
	
	protected OverlayParam params;
	
	protected boolean visible = false;
	
	protected Rectangle bounds = new Rectangle();

	public abstract void draw(SpriteBatch batch);
	
	public abstract boolean shouldPause();
	
	public Overlay(boolean requestInput){
		this.requestInput = requestInput;
	}
	
	public void onShow(OverlayParam p){
		this.visible = true;
		if(requestInput && this instanceof InputHandler){
            GameManager.INSTANCE.getInput().pushHandler((InputHandler)this);
		}
		this.params = p;
	}	

	public void onHide(){
		this.visible = false;
		if(requestInput && this instanceof InputHandler){
            GameManager.INSTANCE.getInput().popHandler();
		}
	}
	
	public void hide(){
		this.visible = false;
	}
	
	
	public boolean isVisible() {
		return visible;
	}
	
}
