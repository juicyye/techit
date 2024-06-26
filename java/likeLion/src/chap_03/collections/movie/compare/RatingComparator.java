package chap_03.collections.movie.compare;

import chap_03.collections.movie.Movie;

import java.util.Comparator;

public class RatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return Double.compare(o2.getRating(), o1.getRating());
    }
}
