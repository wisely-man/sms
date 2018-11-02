function checkAllTextValid(form){
	var resultTag = 0 ; //记录不含引号的文本框数量
	var flag = 0 ;		//记录所有text文本框数量
	for ( var i = 0; i < array.length; i++) {
		if (form.elements[i].type=="text") {
			flag = flag +1 ;
			//正则表达式为过滤的特殊字符
			if (/^[^\|"'<>-]*$/.test(form.elements[i]).value) {
				resultTag = resultTag + 1 ;
			}else{
				form.elements[i].select();
			}
		}
	}
	/**
	 * 如果含引号的文本框等于全部文本框的值，则校验通过
	 */
	if(resultTag == flag){
		return true ;
	}else{
		alert("文本框中不能含有\n\n 1 单引号: ' \n 2 双引号: \" \n 3 竖杠: | \n 4 尖角号: <> \n 5 破折号: - \n\n 请检查输入!");
		return false;
	}
	
	
}


function change(flag,id){
	//修改
	if(flag=="update")
	{
		if(confirm("确认修改吗？")!=true){
			return ;
		}
		window.location.href="ToUpdateBillServlet?billId="+id+"&mess=update";
	}
	//删除
	if(flag=="del")
	{
		if(confirm("确认删除吗？")!=true){
			return ;
		}
		window.location.href="DoDelBillServlet?billId="+id+"&mess=del";
	}
}

function doit(flag,id)
{
	if(flag=="view"){
		if(confirm("确认修改吗？")!=true){
			return;
		}
		window.location.href="ToUpdateUserServlet?mess=view&id="+id ;
	}
	if(flag=="toUpdate")
	{
		if(confirm("确认修改吗？")!=true){
			return;
		}
		window.location.href="ToUpdateUserServlet?mess=doUpdate&id="+id ;
	}
	if(flag=="del")
	{
		if(confirm("确认删除吗？")!=true){
			return;
		}
		window.location.href="DoDelUserServlet?id="+id ;
	}
	if(flag=="uppass")
	{
		if(confirm("确认修改吗？")!=true){
			return;
		}
		window.location.href="GetAllUsersServlet?mess=updatePass&id="+id ;
	}
}
function checkit()
{
	//判断是否是数字的正则表达式
	var reg1 = /^\s*$/g ;
	var reg2 = /^\D*$/g ;
	var oForm1 = document.form1 ;
	if(reg1.test(oForm1.userId.value)||reg2.test(oForm1.userId.value)){
		alert("用户编号不能为空！");
		return false ;
	}
	if(reg1.test(oForm1.username.value)){
		alert("用户名不能为空！");
		return false ;
	}
	if(reg1.test(oForm1.password.value)){
		alert("密码不能为空！");
		return false ;
	}
	if(oForm1.password.value!=oForm1.password1.value){
		alert("两次密码输入不一致！");
		return false ;
	}
	if(reg1.test(oForm1.age.value)){
		alert("年龄不能为空！");
		return false ;
	}
	if(reg1.test(oForm1.mobile.value)||reg2.test(oForm1.mobile.value)){
		alert("电话不能为空！");
		return false ;
	}

	return true;
}
