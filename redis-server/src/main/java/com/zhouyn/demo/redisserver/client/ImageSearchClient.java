package com.zhouyn.demo.redisserver.client;

import com.aliyun.imagesearch.Client;
import com.aliyun.imagesearch.models.*;
import com.aliyun.tea.TeaException;
import com.aliyun.teautil.models.RuntimeOptions;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author zhouyn
 */
public class ImageSearchClient {
    private final String accessKeyId = "LTAI4G8DX1x9vbe5TQA1A3sr";
    private final String accessKeySecret = "GJvT0bM5gNlav41kQBkO5rxYtIKRbU";
    private final String type = "access_key";
    private final String endpoint = "imagesearch.cn-shanghai.aliyuncs.com";
    private final String regionId = "cn-shanghai";

    public void addImage() throws Exception {
        Config authConfig = new Config();
        authConfig.accessKeyId = accessKeyId;
        authConfig.accessKeySecret = accessKeySecret;
        authConfig.type = type;
        authConfig.endpoint = endpoint;
        authConfig.regionId = regionId;

        Client imageSearchClient = new Client(authConfig);
        AddImageAdvanceRequest request = new AddImageAdvanceRequest();
//        SearchImageByPicAdvanceRequest
        request.instanceName = "imageserarch01";
        request.productId = "4";
        request.picName = "lufei4";
        String picName = "/Users/zhouyn/Downloads/图片/lufei4.jpeg";
        InputStream inputStream = new FileInputStream(picName);
        request.picContentObject = inputStream;
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        try {
            AddImageResponse response = imageSearchClient.addImageAdvance(request, runtimeOptions);
            System.out.println("success: " + response.success + ". message: " + response.message
                    + ". categoryId: " + response.picInfo.categoryId + ". region:" + response.picInfo.region
                    + ". requestId: " + response.requestId);
        } catch (TeaException e) {
            System.out.println(e.getCode());
            System.out.println(e.getData());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void searchImageByPic() throws Exception {
        Config authConfig = new Config();
        authConfig.accessKeyId = accessKeyId;
        authConfig.accessKeySecret = accessKeySecret;
        authConfig.type = type;
        authConfig.endpoint = endpoint;
        authConfig.regionId = regionId;
        Client client = new Client(authConfig);
        SearchImageByPicAdvanceRequest request = new SearchImageByPicAdvanceRequest();
        // 必填，图像搜索实例名称。
        request.instanceName = "imageserarch01";
//        // 选填，商品类目。
//        // 1. 对于商品搜索：若设置类目，则以设置的为准；若不设置类目，将由系统进行类目预测，预测的类目结果可在Response中获取 。
//        // 2. 对于布料、商标、通用搜索：不论是否设置类目，系统会将类目设置为88888888。
//        request.categoryId = 3;
//        // 选填，返回结果的数目。取值范围：1-100。默认值：10。
//        request.num = 10;
//        // 选填，返回结果的起始位置。取值范围：0-499。默认值：0。
//        request.start = 0;
//        // 选填，是否需要进行主体识别，默认为true。
//        // 1.为true时，由系统进行主体识别，以识别的主体进行搜索，主体识别结果可在Response中获取。
//        // 2. 为false时，则不进行主体识别，以整张图进行搜索。
//        // 3.对于布料图片搜索，此参数会被忽略，系统会以整张图进行搜索。
//        request.crop = true;
//        // 选填，图片的主体区域，格式为 x1,x2,y1,y2, 其中 x1,y1 是左上角的点，x2，y2是右下角的点。
//        // 若用户设置了Region，则不论Crop参数为何值，都将以用户输入Region进行搜索。
//        // 3.对于布料图片搜索，此参数会被忽略，系统会以整张图进行搜索。
//        request.region="167,467,221,407";
//        // 选填，过滤条件
//        // int_attr支持的操作符有>、>=、<、<=、=，str_attr支持的操作符有=和!=，多个条件之支持AND和OR进行连接。
//        // 示例:
//        //  1. 根据IntAttr过滤结果，int_attr>=100
//        //  2. 根据StrAttr过滤结果，str_attr!="value1"
//        //  3. 根据IntAttr和StrAttr联合过滤结果，int_attr=1000 AND str_attr="value1"
//        request.filter="int_attr=56 AND str_attr=\"test\"";
        String picName = "/Users/zhouyn/Downloads/图片/lufei3.jpeg";
//        String picName = "https://dev.cloudflarecdns.com/files/up/s/097fea57480842ff8980bc93b0bc120b.jpg";
        InputStream inputStream = new FileInputStream(picName);
        // 图片内容，最多支持 2MB大小图片以及5s的传输等待时间。当前仅支持jpg和png格式图片；
        // 对于商品、商标、通用图片搜索，图片长和宽的像素必须都大于等于200，并且小于等于1024；
        // 对于布料搜索，图片长和宽的像素必须都大于等于448，并且小于等于1024；
        // 图像中不能带有旋转信息
        request.picContentObject = inputStream;
        request.num = 10;
        request.start = 0;
        RuntimeOptions runtimeObject = new RuntimeOptions();
        try {
            SearchImageByPicResponse response = client.searchImageByPicAdvance(request, runtimeObject);
            System.out.println(response.requestId);
            System.out.println(response.picInfo.categoryId);
            System.out.println(response.picInfo.region);
            //  SearchImageByPicResponse.SearchImageByPicResponseAuctions[] auctions = response.auctions;
            List<SearchImageByPicResponse.SearchImageByPicResponseAuctions> auctions = response.auctions;
            for (SearchImageByPicResponse.SearchImageByPicResponseAuctions auction : auctions) {
                System.out.println(auction.categoryId + " " + auction.picName + " " + auction.productId + " " + auction.customContent + " " + auction.sortExprValues + " " + auction.strAttr + " " + auction.intAttr);
            }
        } catch (TeaException e) {
            System.out.println(e.getCode());
            System.out.println(e.getData());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ImageSearchClient imageSearchClient = new ImageSearchClient();
        try {
//            imageSearchClient.addImage();
            imageSearchClient.searchImageByPic();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
