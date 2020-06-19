

### 百度翻译处的语音合成接口

```java
//百度翻译  语音合成  接口
String api = "http://fanyi.baidu.com/gettts?spd=3&lan=zh&text=" + URLEncoder.encode(input, "utf-8") + "&source=web";
```





### 朗读女软件中找到的  语音合成  接口（支持倍速播放）

```java
//朗读女软件中找到的  语音合成  接口
String api = "http://tsn.baidu.com/text2audio?&lan=zh&tok=24.fd0ea7a66937cb5b6d6632c826926aaa.2592000.1594977939.282335-9613883&ctp=1&cuid=B8:88:E3:E8:8A:DE&spd=9&pit=5&vol=15&per=0&tex=" + URLEncoder.encode(input, "utf-8")
```



http://tsn.baidu.com/text2audio?&lan=zh&tok=24.fd0ea7a66937cb5b6d6632c826926aaa.2592000.1594977939.282335-9613883&ctp=1&cuid=B8:88:E3:E8:8A:DE&spd=9&pit=5&vol=15&per=0&tex=测试链接




