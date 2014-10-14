/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.camel.manual.jms;

/**
 *
 * @author Mahavir Singh
 */
public interface Sender<T> {
    void sendMessage(T t) throws Exception;
}
