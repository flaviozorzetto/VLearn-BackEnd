package br.com.fiap.vlearn.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.vlearn.exceptions.RestNotFoundException;
import br.com.fiap.vlearn.models.Login;
import br.com.fiap.vlearn.repository.LoginRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("vlearn/login")
public class LoginController {
	Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginRepository repository;

	@GetMapping
	public List<Login> index() {
		return repository.findAll();
	}

	@PostMapping
	public ResponseEntity<Login> create(@RequestBody @Valid Login login) {
		log.info("Cadastrando login " + login);

		repository.save(login);

		return ResponseEntity.status(HttpStatus.CREATED).body(login);
	}

	@GetMapping("{id}")
	public ResponseEntity<Login> show(@PathVariable Long id) {
		log.info("detalhando login " + id);

		var login = getLogin(id);

		return ResponseEntity.ok(login);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Login> destroy(@PathVariable Long id) {
		log.info("apagando login " + id);

		var login = getLogin(id);

		repository.delete(login);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Login> update(@PathVariable Long id, @Valid @RequestBody Login login) {
		log.info("atualizando login " + id);
		getLogin(id);

		login.setId(id);
		repository.save(login);

		return ResponseEntity.ok(login);
	}

	private Login getLogin(Long id) {
		return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Login nao encontrado"));
	}
}
