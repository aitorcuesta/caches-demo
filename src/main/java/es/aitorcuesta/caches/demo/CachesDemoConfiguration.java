package es.aitorcuesta.caches.demo;

import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableCaching
public class CachesDemoConfiguration {
	
	// Using with Oracle Coherence Local configuration
    @Bean
    public CacheManager cacheManager() {
    	CachingProvider cachingProvider = Caching.getCachingProvider();    
        javax.cache.CacheManager cacheManager = cachingProvider.getCacheManager();
        MutableConfiguration<String, Object> config = new MutableConfiguration<>();
        config.setStoreByValue(true);
         
        cacheManager.createCache("books", config);
        return new JCacheCacheManager(cacheManager);
    }

}
