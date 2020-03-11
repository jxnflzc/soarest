package per.jxnflzc.apitest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class APITest {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        List<String> province = new ArrayList<String>();
        List<String> citys = new ArrayList<String>();
        List<String> districts = new ArrayList<String>();
        Map<String, List<String>> citysMap = new HashMap<String, List<String>>();
        Map<String, List<String>> districtsMap = new HashMap<String, List<String>>();

        String url = "http://v.juhe.cn/weather/citys";
        url += "?key=87d087b270edb3a1c7496334c49a6d04";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(url, null, String.class);
        JSONObject jsonData = JSONObject.fromObject(response);
        JSONArray result = (JSONArray) jsonData.get("result");
        for (int i = 0; i < result.size(); i++){
            JSONObject jsonObject = result.getJSONObject(i);
            String tempProvince = jsonObject.getString("province");
            String tempCity = jsonObject.getString("city");
            String tempDistrict = jsonObject.getString("district");

            if (!province.contains(tempProvince)) {
                if (i != 0){
                    String lastProvince = province.get(province.size() - 1);
                    citysMap.put(lastProvince, citys);
                }

                citys = new ArrayList<String>();
                province.add(jsonObject.getString("province"));
            }

            if (!citys.contains(tempCity)) {
                citys.add(jsonObject.getString("city"));
            }
        }

        String outputProvinces = "";
        for (int i = 0; i < province.size(); i++){
            outputProvinces += province.get(i) + "\t";
            if (i % 10 == 0 && i != 0)
                outputProvinces += "\n";
        }
        System.out.println("请从以下省份/直辖市中选择你的省份/直辖市");
        System.out.println(outputProvinces);

        String outputCity = "";
        String myProvince = scanner.next();
        List<String> cityList = citysMap.get(myProvince);
        for (int i = 0; i < cityList.size(); i++){
            outputCity += cityList.get(i) + "\t";
            if (i % 10 == 0 && i != 0)
                outputCity += "\n";
        }
        System.out.println("请从以下城市中选择你的城市");
        System.out.println(outputCity);

        String myCity = scanner.next();

        url = "http://v.juhe.cn/weather/index";
        url += "?key=87d087b270edb3a1c7496334c49a6d04";
        url += "&cityname=" + myCity;
        restTemplate = new RestTemplate();
        response = restTemplate.postForObject(url, null, String.class);
        jsonData = JSONObject.fromObject(response);
        JSONObject result2 = (JSONObject) jsonData.get("result");
        JSONObject weather = (JSONObject) result2.get("today");
        System.out.println(weather.toString());
    }
}
