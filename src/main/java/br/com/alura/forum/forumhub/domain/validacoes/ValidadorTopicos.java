package br.com.alura.forum.forumhub.domain.validacoes;
import br.com.alura.forum.forumhub.domain.DadosCadastroTopicos;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Bean;


public interface ValidadorTopicos {
    void validar(@Valid DadosCadastroTopicos dados);
}
