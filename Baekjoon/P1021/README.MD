# 백준 1021 - 회전하는 큐

### 알고리즘 분류

- 자료구조

- 덱

## 풀이

중간 요소에 접근할 수 있는 자료 구조를 사용하였으면 더 쉽게 풀 수 있었겠지만, 덱의 사용법에 대해 공부하면서 푼 문제이기 때문에 좀 어렵게 풀었다.

1. 2개의 덱을 선언한다.

2. 1부터 N까지의 수를 한 쪽 덱(A)에 순서대로 넣는다. (비어있는 덱은 B)

3. A의 뒷 부분에서 숫자를 하나씩 빼내면서, 주어진 수와 맞는지 비교한 후, 카운트를 1 증가시키고, B의 앞 부분에 집어 넣는다.

4. 주어진 수와 A의 뒷 부분에서 빼낸 숫자가 일치하면, 그 수는 B에 넣지 않는다.

5. A에 남아있는 수를 앞에서 부터 빼내어 B의 뒷 부분에 집어 넣는다.

6. 카운트가 남아있는 수의 개수 / 2 보다 큰 경우 카운트를 (N - 카운트)로 바꾼다. (왼쪽 이동이 더 빠른 경우)

7. 카운트를 정답 변수에 더한다.

8. 주어진 나머지 모든 수에 대해 3 ~ 7번 과정을 A와 B를 바꾸어 적용시킨다.


