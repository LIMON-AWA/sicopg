<%-- 
    Document   : index
    Created on : 17/12/2022, 06:45:40 PM
    Author     : CrisPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
    <head>
        <title>SICOP LICORERA DOÑA ROCÍ</title>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <script src="js/jquery.min.js"></script>
        <!--<script src="js/jquery.easydropdown.js"></script>-->
        <!--start slider -->
        <link rel="stylesheet" href="css/fwslider.css" media="all">
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/fwslider.js"></script>
        <!--end slider -->
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
                                     <li><a href="../index.xhtml">Ingresar</a></li>
                                     

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
                            <!----//search-scripts---->
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
        <div class="banner">
            <!-- start slider -->
            <div id="fwslider">
                <div class="slider_container">
                    <div class="slide"> 
                        <!-- Slide image -->
                        <img src="images/slider1.jpg" class="img-responsive" alt=""/>
                        <!-- /Slide image -->
                        <!-- Texts container -->
                        <div class="slide_content">
                            <div class="slide_content_wrap">
                                <!-- Text title -->
                                <h1 class="title">Alegra tus celebraciones<br>con nuestra variedad en licores.</h1>
                                <!-- /Text title -->
                                <div class="button"><a href="#">Detalles</a></div>
                            </div>
                        </div>
                        <!-- /Texts container -->
                    </div>
                    <!-- /Duplicate to create more slides -->
                    <div class="slide">
                        <img src="images/slider2.jpg" class="img-responsive" alt=""/>
                        <div class="slide_content">
                            <div class="slide_content_wrap">
                                <h1 class="title">Maximiza tu diversión.<br>Que no falte el licor</h1>
                                <div class="button"><a href="#">Detalles</a></div>
                            </div>
                        </div>
                    </div>
                    <!--/slide -->
                </div>
                <div class="timers"></div>
                <div class="slidePrev"><span></span></div>
                <div class="slideNext"><span></span></div>
            </div>
            <!--/slider -->
        </div>
        <div class="main">
            <div class="content-top">
                <h2>Productos</h2>
                <p>Observa lo que tenemos para ti</p>
                <div class="close_but"><i class="close1"> </i></div>
                <ul id="flexiselDemo3" >
                    <li><img src="images/board1.png"  /></li>
                    <li><img src="images/board2.png"  /></li>
                    <li><img src="images/board3.png"  /></li>
                    <li><img src="images/board4.png"  /></li>
                    <li><img src="images/board5.png" /></li>
                </ul>
                <h3>CONOCENOS</h3>
                <script type="text/javascript">
                    $(window).load(function () {
                        $("#flexiselDemo3").flexisel({
                            visibleItems: 5,
                            animationSpeed: 1000,
                            autoPlay: true,
                            autoPlaySpeed: 3000,
                            pauseOnHover: true,
                            enableResponsiveBreakpoints: true,
                            responsiveBreakpoints: {
                                portrait: {
                                    changePoint: 480,
                                    visibleItems: 1
                                },
                                landscape: {
                                    changePoint: 640,
                                    visibleItems: 2
                                },
                                tablet: {
                                    changePoint: 768,
                                    visibleItems: 3
                                }
                            }
                        });

                    });
                </script>
                <script type="text/javascript" src="js/jquery.flexisel.js"></script>
            </div>
        </div>
        <div class="content-bottom">
            <div class="container">
                <div class="row content_bottom-text">
                    <div class="col-md-7">
                        <h3>¿QUE ES SICOP?<br></h3>
                        <p class="m_1" style="background:#0000029"  >Es un Sistema de información enfocado a la calidad y optimización de procesos, 
                            creado con el el fin de mejorar los procesos de los negocios. Este sistema de información de implementara en un negocio de licoreria que se llama "licoreria Doña Roci"</p>
                        <button href="../index.xhtml" type="button" class="btn btn-warning" >INGRESAR</button>
                        
                    </div>
                </div>
            </div>
        </div>
        <div class="features">
            <div class="container">
                <h3 class="m_3">Categorias</h3>
                <div class="close_but"><i class="close1"> </i></div>
                <div class="row">
                    <div class="col-md-3 top_box">
                        <div class="view view-ninth"><a href="single.jsp">
                                <img src="images/pic1.png" class="img-responsive" alt=""/>
                                <div class="mask mask-1"> </div>
                                <div class="mask mask-2"> </div>
                                <div class="content">
                                    <h2>Aguardiente</h2>
                                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing.</p>
                                </div>
                            </a> </div
                    </div>
                    <h4 class="m_4"><a href="#">Aguardiente</a></h4>
                    <p class="m_5">ver más</p>
                </div>
                <div class="col-md-3 top_box">
                    <div class="view view-ninth"><a href="single.jsp">
                            <img src="images/pic2.png" class="img-responsive" alt=""/>
                            <div class="mask mask-1"> </div>
                            <div class="mask mask-2"> </div>
                            <div class="content">
                                <h2>Whisky</h2>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing.</p>
                            </div>
                        </a> </div>
                    <h4 class="m_4"><a href="#">Whisky</a></h4>
                    <p class="m_5">Ver más</p>
                </div>
                <div class="col-md-3 top_box">
                    <div class="view view-ninth"><a href="single.jsp">
                            <img src="images/pic3.png" class="img-responsive" alt=""/>
                            <div class="mask mask-1"> </div>
                            <div class="mask mask-2"> </div>
                            <div class="content">
                                <h2>Vodka</h2>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing.</p>
                            </div>
                        </a> </div>
                    <h4 class="m_4"><a href="#">Vodka</a></h4>
                    <p class="m_5">ver más</p>
                </div>
                <div class="col-md-3 top_box1">
                    <div class="view view-ninth"><a href="single.jsp">
                            <img src="images/pic4.png" class="img-responsive" alt=""/>
                            <div class="mask mask-1"> </div>
                            <div class="mask mask-2"> </div>
                            <div class="content">
                                <h2>Ron</h2>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing.</p>
                            </div>
                        </a> </div>
                    <h4 class="m_4"><a href="#">Ron</a></h4>
                    <p class="m_5">ver más</p>
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
                        <li><a href="../PaginaPrincipall/404/index.xhtml">Promociones</a></li>
                        <li><a href="../PaginaPrincipall/404/index.xhtml">Precios</a></li>
                        <li><a href="../PaginaPrincipall/404/index.xhtml">Categorias</a></li>
                    </ul>
                </div>
                <div class="col-md-3">
                    <ul class="footer_box">
                        <h4>Acerca de</h4>
                        <li><a href="../PaginaPrincipall/404/index.xhtml">SICOP</a></li>
                        <li><a href="../PaginaPrincipall/404/index.xhtml">Equipo</a></li>
                        <li><a href="../PaginaPrincipall/404/index.xhtml">Solicitudes</a></li>
                        

                    </ul>
                </div>
                <div class="col-md-3">
                    <ul class="footer_box">
                        <h4>Soporte</h4>
                        <li><a href="">Contactanos</a></li>
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
                                <input type="text" value="Enter your email" onfocus="this.value = '';" onblur="if (this.value === '') {
                                            this.value = 'Enter your email';
                                        }">
                                <input type="submit" value="Go">
                            </form>
                        </div>
                        <ul class="social">	
                           <li class="facebook"><a href="../PaginaPrincipall/404/index.xhtml"><span> </span></a></li>
                            <li class="twitter"><a href="../PaginaPrincipall/404/index.xhtml"><span> </span></a></li>
                            <li class="instagram"><a href="../PaginaPrincipall/404/index.xhtml"><span> </span></a></li>	
                            <li class="pinterest"><a href="../PaginaPrincipall/404/index.xhtml"><span> </span></a></li>	
                            <li class="youtube"><a href="../PaginaPrincipall/404/index.xhtml"><span> </span></a></li>										  				
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
                            
                            <li><a href="../PaginaPrincipall/404/index.xhtml">Australia<img class="flag" src="images/as.png" alt="" /><span class="value">AS</span></a></li>
                            <li><a href="../PaginaPrincipall/404/index.xhtml">Sri Lanka<img class="flag" src="images/srl.png" alt="" /><span class="value">SL</span></a></li>
                            <li><a href="../PaginaPrincipall/404/index.xhtml">Newziland<img class="flag" src="images/nz.png" alt="" /><span class="value">NZ</span></a></li>
                            <li><a href="../PaginaPrincipall/404/index.xhtml">Pakistan<img class="flag" src="images/pk.png" alt="" /><span class="value">Pk</span></a></li>
                            <li><a href="../PaginaPrincipall/404/index.xhtml">United Kingdom<img class="flag" src="images/uk.png" alt="" /><span class="value">UK</span></a></li>
                            <li><a href="../PaginaPrincipall/404/index.xhtml">United States<img class="flag" src="images/us.png" alt="" /><span class="value">US</span></a></li>
                        </ul>
                    </dd>
                </dl>
            </div>
        </div>
    </div>
    <meta charset="utf-8">


  <meta http-equiv="x-ua-compatible" content="ie=edge">



  <title>Error 404</title>
  <meta name="description" content="Página no encontrada">
 
    


  <meta name="viewport" content="width=device-width, initial-scale=1">



  <link rel="icon" type="image/vnd.microsoft.icon" href="/img/favicon.ico?1665134359">
  <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico?1665134359">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



    <link rel="stylesheet" href="https://licotecaonline.com/modules/anproductvideos/views/css/video-js.css" type="text/css" media="all">
  <link rel="stylesheet" href="//code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/themes/doubleshot/assets/css/theme.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/an_theme/views/fonts/lato/lato.css" type="text/css" media="all">
  <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,600i,700,800&amp;amp;subset=cyrillic,cyrillic-ext,latin-ext" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/ageverification/views/css/remodal.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/ageverification/views/css/remodal-default-theme.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/ageverification/views/css/bootstrap-select.min.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/ageverification/views/css/av.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/ageverification/views/css/bootstrap-dropdowns.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/jxmegamenu/views/css/jxmegamenu.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/jxmegamenu/views/css/items/combined_unique_styles.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/jxsearch/views/css/jxsearch.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/redsys17//views/css/front.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/megashipping/megashipping.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/g_cartreminder/views/css/front/popup/popup.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/ets_abandonedcart/views/css/abancart.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/js/jquery/ui/themes/base/minified/jquery-ui.min.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/js/jquery/ui/themes/base/minified/jquery.ui.theme.min.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/js/jquery/plugins/autocomplete/jquery.autocomplete.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/anproductextratabs/views/css/front.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/anproductvideos/views/css/front.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/anscrolltop/views/css/1247f4c2ee260d35f2489e2e0eb9125d.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/an_theme/views/css/379861936cc95a750f8628a90de8c681.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/an_brandslider/views/css/owl.carousel.min.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/an_brandslider/views/css/front.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/ps_imageslider/css/homeslider.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/an_theme/views/css/animate.min.css" type="text/css" media="screen">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/anthemeblocks/views/css/owl.carousel.min.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/anthemeblocks/views/templates/front/slider/css/style.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/anthemeblocks/views/templates/front/paymentsmethod/css/paymentsmethod.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/anthemeblocks/views/templates/front/advantagestype2/css/advantagestype2.css" type="text/css" media="all">
  <link rel="stylesheet" href="https://licotecaonline.com/modules/anthemeblocks/views/css/front.css" type="text/css" media="all">




    <script type="text/javascript" src="//vjs.zencdn.net/ie8/1.1.2/videojs-ie8.min.js" ></script>
  <script type="text/javascript" src="//vjs.zencdn.net/5.8.8/video.js" ></script>


  <script type="text/javascript">
        var jxsearch_highlight = "";
        var jxsearch_itemstoshow = "5";
        var jxsearch_minlength = "3";
        var jxsearch_navigation = "1";
        var jxsearch_navigation_position = "bottom";
        var jxsearch_pager = "1";
        var jxsearch_showall_text = "Display all results(%s more)";
        var jxsearch_showallresults = "";
        var prestashop = {"cart":{"products":[],"totals":{"total":{"type":"total","label":"Total","amount":0,"value":"0,00\u00a0\u20ac"},"total_including_tax":{"type":"total","label":"Total (impuestos incl.)","amount":0,"value":"0,00\u00a0\u20ac"},"total_excluding_tax":{"type":"total","label":"Total (impuestos excl.)","amount":0,"value":"0,00\u00a0\u20ac"}},"subtotals":{"products":{"type":"products","label":"Subtotal","amount":0,"value":"0,00\u00a0\u20ac"},"discounts":null,"shipping":{"type":"shipping","label":"Transporte","amount":0,"value":"Selecci\u00f3n pendiente"},"tax":null},"products_count":0,"summary_string":"0 Productos","vouchers":{"allowed":1,"added":[]},"discounts":[],"minimalPurchase":0,"minimalPurchaseRequired":""},"currency":{"name":"euro","iso_code":"EUR","iso_code_num":"978","sign":"\u20ac"},"customer":{"lastname":null,"firstname":null,"email":null,"birthday":null,"newsletter":null,"newsletter_date_add":null,"optin":null,"website":null,"company":null,"siret":null,"ape":null,"is_logged":false,"gender":{"type":null,"name":null},"addresses":[]},"language":{"name":"Espa\u00f1ol (Spanish)","iso_code":"es","locale":"es-ES","language_code":"es","is_rtl":"0","date_format_lite":"d\/m\/Y","date_format_full":"d\/m\/Y H:i:s","id":1},"page":{"title":"La p\u00e1gina que busca no se ha encontrado.","canonical":null,"meta":{"title":"Error 404","description":"P\u00e1gina no encontrada","keywords":"tienda online bebidas, licores online, vinos online, bebidas premium online, licoteca fuenlabrada, bebidas baratas online","robots":"index"},"page_name":"pagenotfound","body_classes":{"lang-es":true,"lang-rtl":false,"country-ES":true,"currency-EUR":true,"layout-full-width":true,"page-pagenotfound":true,"tax-display-enabled":true},"admin_notifications":[]},"shop":{"name":"Licoteca","logo":"\/img\/licoteca-logo-1665133349.jpg","stores_icon":"\/img\/logo_stores.png","favicon":"\/img\/favicon.ico"},"urls":{"base_url":"https:\/\/licotecaonline.com\/","current_url":"https:\/\/licotecaonline.com\/index.php?controller=404","shop_domain_url":"https:\/\/licotecaonline.com","img_ps_url":"https:\/\/licotecaonline.com\/img\/","img_cat_url":"https:\/\/licotecaonline.com\/img\/c\/","img_lang_url":"https:\/\/licotecaonline.com\/img\/l\/","img_prod_url":"https:\/\/licotecaonline.com\/img\/p\/","img_manu_url":"https:\/\/licotecaonline.com\/img\/m\/","img_sup_url":"https:\/\/licotecaonline.com\/img\/su\/","img_ship_url":"https:\/\/licotecaonline.com\/img\/s\/","img_store_url":"https:\/\/licotecaonline.com\/img\/st\/","img_col_url":"https:\/\/licotecaonline.com\/img\/co\/","img_url":"https:\/\/licotecaonline.com\/themes\/doubleshot\/assets\/img\/","css_url":"https:\/\/licotecaonline.com\/themes\/doubleshot\/assets\/css\/","js_url":"https:\/\/licotecaonline.com\/themes\/doubleshot\/assets\/js\/","pic_url":"https:\/\/licotecaonline.com\/upload\/","pages":{"address":"https:\/\/licotecaonline.com\/direccion","addresses":"https:\/\/licotecaonline.com\/direcciones","authentication":"https:\/\/licotecaonline.com\/iniciar-sesion","cart":"https:\/\/licotecaonline.com\/carrito","category":"https:\/\/licotecaonline.com\/index.php?controller=category","cms":"https:\/\/licotecaonline.com\/index.php?controller=cms","contact":"https:\/\/licotecaonline.com\/contactenos","discount":"https:\/\/licotecaonline.com\/descuento","guest_tracking":"https:\/\/licotecaonline.com\/seguimiento-pedido-invitado","history":"https:\/\/licotecaonline.com\/historial-compra","identity":"https:\/\/licotecaonline.com\/datos-personales","index":"https:\/\/licotecaonline.com\/","my_account":"https:\/\/licotecaonline.com\/mi-cuenta","order_confirmation":"https:\/\/licotecaonline.com\/confirmacion-pedido","order_detail":"https:\/\/licotecaonline.com\/index.php?controller=order-detail","order_follow":"https:\/\/licotecaonline.com\/seguimiento-pedido","order":"https:\/\/licotecaonline.com\/pedido","order_return":"https:\/\/licotecaonline.com\/index.php?controller=order-return","order_slip":"https:\/\/licotecaonline.com\/facturas-abono","pagenotfound":"https:\/\/licotecaonline.com\/pagina-no-encontrada","password":"https:\/\/licotecaonline.com\/recuperar-contrase\u00f1a","pdf_invoice":"https:\/\/licotecaonline.com\/index.php?controller=pdf-invoice","pdf_order_return":"https:\/\/licotecaonline.com\/index.php?controller=pdf-order-return","pdf_order_slip":"https:\/\/licotecaonline.com\/index.php?controller=pdf-order-slip","prices_drop":"https:\/\/licotecaonline.com\/productos-rebajados","product":"https:\/\/licotecaonline.com\/index.php?controller=product","search":"https:\/\/licotecaonline.com\/busqueda","sitemap":"https:\/\/licotecaonline.com\/mapa del sitio","stores":"https:\/\/licotecaonline.com\/tiendas","supplier":"https:\/\/licotecaonline.com\/proveedor","register":"https:\/\/licotecaonline.com\/iniciar-sesion?create_account=1","order_login":"https:\/\/licotecaonline.com\/pedido?login=1"},"alternative_langs":{"es":"https:\/\/licotecaonline.com\/pagina-no-encontrada"},"theme_assets":"\/themes\/doubleshot\/assets\/","actions":{"logout":"https:\/\/licotecaonline.com\/?mylogout="},"no_picture_image":{"bySize":{"small_brands_default":{"url":"https:\/\/licotecaonline.com\/img\/p\/es-default-small_brands_default.jpg","width":151,"height":41},"thumb_cover":{"url":"https:\/\/licotecaonline.com\/img\/p\/es-default-thumb_cover.jpg","width":84,"height":112},"small_default":{"url":"https:\/\/licotecaonline.com\/img\/p\/es-default-small_default.jpg","width":98,"height":98},"cart_default":{"url":"https:\/\/licotecaonline.com\/img\/p\/es-default-cart_default.jpg","width":116,"height":154},"slider_default":{"url":"https:\/\/licotecaonline.com\/img\/p\/es-default-slider_default.jpg","width":148,"height":197},"home_default":{"url":"https:\/\/licotecaonline.com\/img\/p\/es-default-home_default.jpg","width":270,"height":270},"medium_default":{"url":"https:\/\/licotecaonline.com\/img\/p\/es-default-medium_default.jpg","width":452,"height":452},"large_default":{"url":"https:\/\/licotecaonline.com\/img\/p\/es-default-large_default.jpg","width":430,"height":573},"modalsize":{"url":"https:\/\/licotecaonline.com\/img\/p\/es-default-modalsize.jpg","width":750,"height":999}},"small":{"url":"https:\/\/licotecaonline.com\/img\/p\/es-default-small_brands_default.jpg","width":151,"height":41},"medium":{"url":"https:\/\/licotecaonline.com\/img\/p\/es-default-slider_default.jpg","width":148,"height":197},"large":{"url":"https:\/\/licotecaonline.com\/img\/p\/es-default-modalsize.jpg","width":750,"height":999},"legend":""}},"configuration":{"display_taxes_label":true,"is_catalog":false,"show_prices":true,"opt_in":{"partner":true},"quantity_discount":{"type":"price","label":"Precio"},"voucher_enabled":1,"return_enabled":1},"field_required":[],"breadcrumb":{"links":[{"title":"Home","url":"https:\/\/licotecaonline.com\/"}],"count":1},"link":{"protocol_link":"https:\/\/","protocol_content":"https:\/\/"},"time":1671582253,"static_token":"ec0085c0bb03bcb5d3a042499f4a90ad","token":"b1487a5107d80e2f13f6877e7ec2ea82"};
        var search_url_local = "";
        var use_jx_ajax_search = true;
      </script>



  <script src=""></script>
			<script type="text/javascript">
				(window.gaDevIds=window.gaDevIds||[]).push('d6YPbH');
				(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
				(i[r].q=i[r].q||[]).push(arguments);},i[r].l=1*new Date();a=s.createElement(o),
				m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m);
				})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
				ga('create', 'UA-144011100-1', 'auto');
				ga('require', 'ec');</script><!-- MODULE Block contact infos -->

