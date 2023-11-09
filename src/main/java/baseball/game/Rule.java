package baseball.game;

import baseball.enumset.Range;

public class Rule {
    // 입력이 규칙에 맞는지 판단
    public boolean isValidInput(String input) {
        return isValidLength(input)
                && isNotDuplicate(input)
                && isNotZero(input)
                && isNumber(input);
    }

    // 사용자가 Y나 N을 제대로 입력했는지 판단
    public boolean isValidYn(String input) {
        String pattern = "[yYnN]";
        return input.length() == 1 && input.matches(pattern);
    }

    // 문자열의 길이가 올바른지 판단
    private boolean isValidLength(String s) {
        return s.length() == Range.MAX_LENGTH.getNum();
    }

    // 숫자 0이 포함되어 있는지 판단
    private boolean isNotZero(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                return false;
            }
        }
        return true;
    }

    // 숫자로만 이루어져 있는지 판단
    private boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    // 중복되는 숫자가 있는지 판단
    private boolean isNotDuplicate(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) != s.lastIndexOf(c)) {
                return false;
            }
        }
        return true;
    }
}
