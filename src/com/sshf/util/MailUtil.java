package com.sshf.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import sun.misc.BASE64Encoder;

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
	
	private static final String CHART_SET = "GBK";

	/**
	 * 发送邮件
	 * @param message
	 * @throws Exception
	 */
	public static void send(Message message) throws Exception{
		Properties props = new Properties();
		props.put("mail.smtp.host", message.getHost());
		Session session = Session.getInstance(props);
		Transport bus = session.getTransport("smtp");
		bus.connect(message.getHost(), message.getUser(), message.getPassword());
		
		javax.mail.Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(message.getFrom()));
		InternetAddress[] address = {new InternetAddress(message.getTo())};
		msg.setRecipients(javax.mail.Message.RecipientType.TO, address);
		msg.setRecipients(javax.mail.Message.RecipientType.CC,InternetAddress.parse(message.getCc(), true));
		msg.setSentDate(new Date());
		msg.setSubject(message.getTitle());
		
		Multipart mp = new MimeMultipart();
		if(message.getText() != null){
			MimeBodyPart pText = new MimeBodyPart();
			pText.setText(message.getText(),CHART_SET);
			mp.addBodyPart(pText);
		}
		if(message.getHtml() != null){
			msg.setDataHandler(new DataHandler(new HTMLDataSource(message.getHtml())));
		}
		if(message.getFiles() != null){
			for(File file : message.getFiles()){
				MimeBodyPart pFile = new MimeBodyPart();
				FileDataSource fds = new FileDataSource(file.getAbsolutePath());
				pFile.setDataHandler(new DataHandler(fds));
				BASE64Encoder enc = new BASE64Encoder();
				pFile.setFileName("=?GBK?B?"+enc.encode((fds.getName()).getBytes())+"?=");
				mp.addBodyPart(pFile);
			}
		}
		msg.setContent(mp);
		msg.saveChanges();
		bus.sendMessage(msg, msg.getAllRecipients());
		bus.close();
	}
	
	/**
	 * 接收邮件
	 * @return 返回邮件列表
	 */
	public static ArrayList<Message> receive(){
		ArrayList<Message> result = new ArrayList<Message>();
		return result;
	}
	
	static class HTMLDataSource implements DataSource {
		private String html;
		public HTMLDataSource(String htmlString) {
			html = htmlString;
		}
		public InputStream getInputStream() throws IOException {
			if (html == null) throw new IOException("Null HTML");
			return new ByteArrayInputStream(html.getBytes());
		}
		public OutputStream getOutputStream() throws IOException {
			throw new IOException("This DataHandler cannot write HTML");
		}
		public String getContentType() {
			return "text/html";
		}
		public String getName() {
			return "JAF text/html dataSource to send e-mail only";
		}
	}
	
	public static void main(String[] args) throws Exception {
		Message msg = new Message();
		msg.setFrom("xingzenglong0703@163.com");
		msg.setTo("zenglongx@gmail.com");
		msg.setCc("xingzenglong@calandtech.com");
		msg.setText("测试邮件");
		msg.setTitle("测试标题");
		MailUtil.send(msg);
	}
}
