package com.jslee.lib.Implement;

/**
 * 럭키 스트레이트
 *
 * 자리수를 기준으로 반을 나누었을때
 * 왼쪾꽈 오른쪽 각 자리수의 합을 더한 값이 동일할때 러키 스트레이트 기술을 쓸 수 있다
 * 점수 n이 주어졌을 때 이 기술을 사용할수 있는 상태인지 알려주는 함수를 구현해라
 *
 * - 10<=n<=99,999,999
 * - n의 자릿수는 항상 짝수
 *
 * 예시 1
 *  입력: n = 123402
 *  출력: LUCKY
 *
 *  예시 2
 *  입력: n = 7755
 *  출력: READY
 */
public class Test01 {
    public static int n = 123402;

    public static void main() {
        String result;
        String nString = Integer.toString(n);
        int length = nString.length();

        int leftSum = calculate(nString, 1, length / 2);
        int rightSum = calculate(nString, length / 2 + 1, length);

        if (leftSum == rightSum) result = "LUCKY";
        result = "READY";
        System.out.println(result);
    }

    public static int calculate(String nString, int start, int end) {
        int sum = 0;
        for (int i = 0; i < end; i++) {
            String now = nString.substring(i, i + 1);
            sum = sum + Integer.parseInt(now);

        }

        return sum;
    }
}
