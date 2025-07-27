package com.jimmyproject.utils.jwt;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseProperties {
    @NotBlank
    protected String issuer = "your-app-name";///can be overridden by user
    protected long expiration = 86400000;///Default to a day

}
