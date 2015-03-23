package com.makoware.framework.Input.Methods;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.controllers.ControllerListener;
import com.makoware.framework.Input.Handlers.InputHandler;

/**
 * Implement this class to create an input processor based on the platform and use
 * {@code Gdx.input#setProcessor()} to let Gdx know what is processing the inputs.
 *
 * Created by Derek Arner on 3/6/15
 */
public interface InputMethod extends InputProcessor, ControllerListener {

//	public void setHandler(InputHandler handler);
	
	public InputHandler getHandler();

    public void pushHandler(InputHandler handler);

    public void popHandler();

	public void cycle();
	
}
