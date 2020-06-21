const Store = require('electron-store')

class DataStore extends Store {
	//剪切板内容
    playContent = ''
    //播放速度
    spd = '9'
    //构造函数
    constructor(settings) {
        const baseConfig = {name: 'ctrlcq'}
        const finalConfig = {...baseConfig, ...settings};
        super(finalConfig)
    }
    //获取速度
    getSpd(){
        return this.get(this.spd)
    }
    //设置速度
    setSpd(v){
        return this.set(this.spd,v)
    }
    //获取播放文本
    getPlayContent(){
        return this.get(this.playContent)
    }
    //设置播放文本
    setPlayContent(v){
        return this.set(this.playContent,v)
    }
}

module.exports = DataStore