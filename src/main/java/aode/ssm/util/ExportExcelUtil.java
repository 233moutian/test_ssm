package aode.ssm.util;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by ${周欣文} on 2016/8/3.
 * 个人简单工具类,传入一个list<?>和地址即可得到一张表,
 * 暂时只支持数据库varch和实体类String类型,其他类型会导致类型转化出错,
 * 暂不支持多表查询,
 */
public class ExportExcelUtil {
    public static void export(List<?> list,String path) throws Exception {
        if (list == null&&list.size()<0) {      // 拦截.
            return;
        }
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(list.get(0).getClass().getSimpleName());// 创建表单并设置其表名
        HSSFRow tRow = sheet.createRow(0);       //创建一个单元格，从0开始
        // 这里String类型的数组来解析list对象的泛型的方法名,作为行头名
        String fileName[] = getFiledName(list.get(0).getClass().newInstance());
        for(int i=0 ;i <fileName.length ;i++){
            tRow.createCell(i).setCellValue(fileName[i]);
        }
        for (int i = 1;i<list.size();i++){
            tRow = sheet.createRow(i);
            for (int j = 0;j<fileName.length;j++){
                tRow.createCell(j).setCellValue(((String) getFieldValueByName(fileName[j],list.get(i-1))));
            }
        }
        FileOutputStream out = null;
        path = "";   // 这里写生成的文件存放路径  跟上传图片的路径类似
//        File file = new File("D:\\" + list.get(0).getClass().getSimpleName() + ".xls");
        File file = new File(path + ".xls");
        // 以下是输出文件
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
            out = new FileOutputStream(file);
            wb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 得到list的泛型对象的属性名,作为表头--可用,但是不能传入一个泛型类型的
    // 获取属性名数组
    public static String[] getFiledName(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
//            System.out.println(fields[i].getType());
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }

    //根据属性名获取属性值-------------------可用
    public static String getFieldValueByName(String fieldName, Object o) throws Exception{
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            String value = (String) method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
