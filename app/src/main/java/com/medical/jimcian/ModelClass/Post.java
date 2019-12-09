package com.medical.jimcian.ModelClass;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class Post {
    String postid;
    String posterid;
    String posttext;
    int postcomment;
    int postlike;
    String postername;
    private  @ServerTimestamp Date postime;

    public Post() {
    }

    public Post(String postid, String posterid, String posttext, int postcomment, int postlike, String postername, Date postime) {
        this.postid = postid;
        this.posterid = posterid;
        this.posttext = posttext;
        this.postcomment = postcomment;
        this.postlike = postlike;
        this.postername = postername;
        this.postime = postime;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getPosterid() {
        return posterid;
    }

    public void setPosterid(String posterid) {
        this.posterid = posterid;
    }

    public String getPosttext() {
        return posttext;
    }

    public void setPosttext(String posttext) {
        this.posttext = posttext;
    }

    public int getPostcomment() {
        return postcomment;
    }

    public void setPostcomment(int postcomment) {
        this.postcomment = postcomment;
    }

    public int getPostlike() {
        return postlike;
    }

    public void setPostlike(int postlike) {
        this.postlike = postlike;
    }

    public String getPostername() {
        return postername;
    }

    public void setPostername(String postername) {
        this.postername = postername;
    }

    public Date getPostime() {
        return postime;
    }

    public void setPostime(Date postime) {
        this.postime = postime;
    }
}
