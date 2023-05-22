package br.com.fiap.vlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.vlearn.models.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
}
