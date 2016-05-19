package viapi.dtos;

import java.util.ArrayList;
import java.util.List;

public class VideoTitlesDTO {
    public String shortTitle;
    public String fullTitle;
    public String titleUrl;
    public String imageUrl;
    public String titleInfoItem;
    public String titleInfoVotePositive;
    public String titleInfoVoteNegative;
    public List<String> qualities = new ArrayList<>();
}