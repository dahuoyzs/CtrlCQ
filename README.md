<div align="center">
<h1>📝文本朗读器</h1>
<img src="https://img.shields.io/github/license/dahuoyzs/CtrlCQ"/>
<img src="https://img.shields.io/static/v1?label=electron&message=9.0.4&color="/>
<img src="https://img.shields.io/static/v1?label=java&message=1.8&color="/>
<img src="https://img.shields.io/static/v1?label=mac|win|linux&message=7.0.0&color=yellow"/>
</div>



> 此项目短小精悍。核心代码不到200行。极为简单。快来看一看吧。



### 📌项目介绍

世界之大，无奇不有。大家好。欢迎观看本文档。
“CtrlCQ”是怎么回事呢？“Ctrl+C”相信大家都很熟悉，但是“CtrlCQ”又是怎么回事呢，
下面就让小编带大家一起了解一下吧。
CtrlCQ呢就是Ctrl+C和Ctrl+Q的组合 其实也就是 windows电脑上常用的两组按键了。
大家可能会很惊讶说 Ctrl+Q怎么会经常使用呢？
虽然大家平常经常使用Ctrl+C和Ctrl+V，。但是用了此软件后，相信不久得将来大家会习惯使用Ctrl+C和Ctrl+Q的。
因为使用Ctrl+C和Ctrl+Q你就会听到美妙的小姐姐的朗读声。不信你选择本段本文使用一下Ctrl+C和Ctrl+Q试试。
好了这就是关于 CtrlCQ  的所有介绍了。大家有什么想法呢，欢迎在评论区告诉小编一起讨论哦！

为啥这样说话？UC给钱了。（开个玩笑。~_~）



### 📌预览

![image-20200621181320074](https://gitee.com/dahuoyzs/res/raw/master/img/image-20200621181320074.png)



预览图可能版本过低，请以具体应用为准。



### 📥[点击下载](https://gitee.com/dahuoyzs/CtrlCQ/releases/v0.2.0-beta)

[ 文本朗读器 Setup 0.2.0.exe](https://oss.bigfire.cn/soft/%E6%96%87%E6%9C%AC%E6%9C%97%E8%AF%BB%E5%99%A8%20Setup%200.2.0.exe)

[ 文本朗读器-0.2.0-win.zip](https://oss.bigfire.cn/soft/%E6%96%87%E6%9C%AC%E6%9C%97%E8%AF%BB%E5%99%A8-0.2.0-win.zip)

### 🙋[我要提需求](https://gitee.com/dahuoyzs/CtrlCQ/issues)



### 📌目录结构

```
ctrlcq
├── ctrlcq-electron 	electron实现(推荐)
├───── build                      -- 构建时一些依赖
├───── data                  	   -- 项目相关的一些文件
├───── dist                       -- 打包目录
├───── public                     -- 资源文件
└───── src                        -- 源代码

├── ctrlcq-java			java实现
├── frame                      -- 窗口类
├── listenter                  -- 监听器
├── tts                        -- tts
├── url                        -- 工具类
└── App                        -- 多文件实现的启动类
└── Reader                     -- 单文件实现的启动类
```



### 📌ctrlcq-electron版本操作

```shell
#下载
git clone https://gitee.com/dahuoyzs/CtrlCQ.git
#进入目录
cd CtrlCQ/ctrlcq-electron
#安装依赖
npm install
#运行
npm run start
#打包
npm run build
```

##### npm run build时出错

> https://github.com/electron/electron/releases/
> 下载对应的包，并放入到此目录下
> C:\Users\bigfire\AppData\Local\electron\Cache



### 📌ctrlcq-java版本操作

```shell
#下载
git clone https://gitee.com/dahuoyzs/CtrlCQ.git
#进入目录
cd CtrlCQ/ctrlcq-java
#打包成可点击运行的jar包
mvn clean package
```

##### 注意事项

如需设置开机自启动，请将exe放入此目录

> C:\ProgramData\Microsoft\Windows\Start Menu\Programs\StartUp



### 📌相关链接

[Github](https://github.com/dahuoyzs/CtrlCQ)

[Gitee](https://gitee.com/dahuoyzs/CtrlCQ)



### 📌关于作者

[大火yzs](https://gitee.com/dahuoyzs)

[Saron](https://gitee.com/Saron123_admin)



### 📌推荐个阿里大牛的项目



### 📝[写作助手](https://github.com/ystcode/BlogHelper)

> - 一键发布本地文章到知乎、简书、博客园、CSDN、掘金、SegmentFault(思否)、开源中国等平台。
> - 支持的图床有：新浪、图壳、SM.MS、Github、Imgur、七牛云、腾讯云、阿里云、又拍云

此项目编写过程中也大量学习该项目中的一些代码。感谢🙏



### 📌日期

2020年6月



🙏如果帮助到你了，请帮忙点亮[Gitee](https://giteecom/dahuoyzs/CtrlCQ)右上角小星星，这将使我写小呆萌(小demo)更有动力！

❗本项目使用GPL开源协议，使用了本项目代码的项目也必须使用 GPL 协议开源。



