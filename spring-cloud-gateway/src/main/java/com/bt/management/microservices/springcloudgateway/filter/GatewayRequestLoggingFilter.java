package com.bt.management.microservices.springcloudgateway.filter;

import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Logs which route and target URI each request is sent to so we can verify gateway routing.
 */
@Component
public class GatewayRequestLoggingFilter implements GlobalFilter, Ordered {

  private static final Logger log = LoggerFactory.getLogger(GatewayRequestLoggingFilter.class);

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
    String routeId = route != null ? route.getId() : "unknown";
    URI targetUri = route != null ? route.getUri() : null;
    ServerHttpRequest request = exchange.getRequest();

    log.info(
      "Gateway routing {} {} -> route={} target={}",
      request.getMethod(),
      request.getURI().getPath(),
      routeId,
      targetUri
    );

    return chain.filter(exchange);
  }

  @Override
  public int getOrder() {
    return -1;
  }
}
