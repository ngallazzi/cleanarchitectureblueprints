package com.ngallazzi.data.repositories.books;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/ngallazzi/data/repositories/books/BooksLocalDataSourceImpl;", "Lcom/ngallazzi/data/repositories/books/BooksLocalDataSource;", "bookDao", "Lcom/ngallazzi/data/db/BookDao;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "bookEntityMapper", "Lcom/ngallazzi/data/mappers/BookEntityMapper;", "(Lcom/ngallazzi/data/db/BookDao;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/ngallazzi/data/mappers/BookEntityMapper;)V", "bookmark", "", "book", "Lcom/ngallazzi/domain/entities/Volume;", "(Lcom/ngallazzi/domain/entities/Volume;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookmarks", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unbookmark", "data_debug"})
public final class BooksLocalDataSourceImpl implements com.ngallazzi.data.repositories.books.BooksLocalDataSource {
    private final com.ngallazzi.data.db.BookDao bookDao = null;
    private final kotlinx.coroutines.CoroutineDispatcher dispatcher = null;
    private final com.ngallazzi.data.mappers.BookEntityMapper bookEntityMapper = null;
    
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
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getBookmarks(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.ngallazzi.domain.entities.Volume>>> p0) {
        return null;
    }
    
    public BooksLocalDataSourceImpl(@org.jetbrains.annotations.NotNull()
    com.ngallazzi.data.db.BookDao bookDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher, @org.jetbrains.annotations.NotNull()
    com.ngallazzi.data.mappers.BookEntityMapper bookEntityMapper) {
        super();
    }
}