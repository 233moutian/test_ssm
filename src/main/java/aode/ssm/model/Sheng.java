package aode.ssm.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ${周欣文} on 2016/8/10.
 */
@Table
public class Sheng {
    @Id
    private long sheng_id;
    private String sheng;

    public String getSheng() {
        return sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    public long getSheng_id() {
        return sheng_id;
    }

    public void setSheng_id(long sheng_id) {
        this.sheng_id = sheng_id;
    }
}
