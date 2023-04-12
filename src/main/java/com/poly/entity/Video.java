package com.poly.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "VIDEOS")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Video.findByHref", query = "Select o From Video o Where o.href LIKE :param "),
})
//@NamedNativeQueries({
//        @NamedNativeQuery(name = "Video.findVideoLiked", query = "SELECT ?, ?, ?, SUM(CAST(h.isLiked AS INT)) " +
//                " AS TotalLike FROM o.Video v JOIN o.History h ON v.Id WHERE v.isActive = 1" +
//                " GROUP BY ?, ?, ? ORDER BY SUM(CAST(h.isLiked AS INT)) DESC "),
//})

public class Video {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "HREF")
    private String href;
    @Column(name = "POSTER")
    private String poster;
    @Column(name = "`VIEWS`")
    private Integer views = 0;
    @Column(name = "SHARES")
    private Integer shares = 0;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ISACTIVE")
    private Boolean isActive = true;
}
