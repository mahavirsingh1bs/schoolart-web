/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.camel.enricher;

import com.bhageshri.schoolart.camel.jaxb.generated.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mahavir Singh
 */
@Component("ClubEnricher")
public class ClubEnricher implements Enrichable<Player> {
    /**
     * Initiate logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ClubEnricher.class);
    
    @Override
    public void enrich(Player player) {
        LOGGER.debug("Enriching player [{}] with club data", new Object[] { player.getSurname() });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            LOGGER.error("Exception while sleeping occurred", ex);
        }
        player.setTeamName("Borussia Dortmund");
    }
}
