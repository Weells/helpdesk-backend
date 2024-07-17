package com.bruno.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.helpdesk.domain.Chamado;
import com.bruno.helpdesk.domain.Cliente;
import com.bruno.helpdesk.domain.Tecnico;
import com.bruno.helpdesk.domain.dtos.ChamadoDTO;
import com.bruno.helpdesk.domain.enums.Prioridade;
import com.bruno.helpdesk.domain.enums.Status;
import com.bruno.helpdesk.repositories.ChamadoRepository;
import com.bruno.helpdesk.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}

	public Chamado create(@Valid ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}

	public Chamado update(Integer id, ChamadoDTO objDTO) {
		objDTO.setId(id);
		Chamado oldObj = findById(id);
		oldObj = newChamado(objDTO);
		return repository.save(oldObj);
	}
	
	private Chamado newChamado(ChamadoDTO objDTO) {
		Tecnico tecnico = tecnicoService.findById(objDTO.getTecnico());
		Cliente cliente = clienteService.findById(objDTO.getCliente());
		
		Chamado chamado = new Chamado.Builder()
				.setTecnico(tecnico)
				.setCliente(cliente)
				.setPrioridade(Prioridade.toEnum(objDTO.getPrioridade()))
				.setStatus(Status.toEnum(objDTO.getStatus()))
				.setTitulo(objDTO.getTitulo())
				.setObservacoes(objDTO.getObservacoes())
				.build();
		
		if(objDTO.getId() != null) {
			chamado.setId(objDTO.getId());
		}
		if(objDTO.getStatus().equals(2)) {
			chamado.setDataFechamento(LocalDate.now());
		}
		return chamado;
	}

}
