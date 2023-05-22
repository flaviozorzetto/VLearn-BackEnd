package br.com.fiap.vlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.vlearn.models.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}