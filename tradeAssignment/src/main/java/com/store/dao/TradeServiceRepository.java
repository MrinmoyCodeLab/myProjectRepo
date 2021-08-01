package com.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.store.model.TradeDetailVo;

@Repository
public interface TradeServiceRepository extends JpaRepository<TradeDetailVo, String>{
	
	
	@Query(value="SELECT COUNT(VERSION) FROM TRADE_STORE TS WHERE TS.TRADE_ID= :tradeId AND TS.VERSION > :version " ,  nativeQuery = true)
	public int findUpperVersionByTradeId(@Param("tradeId") String tradeId, @Param("version") int version);	
	
	
	@Query(value="SELECT TS.EXPIRED FROM TRADE_STORE TS WHERE TS.TRADE_ID= :tradeId AND TS.VERSION = :version and TS.EXPIRED= :expired " ,  nativeQuery = true)
	public String  findExpiredTrade(@Param("tradeId") String tradeId,@Param("version")int version,@Param("expired") String expired);
	
	@Query(value="SELECT * FROM TRADE_STORE TS WHERE TS.TRADE_ID= :tradeId AND TS.VERSION = :version " ,  nativeQuery = true)
	public TradeDetailVo  findTradeByVersion(@Param("tradeId") String tradeId,@Param("version")int version);
	
	
	@Transactional
    @Modifying
    @Query(value=" UPDATE TRADE_STORE TS SET TS.EXPIRED='Y' WHERE TS.MATURITY_DATE < SYSDATE AND TS.EXPIRED= :expired ",nativeQuery = true)
	public void updateAllByExpired(@Param("expired") String expired );
}
