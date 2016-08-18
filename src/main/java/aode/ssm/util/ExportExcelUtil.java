package aode.ssm.util;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by ${周欣文} on 2016/8/3.
 */
public class ExportExcelUtil {
    public static void export(List<?> list){
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("这里写表名");       // 创建表单并设置其表名
        HSSFRow tRow = sheet.createRow(0);      // 创建表单行
        tRow.createCell(0).setCellValue("学号");  // 行头
            // 这里写行头
        if (list!=null) {
            Field[] fields = list.get(0).getClass().getDeclaredFields();

            for (int i = 0; i <= list.size(); i++){
            tRow.createCell(i).setCellValue(fields[i].getName());  // 行头以list对象的
            }

            for (int i = 1; i <= list.size(); i++) {
            HSSFRow tRows = sheet.createRow(i);
            // Checkin checkin = checkinList.get(i - 1);  得到list里面的对象
//            if (checkin.getS_id() != null) {
//                DecimalFormat df = new DecimalFormat("0");
//                String S_id = df.format(checkin.getS_id());
//                rows.createCell(0).setCellValue(S_id);
//            }
//            if (checkin.getName() != null) {
//                rows.createCell(1).setCellValue(checkin.getName());
//            }

            //赋值  有几个行写几个
            }
        }else{
            return;
        }
        FileOutputStream out = null;
        String path = "";   // 这里写生成的文件存放路径  跟上传图片的路径类似
        File file = new File("文件名" + ".xlsx");
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


}
