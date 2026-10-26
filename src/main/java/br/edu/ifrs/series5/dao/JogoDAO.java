package br.edu.ifrs.series5.dao;

import java.util.List;

import br.edu.ifrs.series5.dominio.Jogo;

public interface JogoDAO {

	void salvar(Jogo jogo);
	Jogo buscarPorId(Long id);
	List<Jogo> listarTodos();
	void atualizar(Jogo jogo);
	void remover(Long id);
}
