package com.xiaoping.controller;

import com.xiaoping.pojo.Rs;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
public class FileUploadController {

    @GetMapping("/upload")
    public String listUploadedFiles(Model model) throws IOException {
        return "uploadForm";
    }

    @PostMapping("/uploadFile")
    @ResponseBody
    public Rs handleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            String saveFileName = file.getOriginalFilename();
            File saveFile = new File(request.getSession().getServletContext().getRealPath("/upload/") + saveFileName);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
                return Rs.ok(saveFile.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return Rs.errorMsg("上传失败," + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                return Rs.errorMsg("上传失败," + e.getMessage());
            }
        } else {
            return Rs.errorMsg("上传失败，因为文件为空.");
        }

    }


    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(FileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
