package aode.ssm.controller;

import aode.ssm.model.Attachment;
import aode.ssm.service.AttachmentService;
import aode.ssm.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by ${周欣文} on 2016/8/17.
 */
@Controller
public class UtilController {
//    ExportExcelUtil   工具类为静态属性和静态方法,可以直接调用
//    FileUploadUtil    工具类为静态属性和静态方法,可以直接调用
    @Autowired
    AttachmentService attachmentService;
    // 第一次上传自己的头像跟修改自己的头像略有区别
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String uploadImage(@RequestParam("upload") MultipartFile upload,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password,
                              Map<String,Object> map,
                              @RequestParam(value = "uid",defaultValue = "0",required = false)String uid){
        System.out.println(username);
        System.out.println(password);
        try {
            String expandedName = ""; // 文件扩展名
            String contentType=upload.getContentType();
            if (upload.isEmpty()|upload.getSize()==0){
//                redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "上传的文件为空!"));
                map.put("message","上传的文件为空!");
                return "/user/updateMassage";
            }
            if (contentType.equals("image/pjpeg") || contentType.equals("image/jpeg")) {
                // IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
                expandedName = ".jpg";
            } else if (contentType.equals("image/png") || contentType.equals("image/x-png")) {
                // IE6上传的png图片的headimageContentType是"image/x-png"
                expandedName = ".png";
            } else if (contentType.equals("image/gif")) {
                expandedName = ".gif";
            } else if (contentType.equals("image/bmp")) {
                expandedName = ".bmp";
            } else {
//                redirectAttributes.addFlashAttribute("result", new AjaxResult(false,
//                        "上传的文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）!"));
                map.put("message","上传的文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）!");
                return "redirect:/index.jsp";
            }
            if (upload.getSize() > 600 * 1024) {
//                redirectAttributes.addFlashAttribute("result", new AjaxResult(false,
//                        "上传的文件不得大于600kb!"));
                map.put("message","上传的文件不得大于600kb!");
                return "redirect:/index.jsp";
            }
            String fileName= FileUploadUtil.uploadFile(upload, FileUploadUtil.ATTACHMENT_PATH);
            Attachment a=new Attachment();
            a.setName(fileName);
            a.setUid(uid);
//            redirectAttributes.addFlashAttribute("name",fileName);
            map.put("name",fileName);
            attachmentService.saveOrUpdate(a);
        }catch (Exception e){
            e.printStackTrace();
        }
        map.put("message","上传成功!!");
        return "/WEB-INF/index";
    }
//
//    public String exportExcle(){
//        ExportExcelUtil.export(new ArrayList<Object>());
//        return "";
//    }

}
