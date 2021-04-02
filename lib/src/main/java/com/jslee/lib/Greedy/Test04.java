package com.jslee.lib.Greedy;
/**
 * 만들 수 없는 금액
 *
 *
 * 예시 1
 * 입력:
 * 출력:
 *
 *
 * 예시 2
 * 입력:
 * 출력:
 *
 */
public class Test04 {
}



public class Main {

    public static int n;
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }

        Collections.sort(arrayList);

        int target = 1;
        for (int i = 0; i < n; i++) {
            // 만들 수 없는 금액을 찾았을 때 반복 종료
            if (target < arrayList.get(i)) break;
            target += arrayList.get(i);
        }

        System.out.println(target);
    }
}
