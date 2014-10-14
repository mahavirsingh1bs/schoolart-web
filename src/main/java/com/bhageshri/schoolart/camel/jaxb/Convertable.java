/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.camel.jaxb;

/**
 *
 * @author Mahavir Singh
 */
public interface Convertable<T> {
    String marshal(T object);
    
    T unmarshal(String objectAsString);
}
