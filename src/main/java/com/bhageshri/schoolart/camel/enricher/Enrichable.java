/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.camel.enricher;

/**
 *
 * @author Mahavir Singh
 */
public interface Enrichable<T> {
    void enrich(T inputObject);
}
