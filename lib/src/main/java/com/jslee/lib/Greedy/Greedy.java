package com.jslee.lib.Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @그리디(Greedy) : 당장 좋은것만 선택하는 그리디
 **/
/**
 * 1. 모험가 길드 (핵심 유형)
 * 2. 곱하기 혹은 더하기 (Facebook 인터뷰 기출)
 * 3. 문자열 뒤집기 (핵심 유형)
 * 4. 만들 수 없는 금액 (K 대회 기출)
 * 5. 볼링공 고르기 (S 기관 입학 테스트)
 * 6. 무지의 먹방 라이브 (카카오)
 */
public class Greedy {

    // 1. 거스름돈 문제
    public static void Greedy_1(String[] args){
        int n = 1260;
        int cnt = 0;
        int[] coinTypes = {500, 100, 50, 10};

        for (int i = 0; i < 4; i++) {
            int coin = coinTypes[i];
            cnt += n / coin;
            n %= coin;
        }

        System.out.println(cnt);
    }
    // -------------------------------------------------------------------------------------------
    // 2. 큰 수의 법칙
    public static void Greedy_2(String[] args){
        Scanner sc = new Scanner(System.in);

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 입력 받은 수들 정렬하기
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1);

        int result = 0;
        result += cnt * first; // 가장 큰 수 더하기
        result += (m - cnt) * second; // 두 번째로 큰 수 더하기

        System.out.println(result);
    }

    // -------------------------------------------------------------------------------------------
    // 3. 숫자 카드 게임
    public static void Greedy_3(String[] args){
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        // 한 줄씩 입력 받아 확인하기
        for (int i = 0; i < n; i++) {
            // 현재 줄에서 '가장 작은 수' 찾기
            int min_value = 10001;
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                min_value = Math.min(min_value, x);
            }
            // '가장 작은 수'들 중에서 가장 큰 수 찾기
            result = Math.max(result, min_value);
        }

        System.out.println(result); // 최종 답안 출력
    }

    // -------------------------------------------------------------------------------------------
    // 4. 1이 될 때까지
    public static void Greedy_4(String[] args){

        Scanner sc = new Scanner(System.in);

        // N, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (true) {
            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int target = (n / k) * k;
            result += (n - target);
            n = target;
            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) break;
            // K로 나누기
            result += 1;
            n /= k;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        result += (n - 1);
        System.out.println(result);

    }


}
