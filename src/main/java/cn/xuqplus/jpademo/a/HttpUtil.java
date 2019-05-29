package cn.xuqplus.jpademo.a;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;

public class HttpUtil {
  
  public static final HttpResponse post(String url, int length, InputStream data) throws IOException {
    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpPost httpPost = new HttpPost(url);
    BasicHttpEntity httpEntity = new BasicHttpEntity();
     httpEntity.setContentType(ContentType.APPLICATION_JSON.toString());
     httpEntity.setContentLength(length);
     httpEntity.setContent(data);
    httpPost.setEntity(httpEntity);
    return httpClient.execute(httpPost);
  }

  public static final HttpResponse get(String url) throws IOException {
    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpGet httpGet = new HttpGet(url);
    return httpClient.execute(httpGet);
  }
}
