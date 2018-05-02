<%-- 
    Document   : TestHistoryPage
    Created on : 02-May-2018, 22:29:00
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

        <title>Test History | Welsh Academy</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>
        <div class="ui grid">
            <div class="ten wide centered column" style="position: relative;">
                <div class="row">
                    <div class="logo-mini right">
                        <h1>
                            <a href="WelcomePage.html"><img class="ui image" src="resources/LOGO.png" alt="Welsh Academy"></a>
                        </h1>
                    </div>
                </div>
                <div>
                    <nav class="ui red five item inverted menu">
                        <a href="WelcomePage.html" class="item">
                            Home
                        </a>
                        <a href="TestPage.html" class="item">
                            Test Yourself
                        </a>
                        <a href="TestHistoryPage.html" class="item active">
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
                <div class="ui floating right icon button" style="border-radius: 5px 0 0 5px;" id="slide">
                    <a href="index.html">
                        <i class="fas fa-sign-out-alt"></i>
                        <span class="text" style="padding-left: 10px;">Logout</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="ui center aligned grid">
            <div class="ui two column grid">
                <div class="ui row">
                    <h2>Total tests taken: </h2>
                </div>
                <div class="ui progress success">
                    <div class="bar">
                        <div class="progress"></div>
                    </div>
                    <div class="label">Total Test Score</div>
                </div>
            </div>
        </div> 

        <div class="ui center aligned grid main">
            <div class="ui column grid">
                <div class="ui vertical animated button" tabindex="0">
                    <div class="visible content">Test History</div>
                    <div class="hidden content">
                        <i class="fas fa-angle-double-down"></i>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>