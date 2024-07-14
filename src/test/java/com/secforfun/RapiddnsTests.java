package com.secforfun;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RapiddnsTests {
    @Test
    public void testGetSubdomains() {
        List<String> subdomains = Rapiddns.getSubdomains("qunar.com");
        for (String subdomain : subdomains) {
            System.out.println(subdomain);
        }
        System.out.println("Total subdomains: " + subdomains.size());
        Assert.assertNotNull(subdomains);
    }

    @Test
    public void testGetSameIpDomains() {
        List<String> domains = Rapiddns.getSameIpDomains("123.59.180.215");
        for (String domain : domains) {
            System.out.println(domain);
        }
        System.out.println("Total domains: " + domains.size());
        Assert.assertNotNull(domains);
    }
}
