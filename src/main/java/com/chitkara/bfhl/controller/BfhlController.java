package com.chitkara.bfhl.controller;

import com.chitkara.bfhl.dto.BfhlRequest;
import com.chitkara.bfhl.dto.BfhlResponse;
import com.chitkara.bfhl.service.BfhlService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller exposing the /bfhl endpoint.
 */
@RestController
@RequestMapping("/bfhl")
public class BfhlController {

    private final BfhlService bfhlService;

    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }
    @GetMapping
    public ResponseEntity<String> getInfo() {
        return ResponseEntity.ok("BFHL API is running. Use POST request on this endpoint.");
    }
    /**
     * POST /bfhl
     * Accepts a JSON body with a "data" array and returns categorized results.
     */
    @PostMapping
    public ResponseEntity<BfhlResponse> processData(@Valid @RequestBody BfhlRequest request) {
        BfhlResponse response = bfhlService.processData(request);
        return ResponseEntity.ok(response);
    }
}
