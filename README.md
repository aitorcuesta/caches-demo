# caches-demo
Caching data demonstration

The primary goal of this application is trying to integrate a simple Spring application with Oracle Coherence as a distributed cache framework.
This is going to be a step by step guide starting with a simple and simulated slow application.

## Step 1 The slow application
This is a simple and a very slow application for reading data from a slow database

## Step 2 Basic Spring cache
Let's add a simple cache integration

## Step 3 JSR 107 Integration
Let's change Spring cache to JCache

## Step 4 Basic Coherence Integration
Let´s use Coherence as local cache provider, things to care about:
- coherence and coherence-jcache jars should be installed in local/nexus repository to be available
- Everything to be cached by Coherence should be Serializable
- For Spring integration Coherence CacheManager must be wrapped as a Spring Cache manager (JCacheCacheManager)