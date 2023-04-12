package com.poly.Dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoLiked {
    private Integer videoId;
    private String title;
    private String href;
    private Integer totalLike;

    @Override
    public String toString() {
        return "VideoLiked [videoID=" + videoId + ", title=" + title + ", href=" + href + ", totalLike=" + totalLike
                + "]";
    }

}
