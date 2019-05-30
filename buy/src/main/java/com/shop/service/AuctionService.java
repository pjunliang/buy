package com.shop.service;

import com.shop.pojo.Auction;
import com.shop.pojo.Auctionrecord;

import java.util.List;

public interface AuctionService {

    /**
     * 查出所有拍卖商品
     * @return
     */
    List<Auction> findAllAction();

    /**
     * 多条件查询
     * @param example
     * @return
     */
   List<Auction> findActionsExample(Auction auction);

    /**
     * 竞拍详情
     * @param auctionId
     * @return
     */
   Auction getAuctionDetails(Integer auctionId);

    /**
     * 竞拍
     * @return
     */
   Integer bidding(Auctionrecord auctionrecord);
}
