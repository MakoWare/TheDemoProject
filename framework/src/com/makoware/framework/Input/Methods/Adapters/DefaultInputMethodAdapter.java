package com.makoware.framework.Input.Methods.Adapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;
import com.makoware.framework.Input.Handlers.Adapters.InputMethodAdapter;
import com.makoware.framework.Input.Handlers.InputHandler;
import com.makoware.framework.Input.Utils.Inputs;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by Derek Arner on 3/6/15.
 */
public class DefaultInputMethodAdapter extends InputMethodAdapter {
    public static final String tag = "DefaultInputMethodAdapter";

    private KeyMapper keyMapper;

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

    public DefaultInputMethodAdapter(KeyMapperConfig config){
        this.keyMapper = new KeyMapper(config);
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
        if(value>0.1f || value<-0.1f)
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
        this.keyPressed(Inputs.KeyDirection.DOWN, keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        this.keyPressed(Inputs.KeyDirection.UP, keycode);
        return false;
    }

    public boolean keyPressed(Inputs.KeyDirection keyDirection, int keycode){
        Method m = keyMapper.forKey(keycode);
        try {
            if(m!=null){
                m.invoke(this.getHandler(),keyDirection);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
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


    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////

    private Object invokeMethod (Object object, String methodName) throws Exception {
        for (Method m : object.getClass().getMethods())
            if (m.getName().equals(methodName)) return m.invoke(object);
        throw new RuntimeException("Could not find method '" + methodName + "' on class: " + object.getClass());
    }

    public static class KeyMapperConfig {
        public Integer
        TRIANGLE,
        CIRCLE,
        SQUARE,
        CROSS,
        D_LEFT,
        D_UP,
        D_RIGHT,
        D_DOWN,
        LEFT_AXIS,
        LEFT_X_AXIS,
        LEFT_Y_AXIS,
        LEFT_1,
        LEFT_2,
        LEFT_3,
        RIGHT_AXIS,
        RIGHT_X_AXIS,
        RIGHT_Y_AXIS,
        RIGHT_1,
        RIGHT_2,
        RIGHT_3,
        START,
        SELECT,
        MENU;
    }

    public static class KeyMapper {
        public HashMap<Integer, Method> map;
        public KeyMapper(KeyMapperConfig config){
            this.map = new HashMap<Integer, Method>();
            Class cls = InputHandler.class;
            try{
                if(config.TRIANGLE!=null){
                    this.map.put(config.TRIANGLE, cls.getMethod("triangle", Inputs.KeyDirection.class));
                }
                if(config.CIRCLE!=null){
                    this.map.put(config.CIRCLE, cls.getMethod("circle", Inputs.KeyDirection.class));
                }
                if(config.SQUARE!=null){
                    this.map.put(config.SQUARE, cls.getMethod("square", Inputs.KeyDirection.class));
                }
                if(config.CROSS!=null){
                    this.map.put(config.CROSS, cls.getMethod("cross", Inputs.KeyDirection.class));
                }
                if(config.D_LEFT!=null){
                    this.map.put(config.D_LEFT, cls.getMethod("left", Inputs.KeyDirection.class));
                }
                if(config.D_UP!=null){
                    this.map.put(config.D_UP, cls.getMethod("up", Inputs.KeyDirection.class));
                }
                if(config.D_RIGHT!=null){
                    this.map.put(config.D_RIGHT, cls.getMethod("right", Inputs.KeyDirection.class));
                }
                if(config.D_DOWN!=null){
                    this.map.put(config.D_DOWN, cls.getMethod("down", Inputs.KeyDirection.class));
                }
                // TODO left axis handling
                if(config.LEFT_1!=null){
                    this.map.put(config.LEFT_1, cls.getMethod("L1", Inputs.KeyDirection.class));
                }
                if(config.LEFT_2!=null){
                    this.map.put(config.LEFT_2, cls.getMethod("L2", Inputs.KeyDirection.class));
                }
                if(config.LEFT_3!=null){
                    this.map.put(config.LEFT_3, cls.getMethod("L3", Inputs.KeyDirection.class));
                }
                // TODO right axis handling
                if(config.RIGHT_1!=null){
                    this.map.put(config.RIGHT_1, cls.getMethod("R1", Inputs.KeyDirection.class));
                }
                if(config.RIGHT_2!=null){
                    this.map.put(config.RIGHT_2, cls.getMethod("R2", Inputs.KeyDirection.class));
                }
                if(config.RIGHT_3!=null){
                    this.map.put(config.RIGHT_3, cls.getMethod("R3", Inputs.KeyDirection.class));
                }
                if(config.START!=null){
                    this.map.put(config.START, cls.getMethod("start", Inputs.KeyDirection.class));
                }
                if(config.SELECT!=null){
                    this.map.put(config.SELECT, cls.getMethod("select", Inputs.KeyDirection.class));
                }
                if(config.MENU!=null){
                    this.map.put(config.MENU, cls.getMethod("menu", Inputs.KeyDirection.class));
                }


            } catch (NoSuchMethodException e){
                Gdx.app.log("DefaultInputMethodAdapter", "exception: "+e);
            }

        }

        public Method forKey(Integer key){
            return this.map.get(key);
        }
    }

}
