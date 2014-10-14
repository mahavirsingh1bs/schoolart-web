/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.camel.enricher;

import com.bhageshri.schoolart.camel.jaxb.generated.Player;
import com.bhageshri.schoolart.camel.manual.jms.FinalListenerImpl;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Mahavir Singh
 */
public class AgeEnricher implements Enrichable<Player> {
    /**
     * Initiate logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AgeEnricher.class);
    
    @Override
    public void enrich(Player inputObject) {
        LOGGER.debug("Enriching player [{}] with age data", new Object[] { inputObject.getSurname() });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            LOGGER.error("Exception while sleeping occurred", ex);
        }
        inputObject.setAge(new Random().nextInt(35));
    }
    
}
