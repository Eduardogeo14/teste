package br.edu.ifrs.series5.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Jogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome nulo ou inválido")
	private String nome;
	
	@NotBlank(message = "Desenvolvedora nula ou inválida")
	private String desenvolvedora;
	
	@NotBlank(message = "Paltaforma nula ou inválida")
	private String plataforma;
	
	@NotNull(message = "Ano lançamento obrigatório")
	@Min(value = 1970, message = "Ano permitido: 1970 ou posterior")
	private Integer anoLancamento;
	
	public Jogo() {}
	
	public Jogo(String nome, String desenvolvedora, String plataforma, Integer anolancamento) {
		setNome(nome);
		setDesenvolvedora(desenvolvedora);
		setPlataforma(plataforma);
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

	public String getDesenvolvedora() {
		return desenvolvedora;
	}

	public void setDesenvolvedora(String desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public Integer getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	@Override
	public String toString() {
		return "Jogo [id=" + id + ", nome=" + nome + ", desenvolvedora=" + desenvolvedora + ", plataforma=" + plataforma
				+ ", anoLancamento=" + anoLancamento + "]";
	}
	

}
