package com.secforfun.service;

import com.secforfun.RapiddnsExtractor;
import com.secforfun.exception.RapiddnsException;
import com.secforfun.utils.HttpClientHelper;

import java.util.ArrayList;
import java.util.List;

public class RapiddnsServiceImpl implements RapiddnsService {
    private final RapiddnsExtractor rapiddnsExtractor = new RapiddnsExtractor();

    @Override
    public List<String> getSubdomains(String domain) {
        String url = "https://rapiddns.io/subdomain/" + domain + "?full=1";

        String responseBody;
        try {
            responseBody = HttpClientHelper.sendGetRequest(url);
        } catch (RapiddnsException e) {
            System.err.println("Error fetching subdomains: " + e.getMessage());
            return new ArrayList<>();
        }

        List<String> subdomains;
        subdomains = rapiddnsExtractor.extractSubdomains(responseBody);
        return subdomains;
    }

    @Override
    public List<String> getSameIpDomains(String ip) {
        String url = "https://rapiddns.io/s/" + ip + "?full=1&down=1";

        String responseBody;
        try {
            responseBody = HttpClientHelper.sendGetRequest(url);
        }catch (RapiddnsException e) {
            System.err.println("Error fetching same IP domains: " + e.getMessage());
            return new ArrayList<>();
        }

        List<String> domains;
        domains = rapiddnsExtractor.extractSubdomains(responseBody);
        return domains;
    }
}
