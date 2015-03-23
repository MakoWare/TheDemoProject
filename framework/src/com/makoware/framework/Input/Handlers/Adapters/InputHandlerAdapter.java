package com.makoware.framework.Input.Handlers.Adapters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.makoware.framework.Input.Handlers.InputHandler;
import com.makoware.framework.Input.Utils.Inputs;

import java.util.HashMap;

/**
 * Created by Derek Arner on 3/17/15.
 */
public class InputHandlerAdapter implements InputHandler {

    private boolean needsToDraw;
    private DrawCallback drawCallback;
    private HashMap<Inputs, InputCallback> callbacks;

    public InputHandlerAdapter(){
        this.callbacks = new HashMap<Inputs, InputCallback>();
        this.needsToDraw = false;
    }

    public InputHandlerAdapter(boolean needsToDraw){
        this.needsToDraw = needsToDraw;
    }

    public void addCallback(Inputs key, InputCallback callback){
        this.callbacks.put(key, callback);
    }

    public void setDrawCallback(DrawCallback drawCallback) {
        this.drawCallback = drawCallback;
    }

    @Override
    public void up(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.D_UP);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void down(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.D_DOWN);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void left(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.D_LEFT);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void right(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.D_RIGHT);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void LAxis(Inputs axis, float val) {
        InputCallback callback = this.callbacks.get(axis);
        if(callback!=null){
            callback.action(Inputs.KeyDirection.VALUE.setValue(val));
        }
    }

    @Override
    public void L1(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.LEFT_1);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void L2(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.LEFT_2);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void L3(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.LEFT_3);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void RAxis(Inputs axis, float val) {
        InputCallback callback = this.callbacks.get(axis);
        if(callback!=null){
            callback.action(Inputs.KeyDirection.VALUE.setValue(val));
        }
    }

    @Override
    public void R1(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.RIGHT_1);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void R2(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.RIGHT_2);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void R3(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.RIGHT_3);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void triangle(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.TRIANGLE);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void circle(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.CIRCLE);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void cross(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.CROSS);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void square(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.SQUARE);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void start(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.START);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void select(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.SELECT);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void menu(Inputs.KeyDirection dir) {
        InputCallback callback = this.callbacks.get(Inputs.MENU);
        if(callback!=null){
            callback.action(dir);
        }
    }

    @Override
    public void drawService(SpriteBatch batch) {
        if(this.drawCallback!=null){
            this.drawCallback.draw(batch);
        }
    }

    @Override
    public boolean needsToDraw() {
        return (needsToDraw && (this.drawCallback!=null));
    }

    public void setNeedsToDraw(boolean needsToDraw) {
        this.needsToDraw = needsToDraw;
    }

    public interface InputCallback {
        public void action(Inputs.KeyDirection direction);
    }

    public interface DrawCallback {
        public void draw(SpriteBatch batch);
    }

//    public interface TouchCallback {
//        public void touch
//    }
}
