package com.poly.service.impl;

import com.poly.DAO.StatisticalDAO;
import com.poly.DAO.impl.StaticalDaoImpl;
import com.poly.Dto.VideoLiked;
import com.poly.service.StaticalService;

import java.util.List;

public class StaticalServiceImpl implements StaticalService {
    private StatisticalDAO statisticalDAO;

    public StaticalServiceImpl() {
        statisticalDAO = new StaticalDaoImpl();
    }

    @Override
    public List<VideoLiked> find_VideoLike() {
        return statisticalDAO.find_VideoLike() ;
    }
}
