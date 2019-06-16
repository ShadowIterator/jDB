# 使用说明

## 启动服务器

```bash
cd jar
java -jar jDBServer.jar
```

服务器自动运行在10086端口上。

## 启动图形界面客户端

```bash
cd jar
java -jar jDBGUI.jar
```

## GUI

### 连接服务器

![Screen Shot 2019-06-16 at 2.48.45 PM](./asset/Screen Shot 2019-06-16 at 2.48.45 PM.png)

1. 启动图形界面后自动弹出对话框输入服务器IP地址及端口。例如，127.0.0.1和10086。
2. 点击Connect即可连接服务器

### 执行语句

![gui](./asset/gui.PNG)

1. sql语句输入到左边的输入框
2. 点击`Execute`按钮
3. 在右边的输出框可以看到输出
4. 在下边栏可以看到运行时间

## Import

![import](./asset/import.PNG)

1. 点击菜单栏的`file`
2. 选择`import sql script`选项卡
3. 在弹出的文件框中选择文件
4. 选择完成之后，语句自动执行，不需要点击按钮
5. 在右边的输出框看到输出
6. 在下边栏看到运行时间