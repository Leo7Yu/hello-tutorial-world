package cn.leo.spring.dao.mybatis.activity;

public interface LotteryConfigDao {

    public Integer selectAidById(int id); 
    
    public Integer insertLotteryAid(int aid);
}
