package BookServiceRohit.BookService.controller;

import BookServiceRohit.BookService.helper.FileUploadhelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadhelper fileUploadhelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file)
    {
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getContentType());
//        System.out.println(file.getSize());
//        System.out.println(file.getName());
       try {

           //validation
           if (file.isEmpty())
           {
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
           }

        if (!file.getContentType().equals("image/jpeg")) // ! = meaning is apposite work
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG content type are allowed");
        }
         // file upload code

           boolean f=fileUploadhelper.uploadFile(file);
        if (f)
        {
             return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());// yeh path return krne ke liye hai(output is ) ...like.... http://localhost:1010/photo.jpg
           // return ResponseEntity.ok("file successfully uploaded");
        }

       }catch (Exception e){
           e.printStackTrace();
       }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong ! Try agrain......");
    }

}
