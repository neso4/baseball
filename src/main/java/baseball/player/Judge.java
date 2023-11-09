package baseball.player;

public interface Judge {
    void setAnswer(String answer);

    String getResult(String input);

    boolean isRestart(String yn);
}
