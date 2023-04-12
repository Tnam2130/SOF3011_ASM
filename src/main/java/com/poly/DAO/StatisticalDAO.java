package com.poly.DAO;

import com.poly.Dto.VideoLiked;
import com.poly.entity.User;

import java.util.List;

public interface StatisticalDAO {
    List<VideoLiked> find_VideoLike();
}
