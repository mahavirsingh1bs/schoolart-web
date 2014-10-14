/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.camel.manual.jms;

import com.bhageshri.schoolart.camel.jaxb.generated.Player;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.BytesMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mahavir Singh
 */
@Component
public class FinalListenerImpl implements MessageListener {
    /**
     * Initiate logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FinalListenerImpl.class);
    
    @Autowired
    private MessageConverter messageConverter;
    
    @Override
    public void onMessage(Message message) {
        if (!(message instanceof BytesMessage)) {
            LOGGER.error("Wrong msg!");
            return;
        }
        
        Player player = null;
        try {
            player = (Player ) messageConverter.fromMessage(message);
            
            if (player.getTeamName() != null) {
                LOGGER.debug("Message already enriched! Shutting down the system");
                System.exit(0);
            } else {
                LOGGER.debug("The message should have been enriched but wasn't");
                System.exit(1);
            }
        } catch (Exception ex) {
            LOGGER.error("Exception occurred", ex);
        }
    }
}
