package com.jslee.lib.DfsBfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 ****************    경쟁적 전염 (핵심)   ***************
 * n x n 크기의 시험
 * k 종류의 바이러스는 1초마다 각각 상하좌우로 번식한다
 * 바이러스가 겹치면 작은 숫자가 우선한다
 *
 * s초 후 (x, y) 위에 존재하는 바이러스 종류는?
 *
 * */
class Virus implements Comparable<Virus> {

    private int index;
    private int second;
    private int x;
    private int y;

    public Virus(int index, int second, int x, int y) {
        this.index = index;
        this.second = second;
        this.x = x;
        this.y = y;
    }

    public int getIndex() {
        return this.index;
    }

    public int getSecond() {
        return this.second;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // 정렬 기준은 '번호가 낮은 순서'
    @Override
    public int compareTo(Virus other) {
        if (this.index < other.index) {
            return -1;
        }
        return 1;
    }
}

class Main {

    public static int n, k;
    // 전체 보드 정보를 담는 배열
    public static int[][] graph = new int[200][200];
    public static ArrayList<Virus> viruses = new ArrayList<Virus>();

    // 바이러스가 퍼져나갈 수 있는 4가지의 위치
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                // 해당 위치에 바이러스가 존재하는 경우
                if (graph[i][j] != 0) {
                    // (바이러스 종류, 시간, 위치 X, 위치 Y) 삽입
                    viruses.add(new Virus(graph[i][j], 0, i, j));
                }
            }
        }

        // 정렬 이후에 큐로 옮기기 (낮은 번호의 바이러스가 먼저 증식하므로)
        Collections.sort(viruses);
        Queue<Virus> q = new LinkedList<Virus>();
        for (int i = 0; i < viruses.size(); i++) {
            q.offer(viruses.get(i));
        }

        int targetS = sc.nextInt();
        int targetX = sc.nextInt();
        int targetY = sc.nextInt();

        // 너비 우선 탐색(BFS) 진행
        while (!q.isEmpty()) {
            Virus virus = q.poll();
            // 정확히 second만큼 초가 지나거나, 큐가 빌 때까지 반복
            if (virus.getSecond() == targetS) break;
            // 현재 노드에서 주변 4가지 위치를 각각 확인
            for (int i = 0; i < 4; i++) {
                int nx = virus.getX() + dx[i];
                int ny = virus.getY() + dy[i];
                // 해당 위치로 이동할 수 있는 경우
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    // 아직 방문하지 않은 위치라면, 그 위치에 바이러스 넣기
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = virus.getIndex();
                        q.offer(new Virus(virus.getIndex(), virus.getSecond() + 1, nx, ny));
                    }
                }
            }
        }

        System.out.println(graph[targetX - 1][targetY - 1]);
    }
}