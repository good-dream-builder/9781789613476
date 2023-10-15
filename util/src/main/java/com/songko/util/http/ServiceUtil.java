package com.songko.util.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 마이크로서비스의 호스트 이름, IP 주소, 포트를 검색
 */
@Component
public class ServiceUtil {
    @Value("${server.port}")
    private String port;
    private String serviceAddress = null;

    public String getServiceAddress() {
        if(this.serviceAddress == null) {
            this.serviceAddress = findMyHostName() + "/" + findMyIpAddress() + ":" + port;
        }
        return this.serviceAddress;
    }

    private String findMyIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "unknown host name";
        }
    }

    private String findMyHostName() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "unknown IP address";
        }
    }

}
