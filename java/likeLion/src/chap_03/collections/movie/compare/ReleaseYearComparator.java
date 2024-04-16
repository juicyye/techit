package chap_03.collections.movie.compare;

import chap_03.collections.movie.Movie;

import java.util.Comparator;

public class ReleaseYearComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return Integer.compare(o2.getYear(), o1.getYear());
    }
}
