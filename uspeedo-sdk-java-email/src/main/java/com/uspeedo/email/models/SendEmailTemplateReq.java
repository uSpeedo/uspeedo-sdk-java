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

package com.uspeedo.email.models;

import java.util.List;


import com.uspeedo.common.request.Request;
import com.uspeedo.common.annotation.NotEmpty;
import com.uspeedo.common.annotation.USpeedoParam;

public class SendEmailTemplateReq extends Request {

    
        
    /**
     * account id
     */
    @USpeedoParam("AccountId")
    private Integer accountId;
        
    
        
    /**
     * 
     */
    @NotEmpty
    @USpeedoParam("EmailContent")
    private List<TargetEmail> emailContent;
        
    
        
    /**
     * 
     */
    @NotEmpty
    @USpeedoParam("SendEmail")
    private String sendEmail;
        
    
        
    /**
     * 
     */
    @NotEmpty
    @USpeedoParam("TemplateId")
    private String templateId;

    /**
     * Subject - 邮件主题（可选）
     */
    @USpeedoParam("Subject")
    private String subject;

    /**
     * Abstract - 邮件摘要（可选）
     */
    @USpeedoParam("Abstract")
    private String abstractContent;

    
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
    
    public List<TargetEmail> getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(List<TargetEmail> emailContent) {
        this.emailContent = emailContent;
    }
    
    public String getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(String sendEmail) {
        this.sendEmail = sendEmail;
    }
    
    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }

    
    public static class TargetEmail extends Request {
        
        
    /**
     * 
     */
    @USpeedoParam("EmailAddress")
    private String emailAddress;
        
    
        
    /**
     * variableName{##}variableValue
     */
    @USpeedoParam("TemplateVariableParams")
    private List<String> templateVariableParams;
        
    
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public List<String> getTemplateVariableParams() {
        return templateVariableParams;
    }

    public void setTemplateVariableParams(List<String> templateVariableParams) {
        this.templateVariableParams = templateVariableParams;
    }
    
    }
}









