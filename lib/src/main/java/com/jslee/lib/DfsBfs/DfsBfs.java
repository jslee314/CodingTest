package com.jslee.lib.DfsBfs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @DFS BFS : 탐색 알고리즘
 **/
/**
 * 1. 특정 거리의 도시 찾기 (핵심 유형)
 * 2. 연구소 (삼성)
 * 3. 경쟁적 전염 (핵심 유형)
 * 4. 괄호 변환 (카카오)
 * 5. 연산자 끼워 넣기 (삼성)
 * 6. 감시 피하기 (핵심 유형)
 * 7. 인구 이동 (삼성)
 * 8. 블록 이동하기 (카카오)
 */
public class DfsBfs {

    /**
     * @DFS :깊은 부분을 우선 탐색
     * 스택(재귀함수)자료구조 이용
     *  1. 탐색시작 노드를 스텍(ArrayList: add/get)에 삽입하고 방문처리
     *  2. 스택의 최상단 노드에 방문하지 않은 인접한 노드가 하나라도 있으면
     */

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph3 = new ArrayList<ArrayList<Integer>>();

    public static void dfs_main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph3.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 노드 정보 저장
        graph3.get(1).add(2);
        graph3.get(1).add(3);
        graph3.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph3.get(2).add(1);
        graph3.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph3.get(3).add(1);
        graph3.get(3).add(4);
        graph3.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph3.get(4).add(3);
        graph3.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph3.get(5).add(3);
        graph3.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph3.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph3.get(7).add(2);
        graph3.get(7).add(6);
        graph3.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph3.get(8).add(1);
        graph3.get(8).add(7);

        dfs(1);
    }

    // DFS 함수 정의
    public static void dfs(int x) {

        // 현재 노드를 방문 처리
        visited[x] = true;
        System.out.print(x + " ");

        // 현재 노드와 연결된 다른 노드(방문하지 않은)를 재귀적으로 방문
        // 현재노드: graph3.get(x)
        // 다른노드: graph3.get(x).get(i)
        for (int i = 0; i < graph3.get(x).size(); i++) {

            int y = graph3.get(x).get(i);
            if (!visited[y])
                dfs(y);
        }

    }

    /**
     * BFS
     * 그래프에서 가까운 노드부터 우전적으로 탐색
     * "큐" 자료구조 이용
     */
    public static boolean[] visited1 = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph4 = new ArrayList<ArrayList<Integer>>();

    // BFS 함수 정의
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        // 현재 노드를 방문 처리
        visited1[start] = true;

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            // 큐에서 하나의 원소를 뽑아 출력
            int x = q.poll();
            System.out.print(x + " ");

            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for (int i = 0; i < graph4.get(x).size(); i++) {
                int y = graph4.get(x).get(i);
                if (!visited1[y]) {
                    q.offer(y);
                    visited1[y] = true;
                }
            }
        }
    }

    public static void bfs_main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph4.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 노드 정보 저장
        graph4.get(1).add(2);
        graph4.get(1).add(3);
        graph4.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph4.get(2).add(1);
        graph4.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph4.get(3).add(1);
        graph4.get(3).add(4);
        graph4.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph4.get(4).add(3);
        graph4.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph4.get(5).add(3);
        graph4.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph4.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph4.get(7).add(2);
        graph4.get(7).add(6);
        graph4.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph4.get(8).add(1);
        graph4.get(8).add(7);

        bfs(1);
    }


    /**
     * 음료수 얼려 먹기
     */
    public static void dfs_bfs_1(String[] args) {

    }

    /**
     * 미로 탈출
     */
    public static void dfs_bfs_2(String[] args) {

    }


    /**
     * 스택 예제
     */
    public static void stack(String[] args) {
        Stack<Integer> s = new Stack<>();

        // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
        s.push(5);
        s.push(2);
        s.push(3);
        s.push(7);
        s.pop();
        s.push(4);
        s.pop();
        // 스택의 최상단 원소부터 출력
        while (!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

    /**
     * 큐 예제
     */
    public static void queue(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
        q.offer(5);
        q.offer(2);
        q.offer(3);
        q.offer(7);
        q.poll();
        q.offer(1);
        q.offer(4);
        q.poll();
        // 먼저 들어온 원소부터 추출
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }

    /**
     * 무한히 반복 재귀함수 예제
     */
    public static void recursion_1(String[] args) {
        recursiveFunction();
    }

    public static void recursiveFunction() {
        System.out.println("재귀 함수를 호출합니다.");
        recursiveFunction();
    }

    /**
     * 재귀함수의 종료 조건
     */
    public static void recursion_2(String[] args) {
        recursiveFunction(1);
    }

    public static void recursiveFunction(int i) {
        // 100번째 호출을 했을 때 종료되도록 종료 조건 명시
        if (i == 100) return;
        System.out.println(i + "번째 재귀 함수에서 " + (i + 1) + "번째 재귀함수를 호출합니다.");
        recursiveFunction(i + 1);
        System.out.println(i + "번째 재귀 함수를 종료합니다.");
    }

    /**
     * 2가지 방식으로 구현한 팩토리얼 예제
     * factorial
     */
    // 반복적으로 구현한 n!
    public static int factorialIterative(int n) {
        int result = 1;
        // 1부터 n까지의 수를 차례대로 곱하기
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 재귀적으로 구현한 n!
    public static int factorialRecursive(int n) {
        // n이 1 이하인 경우 1을 반환
        if (n <= 1) return 1;
        // n! = n * (n - 1)!를 그대로 코드로 작성하기
        return n * factorialRecursive(n - 1);
    }

    public static void factorial(String[] args) {
        // 각각의 방식으로 구현한 n! 출력(n = 5)
        System.out.println("반복적으로 구현:" + factorialIterative(5));
        System.out.println("재귀적으로 구현:" + factorialRecursive(5));
    }

    /**
     * 인접 행렬
     * procession
     */
    public static final int INF = 999999999;

    // 2차원 리스트를 이용해 인접 행렬 표현
    public static int[][] graph = {
            {0, 7, 5},
            {7, 0, INF},
            {5, INF, 0}
    };

    public static void procession(String[] args) {
        // 그래프 출력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 인접 리스트
     */
    // 행(Row)이 3개인 인접 리스트 표현
    public static ArrayList<ArrayList<Node>> graph2 = new ArrayList<ArrayList<Node>>();

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 3; i++) {
            graph2.add(new ArrayList<Node>());
        }

        // 노드 0에 연결된 노드 정보 저장 (노드, 거리)
        graph2.get(0).add(new Node(1, 7));
        graph2.get(0).add(new Node(2, 5));

        // 노드 1에 연결된 노드 정보 저장 (노드, 거리)
        graph2.get(1).add(new Node(0, 7));

        // 노드 2에 연결된 노드 정보 저장 (노드, 거리)
        graph2.get(2).add(new Node(0, 5));

        // 그래프 출력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < graph2.get(i).size(); j++) {
                graph2.get(i).get(j).show();
            }
            System.out.println();
        }
    }
}

