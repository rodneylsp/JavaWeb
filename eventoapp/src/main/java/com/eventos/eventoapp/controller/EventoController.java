package com.eventos.eventoapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventos.eventoapp.model.Evento;
import com.eventos.eventoapp.repository.EventoRepository;

@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository repository;

	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
	public String form() {
		return "evento/cadastrarEvento";
	}
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String salvar(Evento evento) {
		
		repository.save(evento);
		return "/eventos";
	}
	
	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		
		ModelAndView mv = new ModelAndView("index");
		
		Iterable<Evento> eventos = repository.findAll();
		mv.addObject("eventos", eventos);
		
		return mv;
	}
	
	@RequestMapping("/{id}")
	public ModelAndView detalhesEvento(@PathVariable("id")Long id) {
		
		Optional<Evento> evento = repository.findById(id);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		if(evento.isPresent())
				mv.addObject("evento",evento.get());
		
		return mv;
	}
	
}
