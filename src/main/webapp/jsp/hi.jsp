<%--
  Created by IntelliJ IDEA.
  User: zhch
  Date: 2020/6/9
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <title>Title</title>
</head>
<body>
    <button class="jump">跳转</button>
</body>
<script>
    $(function () {
        $(".jump").click(function () {
            var data = {"username": "alice", "password": "123123"};
            //var data = "username=alice&password=123123";
            $.ajax({
                //使用jsp代理 要先执行jsp;
                //username=alice&password=123123
                url: `http://localhost/jsp/proxy.jsp?action=createCallApiMsg&url=http://localhost/home/hello&a=666&data=` + encodeURI(JSON.stringify(data)) + "&b=666",
                type: 'POST',
                //data: data,
                contentType: 'application/x-www-form-urlencoded',
                dataType: 'json',
                success: function (res) {
                    console.log(res);
                },
                error: function (err) {
                    console.log('err', err);
                }
            });
        });
    })
</script>
</html>
