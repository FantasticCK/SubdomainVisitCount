package com.CK;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] s = new String[]{"654 yaw.lmm.ca","1225 lmm.ca"};
        Solution solution = new Solution();
        System.out.println(solution.subdomainVisits(s).toString());
    }
}

class Solution {
    Map<String, Integer> subdomainToCount = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains.length==0) return res;
        for (int i = 0; i < cpdomains.length; i++) {
            String[] split = cpdomains[i].split(" ");
            int count = Integer.parseInt(split[0]);
            String domains = split[1];
            subdomainToCount.put(domains, subdomainToCount.getOrDefault(domains,0) + count);
            while (domains.indexOf('.') != -1) {
                String subDomain = domains.substring(domains.indexOf('.') +1);
                subdomainToCount.put(subDomain, subdomainToCount.getOrDefault(subDomain,0)+ count);
                domains = subDomain;
            }
        }

        Iterator iterator = subdomainToCount.keySet().iterator();
        while (iterator.hasNext()){
            String key = (String)iterator.next();
            res.add(subdomainToCount.get(key) + " " + key);
        }
        return res;
    }
}