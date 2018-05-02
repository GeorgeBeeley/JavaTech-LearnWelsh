<%-- 
    Document   : WelcomePage
    Created on : 02-May-2018, 22:27:56
    Author     : Lawrence
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
        <link href="semantic/webfonts/fontawesome-all.css" rel="stylesheet">

        <link rel="icon" type="image/png" href="resources/dragon.png">
        <link href="resources/css/main.css" rel="stylesheet" type="text/css"/>
        <link href="semantic/css/semantic.min.css" rel="stylesheet" type="text/css"/>
        <script src="semantic/js/semantic.min.js" type="text/javascript"></script>

        <title>Home | Welsh Academy</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="ui grid">
            <div class="ten wide centered column" style="position: relative;">
                <div class="row">
                    <div class="logo-mini right">
                        <h1>
                            <a><img class="ui image" src="resources/LOGO.png" alt="Welsh Academy"></a>
                        </h1>
                    </div>
                </div>
                <div>
                    <nav class="ui red five item inverted menu">
                        <a href="WelcomePage.html" class="item active">
                            Home
                        </a>
                        <a href="TestPage.html" class="item">
                            Test Yourself
                        </a>
                        <a href="TestHistoryPage.html" class="item">
                            Test History
                        </a>
                        <a href="AddWordsPage.html" class="item">
                            Add Words
                        </a>
                        <a href="UpdateWordsPage.html" class="item">
                            Update Words
                        </a>
                    </nav>
                </div>
            </div>

            <div class="rtop popout" style="padding-left: 0; padding-right: 0;">
                <div class="ui floating right icon button" style="border-radius: 5px 0 0 5px; max-width: 95px;" id="slide">
                    <a href="index.html">
                        <i class="fas fa-sign-out-alt"></i>
                        <span class="text" style="padding-left: 10px;">Logout</span>
                    </a>
                </div>
            </div>

        </div>

        <div class="ui center aligned grid main">
            <div class="ui content">
                <img class="ui centered image icon logo" src="resources/userIcon.png" alt="Account Icon">
                <h2 style="text-align: center;">Welcome User</h2>
            </div>            
        </div>
    </body>
</html>