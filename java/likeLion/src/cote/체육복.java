package cote;

import java.util.*;

public class 체육복 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        System.out.println("solution(n,lost,reserve) = " + solution(n, lost, reserve));

    }

    static int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for(int x : lost) lostSet.add(x);
        for(int x: reserve){
            if (lostSet.contains(x)) {
                lostSet.remove(x);
            } else{
                reserveSet.add(x);
            }
        }

        for (int x : lostSet) {
            if (reserveSet.contains(x - 1)) {
                reserveSet.remove(x - 1);
            } else if (reserveSet.contains(x + 1)) {
                reserveSet.remove(x + 1);
            } else n--;
        }
        return n;
    }

}
