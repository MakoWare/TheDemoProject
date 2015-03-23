package com.makoware.framework.Input.Controllers;

import com.badlogic.gdx.controllers.Controller;
import com.makoware.framework.Input.Utils.Inputs;

/**
 * Created by Derek Arner on 3/6/15.
 */
public class ControllerMapper {

    public static Inputs getCode(Controller controller, int code){
        return Inputs.CIRCLE;
    }
}
