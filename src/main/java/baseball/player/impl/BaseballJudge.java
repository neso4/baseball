package baseball.player.impl;

import baseball.enumset.Range;
import baseball.enumset.Result;
import baseball.game.Rule;
import baseball.player.Judge;

public class BaseballJudge extends Rule implements Judge {
    private String answer;

    public BaseballJudge(String answer) {
        this.answer = answer;
    }

    @Override
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    // 결과 문자열을 얻는다.
    @Override
    public String getResult(String input) {
        int strike = getStrike(input);
        int ball = getBall(input);
        return createResult(strike, ball);
    }

    @Override
    // 게임 재시작 여부 판단
    public boolean isRestart(String yn) {
        String y = "[y|Y]";
        String n = "[n|N]";
        if (isValidYn(yn)) {
            if (yn.matches(y)) {
                return true;
            } else if (yn.matches(n)) {
                return false;
            }
        }
        throw new IllegalArgumentException();
    }

    // 스트라이트 갯수를 계산한다.
    private int getStrike(String input) {
        String answer = this.answer;
        int result = 0;
        for (int i = 0; i < Range.MAX_LENGTH.getNum(); i++) {
            String digit = Character.toString(input.charAt(i));
            if (answer.contains(digit) && answer.indexOf(digit) == i) {
                result++;
            }
        }
        return result;
    }

    // 볼 갯수를 계산한다.
    private int getBall(String input) {
        String answer = this.answer;
        int result = 0;
        for (int i = 0; i < Range.MAX_LENGTH.getNum(); i++) {
            String digit = Character.toString(input.charAt(i));
            if (answer.contains(digit) && answer.indexOf(digit) != i) {
                result++;
            }
        }
        return result;
    }

    // 볼과 스트라이크의 개수를 비교해 결과 문자열을 만든다.
    private String createResult(int strike, int ball) {
        String result;
        if (strike == Range.MAX_LENGTH.getNum()) {
            result = Result.ANSWER.getWord();
        } else if (strike > 0 && ball > 0) {
            result = ball + " " + Result.BALL.getWord() + ", " + strike + " " + Result.STRIKE.getWord();
        } else if (strike > 0 && ball == 0) {
            result = strike + " " + Result.STRIKE.getWord();
        } else if (strike == 0 && ball > 0) {
            result = ball + " " + Result.BALL.getWord();
        } else {
            result = Result.NOTHING.getWord();
        }
        return result;
    }
}
