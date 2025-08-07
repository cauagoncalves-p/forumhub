package forumhub.controller;

import forumhub.domain.DadosCadastroTopicos;
import forumhub.domain.DadosDetalhamentoTopico;
import forumhub.domain.Topico;
import forumhub.domain.topicosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class topicosController {
    @Autowired
    private topicosRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopicos(@RequestBody @Valid DadosCadastroTopicos dados ,  UriComponentsBuilder uriBuilder){
        var topico = new Topico(dados);
        var topicosave = repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicosave.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }



}
