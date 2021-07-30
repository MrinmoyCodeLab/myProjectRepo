package com.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.store.model.TradeDetailVo;

@Repository
public interface TradeServiceRepository extends JpaRepository<TradeDetailVo, String>{
	
	public List<TradeDetailVo> findAllByTradeId(String tradeId);
	
	
}
