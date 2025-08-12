package br.com.alura.forum.forumhub.domain.validacoes;

import br.com.alura.forum.forumhub.ValidacaoException;
import br.com.alura.forum.forumhub.domain.DadosCadastroTopicos;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class ValidarDuplicatas implements ValidadorTopicos {
    @Override
    public void validar(@Valid DadosCadastroTopicos dados) {
        if (dados.message().equals(dados.titulo())){
            throw new ValidacaoException("O Campo messagem e titulo não podem ser iguais!");
        }
    }
}
