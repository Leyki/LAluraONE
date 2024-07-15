package com.aluracursos.DesafioLiterAlura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json implements IJson {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T parse(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null; // idk why extension complains
    }
}
