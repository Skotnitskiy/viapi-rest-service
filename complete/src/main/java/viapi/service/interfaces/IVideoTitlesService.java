package viapi.service.interfaces;

import viapi.dto.VideoTitlesDTO;

import java.util.List;

public interface IVideoTitlesService {
    List<VideoTitlesDTO> getVideoTitles(Integer pageNumber);
}