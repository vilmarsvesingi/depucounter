/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depucount.main;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author vilmars.vesingi
 */
public class EmailProcessor {
//    
//    donotreply.depucounter
//            oopsoops12

    public static String emailReceiver;
    public static String emailSubject;
    public static String emailText;
    public static String[] emailAttachmentDirectory;

    public static Boolean ifSubjAndAttachRemotelySet;

    public static Boolean attachmentIsMandatory;

    public static String emailTableString;

    public static String getEmailTableString() {
        return emailTableString;
    }

    public static void setEmailTableString(String emailTableString) {
        EmailProcessor.emailTableString = emailTableString;
    }

    public static Boolean getAttachmentIsMandatory() {
        return attachmentIsMandatory;
    }

    public static void setAttachmentIsMandatory(Boolean attachmentIsMandatory) {
        EmailProcessor.attachmentIsMandatory = attachmentIsMandatory;
    }

    public static Boolean getIfSubjAndAttachRemotelySet() {
        return ifSubjAndAttachRemotelySet;
    }

    public static void setIfSubjAndAttachRemotelySet(Boolean remotelySetSubjAndAttach) {
        EmailProcessor.ifSubjAndAttachRemotelySet = remotelySetSubjAndAttach;
    }

    public static String getEmailReceiver() {
        return emailReceiver;
    }

    public static void setEmailReceiver(String emailReceiver) {
        EmailProcessor.emailReceiver = emailReceiver;
    }

    public static String getEmailSubject() {
        return emailSubject;
    }

    public static void setEmailSubject(String emailSubject) {
        EmailProcessor.emailSubject = emailSubject;
    }

    public static String getEmailText() {
        return emailText;
    }

    public static void setEmailText(String emailText) {

        EmailProcessor.emailText = emailText;
    }

    public static String[] getEmailAttachmentDirectory() {
        return emailAttachmentDirectory;
    }

    public static void setEmailAttachmentDirectory(String[] emailAttachmentDirectory) {
        for (String email : emailAttachmentDirectory) {
            email = email.replace("\\", "\\\\");
            EmailProcessor.emailAttachmentDirectory = emailAttachmentDirectory;
        }
    }

    public static void GenerateAndSendEmail() {

        String username = "donotreply.depucounterx@gmail.com";
        String password = "oopsoops12";

        String adressTo = emailReceiver;
        String subjectTxt = emailSubject;
        String emailBody
                = emailText;

        String[] filename = emailAttachmentDirectory;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // check the authentication
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(adressTo));
            message.setSubject(subjectTxt);
            Multipart multipartForMsg = new MimeMultipart();

            // attach the file
            if (attachmentIsMandatory) {

                for (String name : filename) {
                    MimeBodyPart mimeBodyPartForFile = new MimeBodyPart();
                    mimeBodyPartForFile.attachFile(name);
                    multipartForMsg.addBodyPart(mimeBodyPartForFile);

                }
             
            }

            BodyPart mimeBodyPartForTxt = new MimeBodyPart();
            mimeBodyPartForTxt.setContent(emailBody, "text/html; charset=utf-8");
            multipartForMsg.addBodyPart(mimeBodyPartForTxt);

            message.setContent(multipartForMsg);
            Transport.send(message);

            System.out.println("Email Sent Successfully");

        } catch (MessagingException ex) {
            Logger.getLogger(EmailProcessor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmailProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
