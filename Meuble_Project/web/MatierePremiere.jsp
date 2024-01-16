<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList"%>
<%@page import="models.ConnectionBase"%>
<%@page import="models.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>iDESIGN - Interior Design HTML Template</title>
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

    <div class="container-fluid bg-white">
        <div class="container">
            <div class="row">
                <div class="col-lg-5">
                    <div class="d-flex flex-column justify-content-center bg-primary h-50 p-5">
                        <div class="card border-0 mb-2">
                            <img class="card-img-top" src="images/portfolio/chaise.jpg" alt="">
                           
                        </div>
                    </div>
                </div>
                <div class="col-lg-1">

                </div>
                <div class="col-lg-6 col-md-6 mb-5 ">
                    <div class="container w-75">
                        <h4 class="text-primary mb-4">Veuillez passer votre commande</h4>
                        <form action="CommandeController" method="get">
                            <div class="form-group">
                                <div class="tab-content">
                                    <div class="tab-content-inner active" data-content="signup">
                                      <form action="#">
                                        <div class="row form-group">
                                          <div class="col-md-12">
                                            <div class="row form-group">
                                              <div class="col-md-12">
                                                <label for="grandeur">Matiere premiere</label>
                                                <% 
                                                ConnectionBase connex=new ConnectionBase();
                                                MatierePremiere mat=new MatierePremiere();
                                                Fournisseur fns=new Fournisseur();
                                                ArrayList<MatierePremiere> matieres=mat.findAllDAO(connex,MatierePremiere.class);
                                                ArrayList<Fournisseur> fournisseurs=fns.findAllDAO(connex,Fournisseur.class);

        %>
                                                <select name="matiere" id="matiere" class="form-control">
                                                    <% for (MatierePremiere matiere : matieres) {%>
                                                  <option value="<%= matiere.getId_MatierePremiere() %>"><%= matiere.getNom_matiere() %></option>
                                                  <% } %>
                                                </select>
                                                <br>
                                                <label for="style">Quantite</label>
                                                <input type="number" name="quantite" value="quantite">
                                                <br>
                                                <br>
                                                <label for="categorie">Fournisseur</label>
                                                <select name="fournisseur" id="grandeur" class="form-control">
                                                   <% for (Fournisseur fournisseur : fournisseurs) {%>
                                                  <option value="<%= fournisseur.Id_fournisseur %>"><%= fournisseur.nom %></option>
                                                  <% } %>
                                                </select>
                                               </div>
                                            </div>
                                            <br>
                                            <br>
                                        <div class="row form-group">
                                    <div class="col-md-12">
                                            <input type="submit" class="btn btn-primary btn-block" value="Valider">
                                    </div>
                                </div>
                                </form>	
                            </div>
                        
                        </form>
                    </div>
                </div>
            </div>
        </div>
    <jsp:include page="inc/footer.jsp"/>
</body>

</html>