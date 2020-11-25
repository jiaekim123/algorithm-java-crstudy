/*
 *	https://programmers.co.kr/learn/courses/30/lessons/17683
 *	프로그래머스 - 2018 KAKAO BLIND RECRUITMENT - [3차]방금그곡
 */
package week2.question3;

class Solution {
    public String solution(String m, String[] musicinfos) {
        
        //variables
        String answer = "";
        String[] eachMusic;
        int pTime = 0;
        int longest = 0;
        String title = "";
        
        //iterate musicinfos
        for(String info : musicinfos)
        {
            //save each music's info into eachMusic array split by ","
            eachMusic = info.split(",");

            //calculate total playTime
            pTime = playTime(eachMusic[0], eachMusic[1]);
            
            //check whether melody is included in the music
            if(containsMelody(pTime, eachMusic[3], m))
            {                
                //if melody is contained in multiple musics then save the longest music and title
                //Also, automatically save first entered title even play time of musics are same
                if(longest < pTime)
                {
                    longest = pTime;
                    title = eachMusic[2];
                }
            }
        }

        return title.equals("") ? "(None)" : title;
    }
    
    //caluclate music's play time
    private int playTime(String start, String end)
    {
        //variables
        String[] sTime = start.split(":");
        String[] eTime = end.split(":");
        
        int hourToMin = (Integer.parseInt(eTime[0]) - Integer.parseInt(sTime[0])) * 60;
        int min = Integer.parseInt(eTime[1]) - Integer.parseInt(sTime[1]);
        
        //total time: hour to min + minute
        return hourToMin + min;
    }
    
    //check whether song contains melody
    private boolean containsMelody(int playTime, String note, String m)
    {
        //variables
        String[] sharp = {"C#", "D#", "F#", "G#", "A#"};
        String[] lowerCase = {"c", "d", "f", "g", "a"};
        String noSharp = note;
        String noSharpM = m;        
        String match = "";

        //replaceAll note with # to lower case
        for(int i = 0; i < sharp.length; i++)
        {
            noSharp = noSharp.replaceAll(sharp[i], lowerCase[i]);       
            noSharpM = noSharpM.replaceAll(sharp[i], lowerCase[i]);   
        }
        
        //get full music notes in play time
        //repetition
        for(int i = 0; i < (playTime / noSharp.length()); i++)
        {
            match += noSharp;

            if(match.contains(noSharpM))
            {
                return true;
            }
        }
        
        //add extra note    
        match += noSharp.substring(0, playTime % noSharp.length());

        if(match.contains(noSharpM))
        {
            return true;
        }
        
        return false;
    }
}