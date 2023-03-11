package com.projects.CheChatGPT;

import com.projects.CheChatGPT.services.ChatGpt;
import com.projects.beans.Portal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@SpringBootApplication
public class CheChatGptApplication {
	public static final String EXIT = "EXIT";

	@Autowired
	private Portal portal;

	public static void main(String[] args) {
		SpringApplication.run(CheChatGptApplication.class, args);
	}

	@PostConstruct
	public void init() {

		ChatGpt chatGpt = new ChatGpt(portal);

		System.out.println("Welcome to  CheChatGPT 0.0.1\n For exit application type 'exit'");
		final Scanner keyboard = new Scanner(System.in);

		String textToSend;

		do{
			System.out.println(">> ");
			textToSend = keyboard.nextLine();
			if(!EXIT.equalsIgnoreCase(textToSend))
				System.out.println(chatGpt.send(textToSend));

		}while(!EXIT.equalsIgnoreCase(textToSend));
	}
}
