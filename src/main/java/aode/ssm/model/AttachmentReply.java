package aode.ssm.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ${周欣文} on 2016/8/17.
 */

@Table
public class AttachmentReply {
    private String fileName; //文件名用ＵＵＩＤ生成．作为ｉｄ    如果没有上传则使用默认图片default
    private String rid;      //附件所属的实体的id，因为不同类的都是使用这个，为了避免重复所以这类的id都有UUID

    public AttachmentReply(String fileName, String rid) {
        this.fileName = fileName;
        this.rid = rid;
    }
    public AttachmentReply() {
    }

    @Id
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "AttachmentReply{" +
                "fileName='" + fileName + '\'' +
                ", rid='" + rid + '\'' +
                '}';
    }
}
