package cn.leo.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inStream = Main.class.getClassLoader().getResourceAsStream("prop.properties");
        Properties prop = new Properties();
        try {
            prop.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String value = prop.getProperty("hello.properties.world", "20");
        System.out.println(value);
    }

}
