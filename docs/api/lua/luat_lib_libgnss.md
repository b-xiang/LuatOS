---
module: libgnss
summary: NMEA数据处理
version: 1.0
date: 2020.07.03
---

--------------------------------------------------
# libgnss.parse

```lua
libgnss.parse(str)
```

处理nmea数据

## 参数表

Name | Type | Description
-----|------|--------------
`str`|`string`| 原始nmea数据

## 返回值

> *无返回值*

## 调用示例

```lua
-- 解析nmea
libgnss.parse(indata)
log.info("nmea", json.encode(libgnss.getRmc()))
```

## C API

```c
static int l_libgnss_parse(lua_State *L)
```


--------------------------------------------------
# libgnss.isFix

```lua
libgnss.isFix()
```

当前是否已经定位成功

## 参数表

> 无参数

## 返回值

No. | Type | Description
----|------|--------------
1 |`boolean`| 定位成功与否

## 调用示例

```lua
-- 解析nmea
libgnss.parse(indata)
log.info("nmea", "isFix", libgnss.isFix())
```

## C API

```c
static int l_libgnss_is_fix(lua_State *L)
```


--------------------------------------------------
# libgnss.getIntLocation

```lua
libgnss.getIntLocation()
```

获取位置信息

## 参数表

> 无参数

## 返回值

No. | Type | Description
----|------|--------------
1 |`int`| lat数据, 格式为 ddmmmmmmm
2 |`int`| lng数据, 格式为 ddmmmmmmm
3 |`int`| speed数据

## 调用示例

```lua
-- 解析nmea
libgnss.parse(indata)
log.info("nmea", "loc", libgnss.getIntLocation())
```

## C API

```c
static int l_libgnss_get_int_location(lua_State *L)
```


--------------------------------------------------
# libgnss.getRmc

```lua
libgnss.getRmc()
```

获取原始RMC位置信息

## 参数表

> 无参数

## 返回值

No. | Type | Description
----|------|--------------
1 |`table`| 原始rmc数据

## 调用示例

```lua
-- 解析nmea
libgnss.parse(indata)
log.info("nmea", "rmc", json.encode(libgnss.getRmc()))
```

## C API

```c
static int l_libgnss_get_rmc(lua_State *L)
```


