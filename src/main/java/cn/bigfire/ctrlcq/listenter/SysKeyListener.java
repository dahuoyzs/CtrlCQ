package cn.bigfire.ctrlcq.listenter;

import cn.bigfire.ctrlcq.tts.BaiDuTTS;
import cn.hutool.core.swing.clipboard.ClipboardUtil;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

import static com.melloware.jintellitype.JIntellitypeConstants.MOD_CONTROL;

/**
 * @ IDE    ：IntelliJ IDEA.
 * @ Author ：dahuoyzs
 * @ Date   ：2020/5/21  17:30
 * @ Desc   ：
 */
public class SysKeyListener implements HotkeyListener {
    public static final int CtrlQ = 1001;

    public SysKeyListener(){
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
            String str = ClipboardUtil.getStr();
            System.out.println(str);
            BaiDuTTS.tts(str);
        }
    }

    public void destroy() {
        try{
            JIntellitype.getInstance().unregisterHotKey(CtrlQ);
        }catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    //System.exit(0);

}
