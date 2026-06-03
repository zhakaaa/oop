package Material;

import Employees.Employee;
import NotEmployees.User;

import java.util.Date;

public class Message {
    private User sender;
    private User receiver;
    private String content;
    private Date sentDate;

    public Message(){};
    public Message(String content, User sender, User receiver, Date sentDate){
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.sentDate = sentDate;
    }
    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

}
