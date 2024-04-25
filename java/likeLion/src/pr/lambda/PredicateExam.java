package pr.lambda;

import java.util.function.Predicate;

public class PredicateExam {
    public static void main(String[] args) {
        Predicate<Integer> p = i -> i<100;
        Predicate<Integer> q = i -> i<200;
        Predicate<Integer> r = i -> i % 2 ==0;

        Predicate<Integer> notP = p.negate();
        Predicate<Integer> all = notP.and(q).or(r);
        Predicate<Integer> all2 = notP.and(q.or(r));

        String str1 = "abc";
        String str2 = "abc";

        Predicate<String> p2 = Predicate.isEqual(str1);

        boolean check = Predicate.isEqual(str1).test(str2);



    }
}
