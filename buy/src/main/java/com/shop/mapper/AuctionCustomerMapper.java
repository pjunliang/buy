package com.shop.mapper;

import com.shop.pojo.Auction;

public interface AuctionCustomerMapper {

  Auction getAuctionDetails(Integer auctionId);
}