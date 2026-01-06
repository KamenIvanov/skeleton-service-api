package com.pe.skeleton.api.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pe.skeleton.api.dto.AbstractDto;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kamen on 1.06.22 г.
 */
public class SkeletonDeserializer {

    private static final ObjectMapper objectMapper = ObjectMapperSingleton.instance.getObjectMapper();

    private final Map<String, Class<?>> javaClassCache = new HashMap<>();

    public static final SkeletonDeserializer instance = new SkeletonDeserializer();

    private SkeletonDeserializer() {
        // Singleton
    }

    public <T extends AbstractDto> T process(String payload) {
        if (payload == null || payload.isBlank()) {
            return null;
        }
        return unmarshall(payload);
    }

    private <T extends AbstractDto> T unmarshall(String payload) {
        try {
            // 1. Resolve the java type
            final var javaType = resolveJavaType(payload);
            Class<?> javaClazz = javaClassCache.get(javaType);
            if (javaClazz == null) {
                javaClazz = Class.forName(javaType);
                javaClassCache.put(javaType, javaClazz);
            }

            try (var entityStream = new ByteArrayInputStream(payload.getBytes(StandardCharsets.UTF_8))) {
                return objectMapper.readValue(entityStream, objectMapper.constructType(javaClazz));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String resolveJavaType(String payload) {
        try {
            final ObjectNode classNode = objectMapper.readValue(payload, ObjectNode.class);

            // 1. First try with @class
            final var classJsonNode = classNode.get("@class");
            if (classJsonNode != null) {
                return classJsonNode.textValue();
            }

            throw new IllegalArgumentException("No type qualifier for: " + classNode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
