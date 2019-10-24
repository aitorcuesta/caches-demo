package es.aitorcuesta.caches.demo;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableCaching
public class CachesDemoConfiguration {
	
	// Using with simple cache memory
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

}
