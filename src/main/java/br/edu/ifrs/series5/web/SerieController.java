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

import br.edu.ifrs.series5.dao.SerieDAO;
import br.edu.ifrs.series5.dominio.Serie;

@RestController
public class SerieController {

	private final SerieDAO dao;
	
	public SerieController(SerieDAO dao) {
		this.dao = dao;
	}
	
	@PostMapping("/series")
	@ResponseStatus(HttpStatus.CREATED)
	public Serie salvar(@RequestBody Serie serie) {
		dao.salvar(serie);
		return serie;
	}
	
	@GetMapping("/series/{id}")
	public Serie buscarPorId(@PathVariable Long id) {
		return dao.buscarPorId(id);
	}
	
	@GetMapping("/series")
	public List<Serie> listarTodos(){
		return dao.listarTodos();
	}
	
	@PutMapping("/series/{id}")
	public Serie atualizar(@PathVariable Long id, @RequestBody Serie dados) {
		Serie serie = dao.buscarPorId(id);
		
		serie.setNome(dados.getNome());
		serie.setPlataforma(dados.getPlataforma());
		serie.setGenero(dados.getGenero());
		serie.setAnoLancamento(dados.getAnoLancamento());
		dao.atualizar(serie);
		return serie;
	}
	
	@DeleteMapping("/series/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		dao.remover(id);
	}
}
