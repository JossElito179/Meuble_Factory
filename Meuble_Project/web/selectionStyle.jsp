<%@page import="models.Style"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="models.ConnectionBase"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap-5.0.2-dist/css/bootstrap.css">
    <title>Page0</title>
</head>
<style>
    body{
        margin: 0;
        text-decoration: none;
    }
</style>
<body>
    <%
        
                ConnectionBase connection=new ConnectionBase();
                Connection connex=connection.giveConSql();
                ArrayList<Style> styles=Style.getStyle(connex);
    %>
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-4"></div>
        <div class="col-lg-4 col-md-4 col-sm-4">
            <h3 class="mb-3">Choisir le Style</h3>
            <form action="StyleMatiereManager" class="needs-validation" method="get">
                <div class="mb-3">
                    <div class="row">
                        <div class="col-lg-2 col-md-2 col-sm-2">
                            <label for="" class="form-label"><h3>Style:</h3></label>
                        </div>
                        <div class="col-lg-10 col-md-10 col-sm-10" >
                            <select name="style" class="form-select form-select-lg" id="">
                                <% for(Style style: styles) {%>
                                <option value="<%= style.id_style %>"><%= style.getNom_Style() %></option>
                                <% } %>
                            </select>
                        </div>
                    </div>
                    <input type="submit" class="btn btn-primary" value="Valider">
                </div>
            </form>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-4"></div>
    </div>
        </div>
    <script src="css/bootstrap-5.0.2-dist/js/bootstrap.js"></script>
</body>
</html>