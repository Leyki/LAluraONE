package com.aluracursos.forohub.data.incoming;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataTopicoNuevo(
        @NotBlank String titulo,
        @NotBlank String autor, // in reality this should use the token to get the subject instead
        @NotBlank String mensaje,
        @NotNull Long cursoId
) {
}
