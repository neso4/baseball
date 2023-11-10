package baseball.enumset;

/**
 * 로그로 출력되는 메시지
 */
public enum Message {
    GET_INPUT("겹치지 않는 3자리 숫자를 입력하세요. "),
    RESULT("결과: "),
    IS_END("종료하려면 n를, 다시 시작하려면 y을 입력하세요."),
    END("게임을 종료합니다."),
    RESTART("게임을 다시 시작합니다.");
    private final String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
