package baseball.enumset;

/**
 * 입력 결과에 대한 메시지
 */
public enum Result {
    ANSWER("정답"),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String word;

    Result(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
