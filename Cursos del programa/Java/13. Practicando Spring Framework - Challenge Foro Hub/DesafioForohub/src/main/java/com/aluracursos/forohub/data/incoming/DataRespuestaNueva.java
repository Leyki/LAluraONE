package com.aluracursos.forohub.data.incoming;


import jakarta.validation.constraints.NotBlank;


public record DataRespuestaNueva(
        @NotBlank String autor, // todo implement this properly
        @NotBlank String mensaje
) {

}
