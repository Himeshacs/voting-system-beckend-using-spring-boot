<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext['request'].contextPath}"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>TRMM - Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/png" href="assets/images/icon/favicon.ico">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/themify-icons.css">
    <link rel="stylesheet" href="assets/css/metisMenu.css">
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/slicknav.min.css">
    <!-- amchart css -->
    <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
    <!-- others css -->
    <link rel="stylesheet" href="assets/css/typography.css">
    <link rel="stylesheet" href="assets/css/default-css.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/responsive.css">
    <!-- modernizr css -->
    <script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    <!-- preloader area start -->
    <div id="preloader">
        <div class="loader"></div>
    </div>
    <!-- preloader area end -->
    <!-- login area start -->
    <div class="login-area login-s2">
        <div class="container">
            <div class="login-box ptb--100">
                <form action="web" method="POST" >
                    <div class="login-form-head">
                         <h4>Sign In Voting System</h4>
                      <!--   <p>Hello there, Sign in and start managing your Transport System</p> -->
                        
                       <p>Hello there, Sign in and start managing your  System</p> 
                    </div>
                    <div class="login-form-body">
                        <div class="form-gp">
                            <label for="exampleInputEmail1">Email address</label>
                            <input type="email" name="email" id="exampleInputEmail">
                            <i class="ti-email"></i>
                            
                        </div>
                        <div class="form-gp">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" name="password" id="exampleInputPassword">
                            <i class="ti-lock"></i>
                        </div>
                        <div class="row mb-4 rmber-area">
                            <div class="col-6">
                                <div class="custom-control custom-checkbox mr-sm-2">
                                    <input type="checkbox" class="custom-control-input" id="customControlAutosizing">
                                    <label class="custom-control-label" for="customControlAutosizing">Remember Me</label>
                                </div>
                            </div>
                            <div class="col-6 text-right">
                                <a href="#">Forgot Password?</a>
                            </div>
                            
                            <div class="col-12 text-right">
                            ${message}
                            </div>
                            
                            
                            
                        </div>
                        <div class="submit-btn-area">
                            <button id="form_submit" type="submit">Submit <i class="ti-arrow-right"></i></button>
                        </div>
                        
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- login area end -->

    <!-- jquery latest version -->
    <script src="assets/js/vendor/jquery-2.2.4.min.js"></script>
    <!-- bootstrap 4 js -->
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <script src="assets/js/metisMenu.min.js"></script>
    <script src="assets/js/jquery.slimscroll.min.js"></script>
    <script src="assets/js/jquery.slicknav.min.js"></script>
    
    <!-- others plugins -->
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/scripts.js"></script>
    
    
    <script>
  
       $(document).ready(function () {

         //alert("SSS");
         
         
         
                               });


    
    /* function Shop_save(){
     var owname = document.getElementById("owname").value;
     var sname = document.getElementById("sname").value;
     var email = document.getElementById("email").value;
     var tel = document.getElementById("tel").value;
     var add1 = document.getElementById("add1").value;
     var add2 = document.getElementById("add2").value;
     var add3 = document.getElementById("add3").value;
     var location_id = document.getElementById("location_id").value;
     
     var lon = document.getElementById("lon").value;
     var lat = document.getElementById("lat").value;
//     owname,sname,email,tel,add1,add2,add3,location_id
     
      var shop_id = document.getElementById("shop_id").value;

                    $.ajax({
            type: "POST",
            url: "shop_update",
            data: {"owname":owname,"sname":sname,"email":email,
                "tel":tel,"add1":add1,"add2":add2,"add3":add3,"location_id":location_id,"shop_id":shop_id}, // fix: need to append your data to the call
            success: function (data) {
               alert(data);
                   
            }
        });
                   
                        
          

        
        
} */


/* function load_location_list(){
    $.ajax({
        contentType: "application/json",
        type: "POST",
        url: "get_location_list",
          success: function (data) {
//              alert(data);
              var json = JSON.parse(data);
            
              for(var i=0;i<json.length;i++){
                  var IDD  = json[i]['id'].toString();
                   var name= json[i]['name'];
//                   alert(IDD);
                   $("#location_id").append("<option value='"+IDD+"'>"+name+"</option>");
                
               }            
                           
            }
    });
}
 function load_shop_list(){
    $.ajax({
        contentType: "application/json",
        type: "POST",
        url: "get_all_shop",
          success: function (data) {
//              alert(data);
              var trHTML = '';
              var json = JSON.parse(data);
//                         alert(json.length);
              for(var i=0;i<json.length;i++){
     
                    var id=json[i]['id'];
                    var name=json[i]['name'];
                    var address=json[i]['address'];
                    var address2=json[i]['address2'];
                    var address3=json[i]['address3'];
                    var location_id=json[i]['location_id'];
                    var lon=json[i]['lon'];
                    var lat=json[i]['lat'];
                    var owner_name=json[i]['owner_name'];
                    var company_id=json[i]['company_id'];
                    var location_name=json[i]['location_name'];
                    var email=json[i]['spare1'];
                    var tel=json[i]['spare2'];

                   
trHTML += '<tr><td>' + id+ '</td><td>' + name+ '</td><td>' + address+ '</td>\n\
<td>' + address2 + '</td><td>' + address3 + '</td><td>' + lon + '</td><td>' + lat + '</td>\n\
<td>' + owner_name+ '</td><td>' + location_name + '</td><td>' + email + '</td><td>' + tel + '</td>\n\
<td><button type="button" onclick=edit(\''+encodeURIComponent(id)+'\',\''+encodeURIComponent(name)+'\',\''+encodeURIComponent(address) +'\',\''+encodeURIComponent(address2) +'\',\''+encodeURIComponent(address3)+'\',\''+encodeURIComponent(location_id)+'\',\''+encodeURIComponent(lon)+'\',\''+encodeURIComponent(lat)+'\',\''+encodeURIComponent(owner_name)+'\',\''+encodeURIComponent(email)+'\',\''+encodeURIComponent(tel)+'\'); class="btn btn-default bg-blue">Edit</button></td></tr>';
    
                       
    }       
//    alert(trHTML);
      $('#tbody_shop').append(trHTML);

        }
    });
}


function edit(id,name,address,address2,address3,location_id,lon,lat,owner_name,email,tel){
//alert((decodeURIComponent(firstname)));
     $("#shop_id").val((decodeURIComponent(id)));
     $("#sname").val((decodeURIComponent(name)));
     $("#add1").val((decodeURIComponent(address)));
     $("#add2").val((decodeURIComponent(address2)));
     $("#add3").val((decodeURIComponent(address3)));
     $("#location_id").val((decodeURIComponent(location_id)));
     $("#lon").val((decodeURIComponent(lon)));
     $("#lat").val((decodeURIComponent(lat)));
     $("#owname").val((decodeURIComponent(owner_name)));
     $("#email").val((decodeURIComponent(email)));
     $("#tel").val((decodeURIComponent(tel)));
      
          
} */
    
    
</script>
    
    
    
    
</body>

</html>