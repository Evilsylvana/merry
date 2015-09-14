package com.xuanjia.merry.utils;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpUtils {

    public static String post(String url, List<NameValuePair> nvps,
                              Map<String, String> headparameters) throws Exception {

        HttpPost httppost = new HttpPost(url);
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        HttpClient httpClient = httpClientBuilder.build();

        if (null != nvps)
            httppost.setEntity(new UrlEncodedFormEntity(nvps, "UTF8"));
        httppost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        if (headparameters != null) {
            for (Entry<String, String> headparameter : headparameters.entrySet()) {
                httppost.setHeader(headparameter.getKey(), headparameter.getValue());
            }
        }

        HttpResponse response = httpClient.execute(httppost);
        HttpEntity entity = response.getEntity();
        int resStatu = response.getStatusLine().getStatusCode();

        if (resStatu == HttpStatus.SC_OK) {
            String html = EntityUtils.toString(entity);
            html = new String(html.getBytes("ISO-8859-1"), "UTF8");

            return html;
        }
        return String.valueOf(resStatu);
    }

    public static String get(String url, Map<String, String> headparameters) throws Exception {

        HttpGet httpget = new HttpGet(url);
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        HttpClient httpClient = httpClientBuilder.build();

        if (headparameters != null) {
            for (Entry<String, String> headparameter : headparameters.entrySet()) {
                httpget.setHeader(headparameter.getKey(), headparameter.getValue());
            }
        }

        HttpResponse response = httpClient.execute(httpget);
        HttpEntity entity = response.getEntity();
        int resStatu = response.getStatusLine().getStatusCode();

        if (resStatu == HttpStatus.SC_OK) {
            String html = EntityUtils.toString(entity);
            html = new String(html.getBytes("ISO-8859-1"), "UTF8");
            return html;
        }
        return String.valueOf(resStatu);
    }

    public static String head(String url, Map<String, String> headparameters, String headerKey)
                                                                                               throws Exception {
        HttpHead httpHead = new HttpHead(url);
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        HttpClient httpClient = httpClientBuilder.build();

        if (headparameters != null) {
            for (Entry<String, String> headparameter : headparameters.entrySet()) {
                httpHead.setHeader(headparameter.getKey(), headparameter.getValue());
            }
        }

        HttpResponse response = httpClient.execute(httpHead);
        int resStatu = response.getStatusLine().getStatusCode();
        String head = "";

        if (resStatu == HttpStatus.SC_OK) {
            Header[] headers = response.getHeaders(headerKey);
            for (Header header : headers) {
                head = header.getValue();
                System.out.println("Key : " + header.getName() + " ,Value : " + header.getValue());
            }
        }
        return head;
    }

}
