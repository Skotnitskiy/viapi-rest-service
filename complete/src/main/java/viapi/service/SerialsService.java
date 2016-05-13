package viapi.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import viapi.dto.SerialDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerialsService {

    private String serialsUrl = "http://fs.to/video/serials/";
    private String fsUrl = "http://fs.to";

    public List<SerialDTO> getSeials() {
        List<SerialDTO> serialDTOs = new ArrayList<SerialDTO>();
        SerialDTO serialDTO;
        Document doc;
        try {
            doc = Jsoup.connect(serialsUrl).get();
            Elements serialsLinks = doc.select(".b-poster-tile__link");
            for (Element link : serialsLinks) {
                serialDTO = new SerialDTO();
                serialDTO.shortTitle = link.select(".b-poster-tile__title-short").text();
                serialDTO.fullTitle = link.select(".b-poster-tile__title-full").text();
                serialDTO.serialUrl = new URL(fsUrl + link.attr("href"));
                serialDTO.imageUrl = new URL("http:" + link.select(".b-poster-tile__image img[src]").attr("src"));
                serialDTO.titleInfoItem = link.select(".b-poster-tile__title-info-items").text();
                serialDTO.titleInfoVotePositive = link.select(".b-poster-tile__title-info-vote-positive").text();
                serialDTO.titleInfoVoteNegative = link.select(".b-poster-tile__title-info-vote-negative").text();
                Elements qSpans = link.select(".b-poster-tile__title-info-qualities span[class]");
                serialDTO.qualities.addAll(qSpans.stream().map(qSpan -> qSpan.attr("class")).collect(Collectors.toList()));
                serialDTOs.add(serialDTO);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serialDTOs;
    }
}
