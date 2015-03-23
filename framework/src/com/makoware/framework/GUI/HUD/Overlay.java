package com.makoware.framework.GUI.HUD;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.makoware.framework.Utils.Property;

import java.util.HashMap;

public abstract class Overlay {
	
	private HashMap<String, Property> properties;
	
	protected boolean requestInput = false;
//	protected InputHandler oldInput;
//	protected InputMethod input = (InputMethod) Gdx.input.getInputProcessor();
	
	protected boolean visible = false;
	
	protected Rectangle frame = new Rectangle();

	public Overlay(boolean requestInput){
		this.requestInput = requestInput;
        this.properties = new HashMap<String, Property>();

        Property p = Property.with(requestInput, Boolean.class);
        this.properties.put("requestsInput", p);
	}

    public abstract void onShow(OverlayParam p);

	public void draw(SpriteBatch batch, float deltaTime){
        this.draw(this.frame, batch, deltaTime);
    }

    public abstract void draw(Rectangle frame, SpriteBatch batch, float deltaTime);

	public abstract boolean shouldPause();

	public abstract void onHide();

	public void hide(){
		this.visible = false;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean requestsInput() {
//        Boolean b;

//        b = this.properties.get("requestsInput").value(Boolean.class);

		return this.requestInput;
	}

}
