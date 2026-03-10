/**
 * Copyright 2024 USpeedo Technology Co., Ltd.
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

package com.uspeedo.email;

import com.uspeedo.common.config.Config;
import com.uspeedo.common.credential.Credential;
import com.uspeedo.common.exception.USpeedoException;
import com.uspeedo.email.client.EmailClient;
import com.uspeedo.email.models.SendEmailTemplateReq;
import com.uspeedo.email.models.SendEmailTemplateRes;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * Email 集成测试
 * <p>
 * 1. 序列化测试：验证 Subject、Abstract 可选字段的 encode 行为
 * 2. 真实 API 调用：需设置环境变量 USpeedo_PUBLIC_KEY、USpeedo_PRIVATE_KEY，否则跳过
 */
public class EmailClientIntegrationTest {

    private static final String TEMPLATE_ID = "UETXXXXXXXXXXX";
    private static final String SEND_EMAIL = "examples@examples.com";

    @Test
    public void testSendEmailTemplateReqEncodeWithoutOptionalFields() throws USpeedoException {
        SendEmailTemplateReq req = buildMinimalRequest();
        Map<String, Object> encoded = req.encode();

        Assert.assertTrue(encoded.containsKey("TemplateId"));
        Assert.assertTrue(encoded.containsKey("SendEmail"));
        Assert.assertTrue(encoded.containsKey("EmailContent"));
        Assert.assertFalse(encoded.containsKey("Subject"));
        Assert.assertFalse(encoded.containsKey("Abstract"));
    }

    @Test
    public void testSendEmailTemplateReqEncodeWithOptionalFields() throws USpeedoException {
        SendEmailTemplateReq req = buildMinimalRequest();
        req.setSubject("自定义邮件主题");
        req.setAbstractContent("邮件摘要内容");

        Map<String, Object> encoded = req.encode();

        Assert.assertEquals("自定义邮件主题", encoded.get("Subject"));
        Assert.assertEquals("邮件摘要内容", encoded.get("Abstract"));
    }

    @Test
    public void testSendEmailTemplateIntegration() throws USpeedoException {
        String publicKey = System.getenv("USpeedo_PUBLIC_KEY");
        String privateKey = System.getenv("USpeedo_PRIVATE_KEY");
        Assume.assumeNotNull("Skip: USpeedo_PUBLIC_KEY not set", publicKey);
        Assume.assumeNotNull("Skip: USpeedo_PRIVATE_KEY not set", privateKey);

        Config config = new Config();
        Credential credential = new Credential(publicKey, privateKey);
        EmailClient client = new EmailClient(config, credential);

        SendEmailTemplateReq req = buildMinimalRequest();
        req.setSubject("集成测试主题");
        req.setAbstractContent("集成测试摘要");

        SendEmailTemplateRes resp = client.sendEmailTemplate(req);

        Assert.assertNotNull(resp);
        Assert.assertNotNull(resp.getRetCode());
    }

    private SendEmailTemplateReq buildMinimalRequest() {
        SendEmailTemplateReq req = new SendEmailTemplateReq();
        req.setTemplateId(TEMPLATE_ID);
        req.setSendEmail(SEND_EMAIL);

        SendEmailTemplateReq.TargetEmail target = new SendEmailTemplateReq.TargetEmail();
        target.setEmailAddress("example@examples.com");
        target.setTemplateVariableParams(Arrays.asList("variableName{##}variableValue"));

        req.setEmailContent(Arrays.asList(target));
        return req;
    }
}
