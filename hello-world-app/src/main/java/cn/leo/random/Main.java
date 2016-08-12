package cn.leo.random;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        ThreadLocalRandom random=ThreadLocalRandom.current();
        OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream("/random_result", true),"UTF-8");
        try {
            while(true){
                int randomInt=random.nextInt(100);
//                writer.append(String.valueOf(randomInt));
//                writer.append("\n");
//                writer.flush();
                System.out.println(randomInt);
                Thread.sleep(3*1000);
            }
        }finally{
            writer.close();
        }
        
    }

}
