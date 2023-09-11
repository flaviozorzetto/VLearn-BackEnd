package br.com.fiap.vlearn.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_VLEARN_ALUNO")
@SequenceGenerator(name = "vlearn_aluno", sequenceName = "SQ_TB_VLEARN_ALUNO", allocationSize = 1)
public class Aluno {
	@Id
	@GeneratedValue(generator = "vlearn_aluno", strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private String tipo_pcd;
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	@ManyToOne(cascade = CascadeType.ALL)
	private Telefone telefone;
}
