package forumhub.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;

public record DadosCadastroTopicos(
        @NotBlank
        String titulo,
        @NotBlank
        String message,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime data,
        @NotBlank
        String curso,
        @NotBlank
        String autor
        ) {
}
