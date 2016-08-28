package aode.ssm.util;

import aode.ssm.mapper.AttachmentMapper;
import aode.ssm.mapper.PostMapper;
import aode.ssm.model.Attachment;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ${周欣文} on 2016/8/27.
 *
 */
public class ExportExcelUtilTest {
    private ApplicationContext applicationContext;

    //在setUp这个方法得到spring容器
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
    }
    @Test
    public void getFiledName() throws Exception {

        String[] filedName = ExportExcelUtil.getFiledName(Attachment.class.newInstance());
        for (int i = 0;i<filedName.length;i++){
            System.out.println(filedName[i]);
        }
    }
    @Test
    public void export() throws Exception {
        PostMapper postMapper = (PostMapper) applicationContext.getBean("postMapper");
        ExportExcelUtil.export(postMapper.getAll(),"0");
    }
    @Test
    public void getFieldValueByName() throws Exception {
        AttachmentMapper attachmentMapper = (AttachmentMapper) applicationContext.getBean("attachmentMapper");

        System.out.println(ExportExcelUtil.getFieldValueByName("name",attachmentMapper.selectAll().get(0)));

    }

}