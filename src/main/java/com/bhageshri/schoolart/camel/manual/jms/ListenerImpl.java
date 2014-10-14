/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.camel.manual.jms;

import com.bhageshri.schoolart.camel.enricher.Enrichable;
import com.bhageshri.schoolart.camel.jaxb.Convertable;
import com.bhageshri.schoolart.camel.jaxb.generated.Player;
import java.util.List;
import javax.jms.BytesMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mahavir Singh
 */
@Component
public class ListenerImpl implements MessageListener {
    /**
     * Initiate logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ListenerImpl.class);
    
    @Autowired
    private Convertable<Player> playerConverter;
    
    @Autowired
    private List<Enrichable<Player>> listOfEnrichers;
    
    @Autowired
    private MessageConverter messageConverter;
            
    @Autowired
    @Qualifier("destinationPlayerSender")
    private Sender<Player> sender;
    
    @Override
    public void onMessage(Message message) {
        if (!(message instanceof BytesMessage)) {
            LOGGER.error("Wrong Msg!");
            return;
        }
        
        Player player = null;
        try {
            player = (Player) messageConverter.fromMessage(message);
            
            LOGGER.debug("Enriching the input message");
            for (Enrichable<Player> enrichable : listOfEnrichers) {
                enrichable.enrich(player);
            }
            LOGGER.debug("Enriched text message: [{}]", new Object[] { playerConverter.marshal(player) });
            sender.sendMessage(player);
        } catch (Exception ex) {
            LOGGER.error("Exception occurred", ex);
        }
    }
}
