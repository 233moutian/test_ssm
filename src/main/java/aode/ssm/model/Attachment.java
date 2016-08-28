package aode.ssm.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ${周欣文} on 2016/8/17.
 */

@Table
public class Attachment {
    @Id
    private String name; //文件名用ＵＵＩＤ生成．作为ｉｄ    如果没有上传则使用默认图片default
    private String uid;      //附件所属的实体的id，因为不同类的都是使用这个，为了避免重复所以这类的id都有UUID

    public Attachment() {
    }

    public Attachment(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
