package br.com.fiap.vlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.vlearn.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}