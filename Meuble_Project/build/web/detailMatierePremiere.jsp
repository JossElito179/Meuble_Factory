<%@page import="models.Matiere"%>
<%@page import="models.Style"%>
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
    <div class="container">
        <div class="row">
            <div class="col-lg-2 col-md-2 col-sm-2"></div>
            <% Style style= (Style)request.getAttribute("style"); %>
        <div class="col-lg-8 col-md-8 col-sm-8">
            <h3 class="mb-3">Style : <%= style.nom_Style %></h3>
            <div class="table-responsive">
                <table class="table table-primary">
                    <thead id="">
                        <tr>
                            <th scope="col">Matiere</th>
                        </tr>
                    </thead>
                    <tbody id="">
                        <% for (Matiere matiere: style.matierePrim){%>
                        <tr>
                            <td><%= matiere.nom_matiere %></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-lg-2 col-md-2 col-sm-2"></div>
    </div>
        </div>
    <script src="css/bootstrap-5.0.2-dist/js/bootstrap.js"></script>
</body>
</html>