package cn.bigfire.ctrlcq.player;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * @ IDE    ：IntelliJ IDEA.
 * @ Author ：dahuoyzs
 * @ Date   ：2020/5/22  10:23
 * @ Desc   ：
 */
public class MyPlayer extends Thread {

    private InputStream is;
    public MyPlayer(InputStream is){
        this.is = is;

    }
    Player player = null;
    public void run(){
        try {
            player = new Player(new BufferedInputStream(is));
            player.play();
        } catch(JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        if (player!=null){
            player.close();
        }
    }
}
