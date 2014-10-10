/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mahavir.singh
 */
public class BeanUtil {
    private final static BeanUtil INSTANCE = new BeanUtil();
    
    private BeanUtil() { }
    
    public <B, E> B toBean(E e, Class<B> bClass) {
        B bObj = null;
        try {
            bObj = bClass.newInstance();
            for (Method method : bClass.getDeclaredMethods()) {
                if (method.getName().startsWith("set")) {
                    Method eMethod = e.getClass().getDeclaredMethod("get" + method.getName().substring(3), null);
                    method.invoke(bObj, eMethod.invoke(e, null));
                    eMethod.invoke(e, null);
                }
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(BeanUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bObj;
    }
    
    /**
    public <B, E> E toEntity(B b, Class<B> eClass) {
        B bObj = null;
        try {
            bObj = eClass.newInstance();
            for (Method method : bClass.getDeclaredMethods()) {
                if (method.getName().startsWith("set")) {
                    Method eMethod = e.getClass().getDeclaredMethod("get" + method.getName().substring(3), null);
                    method.invoke(bObj, eMethod.invoke(e, null));
                    eMethod.invoke(e, null);
                }
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(BeanUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bObj;
    }*/
    
    public static BeanUtil getInstance() { 
        return INSTANCE;
    }
    
    public static void main(String...args) {
        
    }
}
