package cn.xuqplus.jpademo.service;

import cn.xuqplus.jpademo.util.HttpUtil;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AService {

  public Object dosth() throws IOException {
    HttpResponse response = HttpUtil.get("http://192.168.124.95:8081/b/dosth");
    System.err.println(EntityUtils.toString(response.getEntity()));
    return "ok";
  }
}
