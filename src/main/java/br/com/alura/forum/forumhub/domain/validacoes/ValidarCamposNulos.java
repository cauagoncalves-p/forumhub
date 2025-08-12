package br.com.alura.forum.forumhub.domain.validacoes;

import br.com.alura.forum.forumhub.ValidacaoException;
import br.com.alura.forum.forumhub.domain.DadosCadastroTopicos;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class ValidarCamposNulos implements ValidadorTopicos{
    @Override
    public void validar(@Valid DadosCadastroTopicos dados) {
        if (dados.message() == null || dados.titulo() == null|| dados.curso() == null || dados.autor() == null ||dados.data() == null){
            throw new ValidacaoException("Todos os campos precisam ser preenchidos");
        }
    }
}
