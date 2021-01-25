<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

     
    
   <div class="col-md-4 mb-3" style="display: none;">
        <input type="text" id="person_id" class="form-control" value="" required="">
   </div>
 

<div class="col-12">
                                <div class="card mt-5">
                                    <div class="card-body">
                                        <h4 class="header-title">Server side</h4>
                                        <form class="needs-validation" novalidate="">
                                            <div class="form-row">
                                             <div class="col-md-4 mb-3">
                                                 <div class="form-group">
			                                         <label class="col-form-label">Initial</label>
			                                            <select id="initial" class="custom-select">
			                                                <option selected="selected">Select Initial</option>
			                                                <option value="1">Mr</option>
			                                                <option value="2">Miss</option>
			                                            </select>
	                                        	</div>
	                                         </div>
                                        
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationCustom02">First name</label>
                                                    <input type="text" id="fname" class="form-control" placeholder="First name" value="" required="">
                                                    <div class="valid-feedback">
                                                        Looks good!
                                                    </div>
                                                </div>
                                                
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationCustom02">Last name</label>
                                                    <input type="text" id="lname" class="form-control" placeholder="Last name" value="" required="">
                                                    <div class="valid-feedback">
                                                        Looks good!
                                                    </div>
                                                </div>
                                             
                                                
                                            </div>
                                            <div class="form-row">
                                            
                                              <div class="col-md-4 mb-3">
                                                    <label for="validationCustom04">Address one</label>
                                                    <input type="text" class="form-control" id="add1" placeholder="Address" required="">
                                                    <div class="invalid-feedback">
                                                        Please provide a valid Address.
                                                    </div>
                                                </div>
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationCustom05">Address two</label>
                                                    <input type="text" class="form-control" id="add2" placeholder="Address" required="">
                                                    <div class="invalid-feedback">
                                                        Please provide a valid Address.
                                                    </div>
                                                </div>
                                                
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationCustom05">Address three</label>
                                                    <input type="text" class="form-control" id="add3" placeholder="Address" required="">
                                                    <div class="invalid-feedback">
                                                        Please provide a valid Address.
                                                    </div>
                                                </div>
                                                
                                                
                                                
                                            </div>
                                               
                                            
                                            <div class="form-row">
                                            
                                              <div class="col-md-4 mb-3">
                                                    <div class="form-group">
			                                         <label class="col-form-label">Person Type</label>
			                                            <select class="custom-select" id="p_type">
			                                                <option selected="selected">Select Person Type</option>
			                                                <option value="1">Employee</option>
			                                                <option value="2">Driver</option>
			                                            </select>
	                                        	</div>
                                                </div>
                                                
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationCustom05">Nic</label>
                                                    <input type="text" class="form-control" id="nic" placeholder="Nic" required="">
                                                    <div class="invalid-feedback">
                                                        Please provide a valid Nic.
                                                    </div>
                                                </div>
                                                
                                                 <div class="col-md-4 mb-3">
                                                 <div class="form-group">
			                                         <label class="col-form-label">Location</label>
			                                            <select id="location" class="custom-select">
			                                                <option selected="selected">Select Location</option>
			                                                
			                                            </select>
	                                        	</div>
	                                         </div>
                                                
                                                
                                                
                                            </div>
                                            
                                            
                                             <div class="form-row">
                                            
                                              
                                              <div class="col-md-4 mb-3">
                                                  <label for="validationCustom05">Mobile one</label>
                                                  <input type="text" class="form-control" id="mobile1" placeholder="Mobile one" required="">
                                                  <div class="invalid-feedback">
                                                     Please provide a valid Mobile one.
                                                  </div>
                                              </div>
                                                
                                              <div class="col-md-4 mb-3">
                                                   <label for="validationCustom05">Mobile two</label>
                                                   <input type="text" class="form-control" id="mobile2" placeholder="Mobile two" required="">
                                                   <div class="invalid-feedback">
                                                       Please provide a valid Mobile two.
                                                   </div>
                                              </div>
                                                                                                 
                                              <div class="col-md-4 mb-3">
                                                  <label for="validationCustom05">Email</label>
                                                  <input type="text" class="form-control" id="Email" placeholder="Email" required="">
                                                  <div class="invalid-feedback">
                                                     Please provide a valid Email.
                                                   </div>
                                              </div>
											</div>
											
										<div class="form-row">
											<div class="col-md-4 mb-3">
												<b class="text-muted mb-3 mt-4 d-block">Select Gender:</b>
	                                            <div class="custom-control custom-radio custom-control-inline">
	                                                <input type="radio" checked id="customRadio4" value="1" name="customRadio2" class="custom-control-input">
	                                                <label class="custom-control-label" for="customRadio4">Male</label>
	                                            </div>
	                                            <div class="custom-control custom-radio custom-control-inline">
	                                                <input type="radio" id="customRadio5" name="customRadio2" value="2" class="custom-control-input">
	                                                <label class="custom-control-label" for="customRadio5">Female</label>
	                                            </div>
                                     		</div>
                                     	</div>
                                    
                                     
                                            
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Upload</span>
                                                </div>
                                                <div class="custom-file">
                                                    <input type="file" onchange="encodeImageFileAsURL();" class="custom-file-input" id="inputFileToLoad">
                                                    <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                                                </div>
                                               
                                             
                                            </div>
                                             <div class="col-md-3 mb-3">
                                               <div id="imgTest" style="width:120px;height:120px;">
                                               
                                               
                                               
                                               </div>
                                               
                                            </div>
                                            <div class="col-md-6 mb-6">
                                               <div id="img_load" style="width:120px;height:120px;">
                                               
                                          <!-- 	<img id="myImg" src="assets/images/author/avatar.png" width="120px" height="120px"> -->
                                              	<img id="myImg" src="assets/img/person/26.png" width="120px" height="120px">
                                               
                                      
                                               </div>
                                               
                                            </div>
                                            
                                            <div class="col-md-4 mb-3" style="display: none;">
                                                   <input type="text" disabled class="form-control" id="imagesss" required="">
                                           </div>
                                           
                                     	<hr>
                                     	<div class="form-row">
                                     	
                                     		 <div class="col-md-4 mb-3">
                                                  <label for="validationCustom05">Company Identification Number</label>
                                                  <input type="text" class="form-control" id="inum" placeholder="Identification Number" required="">
                                                  <div class="invalid-feedback">
                                                     Please provide a Identification Number.
                                                   </div>
                                              </div>
                                             
                                              
                                              <div class="col-md-4 mb-3">
                                                  <label for="validationCustom05">ETF Number</label>
                                                  <input type="text" class="form-control" id="etf" placeholder="ETF Number" required="">
                                                  <div class="invalid-feedback">
                                                     Please provide a ETF Number.
                                                   </div>
                                              </div>
                                              
		                                       <div class="col-md-4 mb-3">
		                                          <label for="validationCustom05">License expired date</label>
		                                            <div class="form-group">
			                                           <input class="form-control"  type="date" value="2019-04-05" id="exampledate">
			                                        </div>
		                                     	</div>
                                     	
                                     	</div>
                                     	<div class="form-row">
                                     	
                                     	<div class="col-md-4 mb-3">
                                                  <label for="validationCustom05">License number</label>
                                                  <input type="text" class="form-control" id="lnum" placeholder="License number" required="">
                                                  <div class="invalid-feedback">
                                                     Please provide a License Number.
                                                   </div>
                                              </div>
                                     	
                                     	</div>
                                     	
                                            
                                       <div class="form-group">
                                       		<div class="form-check">
                                            	<input class="form-check-input" type="checkbox" value="" id="invalidCheck" required="">
                                                <label class="form-check-label" for="invalidCheck">Agree to terms and conditions</label>
                                                    <div class="invalid-feedback">You must agree before submitting.</div>
                                                </div>
                                       </div>
                                       
				           <div class="col-lg-6 mt-5">
				           	<button class="btn btn-primary" onclick="Person_save();" type="button">Submit form</button>
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

                         <div class="col-12 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="header-title">Person Table</h4>
                                <div class="single-table">
                                    <div class="table-responsive">
                                        <table class="table table-hover progress-table text-center">
                                            <thead class="text-uppercase">
                                                <tr>
                                                    <th scope="col">person ID</th>
                                                    <th scope="col">Initial</th>
                                                    <th scope="col">FirstName</th>
                                                    <th scope="col">lastName</th>
                                                    <th scope="col">Mobile</th>
                                                    <th scope="col">Nic</th>
                                                    <th scope="col">Join Date</th>
                                                    <th scope="col">Status</th>
                                                    <th scope="col">Location</th>
                                                    <th scope="col">Edit</th>
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
                            
           
  
                            
                            
       <script type='text/javascript'>
       
       $(document).ready(function () {

    	   load_location_list();
    	   load_person_list();
    	   
                              });
       
       
  function encodeImageFileAsURL() {

	 // alert("SSS");
	  
    var filesSelected = document.getElementById("inputFileToLoad").files;
    if (filesSelected.length > 0) {
      var fileToLoad = filesSelected[0];

      var fileReader = new FileReader();

      fileReader.onload = function(fileLoadedEvent) {
        var srcData = fileLoadedEvent.target.result; // <--- data: base64

        var newImage = document.createElement('img');
        newImage.src = srcData;
             
		document.getElementById("imgTest").innerHTML = newImage.outerHTML;
      
       $("#imagesss").val(newImage.src);
        
        return newImage.src;
      }
      fileReader.readAsDataURL(fileToLoad);
     
    }
    
  }
  
  
  
  function Person_save(){
	  
	  var person_id = document.getElementById("person_id").value;
	     var initial = document.getElementById("initial").value;
	     var fname = document.getElementById("fname").value;
	     var lname = document.getElementById("lname").value;
	     var add1 = document.getElementById("add1").value;
	     var add2 = document.getElementById("add2").value;
	     var add3 = document.getElementById("add3").value;
	     var p_type = document.getElementById("p_type").value;
	     var nic = document.getElementById("nic").value;
	     var mobile1 = document.getElementById("mobile1").value;
	     var mobile2 = document.getElementById("mobile2").value;
	     var Email = document.getElementById("Email").value;
	     var image_return = document.getElementById("imagesss").value;
	     var gender = $("input[name='customRadio2']:checked").val();
	     var location = document.getElementById("location").value;
       	     
	     var inum = document.getElementById("inum").value;
	     var etf = document.getElementById("etf").value;
	     var exdate = document.getElementById("exampledate").value;
	     var lnum = document.getElementById("lnum").value;
	     
	     if(gender){
	            // alert("Your are a - " + gender);  //1 is male // 2 is female
	         }
	     
	     //alert(person_id);
	     
	     if(person_id > 0){
	    	 //update
	    	 alert(person_id);
	    	 
	    	 $.ajax({
		            type: "POST",
		            url: "update_person",
		            data: {"initial":initial,"fname":fname,"lname":lname,"add1":add1,
		                "add2":add2,"add3":add3,"p_type":p_type,"nic":nic,"mobile1":mobile1,"mobile2":mobile2,
		                "gender":gender,"image_return":image_return,"location":location,"inum":inum,"etf":etf,
		                "exdate":exdate,"lnum":lnum,"person_id":person_id}, // fix: need to append your data to the call
		            success: function (data) {
					//alert(data);
		                    if (data == false) {
		                       $("#alert_box").append("<div class='lert alert-danger alert-dismissible fade show' role='alert'><strong>Data saved successfully!</strong> You should check in on some of those fields below.<button type='button' id='iderrclose' class='close' data-dismiss='alert' aria-label='Close'><span class='fa fa-times'></span></button></div>");
			                       
		                                setTimeout(function(){ 
		                       $('#iderrclose').trigger('click');

		                                                     }, 2000);

		                            } else {
		                      $("#alert_box").append("<div class='alert alert-success alert-dismissible fade show' role='alert'><strong>Successfully saved Data !</strong> New Records Added to the System.<button type='button' id='idclose' class='close' data-dismiss='alert' aria-label='Close'><span class='fa fa-times'></span></button></div>");
		      		                   
		                                setTimeout(function(){ 
		                      $('#idclose').trigger('click');

		                                                     }, 2000);

		                            }
		            }
		        });
	    	 
	     }else{
	    	 //insert
	    	 alert("insert");
	    	 $.ajax({
		            type: "POST",
		            url: "save_person",
		            data: {"initial":initial,"fname":fname,"lname":lname,"add1":add1,
		                "add2":add2,"add3":add3,"p_type":p_type,"nic":nic,"mobile1":mobile1,"mobile2":mobile2,
		                "gender":gender,"image_return":image_return,"location":location,"inum":inum,"etf":etf,
		                "exdate":exdate,"lnum":lnum}, // fix: need to append your data to the call
		            success: function (data) {
					//alert(data);
		                    if (data == false) {
		                       $("#alert_box").append("<div class='lert alert-danger alert-dismissible fade show' role='alert'><strong>Data saved successfully!</strong> You should check in on some of those fields below.<button type='button' id='iderrclose' class='close' data-dismiss='alert' aria-label='Close'><span class='fa fa-times'></span></button></div>");
			                       
		                                setTimeout(function(){ 
		                       $('#iderrclose').trigger('click');

		                                                     }, 2000);

		                            } else {
		                      $("#alert_box").append("<div class='alert alert-success alert-dismissible fade show' role='alert'><strong>Successfully saved Data !</strong> New Records Added to the System.<button type='button' id='idclose' class='close' data-dismiss='alert' aria-label='Close'><span class='fa fa-times'></span></button></div>");
		      		                   
		                                setTimeout(function(){ 
		                      $('#idclose').trigger('click');

		                                                     }, 2000);

		                            }
		            }
		        });
	    	 
	     }
	                
}
  
  
  
  function load_location_list(){
			$.ajax({
	           contentType: "application/json",
	           type: "POST",
	           url: "location_list",
	            success: function (data) {
		        //  alert(data);
	           var json = JSON.parse(data);
	                
	                   for(var i=0;i<json.length;i++){
	                	   
	                      var id=json[i]['id'];
	                      var name=json[i]['name'];
	                      var status=json[i]['status'];
	                      var regtime=json[i]['regtime'];
	           	
	                      $("#location").append("<option value='"+id+"'>"+name+"</option>");
	                   
	                 }            
	                             
	              }
	              
	      });
	  }

  
  
  function load_person_list(){
			$.ajax({
	           contentType: "application/json",
	           type: "POST",
	           url: "get_person_list",
	            success: function (data) {
		          //alert(data);
	           var json = JSON.parse(data);
	           var trHTML = '';
	           var initial_name="",status_name="";
	           
	                    for(var i=0;i<json.length;i++){
	                	   
	                      var id=json[i]['id'];
	                      var initial=json[i]['initial'];
	                      var fname=json[i]['fname'];
	                      var lname=json[i]['lname'];
	                      var add1=json[i]['add1'];
	                      var add2=json[i]['add2'];
	                      var add3=json[i]['add3'];
	                      var gender=json[i]['gender'];
	                      var type=json[i]['type'];
	                      var status=json[i]['status'];
	                      var regtime=json[i]['regtime'];
	                      var img=json[i]['img'];
	                      var nic=json[i]['nic'];
	                      var mobile1=json[i]['mobile1'];
	                      var mobile2=json[i]['mobile2'];
	                      var email=json[i]['email'];
	                      var spare=json[i]['spare'];
	                      var person_type=json[i]['person_type'];
	                      var location=json[i]['location'];
	                      var location_name=json[i]['location_name'];
	                      	        
	                     // alert(location);
	                      if(initial == 1){
	                    	  initial_name="MR";
	                      }else if(initial == 2){
	                    	  initial_name="Miss";
	                      }
	                      
	                      if(status == 1){
	                    	  status_name="Active"; 
	                      }else if(status == 2){
	                    	  status_name="Deactivate"; 
	                      }
	                               
	                      trHTML +='<tr><th scope="row">'+ id +'</th><td>'+initial_name+'</td><td>'+fname+'</td><td>'+lname+'</td><td>'+mobile1+'</td><td>'+nic+'</td><td>'+regtime+'</td><td><span class="status-p bg-primary">'+status_name+'</span></td><td><span class="status-p bg-primary">'+location_name+'</span></td><td><button type="button" onclick=edit(\''+encodeURIComponent(id)+'\',\''+encodeURIComponent(initial)+'\',\''+encodeURIComponent(fname) +'\',\''+encodeURIComponent(lname) +'\',\''+encodeURIComponent(add1)+'\',\''+encodeURIComponent(add2)+'\',\''+encodeURIComponent(add3)+'\',\''+encodeURIComponent(gender)+'\',\''+encodeURIComponent(person_type)+'\',\''+encodeURIComponent(nic)+'\',\''+encodeURIComponent(mobile1)+'\',\''+encodeURIComponent(mobile2)+'\',\''+encodeURIComponent(email)+'\',\''+encodeURIComponent(img)+'\',\''+encodeURIComponent(location)+'\'); class="btn btn-default bg-blue">Edit</button></td></tr>';
	                
	                     
	                     
	                 } 
	                    
	                    $('#tbody_shop').append(trHTML);
	                             
	              }
	              
	      });
	  }
  
  function edit(id,initial,fname,lname,add1,add2,add3,gender,p_type,nic,mobile1,mobile2,Email,image,location){
	//alert((decodeURIComponent(firstname)));
	//img_load<img src="img_girl.jpg" alt="Girl in a jacket">
	     $("#person_id").val((decodeURIComponent(id)));
	     $("#initial").val((decodeURIComponent(initial)));
	     $("#fname").val((decodeURIComponent(fname)));
	     $("#lname").val((decodeURIComponent(lname)));
	     $("#add1").val((decodeURIComponent(add1)));
	     $("#add2").val((decodeURIComponent(add2)));
	     $("#add3").val((decodeURIComponent(add3)));
	     $("input[name='customRadio2']:checked").val((decodeURIComponent(gender)));
	  	 $("#p_type").val((decodeURIComponent(p_type)));
	     $("#nic").val((decodeURIComponent(nic)));
	     $("#mobile1").val((decodeURIComponent(mobile1)));
	     $("#mobile2").val((decodeURIComponent(mobile2)));
	     $("#Email").val((decodeURIComponent(Email)));
	    
	     document.getElementById("myImg").src ="img/person/"+image+".png";
	    
	     $("#location").val((decodeURIComponent(location)));
	     
	     
	    
	      
	  
	   
	}
    
</script>                     