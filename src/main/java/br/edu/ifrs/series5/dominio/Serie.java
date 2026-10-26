package br.edu.ifrs.series5.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Serie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message = "Nome nulo ou inválido")
	private String nome;
	
	@NotBlank(message = "Plataforma nula ou inválida")
	private String plataforma;
	
	@NotBlank(message = "Gênero nulo ou inválido")
	private String genero;
	
	@NotNull(message = "Ano de lançameto obrigatório")
	@Min(value = 1950, message = "Ano permitido: 1950 ou posterior")
	private Integer anoLancamento;
	
	public Serie() {}
	
	public Serie(String nome, String plataforma, String genero, Integer anoLancamento) {
		setNome(nome);
		setPlataforma(plataforma);
		setGenero(genero);
		setAnoLancamento(anoLancamento);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	@Override
	public String toString() {
		return "Serie [id=" + id + ", nome=" + nome + ", plataforma=" + plataforma + ", genero=" + genero
				+ ", anoLancamento=" + anoLancamento + "]";
	}
	
	
}
