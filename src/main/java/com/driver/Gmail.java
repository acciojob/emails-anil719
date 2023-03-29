package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Mail{
    Date date;
    String sender;
    String message;

    public Mail(Date date, String sender, String message) {
        this.date = date;
        this.sender = sender;
        this.message = message;
    }
}

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    List<Mail> inbox ;
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    List<Mail> trash ;
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.inbox = new ArrayList<>();
        this.trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        if(inbox.size() == inboxCapacity){
            Mail oldestMail = inbox.get(0);
            inbox.remove(oldestMail);
            trash.add(oldestMail);
        }

        Mail newMail = new Mail(date,sender, message);
        inbox.add(newMail);
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(Mail mail : inbox){
            if(mail.message.equals(message)){
                inbox.remove(mail);
                trash.add(mail);
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        if(inbox.isEmpty()) return null;
        // Else, return the message of the latest mail present in the inbox
        Mail latestMail = inbox.get(inbox.size()-1);
        return latestMail.message;
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        if(inbox.isEmpty()) return null;
        // Else, return the message of the oldest mail present in the inbox
        Mail oldestMail = inbox.get(0);
        return oldestMail.message;
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        int count = 0;
        for(Mail mail : inbox){
            Date currDate = mail.date;
            if(currDate.equals(start) || currDate.equals(end) ||
            currDate.after(start) && currDate.before(end)){
                count++;
            }
        }
        return count;
        //It is guaranteed that start date <= end date
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}