package cn.leo.random;

import java.util.Random;

public class SeedRandomMain {

    public static void main(String[] args) throws InterruptedException {
//        ThreadLocalRandom random=ThreadLocalRandom.current();
        Random random=new Random(10000);
//        random.setSeed(10000);
        int randomInt;
        while(true){
            randomInt=random.nextInt(100);
            System.out.println(randomInt);
            Thread.sleep(2*1000);
        }
       
    }

}
