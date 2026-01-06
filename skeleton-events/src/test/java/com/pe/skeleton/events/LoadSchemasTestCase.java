package com.pe.skeleton.events;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class LoadSchemasTestCase {

    @Test
    void loadAvroSchema() {
        final var text = AllEventsRegistry.getAvroSchema();
        Assertions.assertNotNull(text);
    }

    @Test
    void loadBuildInfo() {
        Map<String, String> buildInfoProps = AllEventsRegistry.getBuildInfo();
        //
        Assertions.assertNotNull(buildInfoProps);
        Assertions.assertNotEquals(0, buildInfoProps.size());
    }
}
