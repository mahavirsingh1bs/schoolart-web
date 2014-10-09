function validateSignin(){
	var flag = true;
	
	$('.validation').text('');
	
	var userId = $('input[name=userId]').val();
	if($.trim(userId) == ''){
		$('.userIdErr').text('*Please enter your Enterprise ID');
		flag = false;
	}
	
	var password = $('input[name=password]').val();
	if($.trim(password) == ''){
		$('.passwordErr').text('*Please enter the Password');
		flag = false;
	}
	
	if(!flag){
		$('.validation').css('display','block');
		return false;
	}else{
		$('form[name=loginTenantForm]').submit();
		return true;
	}
}