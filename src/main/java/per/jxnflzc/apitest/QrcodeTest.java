package per.jxnflzc.apitest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;

import java.util.Scanner;

public class QrcodeTest {
    public static void main(String [] args) {
        /*Scanner scanner = new Scanner(System.in);
        String url = "http://apis.juhe.cn/qrcode/api";
        url += "?key=00c69899d29edf2312478018661ed9be";
        String text = scanner.next();
        url += "&text=" + text;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(url, null, String.class);
        JSONObject jsonData = JSONObject.fromObject(response);
        JSONObject result = (JSONObject) jsonData.get("result");
        String base64_image = result.getString("base64_image");

        Base64.Decoder decoder = Base64.getDecoder();
        try {
            // Base64解码
            byte[] b = decoder.decode(base64_image);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream("test.jpg");
            out.write(b);
            out.flush();
            out.close();
        } catch (Exception e) {
        }*/
    }
}
