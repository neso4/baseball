package baseball;

import baseball.enumset.Message;
import baseball.enumset.Result;
import baseball.role.Hitter;
import baseball.role.Judge;
import baseball.role.Pitcher;
import baseball.role.impl.BaseballJudge;
import baseball.role.impl.Computer;
import baseball.role.impl.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

// 게임의 흐름을 제어한다
public class Game {
    private final Logger log = LoggerFactory.getLogger(Game.class);
    private final Pitcher pitcher;
    private final Hitter hitter;
    private final Judge judge;
    private boolean isContinue;     // 게임이 진행되고 있는지 아닌지 나타낸다

    public Game() {
        this.isContinue = true;
        this.pitcher = new Computer();
        this.hitter = new Player();
        this.judge = new BaseballJudge(pitcher.getAnswer());
    }

    // 게임을 시작한다
    public void play() {
        while (isContinue) {
            start();
        }
        log.info(Message.IS_END.getMsg());
        String yn = getUserYn();
        if (isRestart(yn)) {
            restart();
        }
        end();
    }

    private String getUserYn() {
        Scanner scanner = new Scanner(System.in);
        String yn = scanner.next();
        if (isValidYn(yn)) {
            return yn;
        }
        throw new IllegalArgumentException();
    }

    private void end() {
        log.info(Message.END.getMsg());
    }

    private boolean isRestart(String yn) {
        if (isValidYn(yn)) {
            if (yn.contains("Y") || yn.contains("y")) {
                return true;
            }
            if (yn.contains("n") || yn.contains("N")) {
                return false;
            }
        }
        throw new IllegalArgumentException();
    }

    private boolean isValidYn(String yn) {
        boolean b = yn.length() == 1 && yn.matches("[YyNn]");
        return b;
    }

    private void start() {
        List<Integer> userInput = hitter.getUserInput();
        this.isContinue = isEnd(userInput);
    }

    // 정답이면 게임을 끝낸다
    private boolean isEnd(List<Integer> userInput) {
        String result =judge.getResult(userInput);
        log.info(Message.RESULT.getMsg() + result);
        return !result.equals(Result.ANSWER.getWord());
    }

    // 게임을 다시 시작한다
    private void restart() {
        pitcher.getAnswer();
        this.isContinue = true;
        log.info(Message.IS_END.getMsg());
        start();
    }
}