package com.makoware.framework.Core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.*;
import com.makoware.framework.GUI.HUD.HUD;
import com.makoware.framework.Input.Handlers.InputHandler;
import com.makoware.framework.Input.Methods.InputMethod;

/**
 * Created by Derek Arner on 2/26/15.
 */
public enum GameManager {
    INSTANCE;
    private Game game;
    private HUD hud;
    private InputMethod input;
    private AssetManager assets;
//    public void setGame(Game game) { this.game = game;}
    public static void setGame(Game game) { INSTANCE.game = game;}
//    public void setScreen(Screen screen) { this.game.setScreen(screen);}
    public static void setScreen(Screen screen) { INSTANCE.game.setScreen(screen);}
//    public void setHud(HUD hud) { this.hud = hud;}
    public static void setHud(HUD hud) { INSTANCE.hud = hud;}
//    public HUD getHud() {return this.hud;}
    public static HUD getHud() {return INSTANCE.hud;}
//    public InputMethod getInput() { return input;}
    public static InputMethod getInput() { return INSTANCE.input;}
//    public void setInput(InputMethod input) {
//        this.input = input;
//        Gdx.input.setInputProcessor(this.input);
//    }
    public static void setInput(InputMethod input) {
        INSTANCE.input = input;
        Gdx.input.setInputProcessor(INSTANCE.input);
    }

    public static void setAssetManager(AssetManager am) {
        INSTANCE.assets = am;
    }

    public static AssetManager getAssetManager() {
        return INSTANCE.assets;
    }

    public static void pushInputHandler(InputHandler handler){
        INSTANCE.input.pushHandler(handler);
    }

    public static void popInputHandler(){
        INSTANCE.input.popHandler();
    }
}
