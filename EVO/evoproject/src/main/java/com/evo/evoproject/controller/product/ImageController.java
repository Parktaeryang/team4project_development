package com.evo.evoproject.controller.product;
import com.evo.evoproject.service.image.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productimage")
@RequiredArgsConstructor
public class ImageController {
    //로컬 이미지 생성 메소드들
    private final ImageService imageService;

    @GetMapping("/{fileName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
        Resource resource = imageService.loadImage(fileName);
        return ResponseEntity.ok().body(resource);
    }
}
