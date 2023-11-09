package baseball.player.impl;

import baseball.enumset.Range;
import baseball.player.Defence;

import java.util.Random;

public class ComputerDefence implements Defence {
    @Override
    public String getAnswer() {
        return getRandomNumber();
    }

    private String getRandomNumber() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        Range max = Range.MAX_LENGTH;
        String result = "";
        while (result.length() < max.getNum()) {
            int randomNumber = random.nextInt(Range.MAX_BOUND.getNum()) + 1;
            String s = String.valueOf(randomNumber);
            if (!result.contains(s)) {
                result = result.concat(s);
            }
        }
        return result;
    }
}
