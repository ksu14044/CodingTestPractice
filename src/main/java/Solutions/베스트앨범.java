package Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 베스트앨범 {
    static class Song {
        int id;
        int play;

        Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<Song>> songsByGenre = new HashMap<>();

        for(int i = 0 ; i < genres.length ; i++) {
            String genre = genres[i];
            int play = plays[i];

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            List<Song> list = songsByGenre.getOrDefault(genre, new ArrayList<>());
            list.add(new Song(i, play));
            songsByGenre.put(genre, list);
        }

        List<String> sortedGenres = new ArrayList<>(songsByGenre.keySet());
        sortedGenres.sort((g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1));

        List<Integer> result = new ArrayList<>();
        for(String genre : sortedGenres) {
            List<Song> songs = songsByGenre.get(genre);

            songs.sort((s1, s2) -> {
                if(s2.play == s1.play) {
                    return s1.id - s2.id;
                }
                return s2.play - s1.play;
            });

            for(int i = 0 ; i < Math.min(2, songs.size()) ; i++) {
                result.add(songs.get(i).id);
            }
        }

        System.out.println(result);
    }
}
