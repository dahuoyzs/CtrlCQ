package cn.bigfire.ctrlcq.tts;

import cn.bigfire.ctrlcq.player.MyPlayer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @ IDE    ：IntelliJ IDEA.
 * @ Author ：dahuoyzs
 * @ Date   ：2020/5/21  17:33
 * @ Desc   ：
 */
public class BaiDuTTS {
    public static HttpClient httpClient = HttpClients.createDefault();
    public static MyPlayer myPlayer = null;
    public static void tts(String text){
        try {
            String url = "http://fanyi.baidu.com/gettts?spd=3&lan=zh&text=" + URLEncoder.encode(text, "utf-8") + "&source=web";
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            InputStream is = response.getEntity().getContent();
            if (myPlayer!=null){
                myPlayer.close();
                myPlayer.stop();
                myPlayer = null;
            }
            myPlayer = new MyPlayer(is);
            myPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
