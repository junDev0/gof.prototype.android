package com.abc.app.member;

/**
 * Created by admin on 8/3/2016.
 */
public interface MemberService {
    public MemberBean findByPk(String email);
    public int regist(MemberBean memBean);
    public boolean login(MemberBean memBean);
    public void update(MemberPaymentCard pcmBean);
    public void delete(MemberBean memBean);
    public void addBk(String email, int serialNo);
    public void delBk(String email, int serialNo);
    public void addFav(String email, String fav);
    public void update(String updateInfo);

}
