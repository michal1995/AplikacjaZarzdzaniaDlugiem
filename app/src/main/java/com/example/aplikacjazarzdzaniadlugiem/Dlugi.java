package com.example.aplikacjazarzdzaniadlugiem;

/**
  *Represents an item in Dlugi list
  */
public class Dlugi {

    /**
     * Item id
     */
    @com.google.gson.annotations.SerializedName("id")
        private String mId;

    /**
     * Item Za co
     */
    @com.google.gson.annotations.SerializedName("ZaCo")
        private String mZaCo;

    /**
     * Item ile
     */
    @com.google.gson.annotations.SerializedName("Ile")
        private float mIle;

    /**
     * Item potwierdzone
     */
    @com.google.gson.annotations.SerializedName("Potwierdzone")
        private boolean mPotwierdzone;

    /**
     * Item splacone
     */
    @com.google.gson.annotations.SerializedName("Splacone")
        private boolean mSplacone;

    /**
     * Item komu
     */
    @com.google.gson.annotations.SerializedName("Komu")
        private String mKomu;

    /**
     * Item KomuLogin
     */
    @com.google.gson.annotations.SerializedName("KomuLogin")
        private String mKomuLogin;

    /**
     * Item Kto
     */
    @com.google.gson.annotations.SerializedName("Kto")
        private String mKto;

    /**
     * Item
     */
    @com.google.gson.annotations.SerializedName("KtoLogin")
        private String mKtoLogin;

    /**
     * Return the item mKomuLogin
     * @return mKomuLogin
     */
    public String getmKomuLogin() {
        return mKomuLogin;
    }

    /**
     * Return the item mKto
     * @return mKto
     */
    public String getmKto() {
        return mKto;
    }

    /**
     * Return the item mKtoLogin
     * @return mKtoLogin
     */
    public String getmKtoLogin() {
        return mKtoLogin;
    }

    /**
     * Sets the item mKomuLogin
     * @param mKomuLogin
     * mKomuLogin to set
     */
    public void setmKomuLogin(String mKomuLogin) {
        this.mKomuLogin = mKomuLogin;
    }

    /**
     * Sets the item mKto
     * @param mKto
     *  mKto to set
     */
    public void setmKto(String mKto) {
        this.mKto = mKto;
    }

    /**
     * Sets the item mKtoLogin
     * @param mKtoLogin
     * mKtoLogin to set
     */
    public void setmKtoLogin(String mKtoLogin) {
        this.mKtoLogin = mKtoLogin;
    }

    /**
     * Marks the item as completed or incomplited
     * @param mSplacone
     *
     */
    public void setmSplacone(boolean mSplacone) {
        this.mSplacone = mSplacone;
    }

    /**
     * Set the item mKomu
     * @param mKomu
     */
    public void setmKomu(String mKomu) {
        this.mKomu = mKomu;
    }

    /**
     * Indicates if the item is marked as completed
     * @return mPotwierdzone
     */
    public boolean ismPotwierdzone() {
        return mPotwierdzone;
    }

    /**
     * Indicates if mSplacone is marked as completed
     * @return mSplacone
     */
    public boolean ismSplacone() {
        return mSplacone;
    }

    /**
     * Returns the item
     * @return mKomu
     */
    public String getmKomu() {
        return mKomu;
    }

    /**
     * Returns the item
     * @return mId
     */
    public String getmId() {
        return mId;
    }

    /**
     * Returns the item
     * @return mZaco
     */
    public String getmZaCo() {
        return mZaCo;
    }

    /**
     * Returns the item
     * @return mIle
     */
    public float getmIle() {
        return mIle;
    }

    /**
     * Set the item mIle
     * @param mIle
     */
    public void setmIle(float mIle) {
        this.mIle = mIle;
    }

    /**
     * Returns the item
     * @return mKomu
     */
    public void setmZaCo(String mZaCo) {
        this.mZaCo = mZaCo;
    }

    /**
     * Indicates if the mPotwierdzone is marked as completed
     * @return
     */
    public boolean getmPotwierdzone() {
        return mPotwierdzone;
    }

    /**
     * Marks the item as comleted or incompleted
     * @param mPotwierdzone
     */
    public void setmPotwierdzone(boolean mPotwierdzone) {
        this.mPotwierdzone = mPotwierdzone;
    }
}
