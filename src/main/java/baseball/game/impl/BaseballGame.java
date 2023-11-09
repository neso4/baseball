package baseball.game.impl;

import baseball.enumset.Message;
import baseball.enumset.Result;
import baseball.game.Game;
import baseball.player.Attack;
import baseball.player.Defence;
import baseball.player.Judge;
import baseball.player.impl.BaseballJudge;
import baseball.player.impl.ComputerDefence;
import baseball.player.impl.PlayerAttack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

// 공격, 방어, 심판 객체를 받아 게임을 만드는 클래스이다.
// 프로젝트 전체의 의존성도 관리한다.
public class BaseballGame implements Game {
    private static final Logger logger = LoggerFactory.getLogger(BaseballGame.class);
    private static final Scanner scanner = new Scanner(System.in);
    private final Attack attack;
    private final Defence defence;
    private final Judge judge;
    private boolean isContinue;


    public BaseballGame() {
        this.attack = new PlayerAttack(scanner, logger);
        this.defence = new ComputerDefence();
        this.judge = new BaseballJudge(defence.getAnswer());
        this.isContinue = true;
    }

    @Override
    public void playGame() {
        while (this.isContinue) {
            gameStart();
        }
        gameEnd();
    }

    private void gameStart() {
        String ball = attack.getBall();
        String result = judge.getResult(ball);
        logger.info(Message.RESULT.getMsg() + result);
        if (result.equals(Result.ANSWER.getWord())) {
            logger.info(Message.IS_END.getMsg());
            String yn = scanner.next();
            this.isContinue = judge.isRestart(yn);
            if (this.isContinue) {
                gameRestart();
            }
        }
    }

    private void gameEnd() {
        logger.info(Message.END.getMsg());
    }

    private void gameRestart() {
        logger.info(Message.RESTART.getMsg());
        judge.setAnswer(defence.getAnswer());
    }
}
