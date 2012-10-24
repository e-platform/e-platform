package com.sshf.util;

import java.io.File;
import java.util.ArrayList;

/**
 * 邮件工具类
 *
 * 类说明
 *
 * @author xingzl
 *
 * @create-time 2012-7-11 下午03:10:51
 *
 * @version $Id
 */
public class MailUtil {
	
	/**
	 * 发送邮件
	 * @param message
	 * @throws Exception
	 */
	public static void send(Message msg) throws Exception{
		new MailSender().send(msg);
	}
	
	/**
	 * 接收邮件
	 * @return 返回邮件列表
	 */
	public static ArrayList<Message> receive(){
		return new MailReceiver().getMessages();
	}
	
	/**
	 * 通过邮件唯一标示删除邮件
	 * @param messageId
	 * @return
	 */
	public static boolean deleteMail(String messageId){
		return new MailReceiver().deleteMessage(messageId);
	}
	
	
	public static void main(String[] args) throws Exception {
		//html与文本不能一起发
		Message msg = new Message();
		msg.setFrom("xingzenglong0703@163.com");
		msg.setTo("flower_ho@126.com");
//		msg.setTo("zenglongx@gmail.com");
//		msg.setCc("xingzenglong@calandtech.com");
		msg.setTitle("测试标题");
		
		//发送文本
//		msg.setText("测试邮件");
		//发送html
		msg.setHtml("<html><head><title>有汉字" +
                        "</title></head><body><h1>" +
                        "</h1><p>汉字就打瞌睡就爱看附件将控件到拉萨风科技This is a test of sending an HTML e-mail" +
                        " through Java.<a href='http://www.baidu.com'>baidu</a>http://www.baidu.com</body></html>");
		//发送附件
		ArrayList<File> files = new ArrayList<File>();
		File file1 = new File("d:/down/201206300248_1_1041.txt");
		File file2 = new File("d:/down/201207101037_1_1201.txt");
		files.add(file1);
		files.add(file2);
		msg.setFiles(files);
		
		MailUtil.send(msg);
		System.out.println("finish!");
	}
}
