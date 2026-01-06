package com.pe.skeleton.events;

import com.fasterxml.jackson.dataformat.avro.AvroMapper;
import com.fasterxml.jackson.dataformat.avro.schema.AvroSchemaGenerator;
import org.junit.jupiter.api.Test;

class GenerateSchemaWithJacksonTestCase {

    @Test
    void generateSchema() throws Exception {
        final var avroMapper = new AvroMapper();
        avroMapper.findAndRegisterModules();
        final var avroSchemaGenerator = new AvroSchemaGenerator();
        avroSchemaGenerator.enableLogicalTypes();
        avroMapper.acceptJsonFormatVisitor(AllEventsRegistry.class, avroSchemaGenerator);
        final var schema = avroSchemaGenerator.getGeneratedSchema().getAvroSchema();
        final var jsonSchema = schema.toString(true);
        System.out.println("Generated Avro Schema:\n" + jsonSchema);
    }
}
