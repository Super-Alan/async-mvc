package com.cifnews.train.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;


import org.springframework.web.server.WebFilter;

/**
 * @author lucky
 * Created by lucky on 2018/4/20.
 */
@Component
public class LogFilter implements  WebFilter{

    private static final Logger LOG = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        LOG.info("has visit,url:[ {} ]",serverWebExchange.getRequest().getURI());
        return webFilterChain.filter(serverWebExchange);
    }
}
