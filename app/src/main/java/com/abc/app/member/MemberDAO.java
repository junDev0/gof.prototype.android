package com.abc.app.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by admin on 8/3/2016.
 */
public class MemberDAO extends SQLiteOpenHelper{
    public static final String TABLE_NAME = "member";
    public static final String EMAIL = "email";
    public static final String NAME = "name";
    public static final String PASSWORD = "password";
    public static final String GRADE= "grade";
    public static final String PHONE = "phone";
    public static final String REG_DATE = "regDate";
    public static final String BIRTH = "birth";
    public static final String PROFILE_IMG = "profImg";
    public static final String CARD_NUM = "cardNum";
    public static final boolean EMAIL_SV = true;
    public static final String FAV = "fav";
    public static final int SERIAL_NO = 0;

    public MemberDAO(Context context) {
        super(context, "memberDB", null, 1);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists "
                + TABLE_NAME
                + " ( "
                + EMAIL + " test primary key, "
                + NAME + " text, "
                + PASSWORD + " text, "
                + GRADE + " number, "
                + PHONE + " text, "
                + REG_DATE + " text, "
                + BIRTH + " text, "
                + PROFILE_IMG + " text, "
                + CARD_NUM + " text, "
                + EMAIL_SV + " text, "
                + FAV + " text );";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) {
        //drop table
        String sql = "drop table if exists " + TABLE_NAME;
        db.execSQL(sql);
        this.onCreate(db);
    }

    public void update(MemberPaymentCard pcmBean) {
        String sql = "update "+ TABLE_NAME
                + String.format(" set %s = '%s',%s = '%s',%s = %s,%s = '%s',%s = '%s'", NAME,pcmBean.getName(), BIRTH,pcmBean.getBirth(), GRADE, pcmBean.getGrade(),CARD_NUM, pcmBean.getCardNum(),PHONE,pcmBean.getPhone())
                + String.format(" where  email = '%s';",pcmBean.getEmail());
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }

    public void insert(MemberBean memBean) {
        String sql = "INSERT INTO "+TABLE_NAME
                + String.format("(%s,%s,%s)",EMAIL, PASSWORD, GRADE)
                + String.format(" values('%s','%s',%s);",memBean.getEmail(),memBean.getPassword(),memBean.getGrade());
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }

    public MemberBean findByPk(String email) {
        String sql = "select "
                + String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s ",EMAIL, NAME, PASSWORD, GRADE, PHONE, REG_DATE, BIRTH, PROFILE_IMG, CARD_NUM, EMAIL_SV, FAV)
                + String.format(" from "+TABLE_NAME+" where email = '%s';", email);
        MemberBean temp = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor!=null){
            Log.d("DAO findByPk: ","id search success!");
            if (cursor.moveToFirst()){
                temp = new MemberBean();
                temp.setEmail(cursor.getString(0));
                temp.setName(cursor.getString(1));
                temp.setPassword(cursor.getString(2));
                temp.setGrade(cursor.getInt(3));
                temp.setPhone(cursor.getString(4));
                temp.setRegDate(cursor.getString(5));
                temp.setBirth(cursor.getString(6));
                temp.setProfImg(cursor.getString(7));
                temp.setCardNum(cursor.getString(8));
                temp.setRcvEmail(cursor.getString(9).equals("Y")?true:false);
                temp.setFav(cursor.getString(10));
            }
        }
        return temp;
    }

    public boolean login(MemberBean memBean) {
        boolean loginOk = false;
        String sql = "select password from "+TABLE_NAME
                + String.format(" where email = '%s';", memBean.getEmail());
        SQLiteDatabase db = this.getReadableDatabase();
        String password = "";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            password = cursor.getString(0);
        }
        if (password.equals("")){
            loginOk = false;
            Log.d("DAO Login result: ","no email match");
        }else{
            Log.d("DAO Email: ",memBean.getEmail());
            Log.d("DAO Password: ",password);
            loginOk = (password.equals(memBean.getPassword()))?true:false;
        }
        System.out.println("LoginOK? : "+loginOk);
        return loginOk;
    }

    public void delete(MemberBean memBean) {
        String sql = "delete from "+TABLE_NAME
                + String.format(" where email = '%s'; ", memBean.getEmail());
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }

    public void update(String email, String column, String value) {
        String sql = "update "+ TABLE_NAME
                + String.format(" SET  %s ='%s' where email = '%s';",column,value,email);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }

    public void insertBk(String email, int serialNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "insert into BOOKMARK "
                + String.format("(%s, %s)", EMAIL, SERIAL_NO)
                + String.format(" values('%s',%s));",email, serialNo);
        db.execSQL(sql);
    }

    public void delBk(String email, int serialNo) {
        String sql = "delete from BOOKMARK"
                + String.format(" where email = '%s'; ", email);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }

    public void updateFav(String email, String fav) {
        String sql = "update BOOKMARK"
                + String.format(" SET FAV = '%s' where EMAIL = '%s';",fav, email);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
}
