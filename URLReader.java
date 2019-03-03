package Hello;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {
    public static void main(String[] args)throws Exception
    {
        URL tirc =new URL("http://127.0.0.1:8080/");
        BufferedReader in=new BufferedReader(new InputStreamReader(tirc.openStream()));
        String inputLine;
        while((inputLine=in.readLine())!=null)
            System.out.println(inputLine);
        in.close();
    }
}
