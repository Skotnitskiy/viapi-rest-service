package viapi.services.interfaces;

import viapi.dtos.VideoTitlesDTO;

import java.util.List;

public interface IVideoTitlesService {
    List<VideoTitlesDTO> getVideoTitles(String pageNumber, String sort, String videoUrl);
}