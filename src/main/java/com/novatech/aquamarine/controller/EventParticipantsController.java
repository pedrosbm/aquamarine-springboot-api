package com.novatech.aquamarine.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.novatech.aquamarine.model.EventParticipants;
import com.novatech.aquamarine.repository.EventParticipantsRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Participants")
public class EventParticipantsController {
    
    private EventParticipantsRepository repository;

    @GetMapping("/List")
    @ResponseStatus(FOUND)
    public ResponseEntity<List<EventParticipants>> list() {
            List<EventParticipants> clientes = repository.findAll();
            return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    @ResponseStatus(FOUND)
    public ResponseEntity<EventParticipants> get(@PathVariable Long id) {

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<EventParticipants> post(@RequestBody @Valid EventParticipants EventParticipants) {
        try {
            return ResponseEntity.ok(repository.save(EventParticipants));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<EventParticipants> update(@RequestBody @Valid EventParticipants EventParticipants) {
        verify(EventParticipants.getParticipantId());

        return ResponseEntity.ok(repository.save(EventParticipants));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(OK)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        verify(id);
        repository.deleteById(id);

        return ResponseEntity.ok("Apagado com sucesso");
    }
    /**
     * Verificação feita para os métodos de update e delete.
     * 
     * @param id
     * Long
     * @throws ResponseStatusException
     * Se entidade não fôr encontrada
     * @author
     * Pedro Sena
     */
    private void verify(Long id) {

        repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "Instância não encontrada"));

    }
}
