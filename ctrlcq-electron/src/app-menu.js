
const {Menu,app} = require('electron')
const appToast = require('./app-toast')

//此方法不行
// const applition = require('./main.js')



exports.buildContextMenu = function buildContextMenu(tray) {
	// 菜单栏引用
    let menu;


    let submenu = new Array(10);
    for(let i = 1;i<10;i++){
        submenu[i] = {
            label: 'spd'+i,
            click: function (menuItem, browserWindow, event) {
                menuItem.checked = true;
                console.log(menuItem.label);
                menuItem.label = ">"+menuItem.label;
                console.log(menuItem.label);   
            }
        }
    }

    const template = [
        {
            label: '打开主页',
            click: () => {
                appToast.toast({title:"标题",body:"打开主页"})
                // applition.showWinodw();
            }
        },
        {
            label: '语速设置',
            submenu:submenu
            // submenu: [{
            //     label: '语速1',
            //     click: function (menuItem, browserWindow, event) {
            //         console.log(menuItem.checked);
            //         menuItem.checked = true;
            //         console.log(menuItem.checked);
            //         // appToast.toast({title:"语速设置",body:menuItem})
            //     }
            // }, {
            //     label: '语速2',
            //     click: function () {
            //         // menuItem.checked = true
            //         appToast.toast({title:"语速设置",body:"语速设置为2"})
            //     }
            // }, {
            //     label: '语速3',
            //     click: function () {
            //         // menuItem.checked = true
            //         appToast.toast({title:"语速设置",body:"语速设置为3"})
            //     }
            // }, {
            //     label: '语速4',
            //     click: function () {
            //         // menuItem.checked = true
            //         appToast.toast({title:"语速设置",body:"语速设置为4"})
            //     }
            // }, {
            //     label: '语速5',
            //     click: function () {
            //         // menuItem.checked = true
            //         appToast.toast({title:"语速设置",body:"语速设置为5"})
            //     }
            // }, {
            //     label: '语速6',
            //     click: function () {
            //         // menuItem.checked = true
            //         appToast.toast({title:"语速设置",body:"语速设置为6"})
            //     }
            // }, {
            //     label: '语速7',
            //     click: function () {
            //         // menuItem.checked = true
            //         appToast.toast({title:"语速设置",body:"语速设置为7"})
            //     }
            // }, {
            //     label: '语速8',
            //     click: function () {
            //         // menuItem.checked = true
            //         appToast.toast({title:"语速设置",body:"语速设置为8"})
            //     }
            // }, {
            //     label: '语速9',
            //     click: function () {
            //         // menuItem.checked = true
            //         appToast.toast({title:"语速设置",body:"语速设置为9"})
            //     }
            // }]
            // click: () => {
            //     appToast.toast({title:"标题",body:"语速设置"})
            // }
        },
        {
            label: '关于软件',
            click: () => {
                appToast.toast({title:"标题",body:"关于软件"})
            }
        },
		{
            label: '退出程序',
            click: () => {
                tray.destroy()
                app.quit()
            }
        }
    ];
	menu = Menu.buildFromTemplate(template)
    return menu
}