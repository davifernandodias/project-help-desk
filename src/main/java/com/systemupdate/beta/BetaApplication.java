package com.systemupdate.beta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class BetaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		//System.out.println(new BCryptPasswordEncoder().encode("123"));
		SpringApplication.run(BetaApplication.class, args);
	}
    @Autowired
    private JavaMailSender sender;

    @Override
    public void run(String... args) throws Exception {
        SimpleMailMessage simple = new SimpleMailMessage();
        simple.setTo("demodeskservice@gmail.com");
        simple.setText("teste number one");
        simple.setSubject("teste 1");
        sender.send(simple);
    }

}