<!-- /MODULE Block contact infos -->


<script type="text/javascript">
    const ETS_AC_LINK_SUBMIT_LEAD_FORM = "https://licotecaonline.com/lead/";
    const ETS_AC_TRANS = {};
    ETS_AC_TRANS.captchv2_invalid = "Por favor verifique captcha ";
</script>
<script type="text/javascript">
	/*---init defines---*/

    var ets_abancart_has_browser="";var ets_abancart_close_title="Cerrar";var copied_translate="Copiado";	var ETS_ABANCART_LINK_AJAX='https://licotecaonline.com/module/ets_abandonedcart/request';	        var ETS_ABANCART_LINK_SHOPPING_CART='https://licotecaonline.com/my-shopping-carts';
    /*---end init defines---*/
	/*---init favicon---*/

                
	/*---end init favicon---*/

</script>





  <script async src="https://www.googletagmanager.com/gtag/js?id=AW-676642703"></script>
   <script> 
    window.dataLayer = window.dataLayer || []; 
    function gtag(){dataLayer.push(arguments);} 
    gtag('js', new Date()); 
    gtag('config', 'AW-676642703'); 
  </script>

    
  

    
      
    

    <main>
      
              

      <header id="header">
        
          


  <nav class="header-nav">
    
  

        
      </header>

      
        
