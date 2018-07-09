<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>PermSys</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"/>
    <style>
        body{
            background-image: url("/images/bg.jpg");
        }

        form{
            background-color: rgba(250,250,250,0.6);
            padding: 10px;
            margin-top: 100px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="container-fluid">
        <div class="col-md-2 col-md-offset-5">
            <form action="/login" method="post">
                <div class="form-group">
                    <label>username</label>
                    <input class="form-control" placeholder="username" name="username">
                </div>
                <div class="form-group">
                    <label>password</label>
                    <input class="form-control" placeholder="passoword"  type="password" name="password">
                </div>
                <button type="submit" class="btn btn-success">login</button>
            </form>
        </div>
    </div>

</body>


</html>