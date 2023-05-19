package swea.d3;

public class HH24hour {

    public static int getCurrentHour(int pastTime, int previousTime) {
        int currentTime = (pastTime + previousTime);
        currentTime = currentTime < 24 ? currentTime : currentTime - 24; // 24 나머지와 동일,... 생

        return currentTime;
    }
}
