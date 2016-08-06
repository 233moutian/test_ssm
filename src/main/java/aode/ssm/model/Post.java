package aode.ssm.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.Set;

/**
 * Created by ${周欣文} on 2016/8/1.
 * 这个是一的那一端
 */
@Table
public class Post {
    @Id
    private long p_id;
    private String title;   // 帖子标题
    private Date postTime;  //提交时间
//  private int replyCount;     // 回复量----根据set的size就可以

    @Transient              // 帖子内容(即一楼),需要作者回复
    private User author;    // 作者
    @Transient
    private Set<Reply> replies; // 帖子的回复
//    @Transient
//    private Reply lastReply;    // 最后一条回复----关闭懒加载,直接取最后一条回复


    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public long getP_id() {
        return p_id;
    }

    public void setP_id(long p_id) {
        this.p_id = p_id;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Set<Reply> getReplies() {
        return replies;
    }

    public void setReplies(Set<Reply> replies) {
        this.replies = replies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
