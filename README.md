# OOP_숫자야구게임.txt

기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼,
같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고,
그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.

__예) 상대방(컴퓨터)의 수가 425일 때__

* 123을 제시한 경우 : 1스트라이크
* 456을 제시한 경우 : 1볼 1스트라이크
* 789를 제시한 경우 : 낫싱

위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다.
컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

# 정리

### 역할

* 공격(Attack)
    * 숫자를 맞힌다.
* 방어(Defence)
    * 맞힐 숫자를 만든다.
* 심판(Judge)
    * 공격이 입력한 숫자와 방어가 제시한 숫자를 비교해 결과를 판단한다.
    * 게임을 계속 진행할 지 판단한다.

### 조건

* 입력
    * 정확히 3 글자여야한다.
    * 숫자로만 이루어져야 한다.
    * 중복되는 숫자가 있으면 안된다.
* 결과
    * 같은 수가 같은 자리에 있으면 `스트라이크`이다.
    * 같은 수가 다른 자리에 있으면 `볼`이다.
    * 같은 수가 하나도 없으면 `낫싱`이다.
    * 전부 일치하면 `정답`으로 게임이 끝난다.
* 종료
    * 조건에 맞지 않는 문자열을 입력한다.
    * 정답을 맞힌 후 종료하도록 결정한다.

----

### 참고 페이지

__자바 문법__

* [[JAVA] 난수(랜덤 숫자) 생성 방법(Math.random, Random)](https://crazykim2.tistory.com/598)
* [[JAVA] 자바_contains (문자열 포함 여부 확인)](https://mine-it-record.tistory.com/137)
* [[Java] 문자열이 숫자인지 판별](https://pridiot.tistory.com/34)
* [자바 enum 열거형 타입 문법 정리](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%97%B4%EA%B1%B0%ED%98%95Enum-%ED%83%80%EC%9E%85-%EB%AC%B8%EB%B2%95-%ED%99%9C%EC%9A%A9-%EC%A0%95%EB%A6%AC)

__OOP__

* [의존관계 주입(Dependency Injection) 쉽게 이해하기](https://tecoble.techcourse.co.kr/post/2021-04-27-dependency-injection/)
* [[OOP] 객체지향의 특징 - 캡슐화(Encapsulation)와 정보 은닉](https://blog.itcode.dev/posts/2021/08/08/encapulation)