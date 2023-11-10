package baseball.role.impl;

import baseball.enumset.Range;
import baseball.role.Pitcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 정답을 만든다.
 */
public class Computer implements Pitcher {
    // 정답을 전달한다
    @Override
    public List<Integer> getAnswer() {
        return generateRandomNumbers();
    }

    // 정답을 생성한다
    private List<Integer> generateRandomNumbers() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < Range.MAX_LENGTH.getNum()) {
            int randomNum = random.nextInt(Range.MAX_RANDOM_BOUND.getNum()) + 1;
            if (!answer.contains(randomNum)) {
                answer.add(randomNum);
            }
        }
        return answer;
    }
}
