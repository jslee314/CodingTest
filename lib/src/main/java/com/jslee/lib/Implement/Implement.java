package com.jslee.lib.Implement;

import java.util.Scanner;

/**
 * @구현(implement) : 아이디어를 코드로 바꾸는 구현
 **/
/**
 * 1. 럭키 스트레이트 (핵심 유형): (Python 3.7 코드 / C++ 코드 / Java 코드)
 * 2. 문자열 재정렬 (Facebook 인터뷰 기출): (Python 3.7 코드 / C++ 코드 / Java 코드)
 * 3. 문자열 압축 (카카오): (Python 3.7 코드 / C++ 코드 / Java 코드)
 * 4. 자물쇠와 열쇠 (카카오): (Python 3.7 코드 / C++ 코드 / Java 코드)
 * 5. 뱀 (삼성): (Python 3.7 코드 / C++ 코드 / Java 코드)
 * 6. 기둥과 보 설치 (카카오): (Python 3.7 코드 / C++ 코드 / Java 코드)
 * 7. 치킨 배달 (삼성): (Python 3.7 코드 / C++ 코드 / Java 코드)
 * 8. 외벽 점검 (카카오): (Python 3.7 코드 / C++ 코드 / Java 코드)
 */
public class Implement {

    // -------------------------------------------------------------------------------------------
    // 1. 상하좌우 :
    public static void implement_1(String[] args){
        Scanner sc = new Scanner(System.in);

        // N을 입력받기
        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        String[] plans = sc.nextLine().split(" ");
        int x = 1, y = 1;

        // L, R, U, D에 따른 이동 방향
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        // 이동 계획을 하나씩 확인
        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);
            // 이동 후 좌표 구하기
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            // 공간을 벗어나는 경우 무시
            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
            // 이동 수행
            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }


    // -------------------------------------------------------------------------------------------
    // 2. 시각 : 특정 시간안에 3이 몇번 포함되었나
    public static void implement_2(String[] args){
        Scanner sc = new Scanner(System.in);

        // H를 입력받기
        int h = sc.nextInt();
        int cnt = 0;

        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    // 매 시각 안에 '3'이 포함되어 있다면 카운트 증가
                    if (check(i, j, k)) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    // 특정한 시각 안에 '3'이 포함되어 있는지의 여부
    public static boolean check(int h, int m, int s) {
        if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
            return true;
        return false;
    }


    // -------------------------------------------------------------------------------------------
    // 3. 왕실의 나이트
    public static void implement_3(String[] args){
        Scanner sc = new Scanner(System.in);

        // 현재 나이트의 위치 입력받기
        String inputData = sc.nextLine();
        int row = inputData.charAt(1) - '0';
        int column = inputData.charAt(0) - 'a' + 1;

        // 나이트가 이동할 수 있는 8가지 방향 정의
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        int result = 0;
        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치 확인
            int nextRow = row + dx[i];
            int nextColumn = column + dy[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                result += 1;
            }
        }

        System.out.println(result);
    }


    // -------------------------------------------------------------------------------------------
    // 4. 게임 개발
    public static void implement_4(String[] args){

    }

}
