package abramov.instagram.controller;

import abramov.instagram.model.NonMutualResult;
import abramov.instagram.service.InstagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class InstagramController {
    @Autowired
    private InstagramService instagramService;

    // Отображение формы загрузки
    @GetMapping("/")
    public String showUploadForm() {
        return "upload"; // имя шаблона upload.html
    }

    // Обработка загрузки файлов и возврат результата JSON
    @PostMapping("/process")
    @ResponseBody
    public NonMutualResult handleFileUpload(
            @RequestParam("followersFile") MultipartFile followersFile,
            @RequestParam("followingFile") MultipartFile followingFile) throws IOException {

        return instagramService.findNonMutual(followersFile, followingFile);
    }
}
