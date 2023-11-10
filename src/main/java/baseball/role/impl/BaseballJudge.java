package baseball.role.impl;

import baseball.enumset.Result;
import baseball.role.Judge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 정답을 판단한다.
 */
public class BaseballJudge implements Judge {
    private final Logger log = LoggerFactory.getLogger(BaseballJudge.class);
    private List<Integer> answer;

    public BaseballJudge(List<Integer> answer) {
        this.answer = answer;
    }

    // 결과 문자열을 반환한다
    @Override
    public String getResult(List<Integer> userInput) {
        String s = makeResult(userInput);
        return s;
    }

    @Override
    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    // 결과를 문자열을 만든다
    private String makeResult(List<Integer> userInput) {
        if (isAnswer(userInput)) {
            return Result.ANSWER.getWord();
        }
        int ball = getBallCount(userInput);
        int strike = getStrikeCount(userInput);
        if (ball > 0 && strike == 0) {
            return ball + Result.BALL.getWord();
        }
        if (ball == 0 && strike > 0) {
            return strike + Result.STRIKE.getWord();
        }
        return ball + Result.BALL.getWord() + " " + strike + Result.STRIKE.getWord();
    }

    // 정답인지 판단한다
    private boolean isAnswer(List<Integer> userInput) {
        return answer.equals(userInput);
    }

    // 볼 개수를 계산한다
    private int getBallCount(List<Integer> userInput) {
        int ball = 0;
        for (Integer i : userInput) {
            if (answer.contains(i) && (answer.indexOf(i) != userInput.indexOf(i))) {
                ball++;
            }
        }
        return ball;
    }

    // 스트라이트 개수를 계산한다
    private int getStrikeCount(List<Integer> userInput) {
        int strike = 0;
        for (Integer i : userInput) {
            if (answer.contains(i) && (answer.indexOf(i) == userInput.indexOf(i))) {
                strike++;
            }
        }
        return strike;
    }
}
