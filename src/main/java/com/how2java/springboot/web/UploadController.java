package com.how2java.springboot.web;


import org.apache.http.HttpResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;


@RestController
public class UploadController {
    @Value("${file.upload.path}")
   private String filePath;

    @RequestMapping("/uploading")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView("fileUpload");
        return mv;
    }

   /*@RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {

      String fileName = file.getOriginalFilename();
      String path = filePath;
      File filepath = new File(path,fileName);
      if (!filepath.getParentFile().exists()){filepath.getParentFile().mkdirs();}
      file.transferTo(new File(path+File.separator+fileName));
      model.addAttribute("fileName", "/images/"+fileName);
      return "fileUpload";
   }*/
/*@RequestParam 注解将请求参数绑定到方法参数。*/

    @PostMapping("/fileUpload")
    public String uploadSimpleFile(@RequestParam("file") MultipartFile file){

       String uploadFilePath = file.getOriginalFilename();
       String fileSuffix =uploadFilePath.substring(uploadFilePath.lastIndexOf('.')+1,uploadFilePath.length());
       String fileName = UUID.randomUUID() +"."+fileSuffix;
       File saveFile = new File(filePath,fileName);
       if (!saveFile.getParentFile().exists()){saveFile.getParentFile().mkdirs();}
       try{
           file.transferTo(saveFile);
       }
       catch (IllegalStateException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
        return "/Images/"+fileName;
   }

   @PostMapping("/fileMulUpload")
    public String uploadMulFile(@RequestParam("file")MultipartFile[] file){
       StringBuffer buffer = new StringBuffer();
       for (MultipartFile f : file){
           String result = uploadSimpleFile(f);
           buffer.append(result);
           buffer.append(',');
       }
       String all =buffer.substring(0,buffer.length()-1);
       return all;
   }


    @RequestMapping(value = "/downLoading")
    public String downLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        String fileNameSuffix =request.getParameter("name");
        String path ="\\\\192.168.1.236\\softWare\\1.常规软件\\1.输入法\\";
        /*String fileNameSuffix ="sogou_wubi_31a";*/
        String suffix =".exe";
        String fileName =fileNameSuffix+suffix;
        FileSystemResource file = new FileSystemResource(path.trim()+fileName.trim());
        if (!file.exists()){
                return "error";
        }
       InputStream inputStream = null;
       BufferedInputStream bufferedInputStream = null;
       BufferedOutputStream bufferedOutputStream = null;
       response.setHeader("Content-Disposition", "fileName=" + URLEncoder.encode(fileName, "UTF-8"));

       try
       {
           inputStream = file.getInputStream();
           bufferedInputStream = new BufferedInputStream(inputStream);
           bufferedOutputStream= new BufferedOutputStream(response.getOutputStream());
           FileCopyUtils.copy(bufferedInputStream, bufferedOutputStream);
       }
       catch (Exception e){
           System.out.println(e.getMessage());
           response.sendError(response.SC_NOT_FOUND, e.getMessage());
           return "fail";
       }

       finally {
           if (null!=inputStream){
               inputStream.close();
           }
           if (null!=bufferedInputStream){
               bufferedInputStream.close();
           }
           if (null!=bufferedOutputStream){
               bufferedOutputStream.close();
           }
       }
        return "success";
   }


}
