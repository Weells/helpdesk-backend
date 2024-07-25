package com.bruno.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bruno.helpdesk.domain.Pessoa;
import com.bruno.helpdesk.repositories.PessoaRepository;
import com.bruno.helpdesk.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PessoaRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Pessoa> user = repository.findByEmail(email);
		if(user.isPresent()) {
			Pessoa obj = user.get();
			return new UserSS(obj.getId(), obj.getEmail(), obj.getSenha(), obj.getPerfis());
		}
		throw new UsernameNotFoundException(email);
	}

}
