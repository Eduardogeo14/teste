package br.edu.ifrs.series5.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifrs.series5.dao.JogoDAO;
import br.edu.ifrs.series5.dominio.Jogo;
import jakarta.validation.Valid;

@Controller
public class JogoPaginaController {

	private JogoDAO dao;
	
	public JogoPaginaController(JogoDAO dao) {
		this.dao = dao;
	}
	
	@GetMapping("/paginas/jogos")
	public String listar(Model model) {
		model.addAttribute("jogos", dao.listarTodos());
		return "jogos/lista";
	}
	
	@GetMapping("/paginas/jogos/novo")
	public String formulario(Model model) {
		model.addAttribute("jogo", new Jogo());
		return "jogos/formulario";
	}
	
	@PostMapping("/paginas/jogos/novo")
	public String cadastrar(@Valid @ModelAttribute Jogo jogo, BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "jogos/formulario";
		}
		dao.salvar(jogo);
		return "redirect:/paginas/jogos";
	}
	
	@GetMapping("/paginas/jogos/{id}/editar")
	public String edicao(@PathVariable Long id, Model model) {
		model.addAttribute("jogo", dao.buscarPorId(id));
		return "jogos/edicao";
	}
	
	@PostMapping("/paginas/jogos/editar")
	public String atualizar(@Valid @ModelAttribute Jogo jogo, BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "jogos/edicao";
		}
		dao.atualizar(jogo);
		return "redirect:/paginas/jogos";
	}
	
	@PostMapping("/paginas/jogos/{id}/remover")
	public String remover(@PathVariable Long id) {
		dao.remover(id);
		return "redirect:/paginas/jogos";
	}
}
