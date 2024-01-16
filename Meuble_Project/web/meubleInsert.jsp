<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="models.MatierePremiere"%>
<%@page import="models.Categorie"%>
<%@page import="models.Style"%>
<%@page import="models.Grandeur"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.ConnectionBase"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title></title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">
    <link href="img/favicon.ico" rel="icon">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&family=Oswald:wght@400;500;600&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="lib/flaticon/font/flaticon.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
    <link href="./css/Style.css" rel="stylesheet">
</head>

<body>
<jsp:include page="inc/header.jsp"/>

<br><br><br><br>
            <%

                ConnectionBase connection=new ConnectionBase();
                ArrayList<Grandeur> gs=Grandeur.getGrandeur(connection.giveConSql());
                ArrayList<Style> styles=Style.getStyle(connection.giveConSql());
                ArrayList<Categorie> cts=Categorie.getAllCategories(connection.giveConSql());
                MatierePremiere mat=new MatierePremiere();
                ArrayList<MatierePremiere> mts=mat.findAllDAO(connection,MatierePremiere.class);
            %>
<div class="container-fluid bg-white">
    <div class="container">
        <div class="row">
            <div class="col-lg-5">
                <div class="d-flex flex-column justify-content-center bg-primary h-50 p-5">
                    <div class="card border-0 mb-2">
                        <img class="card-img-top" src="img/chaise.jpg" alt="">

                    </div>
                </div>
            </div>
            <div class="col-lg-1">

            </div>
            <div class="col-lg-6 col-md-6 mb-5 ">
                <div class="container w-75">
                    <h4 class="text-primary mb-4">Insertion de Meuble</h4>
                        <div class="form-group">
                            <div class="tab-content">
                                <div class="tab-content-inner active" data-content="signup">
                                    <form action="InsertionMeuble" method="get">
                                        <div class="row form-group">
                                            <div class="col-md-12">
                                                <%-- <div class="row form-group">
                                                    <div class="col-md-12"> --%>
                                                        <label for="nom">Nom du meuble </label>
                                                        <input type="text" id="nomstyle" name="nom" class="form-control">
                                                    <%-- </div> --%>
                                                    <br>
                                                                                                        <label for="categorie">Categorie modele</label>
                                                    <select name="categorie" id="style" class="form-control">
                        <% for (Categorie ct: cts){%>
                        <option value="<%= ct.id_categorie %>"><%= ct.getNom() %></option>
                            <% } %>
                                                    </select>
                                                    <br>
                                                    <label for="style">Style</label>
                                                    <select name="style" id="categorie" class="form-control">
                        <% for (Style stl: styles){%>
                        <option value="<%= stl.getId_style() %>"><%= stl.getNom_Style() %></option>
                            <% } %>
                                                    </select>
                                                    <label for="grandeur">Grandeur</label>
                                                    <select name="grandeur" id="grandeur" class="form-control">
                                                        <% for (Grandeur gd:gs){%>
                                                        <option value="<%= gd.id_grandeur %>"><%= gd.getNom() %></option>
                            <% } %>
                                                    </select>
                                                    <br>
                                                </div>
                                            </div>
                                        </div>
                                        <input type="submit" class="btn btn-primary btn-block" value="Enregistrer">
                                    </form>
                                </div>
                            </div>
                        </div>

                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="inc/footer.jsp"/>

</body>
</html>

