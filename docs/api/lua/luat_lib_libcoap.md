---
module: libcoap
summary: coap数据处理
version: 1.0
date: 2020.06.30
---

--------------------------------------------------
# libcoap.new

```lua
libcoap.new(code, uri, headers, payload)
```

创建一个coap数据包

## 参数表

Name | Type | Description
-----|------|--------------
`code`|`int`| coap的code, 例如libcoap.GET/libcoap.POST/libcoap.PUT/libcoap.DELETE
`uri`|`string`| 目标URI,必须填写, 不需要加上/开头
`headers`|`table`| 请求头,类似于http的headers,可选
`payload`|`string`| 请求体,类似于http的body,可选

## 返回值

No. | Type | Description
----|------|--------------
1 |`userdata`| coap数据包

## 调用示例

```lua
-- 创建一个请求服务器time的数据包
local coapdata = libcoap.new(libcoap.GET, "time")
local data = coapdata:rawdata()
```

## C API

```c
static int l_libcoap_new(lua_State *L)
```


--------------------------------------------------
# libcoap.parse

```lua
libcoap.parse(str)
```

解析coap数据包

## 参数表

Name | Type | Description
-----|------|--------------
`str`|`string`| coap数据包

## 返回值

No. | Type | Description
----|------|--------------
1 |`userdata`| coap数据包,如果解析失败会返回nil

## 调用示例

```lua
-- 解析服务器传入的数据包
local coapdata = libcoap.parse(indata)
log.info("coapdata", coapdata:hcode(), coapdata:data())
```

## C API

```c
static int l_libcoap_parse(lua_State *L)
```


--------------------------------------------------
# coapdata:msgid

```lua
coapdata:msgid()
```

获取coap数据包的msgid

## 参数表

> 无参数

## 返回值

No. | Type | Description
----|------|--------------
1 |`int`| coap数据包的msgid

## 调用示例

```lua
-- 解析服务器传入的数据包
local coapdata = libcoap.parse(indata)
log.info("coapdata", coapdata:msgid())
```

## C API

```c
static int libcoap_msgid(lua_State *L)
```


--------------------------------------------------
# coapdata:token

```lua
coapdata:token()
```

获取coap数据包的token

## 参数表

> 无参数

## 返回值

No. | Type | Description
----|------|--------------
1 |`string`| coap数据包的token

## 调用示例

```lua
-- 解析服务器传入的数据包
local coapdata = libcoap.parse(indata)
log.info("coapdata", coapdata:token())
```

## C API

```c
static int libcoap_token(lua_State *L)
```


--------------------------------------------------
# coapdata:rawdata

```lua
coapdata:rawdata()
```

获取coap数据包的二进制数据,用于发送到服务器

## 参数表

> 无参数

## 返回值

No. | Type | Description
----|------|--------------
1 |`string`| coap数据包的二进制数据

## 调用示例

```lua
-- 解析服务器传入的数据包
local coapdata = libcoap.new(libcoap.GET, "time")
netc:send(coapdata:rawdata())
```

## C API

```c
static int libcoap_rawdata(lua_State *L)
```


--------------------------------------------------
# coapdata:code

```lua
coapdata:code()
```

获取coap数据包的code

## 参数表

> 无参数

## 返回值

No. | Type | Description
----|------|--------------
1 |`int`| coap数据包的code

## 调用示例

```lua
-- 解析服务器传入的数据包
local coapdata = libcoap.parse(indata)
log.info("coapdata", coapdata:code())
```

## C API

```c
static int libcoap_code(lua_State *L)
```


--------------------------------------------------
# coapdata:hcode

```lua
coapdata:hcode()
```

获取coap数据包的http code, 比coap原始的code要友好

## 参数表

> 无参数

## 返回值

No. | Type | Description
----|------|--------------
1 |`int`| coap数据包的http code,例如200,205,404

## 调用示例

```lua
-- 解析服务器传入的数据包
local coapdata = libcoap.parse(indata)
log.info("coapdata", coapdata:hcode())
```


--------------------------------------------------
# coapdata:type

```lua
coapdata:type(t)
```

获取coap数据包的type, 例如libcoap.CON/NON/ACK/RST

## 参数表

Name | Type | Description
-----|------|--------------
`t`|`int`| 新的type值,可选

## 返回值

No. | Type | Description
----|------|--------------
1 |`int`| coap数据包的type

## 调用示例

```lua
-- 解析服务器传入的数据包
local coapdata = libcoap.parse(indata)
log.info("coapdata", coapdata:type())
```

## C API

```c
static int libcoap_type(lua_State *L)
```


--------------------------------------------------
# coapdata:data

```lua
coapdata:data()
```

获取coap数据包的data

## 参数表

> 无参数

## 返回值

No. | Type | Description
----|------|--------------
1 |`string`| coap数据包的data

## 调用示例

```lua
-- 解析服务器传入的数据包
local coapdata = libcoap.parse(indata)
log.info("coapdata", coapdata:data())
```

## C API

```c
static int libcoap_data(lua_State *L)
```


