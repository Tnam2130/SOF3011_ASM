package com.poly.DAO.impl;

import com.poly.DAO.AbstractDAO;
import com.poly.DAO.StatisticalDAO;
import com.poly.Dto.VideoLiked;
import com.poly.entity.User;
import com.poly.utils.QueryParamemter;

import java.util.ArrayList;
import java.util.List;

public class StaticalDaoImpl extends AbstractDAO<Object[]> implements StatisticalDAO {
    @Override
    public List<VideoLiked> find_VideoLike() {
        String sql = "SELECT v.Id, v.title, v.href, SUM(CAST(h.isLiked AS INT)) AS TotalLike"
                + " FROM Videos v LEFT JOIN History h ON v.ID = h.VideoID"
                + " WHERE v.isActive = 1"
                + " GROUP BY v.Id, v.title, v.href "
                + " ORDER BY SUM(CAST(h.isLiked AS INT)) DESC";
        List<Object[]> objects = super.findManyByNativeQuery(sql);
        List<VideoLiked> result = new ArrayList<>();
        objects.forEach(object -> {
            VideoLiked videoLiked = setData_VideoLiked(object);
            result.add(videoLiked);
        });
        return result;
    }

    private VideoLiked setData_VideoLiked (Object[] object) {
        VideoLiked videoLiked = new VideoLiked();
        videoLiked.setVideoId((Integer) object[0]);
        videoLiked.setTitle((String)object[1]);
        videoLiked.setHref((String)object[2]);
        videoLiked.setTotalLike((Integer)object[3] == null ? 0 : (Integer)object[3]);
        return videoLiked;
    }
}
