package com.medical.jimcian.ModelClass;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class Comment {
    String commentid;
    String commenterid;
    String commenttext;
    String commentername;
    private @ServerTimestamp
    Date commenttime;


    public Comment() {
    }

    public Comment(String commentid, String commenterid, String commenttext, String commentername, Date commenttime) {
        this.commentid = commentid;
        this.commenterid = commenterid;
        this.commenttext = commenttext;
        this.commentername = commentername;
        this.commenttime = commenttime;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public String getCommenterid() {
        return commenterid;
    }

    public void setCommenterid(String commenterid) {
        this.commenterid = commenterid;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext;
    }

    public String getCommentername() {
        return commentername;
    }

    public void setCommentername(String commentername) {
        this.commentername = commentername;
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }
}
