package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.specification.SpecificationFuncionario;

@Service
public class RelatorioFuncionarioDinamico {

	private final FuncionarioRepository funcionarioRepository;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {
		System.out.println("Por favor digite um nome: ");
		String nome = scanner.next();
		if (nome.equalsIgnoreCase("NULL")) {
			nome = null;
		}

		System.out.println("Por favor digite um cpf: ");
		String cpf = scanner.next();
		if (cpf.equalsIgnoreCase("NULL")) {
			cpf = null;
		}

		System.out.println("Por favor digite um salario: ");
		Double salario = scanner.nextDouble();
		if (salario == 0) {
			salario = null;
		}

		System.out.println("Por favor digite uma data contratacao: ");
		String data = scanner.next();
		LocalDate dataContratacao;
		if (data.equalsIgnoreCase("NULL")) {
			dataContratacao = null;
		} else {
			dataContratacao = LocalDate.parse(data, formatter);
		}

		List<Funcionario> funcionarios = funcionarioRepository.findAll(Specification
				.where(SpecificationFuncionario.nome(nome)).or(Specification.where(SpecificationFuncionario.cpf(cpf)))
				.or(Specification.where(SpecificationFuncionario.salario(salario)))
				.or(Specification.where(SpecificationFuncionario.dataCotratacao(dataContratacao))));
		funcionarios.forEach(System.out::println);
	}
}
