/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.camel.manual.jms;

import com.bhageshri.schoolart.camel.jaxb.generated.Player;
import javax.jms.Destination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

/**
 *
 * @author Mahavir Singh
 */
public class PlayerSenderImpl implements Sender<Player> {
    /**
     * Initiate logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerSenderImpl.class);
    
    private Destination destination;
    
    @Autowired
    private JmsTemplate jmsTemplate;
    
    @Override
    public void sendMessage(final Player player) throws Exception {
        LOGGER.debug("Sending [{}] to topic [{}]", new Object[] { player, destination });
        jmsTemplate.convertAndSend(destination, (Object )player);
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

}
