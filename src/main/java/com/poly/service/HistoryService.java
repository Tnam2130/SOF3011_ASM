package com.poly.service;

import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;

import java.util.List;

public interface HistoryService {
    List<History> findByUser(String username);
    List<History> findByUserAndIsLiked(String username);
    History findByUserIdAndVideoId(Integer uid, Integer vid);
    History create (User user, Video video);
    boolean updateLikeOrUnLike (User user, String videoHref);
}
