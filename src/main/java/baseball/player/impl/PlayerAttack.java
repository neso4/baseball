package baseball.player.impl;

import baseball.enumset.Message;
import baseball.game.Rule;
import baseball.player.Attack;
import org.slf4j.Logger;

import java.util.Scanner;

public class PlayerAttack extends Rule implements Attack {
    private final Logger logger;
    private final Scanner scanner;

    public PlayerAttack(Scanner scanner, Logger logger) {
        this.scanner = scanner;
        this.logger = logger;
    }

    @Override
    public String getBall() {
        logger.info(Message.INPUT_BALL.getMsg());
        String str = scanner.next();
        if (isValidInput(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }


}
