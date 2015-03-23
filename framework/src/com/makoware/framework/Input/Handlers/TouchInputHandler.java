package com.makoware.framework.Input.Handlers;

public interface TouchInputHandler extends InputHandler {

	public void touchDown(int screenX, int screenY, int pointer, int button);

	public void touchUp(int screenX, int screenY, int pointer, int button);

	public void touchDragged(int screenX, int screenY, int pointer);
}
