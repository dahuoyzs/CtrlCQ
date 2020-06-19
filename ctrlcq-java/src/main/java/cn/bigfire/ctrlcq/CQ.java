package cn.bigfire.ctrlcq;

import cn.hutool.core.swing.clipboard.ClipboardUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import com.melloware.jintellitype.JIntellitypeConstants;
import javafx.scene.input.Clipboard;
import javazoom.jl.player.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URLEncoder;


/**
 * @ IDE    ：IntelliJ IDEA.
 * @ Author ：dahuoyzs
 * @ Date   ：2020/5/30  17:47
 * @ Desc   ：
 */
public class CQ extends JFrame implements HotkeyListener {
    public CQ()throws Exception{
        this.setTitle("语音助手");
        setBounds(300,300,300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        BufferedImage image = ImageIO.read(getClass().getResource("/static/img/tray.gif"));
        TrayIcon trayIcon = new TrayIcon(image);
        SystemTray.getSystemTray().add(trayIcon);
        trayIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount()==2){
                    System.out.println("显示");
                    setExtendedState(Frame.NORMAL);
                    setVisible(true);
                }
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowIconified(WindowEvent e) {
                super.windowIconified(e);
                //从任务栏中清除掉
                dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                JIntellitype.getInstance().unregisterHotKey(CtrlQ);
            }
        });
        registerKey();
    }
    public final int CtrlQ = 100;
    public void registerKey(){
        JIntellitype.getInstance().registerHotKey(CtrlQ, JIntellitypeConstants.MOD_CONTROL,(int)'Q');
        JIntellitype.getInstance().addHotKeyListener(this);
    }

    @Override
    public void onHotKey(int identifier) {
        if (identifier==CtrlQ){
//            String input = Clipboard.getSystemClipboard().getString().trim();
            String input = ClipboardUtil.getStr().trim();
            System.out.println(input);
            if (input.contains("名字")){
                input.replace("小明","小明真帅");
            }
            tts(input);
        }
    }
    static MyThread myThread = null;
    public static void tts(String input){
        try{
            String url = "http://fanyi.baidu.com/gettts?spd=3&lan=zh&text=" + URLEncoder.encode(input, "utf-8") + "&source=web";
            HttpRequest request = new HttpRequest(url);
            request.setFollowRedirects(true);
            HttpResponse execute = request.execute();
            if (myThread!=null){
                myThread.close();
                myThread = null;
            }
            myThread = new MyThread(execute.bodyStream());
            myThread.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static Player player = null;
    static class MyThread extends Thread{
        private InputStream is;
        public MyThread(InputStream is){
            this.is = is;
        }
        @Override
        public void run() {
            super.run();
            try{
                player = new Player(new BufferedInputStream(is));
                player.play();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        public void close(){
            if (player!=null){
                player.close();
                stop();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new CQ();
    }
}
