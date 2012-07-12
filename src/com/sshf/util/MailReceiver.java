package com.sshf.util;

import java.util.ArrayList;

public class MailReceiver {
	
	private ArrayList<Message> messages;
	
	public ArrayList<Message> getMessages() {
		
		//连接邮件服务器
		connect();
		//获取message
		fetchMessage();
		//解析存储mail
		parseMessage();
		
		return messages;
	}
	
	public boolean deleteMessage(String messageId){
		//连接邮件服务器
		connect();
		//获取message
		fetchMessage();
		//删除
		return false;
	}
	
	private void connect(){}
	
	private void fetchMessage(){}
	
	private void parseMessage(){}
}
