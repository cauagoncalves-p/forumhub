package forumhub.domain;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String message,
        LocalDateTime data,
        String curso,
        String autor
) {
    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMessage(), topico.getData(), topico.getCurso(), topico.getAutor());
    }
}
