package viapi.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import viapi.dto.VideoTitlesDTO;
import viapi.service.interfaces.IVideoTitlesService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoTitlesService implements IVideoTitlesService {

    private String serialsUrl = "http://fs.to/video/serials/";
    private String fsUrl = "http://fs.to";

    @Override
    public List<VideoTitlesDTO> getVideoTitles(Integer pageNumber) {
        List<VideoTitlesDTO> videoTitlesDTOs = new ArrayList<VideoTitlesDTO>();
        VideoTitlesDTO videoTitlesDTO;
        Document doc;
        try {
            doc = Jsoup.connect(serialsUrl).get();
            Elements serialsLinks = doc.select(".b-poster-tile__link");
            for (Element link : serialsLinks) {
                videoTitlesDTO = new VideoTitlesDTO();
                videoTitlesDTO.shortTitle = link.select(".b-poster-tile__title-short").text();
                videoTitlesDTO.fullTitle = link.select(".b-poster-tile__title-full").text();
                videoTitlesDTO.serialUrl = new URL(fsUrl + link.attr("href"));
                videoTitlesDTO.imageUrl = new URL("http:" + link.select(".b-poster-tile__image img[src]").attr("src"));
                videoTitlesDTO.titleInfoItem = link.select(".b-poster-tile__title-info-items").text();
                videoTitlesDTO.titleInfoVotePositive = link.select(".b-poster-tile__title-info-vote-positive").text();
                videoTitlesDTO.titleInfoVoteNegative = link.select(".b-poster-tile__title-info-vote-negative").text();
                Elements qSpans = link.select(".b-poster-tile__title-info-qualities span[class]");
                videoTitlesDTO.qualities.addAll(qSpans.stream().map(qSpan -> qSpan.attr("class")).collect(Collectors.toList()));
                videoTitlesDTOs.add(videoTitlesDTO);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return videoTitlesDTOs;
    }
}
