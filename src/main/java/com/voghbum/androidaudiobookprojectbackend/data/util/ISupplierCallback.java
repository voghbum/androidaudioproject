package com.voghbum.androidaudiobookprojectbackend.data.util;

@FunctionalInterface
public interface ISupplierCallback<R> {
    R get() throws Exception;
}