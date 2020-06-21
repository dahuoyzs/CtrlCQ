
const {Menu,app,shell} = require('electron')
const appToast = require('./app-toast')
const DataStore = require('./app-store')
const dataStore = new DataStore()

let spds = ['spd1','spd2','spd3','spd4','spd5','spd6','spd7','spd8','spd9']
function myGetMenuItemById(id, myMenu) {
    const items = myMenu.items
    let found = items.find(item => item.id === id) || null
    for (let i = 0, length = items.length; !found && i < length; i++) {
        if (items[i].submenu) {
            found = myGetMenuItemById(id, items[i].submenu)
        }
    }
    return found
}
/**
 * 关闭除ID外的其他checked
 */
function closeMenuChecked(id, menu) {
    for (let myId of spds) {
        if (id !== myId) {
            myGetMenuItemById(myId, menu).checked = false
        }
    }
}

exports.buildContextMenu = function buildContextMenu(tray) {
	// 菜单栏引用
    let menu;

    let submenu = new Array(9);
    for(let i = 0;i<9;i++){
        let spd = i+1;
        submenu[i] = {
<<<<<<< HEAD
            label: 'spd'+i,
            click: function (menuItem, browserWindow, event) {
                menuItem.checked = true;
                console.log(menuItem.label);
                menuItem.label = ">"+menuItem.label;
                console.log(menuItem.label);   
=======
            id: spds[i],
            label: '语速'+spd,
            type: 'checkbox',
            checked: false,
            click: function (menuItem, browserWindow, event) {
                menuItem.checked = true;
                dataStore.setSpd(spd);
                closeMenuChecked(spds[i],menu);

>>>>>>> dev
            }
        }
    }

    const template = [
        {
            label: '语速设置',
            submenu:submenu
        },
        {
            label: 'Github',
            click: () => {
                shell.openExternal(require('./app-constant').github).catch()
            }
        },
        {
            label: 'Gitee',
            click: () => {
                shell.openExternal(require('./app-constant').gitee).catch()
            }
        },
        {
            label: '反馈',
            click: () => {
                shell.openExternal(require('./app-constant').issues).catch()
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