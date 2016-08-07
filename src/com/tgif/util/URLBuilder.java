/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erick
 */
public class URLBuilder {
    String host;
    String segment;
    List<String> queryParams;

    public URLBuilder() {
        queryParams = new ArrayList();
    }

    //  http://www.myhost.com/
    public URLBuilder host(String host) {
        this.host = host;
        return this;
    }

    public URLBuilder addPathSegment(String segment) {
        this.segment = segment + "?";
        return this;
    }

    public URLBuilder addQueryParameter(String key, String value) {
        queryParams.add(key+"="+value);
        return this;
    }

    public String getParams() {
        String delimeter = "&",
                  params = "";

        for(String q : queryParams){
            params += q + delimeter;
        }

        if(queryParams.size() > 0) {
            params = params.substring(0, params.length() - 1);
        }
        return params;
    }

    public String build() {
        return host+segment+getParams();
    }
}
