package com.jslee.lib.DfsBfs;

/**
 * ******** 01 음료수 얼려먹기 *********
 *
 * 연결 컴포넌트들의  갯수
 * 핵심: 첫방문일때만 카운트 센다
 *
 * DFS
 *
 */
public class Ex01 {

    public static int n, m;
    public static int[][] graph = new int[1000][1000];

    public static int dw[] = {-1, 1, 0, 0};
    public static int dh[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        int result = 0;
        n = 3;  m = 3;
        graph[0][0] = 0;    graph[0][1] = 0;    graph[0][2] = 1;
        graph[1][0] = 0;    graph[1][1] = 1;    graph[1][2] = 0;
        graph[2][0] = 1;    graph[2][1] = 0;    graph[2][2] = 1;

        for (int h=0; h<3; h++){
            for (int w=0; w<3; w++){
                if(dfs(w, h)) {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }

    public static boolean dfs(int w, int h){
        if (w<0 || h<0 || w >=3 || h>=3)
            return false;

        if(graph[w][h]==0){
            graph[w][h] = 1;

            for (int i =0; i<4; i++){
                int ww = w + dw[i];
                int hh = h + dh[i];
                dfs(hh, ww);

            }
            return true;
        }
        return false;
    }
}
