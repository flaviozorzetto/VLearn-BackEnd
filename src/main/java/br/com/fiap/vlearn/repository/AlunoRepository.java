package br.com.fiap.vlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.vlearn.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
