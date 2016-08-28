package aode.ssm.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * Created by ${周欣文} on 2016/8/1.
 * 这个是一的那一端
 */
@Table
public class Post {
    @Id
    private long p_id;
    private String title;   // 帖子标题
    private Date post_time;  //提交时间
    private String p_author;

    @Transient
    private Reply lastReply;

    public Reply getLastReply() {
        return lastReply;
    }

    public void setLastReply(Reply lastReply) {
        this.lastReply = lastReply;
    }

//  private int replyCount;     // 回复量----根据set的size就可以

//  @Transient              // 帖子内容(即一楼),需要作者回复
//  private User author;    // 作者
    @Transient
    private List<Reply> replies; // 帖子的回复

//    @Transient
//    private Reply lastReply;    // 最后一条回复----关闭懒加载,直接取最后一条回复


//    public User getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }


    public String getP_author() {
        return p_author;
    }

    public void setP_author(String p_author) {
        this.p_author = p_author;
    }

    public long getP_id() {
        return p_id;
    }

    public void setP_id(long p_id) {
        this.p_id = p_id;
    }

    public Date getPost_time() {
        return post_time;
    }

    public void setPost_time(Date post_time) {
        this.post_time = post_time;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Post{" +
                "lastReply=" + lastReply +
                ", p_id=" + p_id +
                ", title='" + title + '\'' +
                ", post_time=" + post_time +
                ", p_author='" + p_author + '\'' +
                ", replies=" + replies +
                '}';
    }
}
