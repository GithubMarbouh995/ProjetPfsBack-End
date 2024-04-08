//package com.marbouh.locationdevetementstraditionnels.utils;
//
//import com.marbouh.locationdevetementstraditionnels.model.Validation;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class Notification {
//    JavaMailSender javaMailSender;
//    public void envoyer(Validation validation) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("abd.marbouh@gmail.com");
//        message.setTo(validation.getUtilisateur().getEmail());
//        message.setSubject("Votre code d'activation");
//
//        String texte = String.format(
//                "Bonjour %s, <br /> Votre code d'action est %s; A bientôt",
//                validation.getUtilisateur().getNom(),
//                validation.getCode()
//        );
//        message.setText(texte);
//
//        javaMailSender.send(message);
//    }
//}
