package com.makoware.framework.Input.Utils;

/**
 * Controller input button representations in the style of Playstation controllers as not to confuse
 * buttons A,B,X,Y with placement on the controller. (ie. SNES layout for ABXY is different from
 * XBox layout)
 *
 * Created by Derek Arner on 3/6/15.
 */
public enum Inputs {
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

    public enum KeyDirection {
        DOWN(0.0f),
        UP(1.0f),
        VALUE(0.0f);

        private float value;

        private KeyDirection(float value){
            this.value = value;
        }

        public KeyDirection setValue(float value){
            this.value = value;
            return this;
        }

        public float getValue(){
            return this.value;
        }

    }
}
