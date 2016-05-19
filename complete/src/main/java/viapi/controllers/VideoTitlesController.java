package viapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import viapi.constants.Req;
import viapi.dtos.VideoTitlesDTO;
import viapi.constants.Sort;
import viapi.services.interfaces.IVideoTitlesService;

import java.util.List;

@RestController
public class VideoTitlesController {
    @Autowired
    IVideoTitlesService videoTitlesService;

    @RequestMapping(value = "/serials", method = RequestMethod.GET)
    public List<VideoTitlesDTO> videoTitlesSerials(@RequestParam(name = "page", defaultValue = "0") String pageNumber,
                                                   @RequestParam(name = "sort", defaultValue = Sort.TREND) String sort) {
        return videoTitlesService.getVideoTitles(pageNumber, sort, Req.SERIALS_URL);
    }

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public List<VideoTitlesDTO> videoTitlesFilms(@RequestParam(name = "page", defaultValue = "0") String pageNumber,
                                                 @RequestParam(name = "sort", defaultValue = Sort.TREND) String sort) {
        return videoTitlesService.getVideoTitles(pageNumber, sort, Req.FILMS_URL);
    }

    @RequestMapping(value = "/cartoons", method = RequestMethod.GET)
    public List<VideoTitlesDTO> videoTitlesCartoons(@RequestParam(name = "page", defaultValue = "0") String pageNumber,
                                                    @RequestParam(name = "sort", defaultValue = Sort.TREND) String sort) {
        return videoTitlesService.getVideoTitles(pageNumber, sort, Req.CARTOONS_URL);
    }

    @RequestMapping(value = "/cartoonserials", method = RequestMethod.GET)
    public List<VideoTitlesDTO> videoTitlesCartoonSerials(@RequestParam(name = "page", defaultValue = "0") String pageNumber,
                                                          @RequestParam(name = "sort", defaultValue = Sort.TREND) String sort) {
        return videoTitlesService.getVideoTitles(pageNumber, sort, Req.CARTOON_SERIALS_URL);
    }

    @RequestMapping(value = "/tvshow", method = RequestMethod.GET)
    public List<VideoTitlesDTO> videoTitlesTvShow(@RequestParam(name = "page", defaultValue = "0") String pageNumber,
                                                  @RequestParam(name = "sort", defaultValue = Sort.TREND) String sort) {
        return videoTitlesService.getVideoTitles(pageNumber, sort, Req.TV_SHOW_URL);
    }
}