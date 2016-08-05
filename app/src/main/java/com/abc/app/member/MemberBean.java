package com.abc.app.member;

/**
 * Created by admin on 8/3/2016.
 */
public class MemberBean {
    private String name,email,password,phone,regDate,birth,profImg,cardNum,fav;

    private boolean isRcvEmail;
    private int grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getProfImg() {
        return profImg;
    }

    public void setProfImg(String profImg) {
        this.profImg = profImg;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    public boolean isRcvEmail() {
        return isRcvEmail;
    }

    public void setRcvEmail(boolean rcvEmail) {
        isRcvEmail = rcvEmail;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
