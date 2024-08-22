package com.bruno.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bruno.helpdesk.domain.Chamado;
import com.bruno.helpdesk.domain.Cliente;
import com.bruno.helpdesk.domain.Tecnico;
import com.bruno.helpdesk.domain.enums.Perfil;
import com.bruno.helpdesk.domain.enums.Prioridade;
import com.bruno.helpdesk.domain.enums.Status;
import com.bruno.helpdesk.repositories.ChamadoRepository;
import com.bruno.helpdesk.repositories.ClienteRepository;
import com.bruno.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Bean
	public void instanciaDB() {
		//<-------------------- TECNICOS ----------------------->
		Tecnico tec1 = new Tecnico.Builder()
				.setId(null)
				.setNome("Paulo Gustavo")
				.setCpf("56843416080")
				.setEmail("paulo@gmail.com")
				.setSenha(encoder.encode("123"))
				.build();
		tec1.addPerfil(Perfil.ADMIN);
		
		Tecnico tec2 = new Tecnico.Builder()
				.setId(null)
				.setNome("Carlos Henrique")
				.setCpf("44035020087")
				.setEmail("carlos@gmail.com")
				.setSenha(encoder.encode("123"))
				.build();
		tec1.addPerfil(Perfil.TECNICO);
		
		Tecnico tec3 = new Tecnico.Builder()
				.setId(null)
				.setNome("Tobias Silva")
				.setCpf("62249949000")
				.setEmail("tobias@gmail.com")
				.setSenha(encoder.encode("123"))
				.build();
		tec1.addPerfil(Perfil.TECNICO);
		
		Tecnico tec4 = new Tecnico.Builder()
				.setId(null)
				.setNome("Fernanda Braga")
				.setCpf("15855822044")
				.setEmail("fernanda@gmail.com")
				.setSenha(encoder.encode("123"))
				.build();
		tec1.addPerfil(Perfil.TECNICO);
		
		Tecnico tec5 = new Tecnico.Builder()
				.setId(null)
				.setNome("Gabriela Santos")
				.setCpf("23165248001")
				.setEmail("gabs@gmail.com")
				.setSenha(encoder.encode("123"))
				.build();
		tec1.addPerfil(Perfil.TECNICO);
		
		Tecnico tec6 = new Tecnico.Builder()
				.setId(null)
				.setNome("Plinio Souza")
				.setCpf("20017251087")
				.setEmail("plinio@gmail.com")
				.setSenha(encoder.encode("123"))
				.build();
		tec1.addPerfil(Perfil.TECNICO);
		
		
		//<-------------------- CLIENTES ----------------------->
		Cliente cli1 = new Cliente.Builder()
				.setId(null)
				.setNome("Linus Torvalds")
				.setCpf("70214573087")
				.setEmail("linus@gmail.com")
				.setSenha(encoder.encode("123"))
				.build();
		
		Cliente cli2 = new Cliente.Builder()
				.setId(null)
				.setNome("Cabral Armando")
				.setCpf("38742711029")
				.setEmail("cabral@gmail.com")
				.setSenha(encoder.encode("123"))
				.build();
		
		Cliente cli3 = new Cliente.Builder()
				.setId(null)
				.setNome("Helena Silva")
				.setCpf("87332043068")
				.setEmail("helena@gmail.com")
				.setSenha(encoder.encode("123"))
				.build();
		
		Cliente cli4 = new Cliente.Builder()
				.setId(null)
				.setNome("Sandro Oliveira")
				.setCpf("62990852077")
				.setEmail("sandro@gmail.com")
				.setSenha(encoder.encode("123"))
				.build();
		
		Cliente cli5 = new Cliente.Builder()
				.setId(null)
				.setNome("Elias Souza")
				.setCpf("55784606077")
				.setEmail("elias@gmail.com")
				.setSenha(encoder.encode("123"))
				.build();
		
		Cliente cli6 = new Cliente.Builder()
				.setId(null)
				.setNome("Mario Fontes")
				.setCpf("82850972002")
				.setEmail("mario@gmail.com")
				.setSenha(encoder.encode("123"))
				.build();

		//<-------------------- CHAMADOS ----------------------->
		Chamado c1 = new Chamado.Builder()
				.setId(null)
				.setPrioridade(Prioridade.MEDIA)
				.setStatus(Status.ABERTO)
				.setTitulo("Chamado 01")
				.setObservacoes("Primeiro chamado")
				.setTecnico(tec1)
				.setCliente(cli1)
				.build();
		
		Chamado c2 = new Chamado.Builder()
				.setId(null)
				.setPrioridade(Prioridade.ALTA)
				.setStatus(Status.ENCERRADO)
				.setTitulo("Chamado 02")
				.setObservacoes("Segundo chamado")
				.setTecnico(tec3)
				.setCliente(cli5)
				.build();
		
		Chamado c3 = new Chamado.Builder()
				.setId(null)
				.setPrioridade(Prioridade.ALTA)
				.setStatus(Status.ANDAMENTO)
				.setTitulo("Chamado 03")
				.setObservacoes("Terceiro chamado")
				.setTecnico(tec2)
				.setCliente(cli1)
				.build();
		
		Chamado c4 = new Chamado.Builder()
				.setId(null)
				.setPrioridade(Prioridade.BAIXA)
				.setStatus(Status.ANDAMENTO)
				.setTitulo("Chamado 04")
				.setObservacoes("Quarto chamado")
				.setTecnico(tec4)
				.setCliente(cli5)
				.build();
		
		Chamado c5 = new Chamado.Builder()
				.setId(null)
				.setPrioridade(Prioridade.MEDIA)
				.setStatus(Status.ABERTO)
				.setTitulo("Chamado 05")
				.setObservacoes("Quinto chamado")
				.setTecnico(tec4)
				.setCliente(cli6)
				.build();
		
		Chamado c6 = new Chamado.Builder()
				.setId(null)
				.setPrioridade(Prioridade.BAIXA)
				.setStatus(Status.ANDAMENTO)
				.setTitulo("Chamado 06")
				.setObservacoes("Sexto chamado")
				.setTecnico(tec2)
				.setCliente(cli3)
				.build();
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, tec6));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
	}
}
