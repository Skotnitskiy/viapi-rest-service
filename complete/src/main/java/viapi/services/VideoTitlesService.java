package viapi.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import viapi.dtos.VideoTitlesDTO;
import viapi.services.interfaces.IVideoTitlesService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoTitlesService implements IVideoTitlesService {
    //TODO: need method for setting request parameters and connect URLs

    @Override
    public List<VideoTitlesDTO> getVideoTitles(String pageNumber, String sort, String videoUrl) {
        List<VideoTitlesDTO> videoTitlesDTOs = new ArrayList<>();
        VideoTitlesDTO videoTitlesDTO;
        Document doc;
        try {
            doc = Jsoup.connect(videoUrl).data("page", pageNumber, "sort", sort).get();
            Elements titlesLinks = doc.select(".b-poster-tile__link");
            for (Element link : titlesLinks) {
                videoTitlesDTO = new VideoTitlesDTO();
                videoTitlesDTO.shortTitle = link.select(".b-poster-tile__title-short").text();
                videoTitlesDTO.fullTitle = link.select(".b-poster-tile__title-full").text();
                videoTitlesDTO.titleUrl = link.attr("href");
                videoTitlesDTO.imageUrl = link.select(".b-poster-tile__image img[src]").attr("src");
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
