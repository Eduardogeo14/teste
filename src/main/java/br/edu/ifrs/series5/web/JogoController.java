package br.edu.ifrs.series5.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.series5.dao.JogoDAO;
import br.edu.ifrs.series5.dominio.Jogo;

@RestController
public class JogoController {

	private final JogoDAO dao;
	
	public JogoController(JogoDAO dao) {
		this.dao = dao;
	}
	
	@PostMapping("/jogos")
	@ResponseStatus(HttpStatus.CREATED)
	public Jogo salvar(@RequestBody Jogo jogo) {
		dao.salvar(jogo);
		return jogo;
	}
	
	@GetMapping("/jogos/{id}")
	public Jogo buscarPorId(@PathVariable Long id) {
		return dao.buscarPorId(id);
	}
	
	@GetMapping("/jogos")
	public List<Jogo> listarTodos(){
		return dao.listarTodos();
	}
	
	@PutMapping("/jogos/{id}")
	public Jogo atualizar(@PathVariable Long id, @RequestBody Jogo dados) {
		Jogo jogo = dao.buscarPorId(id);
		jogo.setNome(dados.getNome());
		jogo.setDesenvolvedora(dados.getDesenvolvedora());
		jogo.setPlataforma(dados.getPlataforma());
		jogo.setAnoLancamento(dados.getAnoLancamento());
		dao.atualizar(jogo);
		return jogo;
	}
	
	@DeleteMapping("/jogos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		dao.remover(id);
	}
}
