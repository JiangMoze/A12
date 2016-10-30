<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/29
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>

    <script type="text/javascript" src="js/jquery-1.11.0.js">



    </script>

    <script type="text/javascript">
        $(function(){
            $("#pro").change(function(){
                var s;
                $('#pro  option:selected').each(function() {
                    s=this.value;
                });


               $.ajax({
                   type:"post",
                   dataType:"text json",
                   data:"pro="+s,
                   url:"city",
                   success:function(text){
                       $("#city option").remove();

                       $(text).each(function(i){

                          $("#city").append("<option value='"+text[i].vol+"'>"+text[i].name+"</option>");

                       });


                   }



               });
            });

        });


    </script>
</head>
<body>
    <select id="pro">

        <optgroup label="东北">
            <option value="hlj">黑龙江</option>
            <option value="ln">辽宁</option>


        </optgroup>

        <optgroup label="华北">
            <option value="hb">河北省</option>
            <option value="hn">河南省</option>

        </optgroup>

    </select>


    <select id="city">


    </select>


</body>
</html>
