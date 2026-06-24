package com.chitkara.bfhl;

import com.chitkara.bfhl.dto.BfhlRequest;
import com.chitkara.bfhl.dto.BfhlResponse;
import com.chitkara.bfhl.service.BfhlService;
import com.chitkara.bfhl.service.BfhlServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BfhlServiceTest {

    private BfhlService service;

    @BeforeEach
    void setUp() {
        service = new BfhlServiceImpl();
    }

    // ── Example A ────────────────────────────────────────────────────────────
    @Test
    void testExampleA_numbers() {
        BfhlRequest req = new BfhlRequest(Arrays.asList("a", "1", "334", "4", "R", "$"));
        BfhlResponse res = service.processData(req);

        assertTrue(res.isSuccess());
        assertEquals(List.of("1"), res.getOddNumbers());
        assertEquals(List.of("334", "4"), res.getEvenNumbers());
        assertEquals("339", res.getSum());
    }

    @Test
    void testExampleA_alphabetsAndSpecial() {
        BfhlRequest req = new BfhlRequest(Arrays.asList("a", "1", "334", "4", "R", "$"));
        BfhlResponse res = service.processData(req);

        assertEquals(List.of("A", "R"), res.getAlphabets());
        assertEquals(List.of("$"), res.getSpecialCharacters());
    }

    @Test
    void testExampleA_concatString() {
        BfhlRequest req = new BfhlRequest(Arrays.asList("a", "1", "334", "4", "R", "$"));
        BfhlResponse res = service.processData(req);

        // Chars collected: A, R → reversed: RA → alternating: Ra
        assertEquals("Ra", res.getConcatString());
    }

    // ── Example B ────────────────────────────────────────────────────────────
    @Test
    void testExampleB_numbers() {
        BfhlRequest req = new BfhlRequest(Arrays.asList("2", "a", "y", "4", "&", "-", "*", "5", "92", "b"));
        BfhlResponse res = service.processData(req);

        assertEquals(List.of("5"), res.getOddNumbers());
        assertEquals(List.of("2", "4", "92"), res.getEvenNumbers());
        assertEquals("103", res.getSum());
    }

    @Test
    void testExampleB_alphabetsAndSpecial() {
        BfhlRequest req = new BfhlRequest(Arrays.asList("2", "a", "y", "4", "&", "-", "*", "5", "92", "b"));
        BfhlResponse res = service.processData(req);

        assertEquals(List.of("A", "Y", "B"), res.getAlphabets());
        assertEquals(List.of("&", "-", "*"), res.getSpecialCharacters());
    }

    @Test
    void testExampleB_concatString() {
        BfhlRequest req = new BfhlRequest(Arrays.asList("2", "a", "y", "4", "&", "-", "*", "5", "92", "b"));
        BfhlResponse res = service.processData(req);

        // Chars: A, Y, B → reversed: BYA → alternating: ByA
        assertEquals("ByA", res.getConcatString());
    }

    // ── Example C ────────────────────────────────────────────────────────────
    @Test
    void testExampleC_noNumbers() {
        BfhlRequest req = new BfhlRequest(Arrays.asList("A", "ABCD", "DOE"));
        BfhlResponse res = service.processData(req);

        assertTrue(res.getOddNumbers().isEmpty());
        assertTrue(res.getEvenNumbers().isEmpty());
        assertEquals("0", res.getSum());
        assertTrue(res.getSpecialCharacters().isEmpty());
    }

    @Test
    void testExampleC_alphabets() {
        BfhlRequest req = new BfhlRequest(Arrays.asList("A", "ABCD", "DOE"));
        BfhlResponse res = service.processData(req);

        assertEquals(List.of("A", "ABCD", "DOE"), res.getAlphabets());
    }

    @Test
    void testExampleC_concatString() {
        BfhlRequest req = new BfhlRequest(Arrays.asList("A", "ABCD", "DOE"));
        BfhlResponse res = service.processData(req);

        // Chars collected (upper): A A B C D D O E → reversed: E O D D C B A A
        // Alternating: E o D d C b A a → "EoDdCbAa"
        assertEquals("EoDdCbAa", res.getConcatString());
    }

    // ── Edge cases ───────────────────────────────────────────────────────────
    @Test
    void testEmptyData() {
        BfhlRequest req = new BfhlRequest(List.of());
        BfhlResponse res = service.processData(req);

        assertTrue(res.isSuccess());
        assertTrue(res.getOddNumbers().isEmpty());
        assertTrue(res.getEvenNumbers().isEmpty());
        assertEquals("0", res.getSum());
        assertEquals("", res.getConcatString());
    }

    @Test
    void testOnlySpecialChars() {
        BfhlRequest req = new BfhlRequest(Arrays.asList("@", "#", "!"));
        BfhlResponse res = service.processData(req);

        assertEquals(List.of("@", "#", "!"), res.getSpecialCharacters());
        assertTrue(res.getOddNumbers().isEmpty());
        assertTrue(res.getEvenNumbers().isEmpty());
        assertTrue(res.getAlphabets().isEmpty());
        assertEquals("0", res.getSum());
    }

    @Test
    void testIsSuccessAlwaysTrue() {
        BfhlRequest req = new BfhlRequest(List.of("1", "a"));
        BfhlResponse res = service.processData(req);
        assertTrue(res.isSuccess());
    }
}
