package com.pe.skeleton.api.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pe.skeleton.api.dto.AbstractDto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author kamen on 1.06.22 г.
 */
public class SkeletonSerializer {

    private static final ObjectMapper objectMapper = ObjectMapperSingleton.instance.getObjectMapper();

    public static final SkeletonSerializer instance = new SkeletonSerializer();

    private SkeletonSerializer() {
        // Singleton
    }

    public String process(AbstractDto entity) {
        if (entity == null) {
            return null;
        }
        return marshall(entity);
    }

    private String marshall(Object payload) {
        try (var out = new ByteArrayOutputStream()) {
            objectMapper.writeValue(out, payload);
            return out.toString(StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
