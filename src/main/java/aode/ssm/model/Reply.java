package aode.ssm.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by ${周欣文} on 2016/8/1.
 * 这个是多的那一端  加上一的那一端的id
 */
@Table
public class Reply {

    @Id
    private long r_id;
    private String content; // 回复内容
    private Date lastUpdateTime; // 最后修改时间
    private long post_id;
    private String r_author;  // 回复者

    @Transient
    private Post post;  // 属于的帖子

    @Transient
//    private User author;  // 回复者


//    public User getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }


    public String getR_author() {
        return r_author;
    }

    public void setR_author(String r_author) {
        this.r_author = r_author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public long getPost_id() {
        return post_id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    public long getR_id() {
        return r_id;
    }

    public void setR_id(long r_id) {
        this.r_id = r_id;
    }
}
