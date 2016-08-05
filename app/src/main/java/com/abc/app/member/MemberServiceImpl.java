package com.abc.app.member;

import android.content.Context;
import android.util.Log;

/**
 * Created by admin on 8/3/2016.
 */
public class MemberServiceImpl implements MemberService {
    MemberDAO dao;

    public MemberServiceImpl(Context context) {
        dao = new MemberDAO(context);
        Log.d("==create db===",": access point");
    }

    @Override
    public MemberBean findByPk(String email) {
        return dao.findByPk(email);
    }

    @Override
    public int regist(MemberBean memBean) {
        dao.insert(memBean);
        return 0;
    }

    @Override
    public boolean login(MemberBean memBean) {
        MemberPaymentCard pcmBean = new MemberPaymentCard();
        pcmBean.setEmail(memBean.getEmail());
        return dao.login(memBean);
    }

    @Override
    //Register with additional info
    public void update(MemberPaymentCard pcmBean) {
        pcmBean.setName(pcmBean.getName());
        dao.update(pcmBean);;
    }

    @Override
    public void delete(MemberBean memBean) {
        dao.delete(memBean);
    }

    @Override
    public void addBk(String email, int serialNo) {
        dao.insertBk(email, serialNo);
    }

    @Override
    public void delBk(String email, int serialNo) {
        dao.delBk(email, serialNo);
    }

    @Override
    public void addFav(String email, String fav) {
        dao.updateFav(email, fav);
    }

    @Override
    public void update(String updateInfo) {
        String[] arr = updateInfo.split(":");
        dao.update(arr[0],arr[1],arr[2]);
    }
}
