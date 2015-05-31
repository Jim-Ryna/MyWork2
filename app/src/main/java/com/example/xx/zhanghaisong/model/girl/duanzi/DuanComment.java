package com.example.xx.zhanghaisong.model.girl.duanzi;

/**
 * Created by xx on 2015/5/30.
 */
public class DuanComment{
    private String comment_author;
    private String comment_date;
    private String comment_content;
    private String text_content;

    public String getVote_negative() {
        return vote_negative;
    }

    public void setVote_negative(String vote_negative) {
        this.vote_negative = vote_negative;
    }

    public String getVote_positive() {
        return vote_positive;
    }

    public void setVote_positive(String vote_positive) {
        this.vote_positive = vote_positive;
    }

    public String getText_content() {
        return text_content;
    }

    public void setText_content(String text_content) {
        this.text_content = text_content;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    private String vote_positive;
    private String vote_negative;
    public String getComment_date() {
        return comment_date;
    }

    public void setComment_date(String comment_dat) {
        this.comment_date = comment_dat;
    }

    public String getComment_author() {
        return comment_author;
    }

    public void setComment_author(String comment_author) {
        this.comment_author = comment_author;
    }
}
