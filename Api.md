# API

## 注册与登录功能

### 注册

* 用户注册

```http
POST /api/register
```

request:

```javascript
{
  "username":"",
  "password": ""
}
```

response

```javascript
{
    "code": 200,
    "success": true,
    "msg": "注册成功",
    "data": null
}
```

* 管理员注册

  ```http
  POST /api/adminRegister
  ```

  同上一个API
### 登录

用户登录

``````http
POST /api/login
``````

request:

``````json
{
    "username":"heimao",
    "password":"hahahaha"
}
``````

response:

```json
{
    "code": 200,
    "msg": "登录成功",
    "data": null
}
```

Cookies中携带 satoken用于认证



管理员登录

```http
POST /api/adminLogin
```

  同用户登录API



## 评论功能

### 用户评论

```http
POST /api/newComment
```

request：

```json
{
	"content" : ""
}
```



response :

```json
{
    "code": 200,
    "msg": "评论成功",
    "data": null
}
```

### 管理员评论

```http
POST /api/newAdminComment
```

request:

```json
{
	"content" : " "
}
```

response:

```json
{
    "code": 200,
    "msg": "评论成功",
    "data": null
}
```

### 评论查询

```http
GET /api/getAll
```



```json
[
    {
        "uid": 2,
        "content": "你好",
        "likeCount": 0,
        "authorId": 1,
        "fromAdmin": false
    }...
]
```

### 删除评论

(需要登陆)

```http
GET /api/delete/{uid}
```



