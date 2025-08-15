package br.com.alura.forum.forumhub.controller;

import br.com.alura.forum.forumhub.ValidacaoException;
import br.com.alura.forum.forumhub.domain.*;
import br.com.alura.forum.forumhub.domain.validacoes.ValidadorTopicos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class topicosController {
    @Autowired
    private topicosRepository repository;

    @Autowired
    private List<ValidadorTopicos> validarTopicos;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopicos(@RequestBody @Valid DadosCadastroTopicos dados , UriComponentsBuilder uriBuilder){
        var topico = new Topico(dados);
        validarTopicos.forEach(v -> v.validar(dados));
        var topicosave = repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicosave.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping()
    public ResponseEntity<Page<DadosListagemTopico>> listagem(@PageableDefault(size = 10, sort = {"titulo"}) Pageable page){
        var pag = repository.findAll(page)
                .map(DadosListagemTopico::new);

        return ResponseEntity.ok(pag);
    }

    @GetMapping("{id}")
    public ResponseEntity listarTopicoPeloId(@PageableDefault @Valid DadosDetalhamentoTopico dados){
            var topico = repository.findById(dados.id())
                    .orElseThrow(() -> new ValidacaoException("O ID do Topico não existe"));
            return ResponseEntity.ok(topico);
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity deletarTopicoPeloId(@PageableDefault DadosDetalhamentoTopico dados){
        var topico = repository.findById(dados.id())
                .orElseThrow(() -> new ValidacaoException("O ID do Topico não existe"));

        repository.delete(topico);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> atualizarTopicos(@PathVariable Long id,
            @RequestBody @Valid DadosAtualizarTopico dados) {
        var topico = repository.findById(id)
                .orElseThrow(() -> new ValidacaoException("O ID do Tópico não existe"));

        topico.DadosAtualizarTopico(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }
}