<aside id="notifications">
  <div class="container">
    
    
    
      </div>
</aside>
      

     

    
   
      
  

<style>
            .remodal-av .dropdown-toggle:after {
            display: none;
        }
    
     .remodal-overlay {
         background: rgba(43, 46, 56, 1) !important;
     }

    .remodal-av {
        background: #05004e !important;
    }

    
     
    
      </style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js" type="text/javascript"></script>

<script>
    var mode = "live";
    var inst;

    function avAllow()
    {
        $(".remodal-av .remodal-confirm").removeClass("dis-age dis");
        $(".text-unverified").hide();
        $(".text-age").hide();
        $(".text-verified").fadeIn();
        $(".remodal-confirm").attr("data-remodal-action", "confirm");
    }

    function avReject()
    {
        if (mode !== "classic")
            $(".remodal-av .remodal-confirm").removeClass("dis");

        if (mode !== "classic")
            $(".remodal-av .remodal-confirm").addClass("dis-age");

        $(".text-verified").hide();
        $(".text-unverified").hide();
        $(".text-age").fadeIn();
        $(".remodal-confirm").attr("data-remodal-action", "");
    }

    function avLiveValidation()
    {
        $('.av-select').on('change', function() {
            performValidation();
        });
    }

    function avClassicValidation()
    {
        $('.remodal-confirm').click(function() {
            performValidation();
        });
    }

    function performValidation()
    {
        // Current date
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1; //January is 0!
        var yyyy = today.getFullYear();

        // Selected date
        var day = $(".av-day").find("option:selected").val();
        var month = $(".av-month").find("option:selected").val();
        var year = $(".av-year").find("option:selected").val();

        if(year < yyyy-18) {
            // Allowed
            avAllow();
        } else {
            if(year === yyyy-18) {
                // Check month and day
                if(month < mm) {
                    // Allowed
                    avAllow();
                } else {
                    if(month === mm) {
                        if(day <= dd) {
                            // Allowed
                            avAllow();
                        } else {
                            // Not allowed
                            avReject();
                        }
                    } else {
                        // Not allowed
                        avReject();
                    }
                }
            } else {
                // Not allowed
                avReject();
            }
        }
    }

    jQuery( document ).ready(function() {
                avLiveValidation();
        
        jQuery(".remodal-confirm").click(function () {
            if($(this).attr("data-remodal-action")==="confirm") {
                avAjax();
                inst.close();
            }
        });
    });

            jQuery( document ).ready(function() {
            $('.remodal-av').remodal({ hashTracking: false });
            $(".selectpicker").selectpicker();
            inst = $.remodal.lookup[$('[data-remodal-id=modalav]').data('remodal')];
            inst.open();
        });
    </script>

