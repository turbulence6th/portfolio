package com.turbulence6th.portfolio.controller;

import com.turbulence6th.portfolio.manager.ImageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "/image")
public class ImageController {

    private ImageManager imageManager;

    @Autowired
    public ImageController(ImageManager imageManager) {
        this.imageManager = imageManager;
    }

    @RequestMapping(path = "/cv/{page}", method = RequestMethod.GET)
    public void cv(HttpServletResponse response, @PathVariable int page) throws IOException {
        ImageIO.write(imageManager.getPages()[page], "png", response.getOutputStream());
    }
}
