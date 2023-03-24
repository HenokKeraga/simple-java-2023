package queue;

import java.util.*;
import java.util.stream.Stream;

public class Queue {
    public static void main(String[] args) {
        var integers = new PriorityQueue<Integer>(1);
        //integers.addAll(List.of(3,8,1,0));

        Stream.of(3,8,1,0).forEach(v-> {
            if (!integers.isEmpty()){
                if(integers.peek()>v){
                    integers.poll();
                    integers.add(v);
                }
            }else {
                integers.add(v);
            }

        });



        System.out.println(integers);

    }
}
