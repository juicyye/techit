package chap_03.collections.movie.compare;

import chap_03.collections.movie.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareMain {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Shawshank Redemption", 1994, 9.3));
        movies.add(new Movie("The Godfather", 1972, 9.2));
        movies.add(new Movie("The Dark Knight", 2008, 9.0));

        // 제목 기준 정렬 (Comparable)
        Collections.sort(movies);
        System.out.println("Sorted by title:");
        movies.forEach(System.out::println);

        // 평점 기준 정렬 (Comparator)
        Collections.sort(movies, (a,b) ->
            Double.compare(b.getRating(),a.getRating())
        );
        System.out.println("Sorted by rating:");
        movies.forEach(System.out::println);

        // 출시 연도 기준 정렬 (Comparator)
        Collections.sort(movies, (a,b) ->
            Integer.compare(b.getYear(),a.getYear())
        );
        System.out.println("Sorted by release year:");
        movies.forEach(System.out::println);
    }
}
