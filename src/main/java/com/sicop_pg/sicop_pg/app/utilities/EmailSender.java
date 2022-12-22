/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicop_pg.sicop_pg.app.utilities;

/**
 *
 * @author User
 */

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class EmailSender {
    
public static boolean enviarEmail(String destinatario,String asunto,String cuerpo){
   
        String remitente = "sicopcp@gmail.com";
       
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.ssl.trust","*");
        props.put("mail.smtp.user",remitente);
        props.put("mail.smtp.clave","ybgd nzny xenx yvns");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","smtp.true");
        props.put("mail.smtp.port","587");
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
props.put("mail.smtp.port", "587"); //TLS Port
props.put("mail.smtp.auth", "true"); //enable authentication
props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
       
        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            String clave = "ybgd nzny xenx yvns";
            transport.connect("smtp.gmail.com",remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;
        }
        catch (MessagingException me){
            me.printStackTrace();
            System.out.println("####" +me.getMessage());
            return false;
        }
        }
   
}