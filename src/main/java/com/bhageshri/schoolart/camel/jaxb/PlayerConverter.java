/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.camel.jaxb;

import com.bhageshri.schoolart.camel.jaxb.generated.Player;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mahavir Singh
 */
@Component("PlayerConverter")
public class PlayerConverter implements Convertable<Player> {
    /**
     * Initiate logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerConverter.class);
    
    private final JAXBContext jaxbContext;
    private final Marshaller jaxbMarshaller;
    private final Unmarshaller jaxbUnmarshaller;
    
    public PlayerConverter() throws JAXBException {
        jaxbContext = JAXBContext.newInstance(Player.class);
        jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    }
    
    @Override
    public String marshal(Player player) {
        OutputStream stream = new ByteArrayOutputStream();
        try {
            jaxbMarshaller.marshal(player, stream);
        } catch (JAXBException ex) {
            LOGGER.error("Exception occured while marshalling", ex);
        }
        return stream.toString();
    }
    
    @Override
    public Player unmarshal(String playerAsString) {
        try {
            return (Player) jaxbUnmarshaller.unmarshal(new ByteArrayInputStream(playerAsString.getBytes()));
        } catch(JAXBException ex) {
            LOGGER.error("Exception occured while unmarshalling", ex);
        }
        return null;
    }
            
}
