package com.secforfun.service;

import java.util.List;

public interface RapiddnsService {
    List<String> getSubdomains(String domain);
    List<String> getSameIpDomains(String ip);
}
