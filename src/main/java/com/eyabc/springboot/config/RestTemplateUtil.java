package com.eyabc.springboot.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.pool.PoolStats;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class RestTemplateUtil {
    private final PoolingHttpClientConnectionManager poolingHttpClientConnectionManager;
    private final HttpHostsConfiguration httpHostConfiguration;

    public boolean checkPending() {
        PoolStats totalStats = poolingHttpClientConnectionManager.getTotalStats();
        int pendingCount = totalStats.getPending();
        log.debug("RestTemplateMonitor.pendingCount : "+pendingCount);

        if (pendingCount < httpHostConfiguration.getMaxPending()) {
            log.debug("RestTemplateMonitor.checkPending : false");
            return false;
        }
        log.debug("RestTemplateMonitor.checkPending: true");
        return true;
    }
    public String createHttpInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("=========================").append("\n");
        sb.append("General Info:").append("\n");
        sb.append("-------------------------").append("\n");
        sb.append("MaxTotal: ").append(poolingHttpClientConnectionManager.getMaxTotal()).append("\n");
        sb.append("DefaultMaxPerRoute: ").append(poolingHttpClientConnectionManager.getDefaultMaxPerRoute()).append("\n");
        sb.append("ValidateAfterInactivity: ").append(poolingHttpClientConnectionManager.getValidateAfterInactivity()).append("\n");
        sb.append("=========================").append("\n");

        PoolStats totalStats = poolingHttpClientConnectionManager.getTotalStats();
        sb.append(createPoolStatsInfo("Total Stats", totalStats));

        Set<HttpRoute> routes = poolingHttpClientConnectionManager.getRoutes();

        if (routes != null) {
            for (HttpRoute route : routes) {
                sb.append(createRouteInfo(poolingHttpClientConnectionManager, route));
            }
        }
        return sb.toString();
    }

    private String createRouteInfo(PoolingHttpClientConnectionManager connectionManager, HttpRoute route) {
        PoolStats routeStats = connectionManager.getStats(route);
        return createPoolStatsInfo(route.getTargetHost().toURI(), routeStats);
    }

    private String createPoolStatsInfo(String title, PoolStats poolStats) {
        StringBuilder sb = new StringBuilder();
        sb.append(title + ":").append("\n");
        sb.append("-------------------------").append("\n");
        if (poolStats != null) {
            sb.append("Available: ").append(poolStats.getAvailable()).append("\n");
            sb.append("Leased: ").append(poolStats.getLeased()).append("\n");
            sb.append("Max: ").append(poolStats.getMax()).append("\n");
            sb.append("Pending: ").append(poolStats.getPending()).append("\n");
        }

        sb.append("=========================").append("\n");
        return sb.toString();
    }
}
