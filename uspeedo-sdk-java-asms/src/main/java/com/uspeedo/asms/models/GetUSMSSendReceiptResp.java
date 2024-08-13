/**
 * Copyright 2021 USpeedo Technology Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uspeedo.asms.models;

import java.util.List;


import com.google.gson.annotations.SerializedName;

import com.uspeedo.common.response.Response;

public class GetUSMSSendReceiptResp extends Response {

    
        
    /**
     * 
     */
    @SerializedName("Data")
    private List<ReceiptPerSession> data;
        
    
    public List<ReceiptPerSession> getData() {
        return data;
    }

    public void setData(List<ReceiptPerSession> data) {
        this.data = data;
    }
    
    public static class ReceiptPerSession extends Response {
        
        
    /**
     * 
     */
    @SerializedName("SessionNo")
    private String sessionNo;
        
    
        
    /**
     * 
     */
    @SerializedName("ReceiptSet")
    private List<ReceiptPerPhone> receiptSet;
        
    
    public String getSessionNo() {
        return sessionNo;
    }

    public void setSessionNo(String sessionNo) {
        this.sessionNo = sessionNo;
    }
    
    public List<ReceiptPerPhone> getReceiptSet() {
        return receiptSet;
    }

    public void setReceiptSet(List<ReceiptPerPhone> receiptSet) {
        this.receiptSet = receiptSet;
    }
    
    }
    public static class ReceiptPerPhone extends Response {
        
        
    /**
     * 
     */
    @SerializedName("AccountId")
    private Integer accountId;
        
    /**
     * 
     */
    @SerializedName("BrevityCode")
    private String brevityCode;
        
        
    /**
     * 
     */
    @SerializedName("CostCount")
    private Integer costCount;
        
            
    /**
     * 
     */
    @SerializedName("CountryCode")
    private String countryCode;
        
        
    /**
     * 
     */
    @SerializedName("Phone")
    private String phone;
        
    
        
    /**
     * 
     */
    @SerializedName("ReceiptCode")
    private String receiptCode;
        
    
        
    /**
     * 
     */
    @SerializedName("ReceiptDesc")
    private String receiptDesc;
        
    
        
    /**
     * 
     */
    @SerializedName("ReceiptResult")
    private String receiptResult;
        
    
        
    /**
     * 
     */
    @SerializedName("ReceiptTime")
    private Integer receiptTime;
        
    
        
    /**
     * 
     */
    @SerializedName("UserId")
    private String userId;
        
    
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
    
    public String getBrevityCode() {
        return brevityCode;
    }

    public void setBrevityCode(String brevityCode) {
        this.brevityCode = brevityCode;
    }

    public Integer getCostCount() {
        return costCount;
    }

    public void setCostCount(Integer costCount) {
        this.costCount = costCount;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
        
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }
    
    public String getReceiptDesc() {
        return receiptDesc;
    }

    public void setReceiptDesc(String receiptDesc) {
        this.receiptDesc = receiptDesc;
    }
    
    public String getReceiptResult() {
        return receiptResult;
    }

    public void setReceiptResult(String receiptResult) {
        this.receiptResult = receiptResult;
    }
    
    public Integer getReceiptTime() {
        return receiptTime;
    }

    public void setReceiptTime(Integer receiptTime) {
        this.receiptTime = receiptTime;
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    }
}