<div class="remodal remodal-av" data-remodal-id="modalav">

    <h3 style="color: #FFFFFF">Acceso permitido sólo a mayores de 18 años</h3>
        <p style="color: #FFFFFF">
                    Seleccione su fecha de nacimiento
            </p>

            <select class="selectpicker av-select av-day">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                            <option value="25">25</option>
                            <option value="26">26</option>
                            <option value="27">27</option>
                            <option value="28">28</option>
                            <option value="29">29</option>
                            <option value="30">30</option>
                            <option value="31">31</option>
                    </select>
        <select class="selectpicker av-select av-month">
            <option value="1">Enero</option>
            <option value="2">Febrero</option>
            <option value="3">Marzo</option>
            <option value="4">Abril</option>
            <option value="5">Mayo</option>
            <option value="6">Junio</option>
            <option value="7">Julio</option>
            <option value="8">Agosto</option>
            <option value="9">Septiembre</option>
            <option value="10">Octubre</option>
            <option value="11">Noviembre</option>
            <option value="12">Diciembre</option>
        </select>
        <select class="selectpicker av-select av-year">
                            <option value="2022">2022</option>
                            <option value="2021">2021</option>
                            <option value="2020">2020</option>
                            <option value="2019">2019</option>
                            <option value="2018">2018</option>
                            <option value="2017">2017</option>
                            <option value="2016">2016</option>
                            <option value="2015">2015</option>
                            <option value="2014">2014</option>
                            <option value="2013">2013</option>
                            <option value="2012">2012</option>
                            <option value="2011">2011</option>
                            <option value="2010">2010</option>
                            <option value="2009">2009</option>
                            <option value="2008">2008</option>
                            <option value="2007">2007</option>
                            <option value="2006">2006</option>
                            <option value="2005">2005</option>
                            <option value="2004">2004</option>
                            <option value="2003">2003</option>
                            <option value="2002">2002</option>
                            <option value="2001">2001</option>
                            <option value="2000">2000</option>
                            <option value="1999">1999</option>
                            <option value="1998">1998</option>
                            <option value="1997">1997</option>
                            <option value="1996">1996</option>
                            <option value="1995">1995</option>
                            <option value="1994">1994</option>
                            <option value="1993">1993</option>
                            <option value="1992">1992</option>
                            <option value="1991">1991</option>
                            <option value="1990">1990</option>
                            <option value="1989">1989</option>
                            <option value="1988">1988</option>
                            <option value="1987">1987</option>
                            <option value="1986">1986</option>
                            <option value="1985">1985</option>
                            <option value="1984">1984</option>
                            <option value="1983">1983</option>
                            <option value="1982">1982</option>
                            <option value="1981">1981</option>
                            <option value="1980">1980</option>
                            <option value="1979">1979</option>
                            <option value="1978">1978</option>
                            <option value="1977">1977</option>
                            <option value="1976">1976</option>
                            <option value="1975">1975</option>
                            <option value="1974">1974</option>
                            <option value="1973">1973</option>
                            <option value="1972">1972</option>
                            <option value="1971">1971</option>
                            <option value="1970">1970</option>
                            <option value="1969">1969</option>
                            <option value="1968">1968</option>
                            <option value="1967">1967</option>
                            <option value="1966">1966</option>
                            <option value="1965">1965</option>
                            <option value="1964">1964</option>
                            <option value="1963">1963</option>
                            <option value="1962">1962</option>
                            <option value="1961">1961</option>
                            <option value="1960">1960</option>
                            <option value="1959">1959</option>
                            <option value="1958">1958</option>
                            <option value="1957">1957</option>
                            <option value="1956">1956</option>
                            <option value="1955">1955</option>
                            <option value="1954">1954</option>
                            <option value="1953">1953</option>
                            <option value="1952">1952</option>
                            <option value="1951">1951</option>
                            <option value="1950">1950</option>
                            <option value="1949">1949</option>
                            <option value="1948">1948</option>
                            <option value="1947">1947</option>
                            <option value="1946">1946</option>
                            <option value="1945">1945</option>
                            <option value="1944">1944</option>
                            <option value="1943">1943</option>
                            <option value="1942">1942</option>
                            <option value="1941">1941</option>
                            <option value="1940">1940</option>
                            <option value="1939">1939</option>
                            <option value="1938">1938</option>
                            <option value="1937">1937</option>
                            <option value="1936">1936</option>
                            <option value="1935">1935</option>
                            <option value="1934">1934</option>
                            <option value="1933">1933</option>
                            <option value="1932">1932</option>
                            <option value="1931">1931</option>
                            <option value="1930">1930</option>
                            <option value="1929">1929</option>
                            <option value="1928">1928</option>
                            <option value="1927">1927</option>
                            <option value="1926">1926</option>
                            <option value="1925">1925</option>
                            <option value="1924">1924</option>
                            <option value="1923">1923</option>
                            <option value="1922">1922</option>
                    </select>
        <br>

    
    <button class="remodal-confirm dis">
        <span class="text-verified" style="display: none;margin: 0 20px;">
                    ACCEDER
                </span>

        <span class="text-unverified" style="margin: 0 20px;">
         ACCEDER</span>
         <span class="text-age" style="margin: 0 20px;display: none;">
         Para acceder a la web de la Licoreria Doña Rocí debes de ser mayor de 18 años
         </span>
        
            </button>

