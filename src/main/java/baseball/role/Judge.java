package baseball.role;

import java.util.List;

public interface Judge {
    String getResult(List<Integer> userInput);
    void setAnswer(List<Integer> answer);
}
