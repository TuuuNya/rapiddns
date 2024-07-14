package com.secforfun;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class RapiddnsExtractor {
    public List<String> extractSubdomains(String html) {
        List<String> domains = new ArrayList<>();
        Document doc = Jsoup.parse(html);
        Elements tables = doc.select("table");

        for (Element table : tables) {
            Elements rows = table.select("tr");

            for (Element row : rows) {
                Elements columns = row.select("td");
                if (!columns.isEmpty()) {
                    String domain = columns.get(0).text();
                    domains.add(domain);
                }

            }
        }

        return domains;
    }
}
