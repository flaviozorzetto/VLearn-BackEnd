package br.com.fiap.vlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.vlearn.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
