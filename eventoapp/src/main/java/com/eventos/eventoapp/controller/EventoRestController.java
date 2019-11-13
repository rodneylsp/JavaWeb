package com.eventos.eventoapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventos.eventoapp.model.Evento;
import com.eventos.eventoapp.repository.EventoRepository;

@RestController
public class EventoRestController {

	@Autowired
	private EventoRepository repository;

	@RequestMapping("/eventos/{id}")
	public ResponseEntity<Evento> getEventoById(@PathVariable("id") Long id) {

		if (!id.equals(0L)) {

			Optional<Evento> evento = repository.findById(id);
			if (!evento.isPresent()) {
				return new ResponseEntity<Evento>(evento.get(), HttpStatus.OK);
			}
		}

		return new ResponseEntity<Evento>(HttpStatus.NOT_FOUND);
	}
}
