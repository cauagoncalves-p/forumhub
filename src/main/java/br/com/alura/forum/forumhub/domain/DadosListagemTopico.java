package br.com.alura.forum.forumhub.domain;

import java.time.LocalDateTime;

public record DadosListagemTopico(
        Long Id,
        String titulo,
        String message,
        LocalDateTime data
) {
    public DadosListagemTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMessage(), topico.getData());
    }
}
