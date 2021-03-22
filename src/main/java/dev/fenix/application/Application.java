package dev.fenix.application;


import dev.fenix.application.person.module.Person;
import dev.fenix.application.person.repository.PersonRepository;
import dev.fenix.application.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.Random;


@SpringBootApplication

public class Application {

    @Autowired
	private UserRepository userRepository;
	@Autowired
	private PersonRepository personRepository ;

    @PostConstruct
	public void initPerson(){
		for (int i = 0; i < 2; i++) {
			Person fayssal = new Person();
			fayssal.setFirstName(this.generateRandom("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz "));
			fayssal.setLastName(this.generateRandom("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz "));
			personRepository.save(fayssal);
		}
	}

	private static String generateRandom(String aToZ) {
		Random rand=new Random();
		StringBuilder res=new StringBuilder();
		for (int i = 0; i < 10; i++) {
			int randIndex=rand.nextInt(aToZ.length());
			res.append(aToZ.charAt(randIndex));
		}
		return res.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
