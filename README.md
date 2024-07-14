# rapiddns

A unofficial Java library for rapiddns.io

Thanks to [RapidDNS](https://rapiddns.io/)

## Usage

### Maven引入

```xml
<dependency>
    <groupId>com.secforfun</groupId>
    <artifactId>rapiddns</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 示例

```java
package com.test;

import com.secforfun.Rapiddns;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> domains = Rapiddns.getSubdomains("qunar.com");
        System.out.println("Subdomains size of qunar.com: " + domains.size());

        List<String> domainsByIp = Rapiddns.getSameIpDomains("52.74.223.119");
        System.out.println("Domains size of IP: " + domainsByIp.size());
    }
}
```