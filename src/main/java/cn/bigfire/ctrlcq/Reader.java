package cn.bigfire.ctrlcq;

import cn.hutool.core.swing.clipboard.ClipboardUtil;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import javafx.scene.input.Clipboard;
import javazoom.jl.player.Player;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import static com.melloware.jintellitype.JIntellitypeConstants.MOD_CONTROL;

/**
 * @ IDE    ：IntelliJ IDEA.
 * @ Author ：dahuoyzs
 * @ Date   ：2020/5/21  16:54
 * @ Desc   ：
 */
public class Reader extends JFrame implements HotkeyListener {

    public void initTray() throws Exception {
        this.setTitle("Voice assistant");
        int x=500;
        int y=200;
        int width=300;
        int height=200;
        setBounds(x,y,width,height);

        JTextArea jTextArea = new JTextArea();
        jTextArea.setEnabled(false);
        jTextArea.setFont(new Font("monospaced", Font.BOLD, 22));
        jTextArea.setText("Ctrl+C   copy\r\nCtrl+Q  reader。\r\n选中任意文本CtrlCQ即可");
        this.add(jTextArea);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //从硬盘上读取
//        String icoPathName = "D:\\test\\ico\\tray.gif";
//        BufferedImage read = ImageIO.read(new File(icoPathName));
        //从当前项目的resources目录下读取
        String tray = "/static/img/tray.gif";
        BufferedImage read = ImageIO.read(getClass().getResource(tray));
        TrayIcon trayIcon = new TrayIcon(read);
        SystemTray.getSystemTray().add(trayIcon);
        this.addWindowListener(new WindowAdapter() {
            public void windowIconified(WindowEvent e) {
                //窗口最小化时dispose该窗口,即把下面任务栏中的状态取消掉
                dispose();
            }
            public void windowClosing(WindowEvent e) {
                //释放资源
                destroy();
            }
        });
        trayIcon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //双击托盘窗口再现
                if (e.getClickCount() == 2) {
                    setExtendedState(Frame.NORMAL);
                    setVisible(true);
                }
            }
        });


    }

    public static final int CtrlQ = 1001;
    //注册系统按键监听
    public void initHotkey() {
        try{
            //参数KEY_1表示改组热键组合的标识，第二个参数表示组合键，如果没有则为0，该热键对应ctrl+alt+I
            JIntellitype.getInstance().registerHotKey(CtrlQ, MOD_CONTROL, (int) 'Q');
            JIntellitype.getInstance().addHotKeyListener(this);
        }catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public void onHotKey(int identifier) {
        if (identifier == CtrlQ) {
            String str = ClipboardUtil.getStr().trim();
            System.out.println(str);
            tts(str);
        }
    }

    //取消按键监听
    public static void destroy() {
        try{
            JIntellitype.getInstance().unregisterHotKey(CtrlQ);
        }catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }


    static HttpClient httpClient = HttpClients.createDefault();
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

    static class MyPlayer extends Thread{
        private InputStream is;
        public MyPlayer(InputStream is){
            this.is = is;
        }
        Player player = null;
        @Override
        public void run() {
            super.run();
            try {
                player = new Player(new BufferedInputStream(is));
                player.play();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        public void close(){
            if (player!=null){
                player.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        reader.initTray();
        reader.initHotkey();
    }

}
