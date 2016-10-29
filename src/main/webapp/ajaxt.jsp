<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/29
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="js/jquery-1.11.0.js">



    </script>

    <script type="text/javascript">
        $(function(){
            $("#btn").click(function(){
                $.ajax({
                    url:"user",
                    data:"username="+$("#username").val(),
                    dataType:"text",
                    type:"post",
                    success:function(text){
                        if(text.indexOf("true")>-1){//找到了
                            alert("已经被注册了");

                        }else{
                            alert("恭喜你");

                        }

                    }



                });

            });


        });
    </script>
</head>
<body>
    用户名：<input name="username" id="username"/>
    <button id="btn">按钮</button>
</body>
</html>
