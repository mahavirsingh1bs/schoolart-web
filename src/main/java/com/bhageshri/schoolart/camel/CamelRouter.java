/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.camel;

import org.apache.camel.spring.Main;

/**
 *
 * @author Mahavir Singh
 */
public class CamelRouter {

    public static void main(String...args) throws Exception {
        Main main = new Main();
        main.setApplicationContextUri("/camel/camelContext.xml");
        main.run(args);
    }
}
