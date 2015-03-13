package com.makoware.framework.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Derek Arner on 3/6/15.
 */
public class DefaultInputMethodAdapter extends InputMethodAdapter {

    public DefaultInputMethodAdapter() {
        super();
        for( Controller c : Controllers.getControllers()){
            Gdx.app.log("InputMethodAdapter","Controller: " + c.getName() + " of class: " + c.getClass().toString());
        }
        if(Controllers.getControllers().size == 1){
            this.controller = Controllers.getControllers().first();
            this.controller.addListener(this);
        }
    }

    @Override
    public void cycle() {
    }

    @Override
    public void connected(Controller controller) {
        Gdx.app.log("InputMethodAdapter","*CONNECTED* Controller: " + controller.getName() + " of class: " + controller.getClass().toString());
        this.controller = controller;
        this.controller.addListener(this);
    }

    @Override
    public void disconnected(Controller controller) {
        Gdx.app.log("InputMethodAdapter","*DISCONNECTED* Controller: " + controller.getName());
        this.controller.removeListener(this);
        this.controller = null;
    }

    @Override
    public boolean buttonDown(Controller controller, int buttonCode) {
        Gdx.app.log("InputMethodAdapter","Controller: " + controller.getName() + " Button: " + buttonCode);
        return false;
    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode) {
        return false;
    }

    @Override
    public boolean axisMoved(Controller controller, int axisCode, float value) {
        if(value>0.9f || value<-0.9f)
            Gdx.app.log("InputMethodAdapter","Controller: " + controller.getName() + " AXIS: " + axisCode + " value: " + value);
        return false;
    }

    @Override
    public boolean povMoved(Controller controller, int povCode, PovDirection value) {
        Gdx.app.log("InputMethodAdapter","Controller: " + controller.getName() + " POV: " + povCode + " value: " + value);
        return false;
    }

    @Override
    public boolean xSliderMoved(Controller controller, int sliderCode, boolean value) {
        Gdx.app.log("InputMethodAdapter","Controller: " + controller.getName() + " xSlider: " + sliderCode + " value: " + value);
        return false;
    }

    @Override
    public boolean ySliderMoved(Controller controller, int sliderCode, boolean value) {
        Gdx.app.log("InputMethodAdapter","Controller: " + controller.getName() + " ySlider: " + sliderCode + " value: " + value);
        return false;
    }

    @Override
    public boolean accelerometerMoved(Controller controller, int accelerometerCode, Vector3 value) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch(keycode){
            case Input.Keys.W:
                this.getHandler().up(1);
                break;
        }
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
