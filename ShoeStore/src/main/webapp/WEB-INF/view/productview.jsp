<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap 4 Navbar Color Schemes</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">        
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div>
            <nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
                <a href="#" class="navbar-brand">ShoeStore</a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse2">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarCollapse2">
                    <div class="navbar-nav">
                        <a href="/ShoeStore/product/list.html" class="nav-item nav-link active">Products</a>
                        <a href="/ShoeStore/cart.html" class="nav-item nav-link">Cart</a>
                    </div>
                    <form class="form-inline ml-auto" action="/ShoeStore/product/list.html" method="GET">
                        <input type="text" class="form-control mr-sm-2" name="keyword" placeholder="Keyword">
                        <button type="submit" class="btn btn-outline-light">Search</button>
                    </form>
                    <div class="form-inline ml-auto">
                        <button class="btn btn-outline-light" onclick="window.location.href='/ShoeStore/login.html'">Login</button>
                    </div>
                    <div style="margin-left: 30px">
                        <button class="btn btn-outline-light" onclick="window.location.href='/ShoeStore/register.html'">Sign Up</button>
                    </div>
                </div>
            </nav>
            
            <div class="single-product-area">
                <div class="container">
                    <div class="row">
                        <c:forEach var="prod" items="${list}">
                            <div class="col-md-3 col-sm-6" style="height: 400px; width: 292px; text-align: center; margin-top: 50px; ">
                                <div class="single-shop-product">
                                    <div class="product-image">
                                        <img src="/ShoeStore/image/${prod.image}" alt="${prod.image}" height="260px" width="230px">
                                    </div>
                                    <h3><a>${prod.prodName}</a></h2>
                                    <ins>${prod.price}</ins>
                                    <div>
                                        <button style="border-radius: 10px">Add to cart</button>
                                        <button style="border-radius: 10px" onclick="window.location.href='/ShoeStore/product/detail.html?prodId=${prod.id}'">View description</button>
                                        
                                    </div>                                    
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
