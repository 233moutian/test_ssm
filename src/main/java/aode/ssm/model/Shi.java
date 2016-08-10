package aode.ssm.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ${周欣文} on 2016/8/10.
 */
@Table
public class Shi {
    @Id
    private long shi_id;
    private String shi;
    private long sheng_id;

    public long getSheng_id() {
        return sheng_id;
    }

    public void setSheng_id(long sheng_id) {
        this.sheng_id = sheng_id;
    }

    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }

    public long getShi_id() {
        return shi_id;
    }

    public void setShi_id(long shi_id) {
        this.shi_id = shi_id;
    }

}
