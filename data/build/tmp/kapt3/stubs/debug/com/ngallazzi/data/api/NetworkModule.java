package com.ngallazzi.data.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR#\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/ngallazzi/data/api/NetworkModule;", "", "()V", "httpClient", "Lokhttp3/OkHttpClient;", "getHttpClient", "()Lokhttp3/OkHttpClient;", "httpClient$delegate", "Lkotlin/Lazy;", "loggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "getLoggingInterceptor", "()Lokhttp3/logging/HttpLoggingInterceptor;", "loggingInterceptor$delegate", "moshi", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "moshi$delegate", "createBooksApi", "Lcom/ngallazzi/data/api/BooksApi;", "endpointURL", "", "getRetrofit", "Lretrofit2/Retrofit;", "data_debug"})
public final class NetworkModule {
    private final kotlin.Lazy moshi$delegate = null;
    private final kotlin.Lazy loggingInterceptor$delegate = null;
    private final kotlin.Lazy httpClient$delegate = null;
    
    private final com.squareup.moshi.Moshi getMoshi() {
        return null;
    }
    
    private final okhttp3.logging.HttpLoggingInterceptor getLoggingInterceptor() {
        return null;
    }
    
    private final okhttp3.OkHttpClient getHttpClient() {
        return null;
    }
    
    private final retrofit2.Retrofit getRetrofit(java.lang.String endpointURL) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ngallazzi.data.api.BooksApi createBooksApi(@org.jetbrains.annotations.NotNull()
    java.lang.String endpointURL) {
        return null;
    }
    
    public NetworkModule() {
        super();
    }
}