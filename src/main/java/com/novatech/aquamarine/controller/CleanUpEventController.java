package com.novatech.aquamarine.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.novatech.aquamarine.model.CleanUpEvent;
import com.novatech.aquamarine.repository.CleanUpEventRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Events")
public class CleanUpEventController {

    @Autowired
    private CleanUpEventRepository repository;

    @GetMapping("/{id}")
    @ResponseStatus(FOUND)
    public ResponseEntity<CleanUpEvent> get(@PathVariable Long id) {

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<CleanUpEvent> post(@RequestBody @Valid CleanUpEvent CleanUpEvent) {
        try {
            return ResponseEntity.ok(repository.save(CleanUpEvent));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<CleanUpEvent> update(@RequestBody @Valid CleanUpEvent CleanUpEvent) {
        verify(CleanUpEvent.getEventId());

        return ResponseEntity.ok(repository.save(CleanUpEvent));
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
