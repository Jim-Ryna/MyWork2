# MyWork2
红岩网校考核
==
    实现基本功能包括妹子图片长按点击实现分享
    第三个fragment上为一个简单动画，实现妹子图片抖动
分包格式：
---
    Adapter(各种listView的适配器)
    model(gson解析所用到的javabean)
    ui(activity)
    utils（工具类：包括下载用的AsynTask的子类，Imagecache的子类，及网络访问封装的HttpHelper）
    view(fragment)
存在问题：
---
    listView存在明显卡顿，参考网上解决方案后未能明显解决
    可能因为Activity继承自ActionbarActivity 导致Actionbar的自定义上存在问题
运行截图：
---
    点击显示大图，长按分享
![](https://github.com/Jim-Ryna/MyWork2/blob/master/readme%E5%9B%BE%E7%89%87/1PYQQ6Y_WD1%4051%248IS03%7BN5.png)
![](https://github.com/Jim-Ryna/MyWork2/blob/master/readme%E5%9B%BE%E7%89%87/HBI%5DSY0%7BMCP5DXTU%5D%7DT_BFN.png)  
![](https://github.com/Jim-Ryna/MyWork2/blob/master/readme%E5%9B%BE%E7%89%87/VRYHB8%40K%7DLK%400ZC%7DYU3W%251W.png)
