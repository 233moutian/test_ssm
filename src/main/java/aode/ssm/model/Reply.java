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
    private Date last_update_time; // 最后修改时间
    private long post_id;
    private String r_author;  // 回复者

    @Transient
    private Post post;  // 属于的帖子

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLast_update_time() {
        return last_update_time;
    }

    public void setLast_update_time(Date last_update_time) {
        this.last_update_time = last_update_time;
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

    public String getR_author() {
        return r_author;
    }

    public void setR_author(String r_author) {
        this.r_author = r_author;
    }

    public long getR_id() {
        return r_id;
    }

    public void setR_id(long r_id) {
        this.r_id = r_id;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "content='" + content + '\'' +
                ", r_id=" + r_id +
                ", last_update_time=" + last_update_time +
                ", post_id=" + post_id +
                ", r_author='" + r_author + '\'' +
                ", post=" + post +
                '}';
    }
}
