package viapi.dto;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VideoTitlesDTO {
    public String shortTitle;
    public String fullTitle;
    public URL serialUrl;
    public URL imageUrl;
    public String titleInfoItem;
    public String titleInfoVotePositive;
    public String titleInfoVoteNegative;
    public List<String> qualities = new ArrayList<String>();
}