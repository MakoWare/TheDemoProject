package com.makoware.framework.Input.Handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.makoware.framework.Input.Utils.Inputs;

/**
 * InputHandler is the mechanism for abstractly handling inputs from various sources.
 * It is the gateway to the game's final inputs.
 *
 * Implement an {@link com.makoware.framework.Input.Methods.InputMethod} to decide which keys
 * will control these final inputs.
 *
 * InputHandler is useful for {@link com.makoware.framework.GUI.HUD.Overlay}s where you
 * can give input control to various parts of the game.
 */
public interface InputHandler {

	public void up(Inputs.KeyDirection dir);
	
	public void down(Inputs.KeyDirection dir);
	
	public void left(Inputs.KeyDirection dir);
	
	public void right(Inputs.KeyDirection dir);
	
	public void LAxis(Inputs axis, float val);
	
	public void L1(Inputs.KeyDirection dir);
	
	public void L2(Inputs.KeyDirection dir);
	
	public void L3(Inputs.KeyDirection dir);
	
	public void RAxis(Inputs axis, float val);
	
	public void R1(Inputs.KeyDirection dir);
	
	public void R2(Inputs.KeyDirection dir);
	
	public void R3(Inputs.KeyDirection dir);
	
	public void triangle(Inputs.KeyDirection dir);
	
	public void circle(Inputs.KeyDirection dir);
	
	public void cross(Inputs.KeyDirection dir);
	
	public void square(Inputs.KeyDirection dir);
	
	public void start(Inputs.KeyDirection dir);
	
	public void select(Inputs.KeyDirection dir);
	
	public void menu(Inputs.KeyDirection dir);
	
	public void drawService(SpriteBatch batch);
	
	public boolean needsToDraw();

}
