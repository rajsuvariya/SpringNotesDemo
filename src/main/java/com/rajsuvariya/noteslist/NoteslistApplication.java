package com.rajsuvariya.noteslist;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class NoteslistApplication {

	public static void main(String[] args) {
		log.debug("Server start up ");
		SpringApplication.run(NoteslistApplication.class, args);
	}

}
