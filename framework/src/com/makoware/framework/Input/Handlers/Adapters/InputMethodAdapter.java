package com.makoware.framework.Input.Handlers.Adapters;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;
import com.makoware.framework.Input.Handlers.InputHandler;
import com.makoware.framework.Input.Methods.InputMethod;

import java.util.Stack;

/**
 * Convenience class. Extend to not have to implement every method and not have to manage the
 * handler stack.
 *
 * Created by Derek Arner on 3/6/15.
 */
public class InputMethodAdapter implements InputMethod {

    protected Stack<InputHandler> handlerStack;
//    protected InputHandler inputHandler;
    protected Controller controller;

    public InputMethodAdapter() {
        this.handlerStack = new Stack<InputHandler>();
    }

//    @Override @Deprecated
//    public void setHandler(InputHandler handler) {
//
//    }

    @Override
    public InputHandler getHandler() {
        return this.handlerStack.peek();
    }

    @Override
    public void pushHandler(InputHandler handler) {
        this.handlerStack.push(handler);
    }

    @Override
    public void popHandler() {
        this.handlerStack.pop();
    }

    @Override
    public void cycle() {
    }

    @Override
    public void connected(Controller controller) {
    }

    @Override
    public void disconnected(Controller controller) {
    }

    @Override
    public boolean buttonDown(Controller controller, int buttonCode) {
        return false;
    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode) {
        return false;
    }

    @Override
    public boolean axisMoved(Controller controller, int axisCode, float value) {
        return false;
    }

    @Override
    public boolean povMoved(Controller controller, int povCode, PovDirection value) {
        return false;
    }

    @Override
    public boolean xSliderMoved(Controller controller, int sliderCode, boolean value) {
        return false;
    }

    @Override
    public boolean ySliderMoved(Controller controller, int sliderCode, boolean value) {
        return false;
    }

    @Override
    public boolean accelerometerMoved(Controller controller, int accelerometerCode, Vector3 value) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
