package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {

	private boolean system = true;
	private final CargoRepository cargoRepository;

	public CrudCargoService(final CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public void init(Scanner scanner) {
		while (system) {
			System.out.println("What postion action do you what to do?");
			System.out.println("0 - Exit");
			System.out.println("1 - Save");
			System.out.println("2 - Update");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = scanner.nextInt();
			switch (action) {
			case 1:
				save(scanner);
				break;
			case 2:
				update(scanner);
				break;
			case 3:
				view();
				break;
			case 4:
				delete(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}

	private void save(Scanner scanner) {
		System.out.println("Position Description");
		String description = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(description);
		cargoRepository.save(cargo);
		System.out.println("Save");
	}

	private void update(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		System.out.println("Position Description");
		String description = scanner.next();

		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(description);
		cargoRepository.save(cargo);
		System.out.println("Update");
	}

	private void view() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	private void delete(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Deleted");
	}
	
}
