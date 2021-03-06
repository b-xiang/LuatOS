---
module: disp
summary: 显示屏控制
version: 1.0
date: 2020.03.30
---

--------------------------------------------------
# disp.init

```lua
disp.init(conf)
```

显示屏初始化

## 参数表

Name | Type | Description
-----|------|--------------
`conf`|`table`| 配置信息

## 返回值

No. | Type | Description
----|------|--------------
1 |`int`| 正常初始化1,已经初始化过2,内存不够3,初始化失败返回4

## 调用示例

```lua
-- 初始化i2c1的ssd1306
if disp.init({mode="i2c_sw", pin0=17, pin1=18}) == 1 then
    log.info("disp", "disp init complete")
end
```

## C API

```c
static int l_disp_init(lua_State *L)
```


--------------------------------------------------
# disp.close

```lua
disp.close()
```

关闭显示屏

## 参数表

> 无参数

## 返回值

> *无返回值*

## 调用示例

```lua
-- 
disp.close()
```

## C API

```c
static int l_disp_close(lua_State *L)
```


--------------------------------------------------
# disp.update

```lua
disp.update()
```

把显示数据更新到屏幕

## 参数表

> 无参数

## 返回值

> *无返回值*

## 调用示例

```lua
-- 
disp.update()
```

## C API

```c
static int l_disp_update(lua_State *L)
```


--------------------------------------------------
# disp.drawStr

```lua
disp.drawStr(content, x, y)
```

在显示屏上画一段文字,要调用disp.update才会更新到屏幕

## 参数表

Name | Type | Description
-----|------|--------------
`content`|`string`| 文件内容
`x`|`int`| 横坐标
`y`|`int`| 竖坐标

## 返回值

> *无返回值*

## 调用示例

```lua
-- 
disp.drawStr("wifi is ready", 10, 20)
```


--------------------------------------------------
# disp.setFont

```lua
disp.setFont(fontId)
```

设置字体

## 参数表

Name | Type | Description
-----|------|--------------
`fontId`|`int`| 字体id, 默认0,纯英文8x8字节. 如果支持中文支持, 那么1代表12x12的中文字体.

## 返回值

> *无返回值*

## 调用示例

```lua
-- 
disp.setFont(1)
```

## C API

```c
static int l_disp_set_font(lua_State *L)
```


