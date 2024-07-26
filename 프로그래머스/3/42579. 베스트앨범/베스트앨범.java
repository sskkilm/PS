import java.util.*;

class Song {
    int idx;
    int play;

    public Song(int idx, int play) {
        this.idx = idx;
        this.play = play;
    }

    @Override
    public String toString() {
        return "Song{" +
                "idx=" + idx +
                ", play=" + play +
                '}';
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<String> genreList = new ArrayList<>(map.keySet());
        Collections.sort(genreList, (o1, o2) -> map.get(o2) - map.get(o1));

        List<Integer> ans = new ArrayList<>();
        for (String genre : genreList) {
            List<Song> songs = new ArrayList<>();

            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i])) {
                    songs.add(new Song(i, plays[i]));
                }
            }
            Collections.sort(songs, (o1, o2) -> o2.play - o1.play);

            if (songs.size() == 1) {
                ans.add(songs.get(0).idx);
            } else {
                ans.add(songs.get(0).idx);
                ans.add(songs.get(1).idx);
            }
        }

        answer = ans.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}