package com.pe.skeleton.events;

import com.pe.skeleton.events.account.AccountBatchEventDto;
import com.pe.skeleton.events.account.AccountEventDto;
import com.pe.skeleton.events.publication.PublicationBatchEventDto;
import com.pe.skeleton.events.publication.PublicationEventDto;
import org.apache.avro.reflect.Union;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@Union({
        AccountEventDto.class,
        AccountBatchEventDto.class,
        PublicationEventDto.class,
        PublicationBatchEventDto.class
})
public interface AllEventsRegistry {

    static String getAvroSchema() {
        final String fileName = "schema.avsc";
        try (var inputStream = AllEventsRegistry.class.getResourceAsStream(fileName)) {
            return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to read: " + fileName, e);
        }
    }

    static Map<String, String> getBuildInfo() {
        final String fileName = "build-info.properties";
        try (var inputStream = AllEventsRegistry.class.getResourceAsStream(fileName)) {
            final var properties = new Properties();
            properties.load(inputStream);
            return new HashMap<>((Map) properties);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read: " + fileName, e);
        }
    }
}
