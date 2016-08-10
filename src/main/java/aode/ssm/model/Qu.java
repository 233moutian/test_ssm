package aode.ssm.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ${周欣文} on 2016/8/10.
 */
@Table
public class Qu {
    @Id
    private long qu_id;
    private String qu;
    private long shi_id;

    public String getQu() {
        return qu;
    }

    public void setQu(String qu) {
        this.qu = qu;
    }

    public long getQu_id() {
        return qu_id;
    }

    public void setQu_id(long qu_id) {
        this.qu_id = qu_id;
    }

    public long getShi_id() {
        return shi_id;
    }

    public void setShi_id(long shi_id) {
        this.shi_id = shi_id;
    }
}
