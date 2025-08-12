package br.com.alura.forum.forumhub.domain;

import java.time.LocalDateTime;

public record DadosListagemTopico(
        String titulo,
        String message,
        LocalDateTime data,
        String curso,
        String autor
) {
    public DadosListagemTopico(Topico topico){
        this(topico.getTitulo(), topico.getMessage(), topico.getData(), topico.getCurso(), topico.getAutor());
    }
}
