package com.sshf.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

public class MailSender {

	private static final String CHART_SET = "GBK";
	
	public void send(Message msg) throws Exception{
		Properties props = new Properties();
		props.put("mail.smtp.host", msg.getHost());
		props.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(props);
		Transport bus = session.getTransport("smtp");
		bus.connect(msg.getHost(), msg.getUser(), msg.getPassword());
		
		javax.mail.Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(msg.getFrom()));
		InternetAddress[] address = {new InternetAddress(msg.getTo())};
		message.setRecipients(javax.mail.Message.RecipientType.TO, address);
		if(msg.getCc() != null)
			message.setRecipients(javax.mail.Message.RecipientType.CC,InternetAddress.parse(msg.getCc(), true));
		message.setSentDate(new Date());
		message.setSubject(msg.getTitle());
		
		Multipart mp = new MimeMultipart();
		if(msg.getText() != null){
			MimeBodyPart pText = new MimeBodyPart();
			pText.setText(msg.getText(),CHART_SET);
			mp.addBodyPart(pText);
		}else if(msg.getHtml() != null){
			MimeBodyPart pHtml = new MimeBodyPart();
			pHtml.setContent(msg.getHtml(), "text/html;charset="+CHART_SET);
			pHtml.setDataHandler(new DataHandler(new HTMLDataSource(msg.getHtml())));
			mp.addBodyPart(pHtml);
		}
		if(msg.getFiles() != null){
			for(File file : msg.getFiles()){
				MimeBodyPart pFile = new MimeBodyPart();
				FileDataSource fds = new FileDataSource(file.getAbsolutePath());
				pFile.setDataHandler(new DataHandler(fds));
				BASE64Encoder enc = new BASE64Encoder();
				pFile.setFileName("=?GBK?B?"+enc.encode((fds.getName()).getBytes())+"?=");
				mp.addBodyPart(pFile);
			}
		}
		message.setContent(mp);
		message.saveChanges();
		bus.sendMessage(message, message.getAllRecipients());
		bus.close();
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
}
