<%-- 
    Document   : login
    Created on : 17/12/2022, 09:15:35 PM
    Author     : CrisPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
    <head>
        <title>SICOP</title>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <link href="css/style.css" rel='stylesheet' type='text/css' />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <script src="js/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $(".dropdown img.flag").addClass("flagvisibility");

                $(".dropdown dt a").click(function () {
                    $(".dropdown dd ul").toggle();
                });

                $(".dropdown dd ul li a").click(function () {
                    var text = $(this).html();
                    $(".dropdown dt a span").html(text);
                    $(".dropdown dd ul").hide();
                    $("#result").html("Selected value is: " + getSelectedValue("sample"));
                });

                function getSelectedValue(id) {
                    return $("#" + id).find("dt a span.value").html();
                }

                $(document).bind('click', function (e) {
                    var $clicked = $(e.target);
                    if (!$clicked.parents().hasClass("dropdown"))
                        $(".dropdown dd ul").hide();
                });


                $("#flagSwitcher").click(function () {
                    $(".dropdown img.flag").toggleClass("flagvisibility");
                });
            });
        </script>
    </head>
    <body>
        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="header-left">
                            <div class="logo">
                                <a href="index.jsp"><img src="../images/logo.png" alt="logo del proyecto"/></a>
                            </div>
                            <div class="menu">
                                <a class="toggleMenu" href="#"><img src="images/nav.png" alt="" /></a>
                                <ul class="nav" id="nav">
                                    <li><a href="shop.jsp">Tienda</a></li>
                                    <li><a href="team.jsp">SICOP</a></li>
                                    <li><a href="experiance.jsp">Categoria</a></li>
                                    <li><a href="shop.jsp">Productos</a></li>
                                    <li><a href="contact.jsp">Contactanos</a></li>	
                                    <li><a href="login.xhtml">Ingresar</a></li>								
                                    <div class="clear"></div>
                                </ul>
                                <script type="text/javascript" src="js/responsive-nav.js"></script>
                            </div>							
                            <div class="clear"></div>
                        </div>
                        <div class="header_right">
                            <!-- start search-->
                            <div class="search-box">
                                <div id="sb-search" class="sb-search">
                                    <form>
                                        <input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
                                        <input class="sb-search-submit" type="submit" value="">
                                        <span class="sb-icon-search"> </span>
                                    </form>
                                </div>
                            </div>
                            <!----search-scripts---->
                            <script src="js/classie.js"></script>
                            <script src="js/uisearch.js"></script>
                            <script>
