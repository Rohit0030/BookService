package BookServiceRohit.BookService.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadhelper
{
//    public final String UPLOAD_DIR="C:\\Users\\rohit\\Downloads\\BookService\\src\\main\\resources\\static\\image";
    public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
    public FileUploadhelper() throws IOException
    {


    }

    public boolean uploadFile(MultipartFile multipartFile)
    {
        boolean f= false;
        try {

//            InputStream is = multipartFile.getInputStream();
//            byte data[]=new byte[is.available()];
//            is.read();
//
//            // write
//            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename());
//            fos.write(data);
//            fos.flush();
//            fos.close();
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f=true;


        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

}
