package viapi.service.interfaces;

import viapi.dto.VideoTitlesDTO;
import viapi.enumerations.Sort;

import java.util.List;

public interface IVideoTitlesService {
    List<VideoTitlesDTO> getVideoTitles(String pageNumber, String sort);
}