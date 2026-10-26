package br.edu.ifrs.series5.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifrs.series5.dominio.Serie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class SerieDAOJPA implements SerieDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void salvar(Serie serie) {
		em.persist(serie);
	}
	
	@Override
	public Serie buscarPorId(Long id) {
		return em.find(Serie.class, id);
	}
	
	@Override
	public List<Serie> listarTodos(){
		return em.createQuery("Select s from Serie s", Serie.class).getResultList();
	}
	
	@Override
	public void atualizar(Serie serie) {
		em.merge(serie);
	}
	
	@Override
	public void remover(Long id) {
		Serie serie = em.find(Serie.class, id);
		
		if(serie != null) {
			em.remove(serie);
		}
	}
}
