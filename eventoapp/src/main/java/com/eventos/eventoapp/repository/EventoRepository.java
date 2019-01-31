package com.eventos.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventos.eventoapp.model.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long>{

}
