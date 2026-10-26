package br.edu.ifrs.series5.dao;

import java.util.List;

import br.edu.ifrs.series5.dominio.Serie;

public interface SerieDAO {
	
	void salvar(Serie serie);
	Serie buscarPorId(Long id);
	List<Serie> listarTodos();
	void atualizar(Serie serie);
	void remover(Long id);
}
