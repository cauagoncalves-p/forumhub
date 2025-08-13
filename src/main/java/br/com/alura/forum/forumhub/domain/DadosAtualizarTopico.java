package br.com.alura.forum.forumhub.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micrometer.common.lang.NonNull;

import java.time.LocalDateTime;

public record DadosAtualizarTopico(
        @NonNull
        Long id,
        String titulo,
        String message,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime data,
        String curso,
        String autor) {
}
