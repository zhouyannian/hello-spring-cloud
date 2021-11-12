package com.zhouyn.demo.redisserver.client;

import com.aliyun.imagesearch.Client;
import com.aliyun.imagesearch.models.Config;
import com.aliyun.imagesearch.models.DeleteImageRequest;
import com.aliyun.imagesearch.models.DeleteImageResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teautil.models.RuntimeOptions;

public class DeleteImage {
    public static void main(String[] args) throws Exception {
        Config authConfig = new Config();
        authConfig.accessKeyId = "LTAI4G2n3mY746Y4xEwDTrEY";
        authConfig.accessKeySecret = "KjBWjoVqiFIyV2BStZjyHHY08OQt3f";
        authConfig.type = "access_key";
        authConfig.endpoint = "imagesearch.cn-shanghai.aliyuncs.com";
        authConfig.regionId = "cn-shanghai";
        Client client = new Client(authConfig);
        DeleteImageRequest request = new DeleteImageRequest();
        // 必填，图像搜索实例名称。
        request.instanceName = "imageserch888";
        // 必填，商品id，最多支持 512个字符。
        // 一个商品可有多张图片。
        request.productId = "10010";
        // 选填，图片名称。若不指定本参数，则删除ProductId下所有图片；若指定本参数，则删除ProductId+PicName指定的图片。
//        request.picName = "test";
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        try {
            DeleteImageResponse response = client.deleteImage(request, runtimeOptions);
            System.out.println("requestId: " + response.requestId + ". success: " + response.success + ". message: " + response.message);
        } catch (TeaException e) {
            System.out.println(e.getCode());
            System.out.println(e.getData());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
