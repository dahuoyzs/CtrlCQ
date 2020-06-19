package cn.bigfire.ctrlcq;

import cn.bigfire.ctrlcq.frame.ReaderJFrame;
import cn.bigfire.ctrlcq.listenter.SysKeyListener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ IDE    ：IntelliJ IDEA.
 * @ Author ：dahuoyzs
 * @ Date   ：2020/5/21  17:39
 * @ Desc   ：
 */
public class App {

    public static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws Exception {
        SysKeyListener sysKeyListener = new SysKeyListener();
        ReaderJFrame readerJFrame = new ReaderJFrame();
        readerJFrame.bind(sysKeyListener);
    }

}
