package baseball.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleTest {
    private final Rule rule = new Rule();

    @Test
    void isValidInputTest() {
        String input = "753";
        assertTrue(rule.isValidInput(input));
    }

    @Test
    void isValidInputFalseTest() {
        String input = "999";
        assertFalse(rule.isValidInput(input));
    }

    @Test
    void isValidYnTest() {
        String input = "n";
        assertTrue(rule.isValidYn(input));
    }

    @Test
    void isValidFalseTest() {
        String input = "Qw";
        assertFalse(rule.isValidYn(input));
    }
}