package org.murat.test.controllers;

import org.murat.test.Utils.MultipartFileSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RestController
@RequestMapping("/")
public class VideoController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "video", method = RequestMethod.GET)
    public void getVideo(HttpServletRequest request, HttpServletResponse response){
        File file = new File("C:\\TestVideos\\BigBuckBunny.mp4");
        try {
            logger.debug("Streaming file '" + file.getName() + "'...");
            MultipartFileSender.fromFile(file)
                    .with(request)
                    .with(response)
                    .serveResource();
        } catch (Exception e) {
            String errorMessage = e.getLocalizedMessage();
            if(!errorMessage.equalsIgnoreCase("java.io.IOException: An established connection was aborted by the software in your host machine")){
                logger.error(errorMessage, e);
            }
        }
    }
}
