package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.service.CrudCargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private boolean system = true;
	
	public SpringDataApplication(final CrudCargoService cargoService) {
		this.cargoService = cargoService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while (system) {
			System.out.println("What information do you whant to execute?");
			System.out.println("0 - Exit");
			System.out.println("1 - Position");
			
			final int action = scanner.nextInt();
			if (action == 1) {
				cargoService.init(scanner);
			} else {
				system = false;
			}
		}
	}

}
