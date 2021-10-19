package com.xiaoping.cmdtest.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 基金信息配置表

 * </p>
 *
 * @author generator
 * @since 2020-11-11
 */
@TableName("t_xmt_activity_fund")
public class ActivityFund implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    private String id;

    /**
     * 基金代码
     */
    private String fundCode;

    /**
     * 基金名称
     */
    private String fundName;

    /**
     * 是否删除：1、逻辑已删除 0、未删除
     */
    private String isDelete;

    /**
     * 基金类型:0-股票型 1-混合型 2-债券型 3-货币型
     */
    private String fundType;

    /**
     * 商城跳转链接
     */
    private String fundUrl;

    /**
     * 申购跳转链接
     */
    private String subscribeUrl;

    /**
     * 基金公司
     */
    private String company;

    /**
     * 历史表现(进一年表现)%
     */
    private Double history;

    /**
     * 鸡仔卡通形象
     */
    private String fundImage;

    /**
     * 卖点(多个以|分隔)
     */
    private String intro;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private String updateDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getFundUrl() {
        return fundUrl;
    }

    public void setFundUrl(String fundUrl) {
        this.fundUrl = fundUrl;
    }

    public String getSubscribeUrl() {
        return subscribeUrl;
    }

    public void setSubscribeUrl(String subscribeUrl) {
        this.subscribeUrl = subscribeUrl;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getHistory() {
        return history;
    }

    public void setHistory(Double history) {
        this.history = history;
    }

    public String getFundImage() {
        return fundImage;
    }

    public void setFundImage(String fundImage) {
        this.fundImage = fundImage;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "ActivityFund{" +
        "id=" + id +
        ", fundCode=" + fundCode +
        ", fundName=" + fundName +
        ", isDelete=" + isDelete +
        ", fundType=" + fundType +
        ", fundUrl=" + fundUrl +
        ", subscribeUrl=" + subscribeUrl +
        ", company=" + company +
        ", history=" + history +
        ", fundImage=" + fundImage +
        ", intro=" + intro +
        ", updateBy=" + updateBy +
        ", updateDate=" + updateDate +
        "}";
    }
}
