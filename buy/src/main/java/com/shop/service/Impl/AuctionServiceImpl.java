package com.shop.service.Impl;

import com.shop.mapper.AuctionCustomerMapper;
import com.shop.mapper.AuctionMapper;
import com.shop.mapper.AuctionrecordMapper;
import com.shop.pojo.Auction;
import com.shop.pojo.AuctionExample;
import com.shop.pojo.Auctionrecord;
import com.shop.service.AuctionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AuctionServiceImpl implements AuctionService {
    @Resource
    AuctionMapper auctionMapper;
    @Resource
    AuctionCustomerMapper auctionCustomerMapper;
    @Resource
    AuctionrecordMapper auctionrecordMapper;

    /**
     * 查询出所有商品
     * @return
     */
    @Override
    public List<Auction> findAllAction() {

        AuctionExample example = new AuctionExample();
        return auctionMapper.selectByExample(example);
    }

    /**
     * 多条件查询
     * @param auction
     * @return
     */
    @Override
    public List<Auction> findActionsExample(Auction auction) {
        System.out.println("运行到service层");
        AuctionExample example = new AuctionExample();
        AuctionExample.Criteria criteria = example.createCriteria();
        if(auction.getAuctionname()!=null && auction.getAuctionname() != ""){
            criteria.andAuctionnameLike("%"+auction.getAuctionname()+"%");
        }
        if(auction.getAuctiondesc()!=null&& auction.getAuctiondesc() != ""){
            criteria.andAuctiondescLike("%"+auction.getAuctiondesc()+"%");
        }
        if(auction.getAuctionstarttime()!=null){
            criteria.andAuctionstarttimeGreaterThan(auction.getAuctionstarttime());
        }
        if(auction.getAuctionendtime() != null){
            criteria.andAuctionendtimeLessThanOrEqualTo(auction.getAuctionendtime());
        }
        if(auction.getAuctionstartprice() !=null){
            criteria.andAuctionstartpriceLessThanOrEqualTo(auction.getAuctionstartprice());
        }
        example.setOrderByClause("auctionstarttime desc");

        return auctionMapper.selectByExample(example);
    }

    /**
     * 竞拍详情
     * @param auctionId
     * @return
     */
    @Override
    public Auction getAuctionDetails(Integer auctionId) {
        return auctionCustomerMapper.getAuctionDetails(auctionId);
    }

    /**
     * 竞拍
     * @param auctionrecord
     * @return
     */
    @Override
    public Integer bidding(Auctionrecord auctionrecord) {

        int row = auctionrecordMapper.insert(auctionrecord);

        return row;
    }

}
