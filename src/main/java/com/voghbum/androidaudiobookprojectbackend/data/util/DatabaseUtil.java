package com.voghbum.androidaudiobookprojectbackend.data.util;

import java.util.function.Consumer;

public final class DatabaseUtil {
    private DatabaseUtil() {
    }

    public static <R> R doWorkForRepository(ISupplierCallback<R> supplier, String msg) {
        try {
            return supplier.get();
        } catch (Throwable var3) {
            throw new RepositoryException(msg, var3);
        }
    }

    public static <R> R doWorkForRepository(ISupplierCallback<R> supplier, Consumer<Throwable> consumer, String msg) {
        try {
            return supplier.get();
        } catch (Throwable var4) {
            consumer.accept(var4);
            throw new RepositoryException(msg, var4);
        }
    }

    public static void doWorkForRepositoryRunnable(IActionCallback action, String msg) {
        try {
            action.run();
        } catch (Throwable var3) {
            throw new RepositoryException(msg, var3);
        }
    }

    public static void doWorkForRepositoryRunnable(IActionCallback action, Consumer<Throwable> consumer, String msg) {
        try {
            action.run();
        } catch (Throwable var4) {
            consumer.accept(var4);
            throw new RepositoryException(msg, var4);
        }
    }

    public static <R> R doWorkForService(ISupplierCallback<R> supplier, String msg) {
        try {
            return supplier.get();
        } catch (RepositoryException var3) {
            throw new DataServiceException(msg, var3.getCause());
        } catch (Throwable var4) {
            throw new DataServiceException(msg, var4);
        }
    }

    public static <R> R doWorkForService(ISupplierCallback<R> supplier, Consumer<Throwable> consumer, String msg) {
        try {
            return supplier.get();
        } catch (RepositoryException var4) {
            consumer.accept(var4);
            throw new DataServiceException(msg, var4.getCause());
        } catch (Throwable var5) {
            throw new DataServiceException(msg, var5);
        }
    }

    public static void doWorkForServiceRunnable(IActionCallback runnable, String msg) {
        try {
            runnable.run();
        } catch (RepositoryException var3) {
            throw new DataServiceException(msg, var3.getCause());
        } catch (Throwable var4) {
            throw new DataServiceException(msg, var4);
        }
    }

    public static void doWorkForServiceRunnable(IActionCallback runnable, Consumer<Throwable> consumer, String msg) {
        try {
            runnable.run();
        } catch (RepositoryException var4) {
            consumer.accept(var4);
            throw new DataServiceException(msg, var4.getCause());
        } catch (Throwable var5) {
            consumer.accept(var5);
            throw new DataServiceException(msg, var5);
        }
    }
}