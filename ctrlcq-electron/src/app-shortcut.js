const {globalShortcut,clipboard,BrowserWindow } = require('electron')
const store = require('./app-store')
const appToast = require('./app-toast')
// 快捷键
const ACCELERATORS = ['CmdOrCtrl+Q']
exports.ACCELERATORS = ACCELERATORS

exports.initGlobalShortcut = function initGlobalShortcut(tray) {
    var playWindow = null;
    if (globalShortcut.isRegistered(ACCELERATORS[0])) {
    	appToast.toast({title: '热键已经被占用', body: '注册失败'})
    }else{
    	globalShortcut.register(ACCELERATORS[0], () => {

            let content = encodeURI(clipboard.readText());
            // store.

            if (playWindow!=null) {
                playWindow.close();
                playWindow = null;
            }
            playWindow = new BrowserWindow({ width: 10, height: 10,webPreferences:{nodeIntegration:true}, show: false });
            playWindow.on('closed', function() {
              playWindow = null;
            });
            playWindow.loadURL('file://' + __dirname + '/play.html');
        });
    }
}





















