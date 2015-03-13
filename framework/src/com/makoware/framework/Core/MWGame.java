package com.makoware.framework.Core;

import com.badlogic.gdx.Game;
import com.makoware.framework.GUI.HUD.HUD;

/**
 * Created by Derek Arner on 3/6/15.
 */
public class MWGame extends Game {

    @Override
    public void create() {
        GameManager.INSTANCE.setGame(this);
        GameManager.INSTANCE.setHud(new HUD());
    }
}
