package com.jslee.lib.DfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * *******   02 미로 탈출 **********
 *
 * 괴물(0)을 피해서 (1)로만으로
 * (1,1)에서 (width, height)까지 가는 최단거리 구하기
 *
 * DFS
 *
 */
class Ex02 {
    public static int width, height;
    public static int[][] graph = new int [201][201];
    public static int result;

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args){
        width = 6;
        height = 5;

        graph[1][1] = 1;graph[1][2] = 0;graph[1][3] = 1;graph[1][4] = 0;graph[1][5] = 1;graph[1][6] = 0;
        graph[2][1] = 1;graph[2][2] = 1;graph[2][3] = 1;graph[2][4] = 1;graph[2][5] = 1;graph[2][6] = 1;
        graph[3][1] = 0;graph[3][2] = 0;graph[3][3] = 0;graph[3][4] = 0;graph[3][5] = 0;graph[3][6] = 1;
        graph[4][1] = 1;graph[4][2] = 1;graph[4][3] = 1;graph[4][4] = 1;graph[4][5] = 0;graph[4][6] = 1;
        graph[5][1] = 1;graph[5][2] = 1;graph[5][3] = 1;graph[5][4] = 1;graph[5][5] = 0;graph[5][6] = 1;

        for(int y = 1; y<= height; y++){
            for(int x = 1; x<= width; x++){
                if(x<=0 || y<=0 || x>width || y>height) continue;
                dfs(x, y);
            }
        }
    }


    // 갓다왓거나 괴물이 있으면 0, 갈수잇는길 1
    public static void dfs(int x, int y){

        if (graph[y][x]==1) {

            graph[y][x] = 0;
            result++;

            if(y== height && x== width)
                System.out.println("result>>>> : "+result);

            for(int i=0; i<4; i++){
                int xx = x + dx[i];
                int yy = y + dy[i];
                dfs(xx, yy);
            }
        }

    }

}
//    public static int n, m;
//    public static int[][] graph = new int[201][201];
//
//    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
//    public static int dx[] = {-1, 1, 0, 0};
//    public static int dy[] = {0, 0, -1, 1};
//
//    public static int bfs(int x, int y) {
//        // 큐(Queue) 구현을 위해 queue 라이브러리 사용
//        Queue<Node> q = new LinkedList<>();
//        q.offer(new Node(x, y));
//
//        // 큐가 빌 때까지 반복하기
//        while(!q.isEmpty()) {
//            Node node = q.poll();
//            x = node.getX();
//            y = node.getY();
//            // 현재 위치에서 4가지 방향으로의 위치 확인
//            for (int i = 0; i < 4; i++) {
//                int nx = x + dx[i];
//                int ny = y + dy[i];
//                // 미로 찾기 공간을 벗어난 경우 무시
//                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
//                // 벽인 경우 무시
//                if (graph[nx][ny] == 0) continue;
//                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
//                if (graph[nx][ny] == 1) {
//                    graph[nx][ny] = graph[x][y] + 1;
//                    q.offer(new Node(nx, ny));
//                }
//            }
//        }
//        // 가장 오른쪽 아래까지의 최단 거리 반환
//        return graph[n - 1][m - 1];
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // N, M을 공백을 기준으로 구분하여 입력 받기
//        n = sc.nextInt();
//        m = sc.nextInt();
//        sc.nextLine(); // 버퍼 지우기
//
//        // 2차원 리스트의 맵 정보 입력 받기
//        for (int i = 0; i < n; i++) {
//            String str = sc.nextLine();
//            for (int j = 0; j < m; j++) {
//                graph[i][j] = str.charAt(j) - '0';
//            }
//        }
//
//        // BFS를 수행한 결과 출력
//        System.out.println(bfs(0, 0));
//    }
//}
//class Node {
//
//    private int x;
//    private int y;
//
//    public Node(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public int getX() {
//        return this.x;
//    }
//
//    public int getY() {
//        return this.y;
//    }
//}


