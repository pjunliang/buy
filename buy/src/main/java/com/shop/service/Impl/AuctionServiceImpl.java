package com.shop.service.Impl;

import com.shop.mapper.AuctionCustomerMapper;
import com.shop.mapper.AuctionMapper;
import com.shop.mapper.AuctionrecordMapper;
import com.shop.pojo.Auction;
import com.shop.pojo.AuctionExample;
import com.shop.pojo.Auctionrecord;
import com.shop.service.AuctionService;
import com.shop.tools.AuctionCustomException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
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
    public Integer bidding(Auctionrecord auctionrecord) throws Exception {
        Auction auction = auctionCustomerMapper.getAuctionDetails(auctionrecord.getAuctionid());

        if(auction.getAuctionendtime().before(new Date())){
            throw new AuctionCustomException("竞拍结束！！！");
        }
        if(auction.getAuctionrecodList()!=null&&auction.getAuctionrecodList().size()>0){
            BigDecimal auctionprice = auction.getAuctionrecodList().get(0).getAuctionprice();
            System.out.println("出价============"+auctionprice);
            if(auctionprice.compareTo(auctionrecord.getAuctionprice())>=1){
                throw new AuctionCustomException("竞拍价格不能低于最高竞拍价！");
            }
        }
        if(auctionrecord.getAuctionprice().compareTo(auction.getAuctionstartprice())<1){
            throw new AuctionCustomException("出价不能小于竞拍价");
        }
        int row = auctionrecordMapper.insert(auctionrecord);

        return row;
    }

}
