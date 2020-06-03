package com.eyabc.springboot.config;

import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class RestTemplateConfiguration {

    private final HttpHostsConfiguration httpHostConfiguration;

    @Bean
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
        PoolingHttpClientConnectionManager result = new PoolingHttpClientConnectionManager();

        result.setMaxTotal(this.httpHostConfiguration.getMaxTotal());
        result.setDefaultMaxPerRoute(this.httpHostConfiguration.getDefaultMaxPerRoute());

        if (!CollectionUtils.isEmpty(this.httpHostConfiguration.getMaxPerRoutes())) {
                for (HttpHostsConfiguration.HttpHostConfiguration httpHostConfig : this.httpHostConfiguration.getMaxPerRoutes()) {
                HttpHost host = new HttpHost(httpHostConfig.getHost(), httpHostConfig.getPort(),
                        httpHostConfig.getScheme());
                result.setMaxPerRoute(new HttpRoute(host), httpHostConfig.getMaxPerRoute());
            }
        }
        return result;
    }

    @Bean
    public RequestConfig requestConfig() {
        return RequestConfig.custom()
                .setConnectionRequestTimeout(httpHostConfiguration.getConnectionRequestTimeout())
                .setConnectTimeout(httpHostConfiguration.getConnectionTimeout())
                .setSocketTimeout(httpHostConfiguration.getSocketTimeout())
                .build();
    }

    /*
    * HttpClient클래스가 아니라 인터페이스입니다. 의도 한대로 개발에 사용할 수 없습니다.
    * 당신이 원하는 것은 HttpClient 인터페이스 를 구현하는 클래스입니다 CloseableHttpClient.*/
    @Bean
    public CloseableHttpClient httpClient() {
        return HttpClientBuilder.create().setConnectionManager(poolingHttpClientConnectionManager())
                .setDefaultRequestConfig(requestConfig()).build();
    }

    @Bean
    public RestTemplate restTemplate() {
        /*
        ClientHttpRequestFactory implementation that uses Apache HttpComponents HttpClient to create requests.
        Allows to use a pre-configured HttpClient instance - potentially with authentication, HTTP connection pooling, etc.
        */
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient());
        return new RestTemplate(requestFactory);
    }
}
