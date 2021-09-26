# 백준 1406 - 에디터

### 알고리즘 분류

- 자료구조

- 스택

- 연결 리스트

## 풀이

처음 문제를 풀 때는 연결 리스트를 사용하여 문자열을 저장하고 조작하도록 하였으나, BuffredReader, BufferedWriter를 사용하였음에도 불구하고 시간초과가 발생하였다.

알아보니 자바 LinkedList에서 삽입, 삭제에 소요되는 시간 복잡도가 O(N)이기 때문에 시간초과가 발생한 것이었다.

그래서 결국 답을 찾아 보았는데, 스택 2개를 이용하여 하나는 커서의 왼쪽을 나타내고, 나머지 하나는 커서의 오른쪽을 나타내도록 하여 문제를 해결하는 방법이었다. 이렇게 하면 삽입, 삭제, 커서 이동 등 문제에서 주어진 모든 연산에 대해 O(1) 시간이 소요되어 전체 문제에 대해 스택에서 문자를 꺼내는 시간인 O(N)으로 해결 가능하였다.

String 에 +로 문자열을 이어 붙이는 것보다 StringBuilder에 append()함수를 이용하여 문자열을 이어 붙이는 것이 속도가 빠르다.