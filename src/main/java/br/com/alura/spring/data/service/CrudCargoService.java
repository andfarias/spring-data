package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {

	private final CargoRepository cargoRepository;
	
	public CrudCargoService(final CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void init(Scanner scanner) {
		save(scanner);
	}
	
	private void save(Scanner scanner) {
		System.out.println("Position Description");
		String description = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(description);
		cargoRepository.save(cargo);
		System.out.println("Save");
	}
}
