package org.test.dto;

/**
 * Created by apple on 2017/10/21.
 */
public class picDTO {

    private int mPicId;

    private int mGoodsId;

    private String mPicUrl;

    public int getmPicId() {
        return mPicId;
    }

    public void setmPicId(int mPicId) {
        this.mPicId = mPicId;
    }

    public int getmGoodsId() {
        return mGoodsId;
    }

    public void setmGoodsId(int mGoodsId) {
        this.mGoodsId = mGoodsId;
    }

    public String getmPicUrl() {
        return mPicUrl;
    }

    public void setmPicUrl(String mPicUrl) {
        this.mPicUrl = mPicUrl;
    }

    @Override
    public String toString() {
        return "picDTO{" +
                "mPicId=" + mPicId +
                ", mGoodsId=" + mGoodsId +
                ", mPicUrl='" + mPicUrl + '\'' +
                '}';
    }
}
