package HelperGroup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {

    public static String readProperty(String FileName, String Value) throws IOException {
        Properties pr=new Properties();
        File path=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\"+FileName+".properties");
        FileInputStream fileInputStream=new FileInputStream(path);
        pr.load(fileInputStream);
        System.out.println(pr.getProperty(Value));
        return pr.getProperty(Value);
    }
}
