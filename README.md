# wow-client
魔兽世界开放api的java客户端

由于国服战网api关闭，目前只实现了通过wowhead的api获取物品信息，如果需要会考虑实现战网的所有api

## 使用

jar包下载
[下载地址1](https://github.com/liufeng0103/wow-client/raw/master/release/wow-client-1.0.0.jar)
[下载地址2](https://github.com/liufeng0103/wow-client/releases/download/v1.0.0/wow-client-1.0.0.jar)

使用WowHeadClient获取物品信息
```
// 如获取星光玫瑰(id: 124105)的信息
XItem item = WowHeadClient.getInstance().getItem(124105);
System.out.println(item);
```
