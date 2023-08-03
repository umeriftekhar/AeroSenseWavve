package com.aerosense.radar.tcp.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： jia.w@aerosense.com
 * @date： 2021/8/9 13:36
 * @version: 1.0
 */

@ConfigurationProperties(prefix = "radar.tcp")
@Data
public class RadarTcpServerProperties implements Serializable {
    /**to enable radar TCP service*/
    private boolean enable;
    /**radar connection address and id mapping：HashMap, RedisMap*/
    private String addressMap = "HashMap";
    /**TCP host address，default： 0.0.0.0*/
    private String host = "0.0.0.0";
    /**TCP listening port must be above 1024, default：8801*/
    private int port = 8899;
    /**default server idle time is 70seconds*/
    private long idleTimeout = 90000;

    /**IP prefix of the server you want to register when the host is not specified*/
    private List<String> preferredeNetworks = new ArrayList<>();
    /**network that you want to ignore when the host is not specified*/
    private List<String> ignoredInterfaces = new ArrayList<>();
    /**Host name registration*/
    private boolean preferHostnameOverIP;
    /**only use site local interfaces*/
    private boolean useOnlySiteLocalInterface;
}
