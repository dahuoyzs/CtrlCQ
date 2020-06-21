const path = require('path')

// 系统托盘图标目录 __dirname:主进程文件所在目录
const iconDir = path.normalize(path.join(__dirname, '../public/img'));
// 按平台选择图标的文件名，mac是18px的倍数，win是16px的倍数
// const iconName = process.platform === 'win32' ? 'star-win.png' : 'star-mac.png'
// 图标的绝对路径
const iconFile = path.normalize(path.join(iconDir, 'audio_blue.png'));


exports.iconFile = iconFile
