package br.com.alura.forum.forumhub.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;

public record DadosCadastroTopicos(
        @NotBlank
        String titulo,
        @NotBlank
        String message,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        LocalDateTime data,
        @NotBlank
        String curso,
        @NotBlank
        String autor
        ) {
}
