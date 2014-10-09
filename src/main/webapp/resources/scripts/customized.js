  /* ========================================================================
   Script starts for toggle sidebar
 * ======================================================================== */
  
  $(document).ready(function() {

            $(".toggle_button").on("click",function(){
              if($("#toggle_div").hasClass("col-md-3")){
                $("#toggle_div").removeClass("col-md-3").addClass("toggleclick");  
                $('.col-md-9').width('98%');				
			    $('#img1').show();
                $('#img2').hide();               
                $("#accordion").hide();
              }
              
              else if($("#toggle_div").hasClass("toggleclick")){
                $("#toggle_div").removeClass("toggleclick").addClass("col-md-3");
				 $('.col-md-9').width('80%');	
                $('#img2').show();
                $('#img1').hide();
                $("#accordion").show();
              }
            }
              );
          }
		  
              );
   /* ========================================================================
   Script starts for accordion sidebar
 * ======================================================================== */  
   
   $(document).ready(function() {
function toggleChevron(e) {
$(e.target)
.prev('.panel-heading')
.find("i.indicator")
.toggleClass('glyphicon-chevron-down glyphicon-chevron-up');
}
$('#accordion').on('hidden.bs.collapse', toggleChevron);
$('#accordion').on('shown.bs.collapse', toggleChevron);
});//]]>


