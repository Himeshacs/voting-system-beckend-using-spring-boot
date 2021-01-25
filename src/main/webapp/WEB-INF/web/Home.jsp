<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

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

<div class="row">
                    <!-- seo fact area start -->
                    <div class="col-lg-8">
                        <div class="row">
                            <div class="col-md-6 mt-5 mb-3">
                                <div class="card">
                                    <div class="seo-fact sbg1">
                                        <div class="p-4 d-flex justify-content-between align-items-center">
                                            <div class="seofct-icon"><i class="ti-thumb-up"></i> Total Citizen Count</div>
                                            <p id="count_vehicle"></p>
                                        </div>
                                        <canvas id="seolinechart1" height="50"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 mt-md-5 mb-3">
                                <div class="card">
                                    <div class="seo-fact sbg2">
                                        <div class="p-4 d-flex justify-content-between align-items-center">
                                            <div class="seofct-icon"><i class="ti-share"></i>Total Person Count</div>
                                            
                                             <p id="count_person"></p>
                                        </div>
                                        <canvas id="seolinechart2" height="50"></canvas>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-md-6 mt-md-5 mb-3">
                                <div class="card">
                                    <div class="seo-fact sbg3">
                                        <div class="p-4 d-flex justify-content-between align-items-center">
                                            <div class="seofct-icon"><i class="ti-share"></i>Total Person Count</div>
                                           <p id="count_customer"></p>
                                        </div>
                                        <canvas id="seolinechart2" height="50"></canvas>
                                    </div>
                                </div>
                            </div>
						</div>
                    </div>
                    
                 
                </div>

     
                
                
                <!-- offset area end -->
    <!-- jquery latest version -->
    <script src="assets/js/vendor/jquery-2.2.4.min.js"></script>
    <!-- bootstrap 4 js -->
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <script src="assets/js/metisMenu.min.js"></script>
    <script src="assets/js/jquery.slimscroll.min.js"></script>
    <script src="assets/js/jquery.slicknav.min.js"></script>

    <!-- start chart js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
    <!-- start highcharts js -->
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/modules/export-data.js"></script>
    <!-- start amcharts -->
    <script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
    <script src="https://www.amcharts.com/lib/3/ammap.js"></script>
    <script src="https://www.amcharts.com/lib/3/maps/js/worldLow.js"></script>
    <script src="https://www.amcharts.com/lib/3/serial.js"></script>
    <script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
    <script src="https://www.amcharts.com/lib/3/themes/light.js"></script>
    <!-- all line chart activation -->
    <script src="assets/js/line-chart.js"></script>
    <!-- all pie chart -->
    <script src="assets/js/pie-chart.js"></script>
    <!-- all bar chart -->
    <script src="assets/js/bar-chart.js"></script>
    <!-- all map chart -->
    <script src="assets/js/maps.js"></script>
    <!-- others plugins -->
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/scripts.js"></script>
     
         <script>
     
         $(document).ready(function () {
       	 
        	 loadcount_vehcle();
        	 all_person_count();
        	 all_customer_count();
         });
         
      function loadcount_vehcle(){
         
         $.ajax({
                contentType: "application/json",
                type: "POST",
                url: "all_vehicle_count",
                success: function (data) {
                    //alert(data);
                    var json = JSON.parse(data);
                    var count_vehicle  = json[0]['count_vehicle'];
                     //alert(count_vehicle);
                    $("#count_vehicle").append("<h2>"+count_vehicle+"</h2>");
                }
            });
            
        }
      
      function all_person_count(){
          
          $.ajax({
                 contentType: "application/json",
                 type: "POST",
                 url: "all_person_count",
                 success: function (data) {
                     //alert(data);
                     var json = JSON.parse(data);
                     var count_person  = json[0]['count_person'];
                      //alert(count_vehicle);
                     $("#count_person").append("<h2>"+count_person+"</h2>");
                 }
             });
             
         } 
      
      
 function all_customer_count(){
          
          $.ajax({
                 contentType: "application/json",
                 type: "POST",
                 url: "all_customer_count",
                 success: function (data) {
                     //alert(data);
                     var json = JSON.parse(data);
                     var count_customer  = json[0]['count_customer'];
                      //alert(count_vehicle);
                     $("#count_customer").append("<h2>"+count_customer+"</h2>");
                 }
             });
             
         } 
      
  /*  function all_customer_count(){
          
          $.ajax({
                 contentType: "application/json",
                 type: "POST",
                 url: "all_customer_count",
                 success: all_customer_count (data) {
                     //alert(data);
                     var json = JSON.parse(data);
                     var count_customer  = json[0]['count_customer'];
                      //alert(count_vehicle);
                     $("#count_customer").append("<h2>"+count_customer+"</h2>");
                 }
             });
             
         }  */
      
      
        
            </script>