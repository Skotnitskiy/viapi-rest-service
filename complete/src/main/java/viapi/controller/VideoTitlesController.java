package viapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import viapi.dto.VideoTitlesDTO;
import viapi.enumerations.Sort;
import viapi.service.interfaces.IVideoTitlesService;

import java.util.List;

@RestController
public class VideoTitlesController {
    @Autowired
    IVideoTitlesService videoTitlesService;

    @RequestMapping("/serials")
    public List<VideoTitlesDTO> videoTitles(@RequestParam(name = "page", defaultValue = "0") String pageNumber,
                                            @RequestParam(name = "sort", defaultValue = Sort.TREND) String sort) {
        return videoTitlesService.getVideoTitles(pageNumber, sort);
    }
}
