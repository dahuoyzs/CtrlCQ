const {globalShortcut,clipboard,BrowserWindow,ipcMain} = require('electron')
const DataStore = require('./app-store')
const dataStore = new DataStore()
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
            dataStore.setPlayContent(content);
            //暂停旧窗口
            if (playWindow!=null) {
                playWindow.close();
                playWindow = null;
            }
            playWindow = new BrowserWindow({ width: 10, height: 10,webPreferences:{nodeIntegration:true}, show: false });
            playWindow.on('closed', function() {playWindow = null;});
            playWindow.loadURL('file://' + __dirname + '/play.html');
        });
    }
    // createWin();
}

//创建主窗体
// let win = null;
// let webContents = null;
// function createWin() {
//     if(win==null){
//         win = new BrowserWindow({ width: 600, height: 300,show: true});
//         //关闭时清空对象
//         win.on('closed', function() {win = null;});
//         win.loadURL('file://' + __dirname + '/main.html');
//         webContents = win.webContents;
//     }
// }

// ipcMain.on('asynchronous-message', (event, arg) => {
//     console.log(arg)  // prints "ping"
//     //给网页端回消息
//     event.sender.send('asynchronous-reply', 'pong')
// });
// exports.webContents;




