new UISearch(document.getElementById('sb-search'));
                            </script>
                            <ul class="icon1 sub-icon1 profile_img">
                                <li><a class="active-icon c1" href="#"> </a>
                                    <ul class="sub-icon1 list">
                                        <div class="product_control_buttons">
                                            <a href="#"><img src="images/edit.png" alt=""/></a>
                                            <a href="#"><img src="images/close_edit.png" alt=""/></a>
                                        </div>
                                        <div class="clear"></div>
                                        <li class="list_img"><img src="images/1.jpg" alt=""/></li>
                                        <li class="list_desc"><h4><a href="#">Producto Seleccionado</a></h4><span class="actual">1 x
                                                $85.000</span></li>
                                        <div class="login_buttons">
                                            <div class="check_button"><a href="checkout.jsp">Confirmar</a></div>
                                            <div class="login_button"><a href="login.jsp">Ingresar</a></div>
                                            <div class="clear"></div>
                                        </div>
                                        <div class="clear"></div>
                                    </ul>
                                </li>
                            </ul>
                            <div class="clear"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="main">
            <div class="shop_top">
                <div class="container">
                    <div class="col-md-6">
                        <div class="login-page">
                            <h4 class="title">Nuevos Clientes</h4>
                            <p>Parece que estás interesado en nuestros servicios. ¡Gracias por considerar nuestra empresa! Si podemos ayudarte en algo, solo envía un correo electrónico o llámanos.</p>
                            <div class="button1">
                                <a href="register.html"><input type="submit" name="Submit" value="Crear Cuenta"></a>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="login-title">
                            <h4 class="title">CLIENTES REGISTRADOS</h4>
                            <div id="loginbox" class="loginbox">
                                <form action="" method="post" name="login" id="login-form">
                                    <fieldset class="input">
                                        <p id="login-form-username">
                                            <label for="modlgn_username">Correo</label>
                                            <input id="modlgn_username" type="text" name="email" class="inputbox" size="18" autocomplete="off">
                                        </p>
                                        <p id="login-form-password">
                                            <label for="modlgn_passwd">Contraseña</label>
                                            <input id="modlgn_passwd" type="password" name="password" class="inputbox" size="18" autocomplete="off">
                                        </p>
                                        <div class="remember">
                                            <p id="login-form-remember">
                                                <label for="modlgn_remember"><a href="#">¿Olvidaste tu contraseña? </a></label>
                                            </p>
                                            <input type="submit" name="Submit" class="button" value="Ingresar"><div class="clear"></div>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <ul class="footer_box">
                        <h4>Productos</h4>
                        <li><a href="#">Promociones</a></li>
                        <li><a href="#">Precios</a></li>
                        <li><a href="#">Categorias</a></li>
                    </ul>
                </div>
                <div class="col-md-3">
                    <ul class="footer_box">
                        <h4>Acerca de</h4>
                        <li><a href="#">SICOP</a></li>
                        <li><a href="#">Equipo</a></li>
                        <li><a href="#">Solicitudes</a></li>
                        

                    </ul>
                </div>
                <div class="col-md-3">
                    <ul class="footer_box">
                        <h4>Soporte</h4>
                        <li><a href="#">Contactanos</a></li>
                        <li><a href="#">sicop@gmail.com</a></li>
                        <li><a href="#">3134670588</a></li>
                        <li><a href="#">Ayuda</a></li>
                        
                    </ul>
                </div>
                <div class="col-md-3">
                    <ul class="footer_box">
                        <h4>Opiniones</h4>
                        <div class="footer_search">
                            <form>
                                <input type="text" value="Enter your email" onfocus="this.value = '';" onblur="if (this.value == '') {
                                            this.value = 'Enter your email';
                                        }">
                                <input type="submit" value="Go">
                            </form>
                        </div>
                        <ul class="social">	
                            <li class="facebook"><a href="#"><span> </span></a></li>
                            <li class="twitter"><a href="#"><span> </span></a></li>
                            <li class="instagram"><a href="#"><span> </span></a></li>	
                            <li class="pinterest"><a href="#"><span> </span></a></li>	
                            <li class="youtube"><a href="#"><span> </span></a></li>										  				
                        </ul>

                    </ul>
                </div>
            </div>
            <div class="row footer_bottom">
                <div class="copy">
                    <p>© 2022 COMPANY <a href="" target="_blank">SICOP</a></p>
                </div>
                <dl id="sample" class="dropdown">
                    <dt><a href="#"><span>Cambiar Región</span></a></dt>
                    <dd>
                        <ul>
                            <li><a href="#">Australia<img class="flag" src="images/as.png" alt="" /><span class="value">AS</span></a></li>
                            <li><a href="#">Sri Lanka<img class="flag" src="images/srl.png" alt="" /><span class="value">SL</span></a></li>
                            <li><a href="#">Newziland<img class="flag" src="images/nz.png" alt="" /><span class="value">NZ</span></a></li>
                            <li><a href="#">Pakistan<img class="flag" src="images/pk.png" alt="" /><span class="value">Pk</span></a></li>
                            <li><a href="#">United Kingdom<img class="flag" src="images/uk.png" alt="" /><span class="value">UK</span></a></li>
                            <li><a href="#">United States<img class="flag" src="images/us.png" alt="" /><span class="value">US</span></a></li>
                        </ul>
                    </dd>
                </dl>
            </div>
        </div>
    </div>
</body>	
</html>