package com.aluracursos.forohub.data.incoming;

import jakarta.validation.constraints.NotNull;

public record DataTopicoEliminar(
        @NotNull Long id
) {
}
