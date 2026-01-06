package com.pe.skeleton.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kamen on 1.06.22 г.
 */
@Schema(description = "Holds information about the error that occurred.")
public class ResponseDto extends AbstractDto {

    @Schema(description = "The exact error code.")
    @JsonProperty(value = "code")
    private ErrorCodeDto code;

    @Schema(description = "The exact error messages.")
    @JsonProperty(value = "messages")
    private List<String> messages = new ArrayList<>();

    public ResponseDto() {
        // POJO
    }

    public ResponseDto(ErrorCodeDto code, List<String> messages) {
        this.code = code;
        this.messages = messages;
    }

    public ErrorCodeDto getCode() {
        return code;
    }

    public void setCode(ErrorCodeDto code) {
        this.code = code;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
