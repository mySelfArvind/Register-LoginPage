<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div class="d-flex flex-column min-vh-100 min-vw-100">
            <div class="d-flex flex-grow-1 justify-content-center align-items-center">
                <form class="bg-light w-50 rounded-2 pt-2 pb-2" action="login" method="POST">
                    <div class="text-center">
                        <h6>Login</h6>
                    </div>
                    <div class="text-center">
                        <%
                            String msg = (String) request.getAttribute("msg");
                            if (msg != null) {
                        %>
                        <p class="text-success"><%=msg%></p>
                        <%
                            }
                        %>
                    </div>
                    <div class="mb-3 w-50 m-auto">
                        <label for="exampleInputEmail1" class="form-label">Email</label>
                        <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3 w-50 m-auto">
                        <label for="exampleInputPassword1" class="form-label">Password</label>
                        <input name="password" type="password" class="form-control" id="exampleInputPassword1">
                    </div>
                    <div class="w-50 m-auto text-center">
                        <button type="submit" class="btn btn-warning bg-warnings w-50 m-auto text-primary">Login</button>
                    </div>
                    <div id="emailHelp" class="form-text text-center"><a href='register.jsp'>Don't Have An Account ?</a></div>
                </form>
            </div>
        </div>
    </body>
</html>
