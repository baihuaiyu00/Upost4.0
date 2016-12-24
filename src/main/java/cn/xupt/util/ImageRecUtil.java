package cn.xupt.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by Admin on 2016/12/19.
 */
public class ImageRecUtil {

    public static String ImagePathGet(String stu_id,HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fieldValue=null;

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(new File(request.getServletContext().getRealPath("/WEB-INF/temp")));
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(!isMultipart){
            System.out.println("stubid");
            return null;
        }
        ServletFileUpload upload = new ServletFileUpload(factory);

        List<FileItem> items = upload.parseRequest(request);
        for(FileItem item:items){
            if(item.isFormField()){
                fieldValue = item.getString("UTF-8");
            }else{
                String mimeType = item.getContentType();
                InputStream in = item.getInputStream();
                //上传的文件名
                String fileName = item.getName();

                if(fileName==null||"".equals(fileName.trim())){
                    continue;
                }
                fileName = fileName.substring(fileName.lastIndexOf("/")+1);//   a.txt

                //构建输出流

                String storeFile = stu_id+"_"+fileName;
                OutputStream out = new FileOutputStream(storeFile);

//                MyFile mf = new MyFile();
//                mf.setFilepath(newStorePath);
//                mf.setFilename(fileName);
//                mf.setId(sendId);
//                fs.addFile(mf);

                byte b[] = new byte[1024];
                int len = -1;
                while((len=in.read(b))!=-1){
                    out.write(b,0,len);
                }
                out.close();
                in.close();
                item.delete();
            }
        }
        return null;
    }

}
