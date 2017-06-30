# wow-client
魔兽世界开放api的java客户端

由于国服战网api关闭，目前只实现了通过wowhead的api获取物品信息，如果需要会考虑实现战网的所有api

不知道什么原因github的release里上传不了jar，所有最新的jar放到release目录下

## 使用
使用WowHeadClient获取物品信息
```
// 如获取星光玫瑰(id: 124105)的信息
XItem item = WowHeadClient.getInstance().getItem(124105);
System.out.println(item);
```
