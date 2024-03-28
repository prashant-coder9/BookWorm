
package com.bookworm.entities;

public class EmailDetails {
 
    
    private String recipient="patilpratikb2017@gmail.com";
    private String msgBody ="Dear customer your complaint is registered successfully and will be resolved soon";
    private String name;
    private String useremail;

    
    
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getMsgBody() {
		return msgBody;
	}
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	@Override
	public String toString() {
		return "EmailDetails [recipient=" + recipient + ", msgBody=" + msgBody + ", name=" + name + ", useremail="
				+ useremail +  "]";
	}
	
	
    
    
}
