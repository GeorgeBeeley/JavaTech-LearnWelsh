<%-- 
    Document   : TestPage
    Created on : 02-May-2018, 22:28:45
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
        <link href="resources/css/main.css" rel="stylesheet" type="text/css"/>
        <link href="semantic/webfonts/fontawesome-all.css" rel="stylesheet">
        <link href="semantic/css/semantic.min.css" rel="stylesheet" type="text/css"/>
        <script src="semantic/js/semantic.min.js" type="text/javascript"></script>

        <title>Test Yourself | Welsh Academy</title>
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
                        <a href="TestPage.html" class="item active">
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
                <div class="ui floating right icon button" id="slide">
                    <a href="index.html">
                        <i class="fas fa-sign-out-alt"></i>
                        <span class="text" style="padding-left: 10px;">Logout</span>
                    </a>
                </div>
            </div>
        </div>

        <div class="ui center aligned grid main">
            <div class="centertext">

                <form id="getTest" action="/JavaTechLearnWelsh/NewTest" method="GET">
                    <input class="large ui button green" type="submit" value="Start New Test" />
                </form>
                
                <!-- Test area -->
                <div class="ui segment text container" id="test">

                    <h1 class="ui questionCount"><span id="qNum">1</span>/20</h1>

                    <h2 class="ui header" id="questionText">
                        Multiple choice question with 4 answers text placeholder, what is ___ in Welsh?
                    </h2>

                    <!-- multiple choice with maximum four answers-->
                    <div class="answers" id="multiple">

                        <div class="ui one grid container">
                            <div class="row two column" id="multiple-1">
                                <div class="ui column segment option">
                                    <p class="ui answer" id="answer1">Answer 1</p>
                                </div>
                                <div class="ui column segment option">
                                    <p class="ui answer" id="answer2">Answer 2</p>
                                </div>
                            </div>

                            <div class="row two column" id="multiple-2">
                                <div class="ui column segment option">
                                    <p class="ui answer" id="answer3">Testreallylongwordevenlonger</p>
                                </div>
                                <div class="ui column segment option">
                                    <p class="ui answer" id="answer4">Answer 4</p>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- END multiple choice with four answers -->

                    <!-- text input answer question-->
                    <div class="test" id="spelling-question">

                        <div class="ui one grid container answers">

                            <div class="row">
                                <div id="text-answer">

                                    <div class="ui massive input">
                                        <input placeholder="You got this..." type="text" name="answer">
                                    </div>                                        

                                </div>
                            </div>

                        </div>
                    </div>
                    <!-- END multiple choice with four answers -->
                    
                    

                </div>
                <!-- Test area end -->
            </div> 

        </div>
    </body>
</html>