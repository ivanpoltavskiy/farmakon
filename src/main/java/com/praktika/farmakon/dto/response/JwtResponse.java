package com.praktika.farmakon.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponse {
    @JsonProperty("Token")
    String token;
}
