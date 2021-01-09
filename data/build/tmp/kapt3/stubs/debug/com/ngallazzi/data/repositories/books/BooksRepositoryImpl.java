package com.ngallazzi.data.repositories.books;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ%\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/ngallazzi/data/repositories/books/BooksRepositoryImpl;", "Lcom/ngallazzi/domain/repositories/BooksRepository;", "localDataSource", "Lcom/ngallazzi/data/repositories/books/BooksLocalDataSource;", "remoteDataSource", "Lcom/ngallazzi/data/repositories/books/BooksRemoteDataSource;", "(Lcom/ngallazzi/data/repositories/books/BooksLocalDataSource;Lcom/ngallazzi/data/repositories/books/BooksRemoteDataSource;)V", "bookmark", "", "book", "Lcom/ngallazzi/domain/entities/Volume;", "(Lcom/ngallazzi/domain/entities/Volume;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookmarks", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRemoteBooks", "Lcom/ngallazzi/domain/common/Result;", "author", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unbookmark", "data_debug"})
public final class BooksRepositoryImpl implements com.ngallazzi.domain.repositories.BooksRepository {
    private final com.ngallazzi.data.repositories.books.BooksLocalDataSource localDataSource = null;
    private final com.ngallazzi.data.repositories.books.BooksRemoteDataSource remoteDataSource = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getRemoteBooks(@org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ngallazzi.domain.common.Result<? extends java.util.List<com.ngallazzi.domain.entities.Volume>>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getBookmarks(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.ngallazzi.domain.entities.Volume>>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object bookmark(@org.jetbrains.annotations.NotNull()
    com.ngallazzi.domain.entities.Volume book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object unbookmark(@org.jetbrains.annotations.NotNull()
    com.ngallazzi.domain.entities.Volume book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public BooksRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.ngallazzi.data.repositories.books.BooksLocalDataSource localDataSource, @org.jetbrains.annotations.NotNull()
    com.ngallazzi.data.repositories.books.BooksRemoteDataSource remoteDataSource) {
        super();
    }
}