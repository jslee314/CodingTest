package com.jslee.lib.DfsBfs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @DFS BFS : 탐색 알고리즘
 **/

/**
 * 01. 음료수 얼려먹기
 * 02.
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
     * 1. 탐색시작 노드를 스텍(ArrayList: add/get)에 삽입하고 방문처리
     * 2. 스택의 최상단 노드에 방문하지 않은 인접한 노드가 하나라도 있으면
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

            int y = graph3.get(x).get(i);   // 연결된 노드의 값
            if (!visited[y])    // 방문한적이 없으
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


}
