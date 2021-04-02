package com.jslee.lib.Implement;
/**
 * 문자열 압축
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
    static StringBuffer stringBuffer = new StringBuffer("0123456");

    static String n = "aabbaccc";

    public static void main(String[] args) {
        int len = n.length();
        int result = n.length();

        for(int unitNum=2; unitNum<len-unitNum; unitNum++){

            int temResult = getStringNumOfCompress(unitNum);
            System.out.println("unitNum >" + unitNum+" /result >"+temResult);
            result = Math.min(result, temResult);

        }
        System.out.println("result : "+result);
    }

    //
    public static int getStringNumOfCompress(int unitNum) { // unitNum: 반복되는 유닛 갯수
        StringBuffer compressed = new StringBuffer(n);
        int i = 0;
        while (i < n.length()-unitNum-1) {

            if (allSameString(compressed, i, unitNum)) {
                compressed.replace(i, i + unitNum, Integer.toString(unitNum) + n.charAt(i));
                i= i+unitNum;
                System.out.println("compressed>> "+i+" >"+ compressed);

            }
            else {
                i = i+1;
            }
        }
        System.out.println("compressed>>>>>>>>>> " + compressed);

        return compressed.length();

//            String subString = tempString.substring(start, start + unitNum);
//
//            for (int i = 0; i < tempString.length(); i++) {
//                int index;
//                index = tempString.indexOf(subString);
//                if (index == -1) {
//                    break;
//                } else {
//                    System.out.println("before>"+tempString);
//                    tempString.replace(index, index+unitNum,"");
//                    System.out.println("after>"+tempString);
//
//                    num = num + 1;
//                }
//            }
//    }

    }
    static boolean allSameString(StringBuffer compressed, int i, int unitNum){

        for (int a = 0; a < unitNum; i++) {
            if(compressed.charAt(i) != compressed.charAt(i + 1)){
                return false;
            }
        }
        System.out.println("true");
        return true;
    }
}
