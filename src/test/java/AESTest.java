import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.jstu.serve.util.AESUtil;
import net.minidev.json.JSONUtil;

import java.util.List;
import java.util.Map;

public class AESTest {
    private static String key = "deda19713deda19713deda19713deda1";


    public static void main(String[] args) {
        String json = "2n0Rb8mlG8wL92erQ2K6x0x85Y1KbtXu1dimAMElbN+IrJeLQnvKyno/0qTrlmvOVwoXnIBULjVR\n" +
                "iKg4bKlZzUl7jeuXX9zZc+WGWZ2SeWwIugsv0iG4HpO+Htq2tAGxDfBhJvu4KZLz7dRDscPII6bP\n" +
                "r6ocO4aTUD5fXVEdledKWoDG5tSuhUtS9l7d+h/J7oCzNJmbnADrDJHgCCz+4n1krGaDdPdGsq+N\n" +
                "xnxj/+27ciDLAwKAQMok1QC2OHlXuCE4vifWCJiGko75nd3pNxKQZXtx6Yx2gNuXj037c048x500\n" +
                "JA8CbqeIml5ddQXuUstCG8K4wBvzKlq0mfVkAOTHPnYTP+KFPyFr8/hQzEaksg5JKwRaf+IVsCIF\n" +
                "hFClW7+pjV7c9dAKa2B5dWQQ6k3t06RSla7/FDNC8VW4nfjxAO75cawe/0W2GbOFbZRWYIc/N3Z6\n" +
                "l9sN6jbZhHYmGNutNtPA25pr2wTqkp8SBIfyr845b/9PTEUoXIrfaa5HQ8qWRKIB2sl/XvqZ6FBB\n" +
                "1Q==";
//        List<Map<String,Object>> list = (List<Map<String, Object>>) JSONObject.parse(json);
//        String result = JSONObject.toJSONString(list);
//        String aesString = AESUtil.encrypt(result,key);
//        System.out.println("加密后的字符串:"+aesString);
        String desString = AESUtil.decrypt(json);
        System.out.println("解密后的字符串:" + desString);

        List<Map<String, Object>> resultList = (List<Map<String, Object>>) JSONObject.parse(desString);
        System.out.println(resultList);
        String string = "HuG7hBEv32/4gKYJWZ1kLu/d4EfgV2BL59JoF6vdwAlFVDXs11tBLbVSZCaHReF3ypFY6bV0vDvg\\r\\nMdOd5+JNjocadUQrXLP5sAD4RqmgMOv9J0KLiJupEXzoX+nU8vrJJWn7UOsXt3x6i1StQXxJhf/z\\r\\nVl7BcCvF/VtfmG0VaEbMFFCZn3zSbDab4680WzmqhAkvh/7hiA5SoM9jmqSsGG4hT30f04L7J12F\\r\\n6AfN8MwgAPB/SBCGuznqj1rTsqBqL4PloWR0FkIEbpCPBob1SEHgV2qvjc4Y5LkQxB8EavQop1OY\\r\\nJhdxJqPNioxqcDgdaS9zGxlOkjehJyyN7idcHVOdwahiSF1dhjWGS0ZezbaPrEPX8LuxQ7FfPyu4\\r\\nYRbTq/pRKmipbQoxcps9yxX7DiV+0TMHHqRZSk71InJXfpmJB5hbGllWsWUy2GNA3bNFxm/po3Lc\\r\\nRJs8sxQR9OLz8pZvs2j6xUjfRdOyHHIyAPvHszWJrE24sIMtNsKG6SHaEGFpJjk7kFvLBOA5U/+y\\r\\n7lDP/EgLAYaJ2qdVJjMtpcT0USe1Su2Xrojr2P8eK2Ed7UVjueFqxb5HMvqMMfAEXEuoYQh6vYYj\\r\\nt7T9tevt+kZifqf1l15ZJdZoxW0EXiHq\\r\\n";
        string = string.replaceAll("\r","").replaceAll("\n","");
        String finalString = AESUtil.decrypt(string);
        System.out.println(finalString);

    }

}
