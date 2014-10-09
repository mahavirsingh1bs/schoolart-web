function validateForm(){
	var flag = true;
	
	$('.error').text('');
	var isChecked = $('#acceptTerms').prop('checked');

	console.log(isChecked);
	if(!isChecked){
		 $('#acceptTerms_err').text('Please accept the terms.');
		 return false;
	}
	
	var id = $('#id').val();
	if($.trim(id) == ''){
		 $('#id_err').text('Please enter the Id.');
		 flag = false;
	}
	
	var pwd = $('#pwd').val();
	if($.trim(pwd) == ''){
		 $('#pwd_err').text('Please enter the password.');
		 flag = false;
	}
	
	var name = $('#name').val();
	if($.trim(name) == ''){
		 $('#name_err').text('Please enter the name.');
		 flag = false;
	}
	
	var address = $('#address').val();
	if($.trim(address) == ''){
		 $('#address_err').text('Please enter the address.');
		 flag = false;
	}
	
	var mob = $('#mob').val();
	if($.trim(mob) == ''){
		 $('#mob_err').text('Please enter the mobile number.');
		 flag = false;
	}else if(!$.isNumeric(mob)){
		 $('#mob_err').text('Please enter valid mobile number.');
		 flag = false;
	}else if($.trim(mob).length != 10){
		$('#mob_err').text('Please enter valid mobile number.');
		 flag = false;
	}
	
	if(!flag)
		return false;
	else{
		$('#tenantInfo').submit();
		return true;
	}
	
}
