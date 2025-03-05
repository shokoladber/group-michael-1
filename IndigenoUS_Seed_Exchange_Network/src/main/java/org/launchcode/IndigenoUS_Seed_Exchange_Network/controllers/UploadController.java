//package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//
//@Controller
//public class UploadController {
//
//    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
//
//    @GetMapping("/uploadimage")
//    public String displayUploadForm() {
//        return "imageupload/index";
//    }
//
//    @PostMapping("/upload")
//    public String uploadImage(Model model, @RequestParam("image") MultipartFile file) throws IOException {
//        if (file.isEmpty()) {
//            model.addAttribute("msg", "Please select a file to upload");
//            return "imageupload/index";
//        }
//
//        File uploadDir = new File(UPLOAD_DIRECTORY);
//        if (!uploadDir.exists()) {
//            uploadDir.mkdirs();
//        }
//
//        String fileName = file.getOriginalFilename();
//        File uploadedFile = new File(uploadDir.getAbsolutePath() + File.separator + fileName);
//        file.transferTo(uploadedFile);
//
//        model.addAttribute("msg", "Uploaded image: " + fileName);
//        return "imageupload/index";
//    }
//}
