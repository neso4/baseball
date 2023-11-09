package baseball.enumset;

// 게임에서 사용되는 수치
public enum Range {
    MAX_LENGTH(3), MAX_BOUND(9);

    private final int num;

    Range(int i) {
        this.num = i;
    }

    public int getNum() {
        return num;
    }
}