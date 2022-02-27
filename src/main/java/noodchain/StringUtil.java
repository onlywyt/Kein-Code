package noodchain;

import java.security.MessageDigest;

/**
 * @program: source-demo
 * @description: 加密算法/ SHA256
 * @ClassName：StringUtil
 * @author: Mr.Wang
 * @create: 2022-02-27 17:22
 **/
public class StringUtil {

    //接受一个字符串并对其应用 SHA256 算法，并将生成的签名作为字符串返回
    public static String appluSha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("sha-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++ ){
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1){
                    hexString.append(0);
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