</div>
<script>
    
    function setcook() {
        var nazwa = 'cookie_ue';
        var wartosc = '1';
        var expire = new Date();
        expire.setMonth(expire.getMonth() + 12);
        document.cookie = nazwa + "==" + escape(wartosc) + ";path=/;" + ((expire === null) ? "" : ("; expires=" + expire.toGMTString()));
    }

    
        

    
        
        function closeUeNotify() {
                        $('#cookieNotice').animate(
                    {bottom: '-200px'},
                    2500, function () {
                        $('#cookieNotice').hide();
                    });
            setcook();
                    }
    
        
    
</script>
<style>
    
    .closeFontAwesome:before {
        content: "\f00d";
        font-family: "FontAwesome";
        display: inline-block;
        font-size: 23px;
        line-height: 23px;
        color: #FFFFFF;
        padding-right: 15px;
        cursor: pointer;
    }

    .closeButtonNormal {
         display: block; 
        text-align: center;
        padding: 2px 5px;
        border-radius: 2px;
        color: #030303;
        background: #FFFFFF;
        cursor: pointer;
    }

    #cookieNotice p {
        margin: 0px;
        padding: 0px;
    }


    #cookieNoticeContent {
        
                    padding:10px;
                
    }

    
</style>
    
    


	  </div>
    </div>
  </div>
