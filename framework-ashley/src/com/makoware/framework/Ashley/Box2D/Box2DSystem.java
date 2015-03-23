package com.makoware.framework.Ashley.Box2D;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.physics.box2d.World;
import com.makoware.framework.Core.Messenger;
import com.makoware.framework.Utils.Callback;
import com.makoware.framework.Utils.Message;

/**
 * Created by Derek Arner on 3/20/15.
 */
public class Box2DSystem extends EntitySystem implements Callback {

    private World world;
    public static int velocityIterations = 6;
    public static int positionIterations = 2;

    public Box2DSystem(World world){
        super(5); // low priority, not sure if there will be anything lower required so not setting to 1
        this.world = world;
        Messenger.addListener(Messenger.PAUSE_KEY, this);
        Messenger.addListener(Messenger.UNPAUSE_KEY, this);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        this.world.step(deltaTime, velocityIterations, positionIterations);
    }

    public World getWorld(){
        return this.world;
    }

    @Override
    public void call(String keyName, Message m) {
        if(keyName== Messenger.PAUSE_KEY){
            this.setProcessing(false);
        } else if(keyName== Messenger.UNPAUSE_KEY){
            this.setProcessing(true);
        }
    }
}
