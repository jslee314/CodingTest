package com.jslee.lib.DfsBfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class DataStructure {
    /**
     * 스택 예제 push pop peek
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
    public static ArrayList<ArrayList<DNode>> graph2 = new ArrayList<ArrayList<DNode>>();

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 3; i++) {
            graph2.add(new ArrayList<DNode>());
        }

        // 노드 0에 연결된 노드 정보 저장 (노드, 거리)
        graph2.get(0).add(new DNode(1, 7));
        graph2.get(0).add(new DNode(2, 5));

        // 노드 1에 연결된 노드 정보 저장 (노드, 거리)
        graph2.get(1).add(new DNode(0, 7));

        // 노드 2에 연결된 노드 정보 저장 (노드, 거리)
        graph2.get(2).add(new DNode(0, 5));

        // 그래프 출력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < graph2.get(i).size(); j++) {
                graph2.get(i).get(j).show();
            }
            System.out.println();
        }
    }
}
// fro 인접 리스트
class DNode {

    private int index;
    private int distance;

    public DNode(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public void show() {
        System.out.print("(" + this.index + "," + this.distance + ") ");
    }

}