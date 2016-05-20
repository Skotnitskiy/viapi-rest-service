package viapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import viapi.constants.Req;
import viapi.constants.Sort;
import viapi.dtos.VideoTitlesDTO;
import viapi.services.interfaces.IVideoTitlesService;

import java.util.List;

@RestController
@RequestMapping("/serials")
public class SerialsController {
    @Autowired
    IVideoTitlesService videoTitlesService;

    @RequestMapping(value = "/show_start/{year}", method = RequestMethod.GET)
    public List<VideoTitlesDTO> groupByVideoTitles(@RequestParam(name = "page", defaultValue = "0") String pageNumber,
                                                   @RequestParam(name = "sort", defaultValue = Sort.TREND) String sort,
                                                   @PathVariable("year") String year) {
        return videoTitlesService.getVideoTitles(pageNumber, sort, Req.SERIALS_URL + "/show_start/"+year);
    }
}