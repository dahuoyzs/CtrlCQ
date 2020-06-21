
const {Menu, Tray, app, BrowserWindow,ipcMain} = require('electron')
const icon = require('./app-icon')
const appShortcut = require('./app-shortcut')
const appMenu = require('./app-menu')

// 监听程序准备就绪
app.on('ready', () => {
    // 隐藏系统任务栏
    hiddenTaskbar()
    // 创建托盘
    const tray = createTray()
    // 注册快捷键
    appShortcut.initGlobalShortcut(tray)
});

// 监听即可禁止窗口关闭时被退出
app.on('window-all-closed', () => {
   //to do
})

//创建托盘图标
function createTray() {
    // 新建系统托盘并添加图标
    const tray = new Tray(icon.iconFile)
    // 悬停通知
    tray.setToolTip('CtrlCQ')
    // 添加右键菜单到系统托盘区
    tray.setContextMenu(appMenu.buildContextMenu(tray))
    // 添加双击事件
    // tray.on('double-click',()=>{   
    //     showWinodw();
    // });
    return tray
}

//隐藏任务栏中的bar
function hiddenTaskbar() {
    switch (process.platform) {
        case "win32":
            Menu.setApplicationMenu(null)
            break
        case "darwin":
            app.dock.hide()
            break
    }
}


