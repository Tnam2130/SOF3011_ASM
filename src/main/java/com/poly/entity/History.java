package com.poly.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "HISTORY")
@Getter
@Setter
@NamedQueries({@NamedQuery(name ="History.findByUser", query="SELECT o FROM History o WHERE o.User.username = :username " +
        "AND o.Video.isActive = true ORDER BY o.viewedDate DESC"),
        @NamedQuery(name = "History.findByUserAndIsLiked", query = "SELECT o FROM History o WHERE o.User.username = " +
                ":username AND o.isLiked = true AND o.Video.isActive = true ORDER BY o.viewedDate DESC"),
        @NamedQuery(name = "History.findByUserIdAndVideoId", query = "Select o From History o Where o.User.Id = :uid " +
                "AND o.Video.Id = :vid AND o.Video.isActive = true"),
})
public class History {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    private User User;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "VIDEOID", referencedColumnName = "ID")
    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    private Video Video;
    @Column(name = "VIEWEDDATE")
    @CreationTimestamp
    private Timestamp viewedDate;
    @Column(name = "ISLIKED")
    private Boolean isLiked;
    @Column(name = "LIKEDDATE")
    private Timestamp likedDate;

}
