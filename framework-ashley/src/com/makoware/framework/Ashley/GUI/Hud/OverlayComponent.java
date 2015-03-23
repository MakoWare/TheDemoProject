package com.makoware.framework.Ashley.GUI.Hud;

import com.badlogic.ashley.core.Component;
import com.makoware.framework.GUI.HUD.Overlay;

/**
 * Created by Derek Arner on 3/16/15.
 */
public class OverlayComponent extends Component {
    public Overlay overlay;
    public String keyName;

    public OverlayComponent(String keyName, Overlay overlay) {
        this.overlay = overlay;
        this.keyName = keyName;
    }
}
