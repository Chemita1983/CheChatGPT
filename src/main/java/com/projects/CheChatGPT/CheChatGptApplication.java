package com.projects.CheChatGPT;

import com.projects.CheChatGPT.services.ChatGpt;
import com.projects.beans.Portal;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CheChatGptApplication {
	public static final String EXIT = "EXIT";

	public static void main(String[] args) {

		ChatGpt chatGpt = new ChatGpt(new Portal());

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
