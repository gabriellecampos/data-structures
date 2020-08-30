import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String solution(int N) {
        String result = "";
        if(N%2 == 0){
            for(int i = 0; i< N -1; i++){
                result += "a";
            }
            result = result+"b";
        }else{
            for(int i = 0; i< N; i++){
                result += "a";
            }
        }

        return result;
    }

    public boolean solution2(int[] A){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            int number = A[i];

            map.putIfAbsent(number, 1);

            if(map.get(number-1) != null){
                return true;
            }else if(map.get(number+1) != null){
                return true;
            }
        }
        return false;
    }

    int solution3(int n1, int n2) {
        int max = n1>=n2 ? n1:n2;
        int min = n1<n2 ? n1:n2;
        return Math.floorDiv(n1+n2, max-min) + Math.floorDiv(n1+n2, min);

    }

    int gcdByEuclidsAlgorithm(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcdByEuclidsAlgorithm(q, p % q);
    }

    List<String> solution4(String inputString, int num){
        Map<Character, Integer> charOccurence = new HashMap<>();
        List<String> result = new ArrayList<>();
        int windowStart = 0;
        String subString;
        System.out.println(inputString);

        for(int windowEnd = 0; windowEnd<inputString.length(); windowEnd++) {
            Character rightChar = inputString.charAt(windowEnd);
            subString = inputString.substring(windowStart, windowEnd+1);
            Character leftChar = inputString.charAt(windowStart);

            if(charOccurence.containsKey(rightChar)) {
                charOccurence.put(rightChar, charOccurence.get(rightChar)+1);
            }else {
                charOccurence.put(rightChar, 1);
            }

            if(windowEnd >= num - 1 ){
                if(charOccurence.values().stream().reduce(0, Integer::sum) == num && charOccurence.size() == num-1) {
                    result.add(subString);
                }
                charOccurence.put(leftChar, charOccurence.get(leftChar) - 1);
                if(charOccurence.get(leftChar) == 0) {
                    charOccurence.remove(leftChar);
                }
                windowStart++;
            }

        }
        return result;
    }

}
