package com.makoware.framework.Core;

import com.makoware.framework.Utils.Callback;
import com.makoware.framework.Utils.Message;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Derek Arner on 3/16/15.
 */
public enum Messenger {
    INSTANCE;

    private HashMap<String, ArrayList<Callback>> listeners;

    public static void addListener(String keyName, Callback listener){
        if(INSTANCE.listeners==null){
            INSTANCE.listeners = new HashMap<String, ArrayList<Callback>>();
        }
        ArrayList<Callback> listenersForKey = INSTANCE.listeners.get(keyName);
        if(listenersForKey==null){
            listenersForKey = new ArrayList<Callback>();
            INSTANCE.listeners.put(keyName, listenersForKey);
        }
        listenersForKey.add(listener);
    }

    public static void removeListener(String keyName, Callback listener){
        if(INSTANCE.listeners!=null){
            ArrayList<Callback> listenersForKey = INSTANCE.listeners.get(keyName);
            if(listenersForKey!=null){
                listenersForKey.add(listener);
            }
        }
    }

    public static void postMessage(String keyName, Message message){
        if(INSTANCE.listeners!=null){
            ArrayList<Callback> listenersForKey = INSTANCE.listeners.get(keyName);
            if(listenersForKey!=null){
                for(Callback c : listenersForKey){
                    c.call(keyName, message);
                }
            }
        }
    }

    public static final String PAUSE_KEY = "MW.KEY.PAUSE";
    public static final String UNPAUSE_KEY = "MW.KEY.UNPAUSE";
    public static final String RESIZE_KEY = "MW.KEY.RESIZE";
}
