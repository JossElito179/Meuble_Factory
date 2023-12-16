<%-- 
    Document   : styleInsert
    Created on : 14 déc. 2023, 13:36:36
    Author     : joss
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="models.Matiere"%>
<%@page import="java.sql.Connection"%>
<%@page import="models.ConnectionBase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/bootstrap-5.0.2-dist/css/bootstrap.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
                ConnectionBase connection=new ConnectionBase();
                Connection connex=connection.giveConSql();
                ArrayList<Matiere> matieres=Matiere.getAll(connection.giveConSql());
        %>
        
        <script>
            function addMatiere(){
                const child=document.querySelector(".container");
                const copie=child.cloneNode(true);
                document.querySelector(".container2").appendChild(copie);
            }
            
        </script> 
       <div class="col-lg-5 col-md-5 col-sm-5">
            <span><h3>Insertion de matiere pour Style</h3></span>
            <form action="InsertionStyle" class="formu">
                <div class="mb-3">
                    <div class="row">
                        <label for="" class="form-label">Style</label>
                        <input type="text" name="nom_style" placeholder="Nom style" class="form-control" id="">
                    </div>
                    
                    <div class="row container">
                        <label for="" class="form-label">Nom</label>
                        <div class="col-lg-4 col-md-4 col-sm-4">
                            <select name="matieres" class="form-select form-select-lg" id="">
                                <% for(Matiere mat:matieres){ %>
                                <option value="<%= mat.Id_MatirePremiere %>"><%= mat.nom_matiere %></option>
                                <% } %>
                            </select>   
                        </div>
                        <div class="col-lg-8 col-md-8 col-sm-8">
                            <input type="number" id="qt"  name="quantites" class="form-control" placeholder="Quantite" required>
                        </div>
                    </div>
                    <div class="container2"></div>        
                </div>
                <p><input type="submit" class="btn btn-primary" value="Valider"></p>
            </form>
                <input type="button" class="btn btn-primary" onclick="addMatiere()" value="Ajouter Matiere">
        </div>
    </body>
</html>
