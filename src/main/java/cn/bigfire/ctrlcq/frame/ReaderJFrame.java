package cn.bigfire.ctrlcq.frame;

import cn.bigfire.ctrlcq.listenter.SysKeyListener;
import com.melloware.jintellitype.JIntellitype;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @ IDE    ：IntelliJ IDEA.
 * @ Author ：dahuoyzs
 * @ Date   ：2020/5/21  17:29
 * @ Desc   ：
 */
public class ReaderJFrame extends JFrame {

    private SysKeyListener sysKeyListener;

    public void bind(SysKeyListener sysKeyListener){
        this.sysKeyListener = sysKeyListener;
    }

    public ReaderJFrame(){
        try {
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
            this.addWindowListener(new WindowAdapter() {
                public void windowIconified(WindowEvent e) {
                    dispose();//窗口最小化时dispose该窗口
                }
                public void windowClosing(WindowEvent e) {
                    if (sysKeyListener!=null){
                        sysKeyListener.destroy();
                    }
                }
            });
            initTray();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void initTray()throws Exception{
        //从硬盘上读取
//        String icoPathName = "D:\\test\\ico\\tray.gif";
//        BufferedImage read = ImageIO.read(new File(icoPathName));
        //从当前项目的resources目录下读取
        String tray = "/static/img/tray.gif";
        BufferedImage read = ImageIO.read(getClass().getResource(tray));
        TrayIcon trayIcon = new TrayIcon(read);
        SystemTray.getSystemTray().add(trayIcon);
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

}
