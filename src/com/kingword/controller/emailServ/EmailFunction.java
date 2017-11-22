package com.kingword.controller.emailServ;

import javax.annotation.Resource;

 


public class EmailFunction {
	//文档信息表
	
	@Resource(name="emailConfigServImpl")
	private EmailConfigServ emailConfigServ;
	public  String  sendMessage()  {  
		System.out.println(" 邮件发送成功.. ");
		emailConfigServ.findAllEmailConfigs();
		
		return "1233333333333333";
   } 
}





















