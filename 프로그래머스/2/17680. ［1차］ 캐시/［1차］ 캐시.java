import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        for (String city : cities) {
            city = city.toLowerCase();
            if (map.containsKey(city)) {
                map.put(city, 0);
                answer += 1;
            } else {
                if (map.size() == cacheSize) {
                    String leastRecentlyUsed = getLeastRecentlyUsed(map);
                    map.remove(leastRecentlyUsed);
                }
                map.put(city, 0);
                answer += 5;
            }

            for (String key : map.keySet()) {
                map.put(key, map.get(key) + 1);
            }
        }

        return answer;
    }

    private String getLeastRecentlyUsed(Map<String, Integer> map) {
        String leastRecentlyUsed = null;

        int max = Integer.MIN_VALUE;
        for (String city : map.keySet()) {
            if (map.get(city) > max) {
                max = map.get(city);
                leastRecentlyUsed = city;
            }
        }

        return leastRecentlyUsed;
    }
}