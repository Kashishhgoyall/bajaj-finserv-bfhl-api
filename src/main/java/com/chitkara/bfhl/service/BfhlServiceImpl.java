package com.chitkara.bfhl.service;

import com.chitkara.bfhl.dto.BfhlRequest;
import com.chitkara.bfhl.dto.BfhlResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BfhlServiceImpl implements BfhlService {

    private static final String FULL_NAME   = "kashish";   
    private static final String DOB         = "03032006";     
    private static final String EMAIL       = "kashish1393.be23@chitkara.edu.in";
    private static final String ROLL_NUMBER = "2310991393";    
    @Override
    public BfhlResponse processData(BfhlRequest request) {

        List<String> data = request.getData();

if (data == null) {
    data = new ArrayList<>();
}

        List<String> oddNumbers       = new ArrayList<>();
        List<String> evenNumbers      = new ArrayList<>();
        List<String> alphabets        = new ArrayList<>();
        List<String> specialChars     = new ArrayList<>();
        long         sumValue         = 0;
        StringBuilder allAlphaChars   = new StringBuilder(); 

        for (String item : data) {
            if (isNumber(item)) {
                long num = Long.parseLong(item);
                sumValue += num;
                if (num % 2 == 0) {
                    evenNumbers.add(item);   
                } else {
                    oddNumbers.add(item);
                }
            } else if (isAlpha(item)) {
                
                alphabets.add(item.toUpperCase());
                
                for (char c : item.toCharArray()) {
                    allAlphaChars.append(Character.toUpperCase(c));
                }
            } else {
                specialChars.add(item);
            }
        }

        BfhlResponse response = new BfhlResponse();
        response.setSuccess(true);
        response.setUserId(FULL_NAME + "_" + DOB);
        response.setEmail(EMAIL);
        response.setRollNumber(ROLL_NUMBER);
        response.setOddNumbers(oddNumbers);
        response.setEvenNumbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecialCharacters(specialChars);
        response.setSum(String.valueOf(sumValue));
        response.setConcatString(buildConcatString(allAlphaChars.toString()));

        return response;
    }

    
    private boolean isNumber(String token) {
        if (token == null || token.isEmpty()) return false;
        try {
            Long.parseLong(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    
    private boolean isAlpha(String token) {
        if (token == null || token.isEmpty()) return false;
        for (char c : token.toCharArray()) {
            if (!Character.isLetter(c)) return false;
        }
        return true;
    }

   
    private String buildConcatString(String allUpper) {
        // Reverse
        String reversed = new StringBuilder(allUpper).reverse().toString();

        // Alternating caps
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            result.append(i % 2 == 0
                    ? Character.toUpperCase(c)
                    : Character.toLowerCase(c));
        }
        return result.toString();
    }
}
