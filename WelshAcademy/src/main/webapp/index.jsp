<%-- 
    Document   : index.jsp
    Created on : 02-May-2018, 22:27:26
    Author     : Lawrence
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
        
        <link rel="icon" type="image/png" href="resources/dragon.png">
        <link href="semantic/webfonts/fontawesome-all.css" rel="stylesheet">
        <link href="resources/css/main.css" rel="stylesheet">
        <link href="semantic/css/semantic.min.css" rel="stylesheet" type="text/css"/>
        <script src="semantic/js/semantic.min.js" type="text/javascript"></script>

        <title>Welsh Academy | Welcome</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script type="text/javascript">
            function toggleForms() {
                var r = document.getElementById('registration');
                var l = document.getElementById('login');
                r.classList.toggle('is-visible');
                l.classList.toggle('is-visible');
            }
        </script>
    </head>
    <body>

        <div class="ui middle aligned center aligned grid hundredheight">
            <div class="login-register-form">
                
                <div class="ui">
                    <h1>
                        <a href="WelcomePage.html"><img class="ui image logo-large" src="resources/LOGO.png" alt="Welsh Academy"></a>
                    </h1>
                </div>
                
                <div class="authentication">
                    <form class="ui form is-visible" id="login" action="/JavaTechLearnWelsh/Login" method="POST">
                        <h2>Sign in</h2>
                        <div class="field">
                            <input type="text" placeholder="username"/>
                        </div>
                        <div class="field">
                            <input type="password" placeholder="password"/>
                        </div>
                        <p>Not registered? <a href="#" id="reg" onclick="toggleForms(); ">Create an account</a></p>
                        <button class="ui red button">Login</button>
                    </form>

                    <form class="ui form" id="registration" action="/JavaTechLearnWelsh/Login" method="POST">
                        <h2>Register</h2>
                        <div class="field">
                            <input type="text" placeholder="first name"/>
                        </div>
                        <div class="field">
                            <input type="text" placeholder="last name"/>
                        </div>
                        <div class="field">
                            <input type="text" placeholder="email address"/>
                        </div>
                        <div class="field">
                            <input type="password" placeholder="password"/>
                        </div>
                        <p>Already registered? <a href="#" id="log" onclick="toggleForms()">Sign In</a></p>
                        <button class="ui red button">Create</button>
                    </form>
                </div>
            </div>
        </div>
    </body>

</html>