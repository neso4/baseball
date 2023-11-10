package baseball.role.impl;

import baseball.enumset.Message;
import baseball.enumset.Range;
import baseball.role.Hitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 규칙에 맞는 숫자를 입력한다.
 */
public class Player implements Hitter {
    private final Logger log = LoggerFactory.getLogger(Player.class);

    // 입력된 값을 전달한다
    @Override
    public List<Integer> getUserInput() {
        return getUserInputToList();
    }

    // 사용자로부터 입력을 받는다
    private List<Integer> getUserInputToList() {
        Scanner scanner = new Scanner(System.in);
        log.info(Message.GET_INPUT.getMsg());
        String userInput = scanner.next();
        if (isValidInput(userInput)) {
            return convertStringToIntList(userInput);
        }
        throw new IllegalArgumentException();
    }

    // 문자열을 int 리스트로 변환한다
    private List<Integer> convertStringToIntList(String userInput) {
        List<Integer> result = new ArrayList<>();
        String[] split = userInput.split("");
        Arrays.stream(split).iterator().forEachRemaining(s ->
                result.add(Integer.parseInt(s)));
        return result;
    }

    // 배열이 모든 규칙에 맞는지 판단한다
    private boolean isValidInput(String userInput) {
        return (isRightLength(userInput) &&
                isAllNumber(userInput) &&
                isDuplicate(userInput) &&
                isZero(userInput));
    }

    // 3 글자 인지 판단한다
    private boolean isRightLength(String userInput) {
        return userInput.length() == Range.MAX_LENGTH.getNum();
    }

    // 숫자로만 이루어져 있는지 판단한다
    private boolean isAllNumber(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    // 중복된 숫자가 없는지 판단한다
    private boolean isDuplicate(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (userInput.indexOf(c) != userInput.lastIndexOf(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isZero(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (c == '0') {
                return false;
            }
        }
        return true;
    }
}
