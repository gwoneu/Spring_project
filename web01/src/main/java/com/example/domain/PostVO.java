package com.example.domain;

import java.util.Date;

public class PostVO extends UserVO { //UserVO 를 상속받는다.
	private int pid;
	private String title;
	private String body;
	private String writer;
	private Date regdate; //필드명은 소문자 private 라서 getter setter 로 가져와야 함
	private int viewcnt;
	private int commcnt;
	
	public int getCommcnt() {
		return commcnt;
	}

	public void setCommcnt(int commcnt) {
		this.commcnt = commcnt;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public int getPid() { // pid 를 가져올 때
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override // VO 에 들어있는 모든 값들의 값을 텍스트로 콘솔창에 띄워 볼 수 있다. -> source generate toString();
	public String toString() {
		return "PostVO [pid=" + pid + ", title=" + title + ", body=" + body + ", writer=" + writer + ", regdate="
				+ regdate + ", getPid()=" + getPid() + ", getTitle()=" + getTitle() + ", getBody()=" + getBody()
				+ ", getWriter()=" + getWriter() + ", getRegdate()=" + getRegdate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
