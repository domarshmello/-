package org.test.dto;

import lombok.Data;

/**
 * sub:entity
 * Created by apple on 2017/11/16.
 */
@Data
public class SubDTO {

    private String subId;
    private int deparId;
    private String subName;
    private String subDesc;
    private String subPalce;
    private int subSelected;
    private int submount;
    private String subDetail;
    private String subTime;

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public int getDeparId() {
        return deparId;
    }

    public void setDeparId(int deparId) {
        this.deparId = deparId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSubDesc() {
        return subDesc;
    }

    public void setSubDesc(String subDesc) {
        this.subDesc = subDesc;
    }

    public String getSubPalce() {
        return subPalce;
    }

    public void setSubPalce(String subPalce) {
        this.subPalce = subPalce;
    }

    public int getSubSelected() {
        return subSelected;
    }

    public void setSubSelected(int subSelected) {
        this.subSelected = subSelected;
    }

    public int getSubmount() {
        return submount;
    }

    public void setSubmount(int submount) {
        this.submount = submount;
    }

    public String getSubDetail() {
        return subDetail;
    }

    public void setSubDetail(String subDetail) {
        this.subDetail = subDetail;
    }

    public String getSubTime() {
        return subTime;
    }

    public void setSubTime(String subTime) {
        this.subTime = subTime;
    }
}
