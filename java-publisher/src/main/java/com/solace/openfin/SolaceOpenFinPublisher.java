package com.solace.openfin;

import org.apache.qpid.jms.JmsConnectionFactory;
import javax.jms.*;
import java.io.Console;

public class SolaceOpenFinPublisher {

    public static void main(String[] args) throws JMSException{
        JmsConnectionFactory solaceConnectionFactory = new JmsConnectionFactory("default", "default", "amqp://localhost:5672");
        Connection connection = solaceConnectionFactory.createConnection();
        connection.start();
        JMSContext context = solaceConnectionFactory.createContext();
        final Topic topic = context.createTopic("OPENFIN/SOLACE/JAVA");
        JMSProducer messageProducer = context.createProducer();
        String message = new String();

        Console console = System.console();

        while(true){
            if(console!=null){
               message = console.readLine("Enter the message: ");
               messageProducer.send(topic,message);
            }
        }
    }

}