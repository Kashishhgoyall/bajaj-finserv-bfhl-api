package com.chitkara.bfhl.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * Request DTO for the /bfhl endpoint.
 * Contains the input array of mixed data types as strings.
 */
public class BfhlRequest {

    @NotNull(message = "data field must not be null")
    private List<String> data;

    public BfhlRequest() {}

    public BfhlRequest(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
