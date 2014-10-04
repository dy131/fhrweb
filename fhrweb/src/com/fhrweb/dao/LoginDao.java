package com.fhrweb.dao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.fhrweb.model.User;


@Repository
public class LoginDao extends BaseDao<User, Long> {

	/***
	 * 鏍规嵁姣旇禌鏃堕棿鍜宭eague_type鑾峰彇ATP/WTA姝ｅ湪杩涜鐨勮禌浜嬩俊鎭�
	 * @param hasScore true-鏈夋瘮鍒嗙殑璧涗簨 
	 * @param today
	 * @return
	 */
	public List<User> getUserByDate(Date begin, Date end, boolean hasScore) {
		StringBuffer sqlSb = new StringBuffer("select  t.league_id, t.cn_full_name league_cn_full_name, to_char(t.begin_date, 'MM.dd') league_en_full_name, " +
				" to_char(t.end_date, 'dd') league_tr_full_name from (" +
				" select distinct tm.league_id, tl.cn_full_name,tls.begin_date, tls.end_date " +
				" from TENNIS_MATCH tm " +
				" inner join TENNIS_LEAGUE tl on tm.league_id=tl.id " +
				" inner join TENNIS_LEAGUE_SEASON tls on tls.league_id=tm.league_id and tls.season_id=tm.season_id " +
				" where tm.match_time<:p1 and tm.match_time>=:p2 " +
				" and tls.end_date is not null and tls.begin_date is not null and (tm.league_type=1 or tm.league_type=3 or tm.league_type=2 or tm.league_type=4) ");
		if (hasScore)
			sqlSb.append(" and tm.turn_score_a1 is not null and tm.turn_score_b1 is not null ");
		else 
			sqlSb.append(" and tm.status not in (0,10,11,12,18,19) ");
		sqlSb.append(" ) t order by t.begin_date desc");
		return null;
	}
	
	
	public List<User> getNextHasMatchDate(Date date) {
		String sql = "select * from (select tm.match_time from tennis_match tm where tm.match_time>=:p1 order by tm.match_time) t where rownum=1";
		return null;
	}


	@Override
	protected Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}