package codeforces.com.tasks.bookOlProg;

public class MinTimeForAllTask {

    public static void main(String[] args) {
        int taskNum = 8;
        //need to be sorted
        int[] machineTimes = new int[]{2, 3, 7};
        int gtdTime = machineTimes[0] * taskNum;
        int maxNotEnoughTime = -1;
        for (int b = gtdTime; b >= 1 ; b /= 2) {
            while (!enoughTime(maxNotEnoughTime + b, taskNum, machineTimes)) maxNotEnoughTime += b;
        }
        System.out.println(maxNotEnoughTime + 1);
    }

    static boolean enoughTime(int time, int taskNum, int[] machineTimes) {
        double madeTasks = 0;
        for (int i = 0; i < machineTimes.length; i++) {
            madeTasks += time/machineTimes[i];
        }
        if (madeTasks >= taskNum) return true;
        else return false;
    }

}
