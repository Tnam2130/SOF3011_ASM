package com.poly.service.impl;

import com.poly.DAO.HistoryDAO;
import com.poly.DAO.impl.HistoryDAOimpl;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;

import java.sql.Timestamp;
import java.util.List;

public class HistoryServiceImpl implements HistoryService {
    private final HistoryDAO dao = new HistoryDAOimpl();
    private final VideoService videoService = new VideoServiceImpl();
    @Override
    public List<History> findByUser(String username) {
        return dao.findByUser(username);
    }

    @Override
    public List<History> findByUserAndIsLiked(String username) {
        return dao.findByUserAndIsLiked(username);
    }

    @Override
    public History findByUserIdAndVideoId(Integer uid, Integer vid) {
        return dao.findByUserIdAndVideoId(uid, vid);
    }

    @Override
    public History create(User user, Video video) {
        History existHistory= findByUserIdAndVideoId(user.getId(), video.getId());
        if(existHistory == null){
            existHistory = new History();
            existHistory.setUser(user);
            existHistory.setVideo(video);
            existHistory.setViewedDate(new Timestamp(System.currentTimeMillis()));
            existHistory.setIsLiked(false);
            return dao.create(existHistory);
        }

        return existHistory;
    }

    @Override
    public boolean updateLikeOrUnLike(User user, String videoHref) {
        Video video = videoService.findByHref(videoHref);
        History existHistory = findByUserIdAndVideoId(user.getId(), video.getId());
        if(!existHistory.getIsLiked()){
            existHistory.setIsLiked(true);
            existHistory.setLikedDate(new Timestamp(System.currentTimeMillis()));
        }else{
            existHistory.setIsLiked(false);
            existHistory.setLikedDate(null);
        }
        History updateHistory = dao.update(existHistory);
        return updateHistory != null ? true : false;
    }
}
