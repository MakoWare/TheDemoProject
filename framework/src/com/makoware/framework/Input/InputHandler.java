package com.makoware.framework.Input;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * InputHandler is the mechanism for abstractly handling inputs from various sources.
 * It is the gateway to the game's final inputs.
 *
 * Implement an {@link com.makoware.framework.Input.InputMethod} to decide which keys
 * will control these final inputs.
 *
 * InputHandler is useful for {@link com.makoware.framework.GUI.HUD.Overlay}s where you
 * can give input control to various parts of the game.
 */
public interface InputHandler {

	public void up(int dir);
	
	public void down(int dir);
	
	public void left(int dir);
	
	public void right(int dir);
	
	public void LAxis(int axis, float val);
	
	public void L1(int dir);
	
	public void L2(int dir);
	
	public void L3(int dir);
	
	public void RAxis(int axis, float val);
	
	public void R1(int dir);
	
	public void R2(int dir);
	
	public void R3(int dir);
	
	public void triangle(int dir);
	
	public void circle(int dir);
	
	public void cross(int dir);
	
	public void square(int dir);
	
	public void start(int dir);
	
	public void select(int dir);
	
	public void ps(int dir);
	
	public void drawService(SpriteBatch batch);
	
	public boolean needsToDraw();

}
