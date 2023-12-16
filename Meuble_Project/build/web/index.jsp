<%@page import="java.sql.Connection"%>
<%@page import="models.Categorie"%>
<%@page import="models.Style"%>
<%@page import="models.Grandeur"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.ConnectionBase"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/bootstrap-5.0.2-dist/css/bootstrap.css">
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
        <div class="col-lg-5 col-md-5 col-sm-5">
            <%

                ConnectionBase connection=new ConnectionBase();
                ArrayList<Grandeur> gs=Grandeur.getGrandeur(connection.giveConSql());
                ArrayList<Style> styles=Style.getStyle(connection.giveConSql());
                ArrayList<Categorie> cts=Categorie.getAllCategories(connection.giveConSql());
            %>
            <h3 class="mb-3">Insertion Meuble</h3>
            <form action="InsertMeuble" method="get">
                <div class="mb-3">
                    <div class="row">
                        <label for="" class="form-label">Modele</label>
                        <input type="text" name="nom" placeholder="Nom Modele" class="form-control" id="">
                    </div>
                    <div class="row">
                        <label for="" class="form-label">Style</label>
                        
                        <select name="style" class="form-select form-select-lg" id="">
                        <% for (Style stl: styles){%>
                        <option value="<%= stl.getId_style() %>"><%= stl.getNom_Style() %></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="row">
                        <label for="" class="form-label">Categorie</label>
                        <select name="categorie" class="form-select form-select-lg" id="">
                        <% for (Categorie ct: cts){%>
                        <option value="<%= ct.id_categorie %>"><%= ct.getNom() %></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="row">
                        <label for="" class="form-label">Grandeur</label>
                        <select name="grandeur" class="form-select form-select-lg" id="">
                        <% for (Grandeur gd:gs){%>
                            <option value=""><%= gd.getNom() %></option>
                            <% } %>
                        </select>
                    </div>
                    <input type="submit" class="btn btn-primary" value="Enregistrer">
                </div>
            </form>
        </div>
        <div class="col-lg-1 col-md-1 col-sm-1"></div>
    </div>
        </div>
                        <div><a href="styleInsert.jsp">Ici</a><a href="selectionStyle.jsp">Ici2</a></div>
    <script src="css/bootstrap-5.0.2-dist/js/bootstrap.js"></script>
</body>
</html>