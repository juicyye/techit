package cote;

import java.util.*;

public class 베스트앨범 {
    static class Song implements Comparable<Song> {
        int index;
        int plays;

        public Song(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }

        @Override
        public int compareTo(Song other) {
            if (this.plays == other.plays) {
                return this.index - other.index; // 고유 번호가 낮은 순으로 정렬
            }
            return other.plays - this.plays; // 재생 횟수가 많은 순으로 정렬
        }
    }

    static int[] solution(String[] genres, int[] plays) {
        Map<String, PriorityQueue<Song>> genreMap = new HashMap<>();
        Map<String, Integer> totalPlays = new HashMap<>();

        // 장르별로 노래들을 그룹화하고, 각 장르의 총 재생 횟수를 계산
        for (int i = 0; i < genres.length; i++) {
            if (!genreMap.containsKey(genres[i])) {
                genreMap.put(genres[i], new PriorityQueue<>());
                totalPlays.put(genres[i], 0);
            }
            genreMap.get(genres[i]).add(new Song(i, plays[i]));
            totalPlays.put(genres[i], totalPlays.get(genres[i]) + plays[i]);
        }

        // 장르별로 최대 2개의 노래를 선택하여 결과 리스트에 추가
        List<Integer> resultList = new ArrayList<>();
        PriorityQueue<GenrePlay> genrePlays = new PriorityQueue<>();
        for (String genre : totalPlays.keySet()) {
            genrePlays.add(new GenrePlay(genre, totalPlays.get(genre)));
        }
        while (!genrePlays.isEmpty()) {
            String genre = genrePlays.poll().genre;
            PriorityQueue<Song> songQueue = genreMap.get(genre);
            for (int i = 0; i < 2 && !songQueue.isEmpty(); i++) {
                resultList.add(songQueue.poll().index);
            }
        }

        // 결과 리스트를 배열로 변환하여 반환
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        return answer;
    }

    static class GenrePlay implements Comparable<GenrePlay> {
        String genre;
        int plays;

        public GenrePlay(String genre, int plays) {
            this.genre = genre;
            this.plays = plays;
        }

        @Override
        public int compareTo(GenrePlay other) {
            return other.plays - this.plays;
        }
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }
}
