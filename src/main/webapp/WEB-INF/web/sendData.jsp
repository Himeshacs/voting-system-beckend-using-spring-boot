<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.dataTables.min.css">
 
    
   <div class="col-md-4 mb-3" style="display: none;">
        <input type="text" id="v_id" class="form-control" value="" required="">
   </div>
   
    <div class="col-lg-0 mt-0">
                        <div class="card">
                            <div class="card-body">
                             <button type="button" style="display: none;" id="button_alert" class="btn btn-primary btn-flat btn-lg mt-3" data-toggle="modal" data-target="#exampleModalLong">Launch demo modal</button>
                                <!-- Modal -->
                                <div class="modal fade" id="exampleModalLong">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Alert box</h5>
                                              <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                                            </div>
                                            <div class="modal-body">
                                                <p>successfully Send</p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" id="idclose_btn" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary" data-dismiss="modal">Ok</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
 

<div class="col-12">
                                <div class="card mt-5">
                                    <div class="card-body">
                                        <h4 class="header-title">Give permission Details</h4>
                                        <form class="needs-validation" novalidate="">
                                            <div class="form-row">
                                             
                                        
                                                <div class="form-row">
                                            
                                              <div class="col-md-6 mb-6">
                                                    <div class="form-group">
			                                         <label class="col-form-label">Person Type</label>
			                                            <select class="custom-select" id="p_type">
			                                                <option value="1">Active All</option>
			                                                <option value="2">Deactive all</option>
			                                                
			                                            </select>
	                                        	</div>
                                                </div>
                                                </div>
                                             
                                                
                                             
                                                
                                            </div>
             	<hr>
                                  
                                     	
                                       
				           <div class="col-lg-6 mt-5">
				           	<button class="btn btn-primary" onclick="send();" type="button">Give Access To Citizen</button>
				           </div>
                           
                           <div class="card">
                                <div class="card-body">
                                   <div class="alert-dismiss" id="alert_box">
            	</div>
        	</div>
    	</div>
  	</form>
  </div>
  </div>
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
       
       $(document).ready(function () {

    	  
    	   
                              });

  function send(){
		  
	     var p_type = document.getElementById("p_type").value;
	     
		    	 $.ajax({
			            type: "GET",
			            url: "code",
			            data: {"p_type":p_type}, // fix: need to append your data to the call
			            success: function (data) {
						//alert(data);
			                    if (data == false) {
		                       $("#alert_box").append("<div class='lert alert-danger alert-dismissible fade show' role='alert'><strong>Data Send successfully!</strong> You should check in on some of those fields below.<button type='button' id='iderrclose' class='close' data-dismiss='alert' aria-label='Close'><span class='fa fa-times'></span></button></div>");
			                       
		                                setTimeout(function(){ 
		                       $('#iderrclose').trigger('click');
		                      // $( "#button_alert" ).trigger( "click" ); 

		                                                     }, 2000);

		                    } else {
			                    
                           	 $('#button_alert').trigger( 'click' );  
                               setTimeout(function(){ 
                               	 $('#idclose_btn').trigger('click');

                                                    }, 2000);

                           }
			            }
			        });
	    	         
}
  
  
    
</script>                     