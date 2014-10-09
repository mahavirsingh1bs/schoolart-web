function validateForm(){
	var flag = true;
	
	$('.validation').text('');
	var isChecked = $('input[name=termsncondis]').prop('checked');

	if(!isChecked){
		 $('.termsncondisErr').text('*Please accept terms and conditions');
		 flag = false;
	}
	
	var userId = $('input[name=userId]').val();
	if($.trim(userId) == ''){
		 $('.userIdErr').text('*Please enter your Enterprise ID');
		 flag = false;
	}else if($.trim(userId).length < 4||$.trim(userId).length > 8){
		 $('.userIdErr').text('*Please enter enterprise id with 4-8 characters');
		 flag = false;
	}
	
	var name = $('input[name=name]').val();
	if($.trim(name) == ''){
		 $('.nameErr').text('*Please enter your Enterprise Name');
		 flag = false;
	}
	
	
	var emailId = $('input[name=emailId]').val();
	var emailPattern= /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	if($.trim(emailId) == ''){
		 $('.emailIdErr').text('*Please enter your Email Id');
		 flag = false;
	}else if(!emailPattern.test(emailId)){
		 $('.emailIdErr').text('*Please enter Email Id in valid format');
		 flag=false;
	}
	
	var phoneNo = $('input[name=phoneNo]').val();
	if($.trim(phoneNo) == ''){
		 $('.phoneNoErr').text('*Please enter your Contact No');
		 flag = false;
	}else if(!$.isNumeric(phoneNo)){
		 $('.phoneNoErr').text('*Please enter valid contact number.');
		 flag = false;
	}else if(!($.trim(phoneNo).length == 10 || $.trim(phoneNo).length == 13)){	
		$('.phoneNoErr').text('*Contact number length should be 10 or 13.');
		 flag = false;
	}
	
	var password = $('input[name=password]').val();
	var passwordpattern= /((^[0-9]+[a-z]+)|(^[a-z]+[0-9]+))+[0-9a-z]+$/i;
	if($.trim(password) == ''){
		 $('.passwordErr').text('Please enter the password.');
		 flag = false;
	}else if(!passwordpattern.test(password))	{
		$('.passwordErr').text('Please enter only alphanumeric password containing two numbers and two alphabets.');
		flag = false;
	}
	
	var address = $('input[name=address]').val();
	
	if($.trim(address) == ''){
		$('.addressErr').text('*Please enter your Address..');
		flag = false;
	}
	
	if(!flag) {
		$('.validation').css('display', 'block');
		return false;
	}else{
		$('form[name=registerTenantForm]').submit();
		return true;
	}
	
}
