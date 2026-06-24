package com.chitkara.bfhl.service;

import com.chitkara.bfhl.dto.BfhlRequest;
import com.chitkara.bfhl.dto.BfhlResponse;

/**
 * Service interface for processing BFHL requests.
 */
public interface BfhlService {

    /**
     * Processes the input data array and returns categorized results.
     *
     * @param request the incoming request containing the data array
     * @return a fully populated BfhlResponse
     */
    BfhlResponse processData(BfhlRequest request);
}
