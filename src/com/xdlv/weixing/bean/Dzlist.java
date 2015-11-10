package com.xdlv.weixing.bean;

import com.xdlv.fw.FwUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dzlist {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.year
     *
     * @mbggenerated
     */
    private Integer year;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.month
     *
     * @mbggenerated
     */
    private Integer month;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.impdate
     *
     * @mbggenerated
     */
    private Date impdate;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.userid
     *
     * @mbggenerated
     */
    private String userid;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.Username
     *
     * @mbggenerated
     */
    private String username;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.Isok
     *
     * @mbggenerated
     */
    private String isok;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.Qmye
     *
     * @mbggenerated
     */
    private Float qmye = 0f;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.zdxsk1
     *
     * @mbggenerated
     */
    private Float zdxsk1 = 0f;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.ysdsk1
     *
     * @mbggenerated
     */
    private Float ysdsk1 = 0f;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.zdfwk1
     *
     * @mbggenerated
     */
    private Float zdfwk1 = 0f;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.jb1
     *
     * @mbggenerated
     */
    private Float jb1 = 0f;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.fl1
     *
     * @mbggenerated
     */
    private Float fl1 = 0f;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.zdxsk2
     *
     * @mbggenerated
     */
    private Float zdxsk2 = 0f;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.jb2
     *
     * @mbggenerated
     */
    private Float jb2;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.fl2
     *
     * @mbggenerated
     */
    private Float fl2;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.zdfwk2
     *
     * @mbggenerated
     */
    private Float zdfwk2;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.qtyfdk2
     *
     * @mbggenerated
     */
    private Float qtyfdk2;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_dzlist.credit_scope
	 * @mbggenerated
	 */
	private String creditScope;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.year
     *
     * @return the value of t_dzlist.year
     * @mbggenerated
     */
    public Integer getYear() {
        return year;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.year
     *
     * @param year the value for t_dzlist.year
     * @mbggenerated
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.month
     *
     * @return the value of t_dzlist.month
     * @mbggenerated
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.month
     *
     * @param month the value for t_dzlist.month
     * @mbggenerated
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.impdate
     *
     * @return the value of t_dzlist.impdate
     * @mbggenerated
     */
    public Date getImpdate() {
        return impdate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.impdate
     *
     * @param impdate the value for t_dzlist.impdate
     * @mbggenerated
     */
    public void setImpdate(Date impdate) {
        this.impdate = impdate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.userid
     *
     * @return the value of t_dzlist.userid
     * @mbggenerated
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.userid
     *
     * @param userid the value for t_dzlist.userid
     * @mbggenerated
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.Username
     *
     * @return the value of t_dzlist.Username
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.Username
     *
     * @param username the value for t_dzlist.Username
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.Isok
     *
     * @return the value of t_dzlist.Isok
     * @mbggenerated
     */
    public String getIsok() {
        return isok;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.Isok
     *
     * @param isok the value for t_dzlist.Isok
     * @mbggenerated
     */
    public void setIsok(String isok) {
        this.isok = isok == null ? null : isok.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.Qmye
     *
     * @return the value of t_dzlist.Qmye
     * @mbggenerated
     */
    public Float getQmye() {
        return zdxsk1 +
                ysdsk1 +
                zdfwk1 +
                jb1 +
                fl1 +
                zdxsk2 +
                jb2 +
                fl2 +
                zdfwk2 +
                qtyfdk2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.Qmye
     *
     * @param qmye the value for t_dzlist.Qmye
     * @mbggenerated
     */
    public void setQmye(Float qmye) {
        this.qmye = qmye;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.zdxsk1
     *
     * @return the value of t_dzlist.zdxsk1
     * @mbggenerated
     */
    public Float getZdxsk1() {
        return zdxsk1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.zdxsk1
     *
     * @param zdxsk1 the value for t_dzlist.zdxsk1
     * @mbggenerated
     */
    public void setZdxsk1(Float zdxsk1) {
        this.zdxsk1 = zdxsk1;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.ysdsk1
     *
     * @return the value of t_dzlist.ysdsk1
     * @mbggenerated
     */
    public Float getYsdsk1() {
        return ysdsk1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.ysdsk1
     *
     * @param ysdsk1 the value for t_dzlist.ysdsk1
     * @mbggenerated
     */
    public void setYsdsk1(Float ysdsk1) {
        this.ysdsk1 = ysdsk1;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.zdfwk1
     *
     * @return the value of t_dzlist.zdfwk1
     * @mbggenerated
     */
    public Float getZdfwk1() {
        return zdfwk1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.zdfwk1
     *
     * @param zdfwk1 the value for t_dzlist.zdfwk1
     * @mbggenerated
     */
    public void setZdfwk1(Float zdfwk1) {
        this.zdfwk1 = zdfwk1;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.jb1
     *
     * @return the value of t_dzlist.jb1
     * @mbggenerated
     */
    public Float getJb1() {
        return jb1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.jb1
     *
     * @param jb1 the value for t_dzlist.jb1
     * @mbggenerated
     */
    public void setJb1(Float jb1) {
        this.jb1 = jb1;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.fl1
     *
     * @return the value of t_dzlist.fl1
     * @mbggenerated
     */
    public Float getFl1() {
        return fl1;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.fl1
     *
     * @param fl1 the value for t_dzlist.fl1
     * @mbggenerated
     */
    public void setFl1(Float fl1) {
        this.fl1 = fl1;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.zdxsk2
     *
     * @return the value of t_dzlist.zdxsk2
     * @mbggenerated
     */
    public Float getZdxsk2() {
        return zdxsk2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.zdxsk2
     *
     * @param zdxsk2 the value for t_dzlist.zdxsk2
     * @mbggenerated
     */
    public void setZdxsk2(Float zdxsk2) {
        this.zdxsk2 = zdxsk2;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.jb2
     *
     * @return the value of t_dzlist.jb2
     * @mbggenerated
     */
    public Float getJb2() {
        return jb2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.jb2
     *
     * @param jb2 the value for t_dzlist.jb2
     * @mbggenerated
     */
    public void setJb2(Float jb2) {
        this.jb2 = jb2;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.fl2
     *
     * @return the value of t_dzlist.fl2
     * @mbggenerated
     */
    public Float getFl2() {
        return fl2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.fl2
     *
     * @param fl2 the value for t_dzlist.fl2
     * @mbggenerated
     */
    public void setFl2(Float fl2) {
        this.fl2 = fl2;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.zdfwk2
     *
     * @return the value of t_dzlist.zdfwk2
     * @mbggenerated
     */
    public Float getZdfwk2() {
        return zdfwk2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.zdfwk2
     *
     * @param zdfwk2 the value for t_dzlist.zdfwk2
     * @mbggenerated
     */
    public void setZdfwk2(Float zdfwk2) {
        this.zdfwk2 = zdfwk2;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.qtyfdk2
     *
     * @return the value of t_dzlist.qtyfdk2
     * @mbggenerated
     */
    public Float getQtyfdk2() {
        return qtyfdk2;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.qtyfdk2
     *
     * @param qtyfdk2 the value for t_dzlist.qtyfdk2
     * @mbggenerated
     */
    public void setQtyfdk2(Float qtyfdk2) {
        this.qtyfdk2 = qtyfdk2;
    }

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_dzlist.credit_scope
	 * @return  the value of t_dzlist.credit_scope
	 * @mbggenerated
	 */
	public String getCreditScope() {
		return creditScope;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_dzlist.credit_scope
	 * @param creditScope  the value for t_dzlist.credit_scope
	 * @mbggenerated
	 */
	public void setCreditScope(String creditScope) {
		this.creditScope = creditScope == null ? null : creditScope.trim();
	}
	
	 public Dzlist() {
        isok = "N";
        qmye = 0f;
        zdxsk1 = 0f;
        ysdsk1 = 0f;
        zdfwk1 = 0f;
        jb1 = 0f;
        fl1 = 0f;
        zdxsk2 = 0f;
        jb2 = 0f;
        fl2 = 0f;
        zdfwk2 = 0f;
        qtyfdk2 = 0f;
    }

    //phone of user company for query
    private String phone;

    private Userdz userdz;
    private UserCompany userCompany;

    public List<String> getIsQueryOk() {
        if (confirm == null && unconfirm == null && reject == null){
            return null;
        }
        List<String> retList = new ArrayList<String>();
        if (confirm != null){
            retList.add(confirm);
        }
        if (unconfirm != null){
            retList.add(unconfirm);
        }
        if (reject != null){
            retList.add(reject);
        }
        return retList;
    }

    private String confirm,unconfirm,reject;
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getUnconfirm() {
        return unconfirm;
    }

    public void setUnconfirm(String unconfirm) {
        this.unconfirm = unconfirm;
    }

    public String getReject() {
        return reject;
    }

    public void setReject(String reject) {
        this.reject = reject;
    }

    public int getDay(){
        if (year != null && month != null){
            return FwUtil.getLastDayInMonth(year,month);
        }
        return 30;
    }

    public Userdz getUserdz() {
        return userdz;
    }

    public void setUserdz(Userdz userdz) {
        this.userdz = userdz;
    }

    public UserCompany getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(UserCompany userCompany) {
        this.userCompany = userCompany;
    }
}