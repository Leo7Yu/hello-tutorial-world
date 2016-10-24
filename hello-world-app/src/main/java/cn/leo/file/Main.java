package cn.leo.file;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File filePath=new File("/aliyun/upload/proxy/image/store/business/");
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        System.out.println("---");
    }

}
