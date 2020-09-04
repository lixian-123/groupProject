package com.kgc.util;


import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@ConfigurationProperties(prefix = "alipay")
@Component
public class AliPayUtils {
    private String protocol;
    private String gatewayHost;
    private String signType;
    private String appId;
    private String merchantPrivateKey; //"<-- 请填写您的应用私钥，例如：MIIEvQIBADANB ... ... -->";
    private String merchantCertPath; //<-- 请填写您的应用公钥证书文件路径，例如：/foo/appCertPublicKey_2019051064521003.crt -->
    private String alipayCertPath; //<-- 请填写您的支付宝公钥证书文件路径，例如：/foo/alipayCertPublicKey_RSA2.crt -->
    private String alipayRootCertPath; //<-- 请填写您的支付宝根证书文件路径，例如：/foo/alipayRootCert.crt -->
    private String notifyUrl;//<-- 请填写您的支付类接口异步通知接收服务地址，例如：https://www.test.com/callback -->
    private String encryptKey;//<-- 请填写您的AES密钥，例如：aa4BtZ4tspm2wnXLb 1ThQA== -->
    private String alipayPublicKey;
    private String returnUrl;
    private String successurl;

    @PostConstruct
    public void init() {
        Factory.setOptions(getOptions());
    }
    //                             订单名称       订单号         金额
    public String toPcPay(String subjectName,String orderNo,String amount) throws Exception {
        String result=null;
        try {
            // 2. 发起API调用（以创建当面付收款二维码为例）
            AlipayTradePagePayResponse response = Factory.Payment.Page().pay(subjectName,orderNo,amount,returnUrl);
            // 3. 处理响应或异常
            if (ResponseChecker.success(response)) {
                result=response.body;
                System.out.println("调用成功");
            } else {
                System.err.println("调用失败，原因：" + response.body);
            }
        } catch (Exception e) {
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
        return result;
    }

    private Config getOptions() {
        Config config = new Config();
        config.protocol = getProtocol();
        config.gatewayHost = getGatewayHost();
        config.signType = getSignType();
        config.appId = getAppId();
        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = this.getMerchantPrivateKey();
        config.alipayPublicKey=getAlipayPublicKey();
        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = getNotifyUrl();
        config.encryptKey=getEncryptKey();
        return config;
    }



    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getGatewayHost() {
        return gatewayHost;
    }

    public void setGatewayHost(String gatewayHost) {
        this.gatewayHost = gatewayHost;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMerchantPrivateKey() {
        return merchantPrivateKey;
    }

    public void setMerchantPrivateKey(String merchantPrivateKey) {
        this.merchantPrivateKey = merchantPrivateKey;
    }

    public String getMerchantCertPath() {
        return merchantCertPath;
    }

    public void setMerchantCertPath(String merchantCertPath) {
        this.merchantCertPath = merchantCertPath;
    }

    public String getAlipayCertPath() {
        return alipayCertPath;
    }

    public void setAlipayCertPath(String alipayCertPath) {
        this.alipayCertPath = alipayCertPath;
    }

    public String getAlipayRootCertPath() {
        return alipayRootCertPath;
    }

    public void setAlipayRootCertPath(String alipayRootCertPath) {
        this.alipayRootCertPath = alipayRootCertPath;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getSuccessurl() {
        return successurl;
    }

    public void setSuccessurl(String successurl) {
        this.successurl = successurl;
    }
}
