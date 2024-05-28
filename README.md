# oneSoftPass
一款集合开发时常用功能及一些方便小工具的Web网站，让开发变得更加轻松方便

目前计划搭建的功能如下：

> 进制转换、Unicode编码转换、MD5密码加密、URL转码&解码
>
> 全球货币实时更新 & 实时汇率计算
>
> 常用网站收集、自定义网站存储
>
> Json文本初始化、正则表达式在线测试
>
> 数据库连接串测试保存、在线可视化数据库操作
>
> 自动生成常规后端代码
>
> 报错日志简单分析报错原因

该工程为后端项目，前端地址：https://github.com/SakuraEdge/oneSoftPassVue

部署流程：

1.数据库使用Mysql，创建名为osp的Schema。 在osp数据库下运行sql/struct.sql文件创建数据表

2.pom.xml更新依赖，前端项目执行npm install

3.运行OneSoftPassApplication即可