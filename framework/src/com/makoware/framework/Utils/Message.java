package com.makoware.framework.Utils;

import java.util.HashMap;
import java.util.Set;

public class Message {
	
	private HashMap<String, Object> things = new HashMap<String, Object>();

    public Message(){
        things = new HashMap<>();
    }

    public Message(String key, Object obj){
        this();
    }
	
	public Message put(String key, Object obj){
		things.put(key, obj);
        return this;
	}
	
	public boolean contains(String key){ 
		return things.containsKey(key); 
	}
	
	public Object get(String key){
		return things.get(key);
	}
	
	public <T> T get(String key, Class<T> c){
		return (T)(things.get(key));
	}

	public Set<String> keys(){
        return things.keySet();
    }
	
}
