<%-- 
    Document   : UpdateWordsPage
    Created on : 02-May-2018, 22:28:17
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

        <title>Update Words | Welsh Academy</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>  
        <%@ page import = "java.sql.*"%>
        <%
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost/welshtranslate";

            String user = "root";
            String password = "Goods333";

            try {
                Connection con = DriverManager.getConnection(url, user, password);%>
        <div class="ui grid">
            <div class="ten wide centered column" style="position: relative;">
                <div class="row">
                    <div class="logo-mini right">
                        <h1>
                            <a href="WelcomePage.jsp"><img class="ui image" src="resources/LOGO.png" alt="Welsh Academy"></a>
                        </h1>
                    </div>
                </div>
                <div>
                    <nav class="ui red five item inverted menu">
                        <a href="WelcomePage.jsp" class="item">
                            Home
                        </a>
                        <a href="TestPage.jsp" class="item">
                            Test Yourself
                        </a>
                        <a href="TestHistoryPage.jsp" class="item">
                            Test History
                        </a>
                        <a href="AddWordsPage.jsp" class="item">
                            Add Words
                        </a>
                        <a href="UpdateWordsPage.jsp" class="item active">
                            Update Words
                        </a>
                    </nav>
                </div>
            </div>
            <div class="rtop popout" style="padding-left: 0; padding-right: 0;">
                <div class="ui floating right icon button" style="border-radius: 5px 0 0 5px;" id="slide">
                    <a href="index.jsp">
                        <i class="fas fa-sign-out-alt"></i>
                        <span class="text" style="padding-left: 10px;">Logout</span>
                    </a>
                </div>
            </div>
        </div>

        <div class="ui middle aligned center aligned grid main">
            <form>
                <div class="ui form">
                    <div class="fields">
                        <div class="field">
                            <label>Word Language</label>
                            <select class="ui fluid search dropdown" name="Gender">
                                <option value="">Language</option>
                                <option value="E">English</option>
                                <option value="W">Welsh</option>
                            </select>
                        </div>
                        <div class="field">
                            <label>Original Word</label>
                            <input type="text" placeholder="Old Word">
                        </div>
                        <div class="field">
                            <label>Updated Word</label>
                            <input type="text" placeholder="New Word">
                        </div>
                        <div class="field">
                            <label>Gender</label>
                            <select class="ui fluid search dropdown" name="Gender">
                                <option value="">Gender</option>
                                <option value="M">Masculine</option>
                                <option value="F">Feminine</option>
                            </select>
                        </div>
                    </div>
                    <div class="ui vertical animated button right" tabindex="0">
                        <div class="visible content">Submit</div>
                        <div class="hidden content">
                            <i class="fas fa-check"></i>
                        </div>
                    </div>
                </div>
            </form>

            <table class="ui celled table words">
                <thead>
                    <tr>
                        <th>English</th>
                        <th>Welsh</th>
                        <th>Gender (M/F)</th>
                    </tr>
                </thead>
                <tbody>
                    <tr><%Statement st = null;
                        ResultSet rs = null;
                        String engWord;
                        String welshWord;
                        String gender;
                        st = con.createStatement();
                        rs = st.executeQuery("SELECT * FROM words");
                        while (rs.next()) {
                            engWord = rs.getString("English");%>
                        <td><%= engWord%></td>
                        <%welshWord = rs.getString("Welsh");%>
                        <td><%= welshWord%></td>
                        <%gender = rs.getString("gender");%>
                        <td><%= gender%></td><tr></tr>
                        <%         }

                            } catch (Exception e) {
                                out.println(e.getMessage());
                                e.printStackTrace();
                            }
                        %>
                    </tr>
                    <tr>
                        <td>Cell</td>
                    </tr>
                    <tr>
                        <td>Cell</td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <th colspan="3">
                            <div class="ui right floated pagination menu">
                                <a class="icon item">
                                    <i class="left chevron icon"></i>
                                </a>
                                <a class="item">1</a>
                                <a class="item">2</a>
                                <a class="item">3</a>
                                <a class="item">4</a>
                                <a class="icon item">
                                    <i class="right chevron icon"></i>
                                </a>
                            </div>
                        </th>
                    </tr>
                </tfoot>
            </table>


        </div>
    </body>
</html>