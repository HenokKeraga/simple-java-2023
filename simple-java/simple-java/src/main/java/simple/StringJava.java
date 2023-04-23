package simple;

import java.util.*;
import java.util.stream.*;
import java.util.stream.Stream;

public class StringJava {
    //    public static void main(String[] args){
//
//        String str ="asdmrfnsdafb";
//
//        var map=  str.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(c ->c,LinkedHashMap::new,Collectors.counting()));
//
//        // System.out.println(map);
//
////        for(Map.Entry entry:map.entrySet()){
////            System.out.println(entry.getValue());
////            System.out.println(entry.getValue().equals(1));
////
////            if(entry.getValue().equals(1)){
////
////                System.out.println(entry.getKey());
////            }
////
////        }
//        for (Map.Entry entry:map.entrySet()){
//
//         if(entry.getValue().equals(1)){
//
//             System.out.println(entry.getKey());
//
//         }
//
//    }
    public static void main(String[] args) {

        String str = "asdmrfnsdafb";

        //  System.out.println(findFirstNonRepeatedChar(str));

        //   var map = str.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(c -> c,LinkedHashMap::new,Collectors.counting()));
        var map = str.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));


        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(1L)) {

                System.out.println(entry.getKey());

            }
        }

    }

//    public static  String findFirstNonRepeatedChar(String input){
//            Map<Character, Integer> map = new LinkedHashMap<>();
//
//            for (char ch : input.toCharArray()) {
//
//                map.put(ch, map.getOrDefault(ch, 0) + 1);
//
//            }
//
//            for (Map.Entry entry : map.entrySet()) {
//
//                if (entry.getValue().equals(1)) {
//                    System.out.println(entry.getKey());
//                }
//            }
//
//        }

}

