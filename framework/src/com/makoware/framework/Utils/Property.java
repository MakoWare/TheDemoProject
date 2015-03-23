package com.makoware.framework.Utils;

/**
 * Created by Derek Arner on 3/20/15.
 */
public class Property<E> {
    public Class<E> clazz;
    public E value;

    public static <T> Property with(T value, Class<T> clazz){
        Property property = new Property<T>();
        property.value = value;
        property.clazz = clazz;
        return  property;
    }

    public E value(){
        return value(clazz);
    }

    public <E> E value(Class<E> cls){
        return (E)value;
    }
}
