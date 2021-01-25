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
    <!-- amcharts css -->
    <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
    <!-- Start datatable css -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.jqueryui.min.css">
    <!-- style css -->
    <link rel="stylesheet" href="assets/css/typography.css">
    <link rel="stylesheet" href="assets/css/default-css.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/responsive.css">
    
     <link href="assets/css/lib/data-table/buttons.bootstrap.min.css" rel="stylesheet" />
    
    <!-- modernizr css -->
    <script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>



                <div class="row">
                    <!-- seo fact area start -->
                    
                    <div class="col-12 mt-5">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="header-title">Date wise summary report</h4>
          
                             <!--    <div class="form-group">
                                            <label for="example-datetime-local-input" class="col-form-label">Strat Date and time</label>
                                            <input class="form-control" type="datetime-local" value="2019-07-19T15:30:00" id="startdate">
                                </div -->   
                                
                                 <div class="form-group">
                                            <label for="example-date-input" class="col-form-label">Strat Date</label>
                                            <input class="form-control" type="date" value="2019-06-01" id="startdate">
                                        </div>
                                        
                                         <div class="form-group">
                                            <label for="example-date-input" class="col-form-label">End Date</label>
                                            <input class="form-control" type="date" value="2019-06-01" id="enddate">
                                        </div>       
                                        
                               <!--  <div class="form-group">
                                            <label for="example-datetime-local-input" class="col-form-label">End Date and time</label>
                                            <input class="form-control" type="datetime-local" value="2019-07-19T15:30:00" id="enddate">
                                </div> -->
                                        
	                    	   <div class="col-lg-6 mt-5">
					           	<button class="btn btn-primary" onclick="load_report_list();" type="button">Search</button>
					           </div> 
                                      
                                     
					</div>
                  </div>
              	</div> 
                 
                 
                           
               
                 <div class="col-12 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="header-title">Travelling report</h4>
                                <div class="single-table">
                                    <div class="table-responsive">
                                        <table class="table table-hover progress-table text-center">
                                            <thead class="text-uppercase">
                                                <tr>
                                                    <th scope="col">ID</th>
                                                    <th scope="col">Time Keeper</th>
                                                    <th scope="col">Vehicle Number</th>
                                                    <th scope="col">Direction</th>
                                                    <th scope="col">Location</th>
                                                    <th scope="col">Time</th>
                                                    <th scope="col">Note</th>
                                                    
                                                </tr>
                                            </thead>
                                            <tbody id="tbody_shop">
                                         
                                               
                                               
                                            </tbody>
                                        </table>
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

    <!-- Start datatable js -->
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
    <script src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.18/js/dataTables.bootstrap4.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.2.3/js/responsive.bootstrap.min.js"></script>
    <!-- others plugins -->
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/scripts.js"></script>
    
    
 
    <!-- nano scroller -->
    <script src="assets/js/lib/menubar/sidebar.js"></script>
    <script src="assets/js/lib/preloader/pace.min.js"></script>
    <!-- sidebar -->
    
    <!-- bootstrap -->

    <script src="assets/js/lib/bootstrap.min.js"></script><script src="assets/js/scripts.js"></script>
    <!-- scripit init-->
    <script src="assets/js/lib/data-table/datatables.min.js"></script>
    <script src="assets/js/lib/data-table/buttons.dataTables.min.js"></script>
    <script src="assets/js/lib/data-table/dataTables.buttons.min.js"></script>
    <script src="assets/js/lib/data-table/buttons.flash.min.js"></script>
    <script src="assets/js/lib/data-table/jszip.min.js"></script>
    <script src="assets/js/lib/data-table/pdfmake.min.js"></script>
    <script src="assets/js/lib/data-table/vfs_fonts.js"></script>
    <script src="assets/js/lib/data-table/buttons.html5.min.js"></script>
    <script src="assets/js/lib/data-table/buttons.print.min.js"></script>
    <script src="assets/js/lib/data-table/datatables-init.js"></script>
    
    
    
     <script type='text/javascript'>
       
       $(document).ready(function () {

    
    	   
    	   
                              });
       
  
     
  function load_report_list(){
	  
	  var startdate= document.getElementById("startdate").value;
	  var enddate= document.getElementById("enddate").value;
	  
	    
	  $("#tbody_shop").empty();
	  
			$.ajax({
				  type: "POST",
			       url: "table_load_mark",
			       data: {"startdate":startdate,"enddate":enddate}, // fix: need to append your data to the call
			       success: function (data) {
		         // alert(data);
	           var json = JSON.parse(data);
	           var trHTML = '';
	           var initial_name="",status_name="";
	           
	                    for(var i=0;i<json.length;i++){
	                	   
	                      var id=json[i]['id'];
	                      var driver_id=json[i]['driver_id'];
	                      var driver_name=json[i]['driver_name'];
	                      var empid=json[i]['empid'];
	                      var emp_name=json[i]['mark_emp_records'];
	                      var vehicel_number=json[i]['vehicel_number'];
	                      var direction=json[i]['direction'];
	                      var location_name=json[i]['location_name'];
	                      var time_visit=json[i]['time_visit'];
	                      var note=json[i]['note'];
	                      
	                     
							       	        
	                 	                               
trHTML +='<tr><th scope="row">'+ id +'</th><td>'+emp_name+'</td><th scope="row">'+vehicel_number+'</th><td>'+direction+'</td><td>'+location_name+'</td><td>'+time_visit+'</td><td><span class="status-p bg-primary">'+note+'</span></td></tr>';
	                
	                     
	                     
	                 } 
	                    
	                    $('#tbody_shop').append(trHTML);
	                             
	              }
	              
	      });
	  }

    
</script>                     
     