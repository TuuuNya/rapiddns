package com.secforfun;

import com.secforfun.service.RapiddnsService;
import com.secforfun.service.RapiddnsServiceImpl;

import java.util.List;

public class Rapiddns {

    private static final RapiddnsService rapiddnsService = new RapiddnsServiceImpl();

    public static List<String> getSubdomains(String domain) {
        return rapiddnsService.getSubdomains(domain);
    }

    public static List<String> getSameIpDomains(String ip) {
        return rapiddnsService.getSameIpDomains(ip);
    }

}
