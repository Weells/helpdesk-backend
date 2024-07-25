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
		Tecnico tec1 = new Tecnico.Builder()
				.setId(null)
				.setNome("Paulo Gustavo")
				.setCpf("56843416080")
				.setEmail("paulo@gmail.com")
				.setSenha(encoder.encode("123"))
				.build();
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente.Builder()
				.setId(null)
				.setNome("Linus Torvalds")
				.setCpf("70214573087")
				.setEmail("linus@gmail.com")
				.setSenha(encoder.encode("123"))
				.build();
		
		Chamado c1 = new Chamado.Builder()
				.setId(null)
				.setPrioridade(Prioridade.MEDIA)
				.setStatus(Status.ANDAMENTO)
				.setTitulo("Chamado 01")
				.setObservacoes("Primeiro chamado")
				.setTecnico(tec1)
				.setCliente(cli1)
				.build();
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
