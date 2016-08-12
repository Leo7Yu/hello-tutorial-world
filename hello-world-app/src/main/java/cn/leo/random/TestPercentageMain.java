package cn.leo.random;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestPercentageMain {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("/random_result"), "UTF-8"));
        
        OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream("/sample", true),"UTF-8");
        
        try {
            String line;
            Map<Integer,Integer> numberMap=new HashMap<>();
            Integer randomNumber;
            Integer times;
            int total=0;
            
            Integer sample=20;
            List<Integer> sampleIndexList=new ArrayList<>();
            while((line=reader.readLine())!=null){
                total++;
                randomNumber=Integer.parseInt(line);
                times=numberMap.get(randomNumber);
                if(times==null){
                    numberMap.put(randomNumber, 1);
                }else{
                    numberMap.put(randomNumber, times+1);
                }
                
                writer.append(sample==randomNumber?"1":"0");
                writer.append("\n");
                if(sample==randomNumber){
//                    System.out.println(total);
                    sampleIndexList.add(total);
                }
            }
            
//            System.out.println("------------------------------------");
//            for(int i=0;i<sampleIndexList.size();i++){
//                if(i==0){
//                    continue;
//                }
//                System.out.println(sampleIndexList.get(i)-sampleIndexList.get(i-1));
//            }
            
            BigDecimal totalBD=new BigDecimal(total);
            BigDecimal timeBD;
            for(Integer key:numberMap.keySet()){
                timeBD=new BigDecimal(numberMap.get(key));
                System.out.println(key+":"+timeBD.divide(totalBD,5,BigDecimal.ROUND_DOWN).doubleValue());
            }
            System.out.println("total number:"+total);
        } finally{
            reader.close();
            writer.close();
        }
        
    }
}
