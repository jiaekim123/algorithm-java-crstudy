/*
    https://programmers.co.kr/learn/courses/30/lessons/17676
    [프로그래머스][2018 KAKAO BLIND RECRUITMENT] 추석 트래픽 (level 3)
 */
package week4.question3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        List<Traffic> trafficList = new ArrayList<Traffic>();
        for (String line : lines){
            trafficList.add(new Traffic(line));
        }

        for (int i = 0; i <trafficList.size(); i++){
            int count = 0;
            long startSection = trafficList.get(i).startTime;
            long endSection = startSection + 1000;

            for (int j = 0; j < trafficList.size(); j++) {
                if (startSection <= trafficList.get(i).startTime
                        && trafficList.get(i).startTime < endSection) {
                    count++;
                } else if (startSection <= trafficList.get(i).endTime
                        && trafficList.get(i).endTime < endSection) {
                    count++;
                } else if (startSection <= trafficList.get(i).startTime
                        && trafficList.get(i).endTime <= endSection) {
                    count++;
                }
                answer = count > answer ? count : answer;
            }

        }

        return answer;
    }
}
class Traffic {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
    long startTime;
    long endTime;
    float processingTime;

    Traffic(String line){
        parseLog(line);
    }

    private void parseLog(String line){
        String[] logs = line.split(" ");
        this.processingTime = Float.parseFloat(logs[2].split("s")[0]);
        try {
            this.endTime = dateFormat.parse(logs[0] + " " + logs[1]).getTime();
            this.startTime = endTime - (long)(processingTime*1000) + 1;
        } catch (Exception e){
            System.out.println("데이터 포맷 에러");
            e.printStackTrace();
        }
        System.out.println(dateFormat.format(startTime));
        System.out.println(dateFormat.format(endTime));
    }
}