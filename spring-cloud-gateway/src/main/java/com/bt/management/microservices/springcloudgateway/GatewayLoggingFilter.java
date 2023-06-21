// package com.bt.management.microservices.springcloudgateway;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.cloud.gateway.filter.GatewayFilterChain;
// import org.springframework.cloud.gateway.filter.GlobalFilter;
// import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
// import org.springframework.core.Ordered;
// import org.springframework.stereotype.Component;
// import org.springframework.web.server.ServerWebExchange;
// import reactor.core.publisher.Mono;

// @Component
// public class GatewayLoggingFilter implements GlobalFilter, Ordered {

//   private static final Logger logger = LoggerFactory.getLogger(
//     GatewayLoggingFilter.class
//   );

//   @Override
//   public int getOrder() {
//     return Ordered.LOWEST_PRECEDENCE - 1; // Place the filter before NettyWriteResponseFilter
//   }

//   @Override
//   public Mono<Void> filter(
//     ServerWebExchange exchange,
//     GatewayFilterChain chain
//   ) {
//     String requestPath = exchange.getRequest().getPath().toString();
//     String requestMethod = exchange.getRequest().getMethodValue().toString();
//     String originalUri = exchange.getRequest().getURI().toString();
//     String requestBody = exchange.getRequest().getBody().toString();

//     logger.info(
//       "Request Path: {}, originalUri: {}, Method: {}, requestBody: {}",
//       requestPath,
//       originalUri,
//       requestMethod,
//       requestBody
//     );

//     return chain.filter(exchange);
//   }
// }
