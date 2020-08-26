# NiuOfflineDemo

小牛离线翻译的 demo

## 小牛离线翻译

此仓库为小牛离线翻译的 Demo，主要翻译英到中日法西俄的语言

### 注意事项

- 需要在 Android 8.1 及以下系统才能运行，Android 9 和 10 会崩溃
- 需要把离线翻译的资源包放到`/storage/emulated/0/`目录，不然也会崩溃 \n（可以使用 adb push 命令推到手机的这个目录下）
- 暂时只有 armeabi-v7a 架构的 so 库，v8a 的库小牛还没有做兼容
