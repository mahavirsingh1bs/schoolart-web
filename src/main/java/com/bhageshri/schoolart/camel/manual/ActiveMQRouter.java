/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.camel.manual;

import com.bhageshri.schoolart.camel.jaxb.PlayerConverter;
import com.bhageshri.schoolart.camel.jaxb.generated.Player;
import com.bhageshri.schoolart.camel.manual.jms.Sender;
import java.io.File;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author Mahavir Singh
 */
public class ActiveMQRouter {

    public static void main(String...args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("/camel/jmsApplicationContext.xml");
        Sender<Player> sender = (Sender<Player>)context.getBean("originPlayerSender");
        
        Resource resource = new ClassPathResource("/camel/RobertLewandowski.xml");
        
        Scanner scanner = new Scanner(new File(resource.getURI())).useDelimiter("\\Z");
        String contents = scanner.next();
        PlayerConverter converter = context.getBean(PlayerConverter.class);
        sender.sendMessage(converter.unmarshal(contents));
    }
    
}
