package com.makoware.framework.Ashley.Core;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Derek Arner on 3/13/15.
 */
public class MWEntitySystem extends EntitySystem {

    private Array<MWEntitySubSystem> subSystems;

    public MWEntitySystem() {
        this(0);
    }

    public MWEntitySystem(int priority) {
        super(priority);
        this.subSystems = new Array<MWEntitySubSystem>(true, 16);
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
    }

    @Override
    public void removedFromEngine(Engine engine) {
        super.removedFromEngine(engine);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }

    public void addSystem(MWEntitySubSystem subSystem){
        this.subSystems.add(subSystem);
    }

    public void removeSystem(MWEntitySubSystem subSystem){
        this.subSystems.indexOf(subSystem,true);
    }
}
