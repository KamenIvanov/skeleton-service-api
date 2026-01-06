/*
 * Copyright (c) 2014, Francis Galiegue (fgaliegue@gmail.com)
 *
 * This software is dual-licensed under:
 *
 * - the Lesser General Public License (LGPL) version 3.0 or, at your option, any
 *   later version;
 * - the Apache Software License (ASL) version 2.0.
 *
 * The text of this file and of both licenses is available at the root of this
 * project or, if you have the jar distribution, in directory META-INF/, under
 * the names LGPL-3.0.txt and ASL-2.0.txt respectively.
 *
 * Direct link to the sources:
 *
 * - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
 * - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
 */
package com.pe.skeleton.api.dto.patch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * A wrapper for Patch operations. It's good to have as an input an object instead of collection,
 * because sometimes the request cannot be deserialized properly as a collection.
 * Another plus is that you can add more properties without modifying the endpoint's input type.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPatchOperationsDto {

    @JsonProperty
    protected List<JsonPatchOperationDto> operations;

    public JsonPatchOperationsDto() {
        // POJO
    }

    public JsonPatchOperationsDto(List<JsonPatchOperationDto> operations) {
        this.operations = operations;
    }

    public List<JsonPatchOperationDto> getOperations() {
        return operations;
    }

    public void setOperations(List<JsonPatchOperationDto> operations) {
        this.operations = operations;
    }
}
