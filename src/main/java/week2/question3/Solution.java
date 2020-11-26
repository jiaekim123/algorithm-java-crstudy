/*
    https://programmers.co.kr/learn/courses/30/lessons/17683
    [프로그래머스][2018 카카오 블라인드 테스트 3차] 방금 그곡
 */
package week2.question3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(String m, String[] musicinfos) {
        // 음악 저장하기
        List<Song> musicList = new ArrayList<>();
        for (String musicInfo : musicinfos) {
            String[] music = musicInfo.split(",");
            int playTime = getPlayTime(music[0], music[1]);
            Song song = new Song(music[2], playTime, music[3]);
            musicList.add(song);
        }

        // 노래 찾아보기
        return findMusic(m, musicList);
    }

    private int getPlayTime(String startTime, String endTime) {
        String[] startTimes = startTime.split(":");
        String[] endTimes = endTime.split(":");
        int start = Integer.parseInt(startTimes[0]) * 60 + Integer.parseInt(startTimes[1]);
        int end = Integer.parseInt(endTimes[0]) * 60 + Integer.parseInt(endTimes[1]);
        return end - start;
    }

    private String findMusic(String m, List<Song> musicList) {
        String answer = "(None)";
        int answerPlayTime = 0;
        for (Song song : musicList) {
            if (isSameSong(song, m, answerPlayTime)) {
                answer = song.name;
                answerPlayTime = song.playTime;
            }
        }
        return answer;
    }

    private boolean isSameSong(Song song, String m, int answerPlayTime){
        if (song.totalSong.contains(m) && answerPlayTime < song.playTime) {
            String[] splits = song.totalSong.split(m);
            if (splits.length==1 || song.totalSong.endsWith(m)){
                return true;
            } else {
                for (int i = 1; i < splits.length; i++){
                    if (!splits[i].startsWith("#")) return true;
                }
            }
        }
        return false;
    }
}

class Song {
    String name;
    int playTime;
    String song;
    String totalSong;

    public Song(String name, int playTime, String song) {
        this.name = name;
        this.playTime = playTime;
        this.song = song;
        this.totalSong = getTotalSong(playTime, song);
    }

    // 라디오에 나온 노래 전체 저장하기
    private String getTotalSong(int playTime, String song) {
        StringBuilder sb = new StringBuilder();
        int songSingleTime = song.length() - song.split("#").length + 1;
        for (int i = 0; i < playTime / songSingleTime; i++) {
            sb.append(song);
        }
        String lastWord = song.substring(0, playTime % songSingleTime);
        sb.append(lastWord);
        return sb.toString();
    }
}