package greedy;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        System.out.println( 123456789 + 5432l );
//        int s[] = { 1, 3, 0, 5, 8, 5 };
//        int f[] = { 2, 4, 6, 7, 9, 9 };
//        int n = s.length;
//
//        // Function call
//        var result = printMaxActivities(s, f, n);
//        System.out.println(result);
    }

    private static List<Map.Entry<Integer,Integer>> printMaxActivities(int[] s, int[] f, int n) {
        List<Map.Entry<Integer,Integer>> result = new ArrayList<>();


        var treeMap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {

            treeMap.put(f[i], s[i]);
        }
        var firstEntry = treeMap.firstEntry();
        System.out.println(firstEntry);


       result.add(firstEntry);

        System.out.println(treeMap);

        var keySet = treeMap.keySet();
        for(Integer k :keySet){
            var first = treeMap.get(k);
            if(first>=result.get(result.size()-1).getKey()){
                result.add(Map.entry(k,treeMap.get(k)));
            }
        }


        return result;
    }
}
