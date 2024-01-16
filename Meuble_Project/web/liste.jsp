<%@page import="java.util.ArrayList"%>
<%@page import="models.MatierePremiere"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    ConnectionBase connex=new ConnectionBase();
    MatierePremiere mat=new MatierePremiere();
    ArrayList<MatierePremiere> matieres=mat.findAllDAO(connex, MatierePremiere.class);
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
                   
                    </form>
                    <br>
            <table border="1">
                <tr>
                    <td>Matiere</td>
                    <td>Unite</td>
                </tr>
                <% for ( MatierePremiere matiere :matieres) {%>
                <tr>
                    <td><a href="composition.jsp?id=<%= matiere.Id_MatierePremiere%>"><%= matiere.nom_matiere %></a></td>
                    <td><%= matiere.unite %></td>
                </tr>
                <% } %>
            </table>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="inc/footer.jsp"/>

</body>
</html>

