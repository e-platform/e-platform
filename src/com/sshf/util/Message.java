package com.sshf.util;

import java.io.File;
import java.util.ArrayList;

public class Message {

	private String from;
	private String to;
	private String cc;
	private String host;
	private String user;
	private String password;
	private String title;
	private String text;
	private String html;
	private ArrayList<File> files;
	
	private static final String DEFAULT_HOST = "smtp.163.com";
	private static final String DEFAULT_USER = "xingzenglong0703@163.com";
	private static final String DEFAULT_PASSWORD = "198573";
	
	public Message(){
		this.host = DEFAULT_HOST;
		this.user = DEFAULT_USER;
		this.password = DEFAULT_PASSWORD;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public ArrayList<File> getFiles() {
		return files;
	}
	public void setFiles(ArrayList<File> files) {
		this.files = files;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