</div>
        
      
    </main>

    
   <script type="text/javascript" src="https://licotecaonline.com/themes/core.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/themes/doubleshot/assets/js/theme.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/ageverification/views/js/remodal.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/ageverification/views/js/bootstrap-select.min.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/ageverification/views/js/av-functions-17.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/jxmegamenu/views/js/hoverIntent.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/jxmegamenu/views/js/superfish.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/jxmegamenu/views/js/jxmegamenu.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/jxsearch/views/js/jxsearch.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/js/jquery/ui/i18n/jquery.ui.datepicker-es.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/redsys17//views/js/front.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/ganalytics/views/js/GoogleAnalyticActionLib.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/g_cartreminder/views/js/front/popup/showpopup.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/g_cartreminder/views/js/front/notification/favico.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/g_cartreminder/views/js/front/notification/jquery.tabalert.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/g_cartreminder/views/js/front/notification/notification.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/ets_abandonedcart/views/js/jquery.countdown.min.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/ets_abandonedcart/views/js/abancart.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/ets_abandonedcart/views/js/jquery.growl.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/ets_abandonedcart/views/js/captcha.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/js/jquery/ui/jquery-ui.min.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/js/jquery/plugins/autocomplete/jquery.autocomplete.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/ps_shoppingcart/ps_shoppingcart.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/anscrolltop/views/js/front.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/an_brandslider/views/js/owl.carousel.min.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/an_brandslider/views/js/594a13ba429acf0f830827f644cc9a4d.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/ps_imageslider/js/responsiveslides.min.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/ps_imageslider/js/homeslider.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/megashipping/megashipping.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/legendimages/views/js/front.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/js/jquery/plugins/timepicker/jquery-ui-timepicker-addon.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/anproductvideos/views/js/front.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/an_theme/views/js/nprogress.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/an_theme/views/js/wow.min.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/an_theme/views/js/stickymenu.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/anthemeblocks/views/js/owl.carousel.min.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/modules/anthemeblocks/views/templates/front/slider/js/slider.js" ></script>
  <script type="text/javascript" src="https://licotecaonline.com/themes/doubleshot/assets/js/custom.js" ></script>


    

    
      <script type="text/javascript">
  </script>
</body>	
</html>