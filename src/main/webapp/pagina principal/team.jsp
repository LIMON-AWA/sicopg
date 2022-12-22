<%-- 
    Document   : team
    Created on : 17/12/2022, 09:22:41 PM
    Author     : CrisPC
--%>


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
        <!-- Add fancyBox main JS and CSS files -->
        <script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
        <link href="css/magnific-popup.css" rel="stylesheet" type="text/css">
        <script>
$(document).ready(function () {
$('.popup-with-zoom-anim').magnificPopup({
    type: 'inline',
    fixedContentPos: false,
    fixedBgPos: true,
    overflowY: 'auto',
    closeBtnInside: true,
    preloader: false,
    midClick: true,
    removalDelay: 300,
    mainClass: 'my-mfp-zoom-in'
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
                                <a class="toggleMenu" href="#"><img src="images/nav.png" alt="nav" /></a>
                                <ul class="nav" id="nav">
                                    <li><a href="shop.jsp">Tienda</a></li>
                                    <li><a href="team.jsp">SICOP</a></li>
                                    <li><a href="experiance.jsp">Categoria</a></li>
                                    <li><a href="shop.jsp">Productos</a></li>
                                    <li><a href="contact.jsp">Contactanos</a></li>	
                                    <li><a href="../index.xhtml">Ingresar</a></li>>							
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
                    <div class="row team_box">
                        <h3 class="m_2">EQUIPO SICOP</h3>
                        <div class="col-md-3 team1">
                            <a class="popup-with-zoom-anim" href="#small-dialog3"><img src="images/team1.png" class="img-responsive" title="continue" alt=""/></a>
                            <div id="small-dialog3" class="mfp-hide">
                                <div class="pop_up2">
                                    <h2>DESARROLLADOR</h2>
                                    <p>CRISTIAN DAVID BOYACÁ GONZALEZ </p>
                                    <p>19 AÑOS, BOGOTÁ D.C, ANALISTA Y DESARROLLADOR DE SISTEMAS DE INFORMACIÓN. </p>
                                </div>
                            </div>
                            <h4 class="m_5"><a href="#">CRISTIAN DAVID BOYACÁ GONZALEZ</a></h4>
                            <p class="m_6">ANALISTA Y DESARROLLADOR DE SISTEMAS DE INFORMACIÓN</p>
                        </div>
                        
                        <div class="col-md-3 team1">
                            <a class="popup-with-zoom-anim" href="#small-dialog3"><img src="images/team2.png" class="img-responsive" title="continue" alt=""/></a>
                            <div id="small-dialog3" class="mfp-hide">
                                <div class="pop_up2">
                                    <h2>DESARROLLADORA </h2>
                                    <p>PATRICIA LILIANA GONZALEZ AULAR</p>
                                    <p>20 AÑOS, BOGOTÁ D.C, ANALISTA Y DESARROLLADOR DE SISTEMAS DE INFORMACIÓN.</p>
                                </div>
                            </div>
                            <h4 class="m_5"><a href="#">PATRICIA LILIANA GONZALEZ AULAR</a></h4>
                            <p class="m_6">ANALISTA Y DESARROLLADOR DE SISTEMAS DE INFORMACIÓN</p>
                        </div>
                       
                        
                    <div class="row">
                        <div class="col-md-4 team_bottom">
                            <ul class="team_list">
                                <h4>VALORES DE SICOP</h4>
                                <li><a href="#">Confiabilidad:</a><p>El ser confiable reúne los valores de honestidad, integridad, lealtad y capacidad de cumplir.</p></li>
                                <li><a href="#">Respeto:</a><p>El respeto por nuestros clientes, colaboradores, el medio ambiente y por nuestra comunidad nos coloca en un nivel superior y nos asegura permanencia.</p></li>
                                <li><a href="#">Humanidad:</a><p>Los principios y normas que promueven el desarrollo humano son el corazón de la ética.</p></li>
                                <li><a href="#">Responsabilidad:</a><p>Somos responsables de lo que hacemos y la responsabilidad exige de nosotros la excelencia.</p></li>
                            </ul>
                        </div>
                        <div class="col-md-8">
                            <ul class="team_list">
                                <h4>VISIÓN</h4>
                                <p class="m_7">Las expectativas es brindar la calidad de nuestros clientes, brindándoles un excelente servicio. Así mismo, generar valor económico para los accionistas y los empleados impulsando el crecimiento de la economía regional.</p>
                                <img src="../images/team5.jpg" class="img-responsive" alt=""/>
                            </ul>
                            
                            
                        </div>
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