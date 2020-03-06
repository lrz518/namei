package com.jk.controller;

/**
 * 配置支付相关信息
 * @Author： 孙创业
 * @Date：2019/3/6 10:35
 */
public class AlipayConfig {

	/**应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号*/
	public static String app_id = "2016101500689976";

	/**商户私钥，您的PKCS8格式RSA2私钥*/
	public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCRrs2gFY7rzoVHe/FyQEdLSDEPOZ3uws7v1vnxRIN/jTD40RaaZbsEO7Og/qm6/fx55sI9Z0flNSMiA8a3X1ZBtLD+oEAz5wP9Gt7AGa7I33GIMCwZUdKroe2h8yMXsAUP57y1PXy2XDEVLsfOn8GJ8p54Bamu+Oe1PrOrFXhN0BNb5AJdeAfo3Mx2hb4IIXzBQL/KYI2P649ub/5HYgIk/SJqbpOQw5Vf6gBO4a8UkUH/TPoVk55oUstLO2Gj/hWGpIEWl2/U6MqQJ3sE2GYWln0KI1JkorY2wa8Z4CLAH0mF9cv2Tz/YeZeJQa758vEE5Vb4/Kaeok9M1w9D5xZAgMBAAECggEAYbYxhuBdTWjRNLN+eqeXiU2mzOksp1MISujtQvpB33LyGpakVvfpdegBZa4B2x8TmkHvu5mVHvHfNgR659iGwrZmcQ27omMVF7Zowxn685PcKzW3sNZV0YL0UYireAE9KjLJwjLOwjYq6Wbv7q1ORsyjhiP4eVhlkmUGNOt3gnJ/ejMuGypFMVcmIHlv652/AOWOA0viHvsCmpQU2hGnLbZBL+8p1LxqqEvVxdxuY91spmomw7UMEodWXe+Z8oihmOzKkUUdSWZBzP5YzDBm1sSb2EexE7E6HFAaOfUqeQ8ORIoHhDnfpgTyVfv11D0hNqpAY91Nh6Nq2tv/sgUfcQKBgQC24dVI0Joo2vY+VCbcYm/5R5jKO0T+Q01VIalVPPb1scd0Ziy06aoFW+c07VUL9sXHwsioC94xdkXgLB/s1St7LSF61NqeBqsvjIm2ZHQOIIbNHo3HhOrwsWMtb0IxSzUsqR/WLZt+SSwd/JCTHsr9wTS/XKz36UNVDDt3PzswLQKBgQC2XKL4AvgOWSsY8U4roy9zMaFhY3TTzeFrQv7lGgnDyt9xT3fdyVnMGu3wUQPrT2U/3QvFl8FwKUpHaT4VajjUVYk1nEZ5NRMdrrkbxhdq4zvxDYUu9n/AX3wF2bPscl8nE31BhOSERe6+WdQtiJvYwaSRgCFf1mFcNU6wOqEMXQKBgQCCO8Q0/Egru/ILZMXfv0HaFQBbU2XIY4kYjMYXazi6soVFANXpZ1SqSE4XxMMBqBQkMzPNZ9YtBvqvrvx1HUC/kN38qMOeMUWKsNwIxPRYcxVL0OxKHv9ntAraehZ7IAGX8kA3t3a5scX2/Lq/6ffISOQVOhv612QZloJqYt71aQKBgFGazLatJXHORzHnMbLnWGF1ESFyjyIE3F3SYhwFdd8u1qRvClWuN8fVOSq0JkvTgJx+fzkRutdFMt8X4ldU7E9gY4EhCIxOytoaiO07zNjhDL7G7RVh6zMbx3UawaAKYjgrSX7bSCNE5Bw8OG2T1yG9LbaKnuSzG2hW1nqYEd9lAoGAQjbDdHi7UWngz48zve3cKZdMxcOTYxYQaM8BeXcBX6/8QJ5vXKFEUugZsOJUz9eD76Xzdh57l2cxl/eoIeaZlfbquHsAPa4cNsCf6uFW/24vfU54CSFo6Vhm/R1VUr4iLXviytpYwGwUfelvwJkbJ9PoJMhAx++K7qe2lcDcpbY=";

	/**支付宝公钥,查看地址：https://openhome.suncy.com/platform/keyManage.htm 对应APPID下的支付宝公钥。*/
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi6uYTZnLTHx92enGZ8u0ctsN67gp1xe6r//IXsheusoUCn0F4Yv/eZ64FTWnuD2/0DPjRAxDiaxbu9abcw9UWAg3D1nOe/aC/SO+Xj65u5teRTmyZ07R2ZrOa6XUnBR9C0lZ+eVVSGWeUZ2xcNGzo41JxCAalOlq6YDeldpBceklGALkOm7P9zYHz8jncjI6qkHakpadGDVkrYvNNYXWvbsYxGZSYdothdX/0z3AATBHSMsdmfDWJroEHqjDhQQLiROyWpExNVZ+bDdIEpjEqVVpyfNi+BgQqy1KuAbyLH6Su7nuw78z4YmKtxighP/PGcrPC+EAa7PFADQDYrZGgwIDAQAB";

	/**服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问*/
	public static String notify_url = "https://openapi.alipaydev.com/gateway.do";

	/**页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问*/
	public static String return_url = "http://localhost:8080/alipay/alipayReturnNotice";

	/**签名方式*/
	public static String sign_type = "RSA2";

	/**字符编码格式*/
	public static String charset = "utf-8";

	/** 支付宝网关*/
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}
