import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth: clothes) {
            String key = cloth[1];
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        // System.out.println(map);
        // map을 순차적으로 돌기
        Iterator<Integer> iter = map.values().iterator();
        while (iter.hasNext()) {
            answer *= iter.next().intValue() + 1;
        }

        return answer - 1;
    }
}