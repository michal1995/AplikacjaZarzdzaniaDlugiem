package com.example.aplikacjazarzdzaniadlugiem;

public class Dlugi {
    @com.google.gson.annotations.SerializedName("id")
        private String mId;
    @com.google.gson.annotations.SerializedName("ZaCo")
        private String mZaCo;
    @com.google.gson.annotations.SerializedName("Ile")
        private float mIle;
    @com.google.gson.annotations.SerializedName("Potwierdzone")
        private boolean mPotwierdzone;
    @com.google.gson.annotations.SerializedName("Splacone")
        private boolean mSplacone;
    @com.google.gson.annotations.SerializedName("Komu")
        private String mKomu;
    @com.google.gson.annotations.SerializedName("KomuLogin")
        private String mKomuLogin;
    @com.google.gson.annotations.SerializedName("Kto")
        private String mKto;
    @com.google.gson.annotations.SerializedName("KtoLogin")
        private String mKtoLogin;

    public String getmKomuLogin() {
        return mKomuLogin;
    }

    public String getmKto() {
        return mKto;
    }

    public String getmKtoLogin() {
        return mKtoLogin;
    }

    public void setmKomuLogin(String mKomuLogin) {
        this.mKomuLogin = mKomuLogin;
    }

    public void setmKto(String mKto) {
        this.mKto = mKto;
    }

    public void setmKtoLogin(String mKtoLogin) {
        this.mKtoLogin = mKtoLogin;
    }

    public void setmSplacone(boolean mSplacone) {
        this.mSplacone = mSplacone;
    }

    public void setmKomu(String mKomu) {
        this.mKomu = mKomu;
    }

    public boolean ismPotwierdzone() {
        return mPotwierdzone;
    }

    public boolean ismSplacone() {
        return mSplacone;
    }

    public String getmKomu() {
        return mKomu;
    }

    public String getmId() {
        return mId;
    }

    public String getmZaCo() {
        return mZaCo;
    }

    public float getmIle() {
        return mIle;
    }

    public void setmIle(float mIle) {
        this.mIle = mIle;
    }

    public void setmZaCo(String mZaCo) {
        this.mZaCo = mZaCo;
    }

    public boolean getmPotwierdzone() {
        return mPotwierdzone;
    }

    public void setmPotwierdzone(boolean mPotwierdzone) {
        this.mPotwierdzone = mPotwierdzone;
    }
}
