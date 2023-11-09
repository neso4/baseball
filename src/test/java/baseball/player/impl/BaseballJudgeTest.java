package baseball.player.impl;

import baseball.player.Judge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballJudgeTest {
    private final Judge judge = new BaseballJudge(new ComputerDefence().getAnswer());

    @Test
    void isRestartThrowsExceptionTest() {
        String input = "qqq";

        assertThrows(IllegalArgumentException.class, () -> judge.isRestart(input));
    }
}