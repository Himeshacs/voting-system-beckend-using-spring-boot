<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>



    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.dataTables.min.css">
 



                <div class="row">
                    <!-- seo fact area start -->
                    
                    <div class="col-12 mt-3">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="header-title">Date wise summary report</h4>
          						<div class="col-lg-3 mt-3">
                                 <div class="form-group">
                                            <label for="example-date-input" class="col-form-label">Strat Date</label>
                                            <input class="form-control" type="date"  id="startdate">
                                        </div>
                                </div>
                                        <div class="col-lg-3 mt-3">
                                         <div class="form-group">
                                            <label for="example-date-input" class="col-form-label">End Date</label>
                                            <input class="form-control" type="date"  id="enddate">
                                        </div>     
                                        </div>   
                                <div class="col-lg-3 mt-3">
					        	<button class="btn btn-primary" onclick="load_report_list();" type="button">Search</button>
					        	<button onclick="myFunction()" class="btn btn-warning" onclick="load_report_list();" type="button">Clear</button>
					    </div> 
                    </div>
                  </div>
              	</div> 
                 	</div> 
              <div class="col-12 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="header-title">Person Table</h4>
                                <div class="single-table">
                                    <div class="table-responsive">
                                       <div class="col-12 mt-5"> 
                                      
               
               <table id=summary-table class="display nowrap" style="width:100%">
        <thead>
            <tr>
                 <th>ID</th>
                <th>Employee name</th>
                <th>Confirm/Pending</th>
                <th>VType</th>
                <th>Vnumber</th>
                <th>Direction</th>
               	<th>Location</th>
                <th>Time</th>
                 <th>Note</th>
                <th>Fule</th>
                <th>Milage</th>
                <th>Type</th>
            </tr>
        </thead>
        <tbody id="tbodyid">
        
                     
           
            
        </tbody>
        <tfoot>
            <tr>
                <th>ID</th>
                <th>EMP name</th>
                <th>Confirm/Pending</th>
                <th>VType</th>
                <th>Vnumber</th>
                <th>Direction</th>
               	<th>Location</th>
                <th>Time</th>
                <th>Note</th>
                <th>Fule</th>
                <th>Milage</th>
                <th>Type</th>
            </tr>
        </tfoot>
    </table>
                  </div> 
                              </div>
              	</div> 
                        </div></div> 
                        </div>
         <script src="https://code.jquery.com/jquery-3.3.1.js"></script>     
         <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>      
         <script src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js"></script>      
         <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.flash.min.js"></script>      
         <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>      
         <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>      
         <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>      
         <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.html5.min.js"></script>        
         <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.print.min.js"></script>          
        
         
    
     <script type='text/javascript'>
       
     $(document).ready(function() {
    	 console.clear();
    	 //current_datetime();
     	 
    	} );
       
  
     
  function load_report_list(){
	  
	  var startdate= document.getElementById("startdate").value;
	  var enddate= document.getElementById("enddate").value;
	  myFunction();  //clear console
	
	  $("#tbodyid").empty();
  
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
	                      var vehicel_type=json[i]['vehicel_type'];
	                      var direction=json[i]['direction'];
	                      var location_name=json[i]['location_name'];
	                      var time_visit=json[i]['time_visit'];
	                      var note=json[i]['note'];
	                      var fule=json[i]['fule'];
	                      var km_milage=json[i]['km_milage'];
	                      
						  var type_id=json[i]['type_id'];
						  var status=json[i]['status'];
						  
var status_name="";
						  
	                      
	                      if(status == "1"){
	                    	  //alert(status);
	                    	  status_name="Pending";
	                      }else if(status == "2"){
	                    	  //alert(status);
	                    	  status_name="Confirm";
	                      }
	                      
	                      var type_name="";
	                      
	                      if(type_id =="1"){
	                    	  type_name="Visit to another garage";
	                      }else if(type_id =="2"){
	                    	  type_name="Visit to the fule reason";
	                      }else if(type_id =="3"){
	                    	  type_name="Customer Rent a vehicle with driver";
	                      }else if(type_id =="4"){
	                    	  type_name="Customer Rent a vehicle without driver(self drive)";
	                      }else if(type_id =="5"){
	                    	  type_name="Visit to the travelling other reason";
	                      }
	                   
	                      trHTML +='<tr><th scope="row">'+ id +'</th><td>'+emp_name+'</td><td><span class="status-p bg-warning">'+status_name+'</span></td><th scope="row">'+vehicel_type+'</th><th scope="row">'+vehicel_number+'</th><td>'+direction+'</td><td>'+location_name+'</td><td>'+time_visit+'</td><td><span class="status-p bg-primary">'+note+'</span></td><td><span class="status-p bg-primary">'+fule+'</span></td><td><span class="status-p bg-primary">'+km_milage+'</span></td><td><span class="status-p bg-primary">'+type_name+'</span></td></tr>';
     
	                 } 
	                    $( "#summary-table tbody" ).append(trHTML);
	                    load_table();
	              }
	              
	      });
	  }
 
  function myFunction() {
	  console.clear();
  }
  
  function load_table(){
	 
	  $.extend($.fn.dataTable.defaults, {
	    dom: 'Bfrtip',
	    buttons: ['copy', 'csv', 'excel', 'pdf', 'print']
	  });

	  $("#summary-table").DataTable();	  	  	  		 
  }
  
  function current_datetime(){
	  var startdate= document.getElementById("startdate").value;
	  var enddate= document.getElementById("enddate").value;
	  
	  var today = new Date();
	  var date = (today.getMonth()+1)+'/'+today.getDate()+'/'+today.getFullYear();
	 /*  //alert(date);
	  document.getElementById("startdate").value = date;
	  
	  document.getElementById("enddate").value = date; */
  }


    
</script>                     
     