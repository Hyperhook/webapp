package app.util;

import lombok.*;

public class Path {

    // The @Getter methods are needed in order to access
    // the variables from Velocity Templates
    public static class Web {
        @Getter public static final String INDEX = "/";
        @Getter public static final String LOGIN = "/login/";
        @Getter public static final String LOGOUT = "/logout/";
        @Getter public static final String BOOKS = "/books/";
        @Getter public static final String ONE_BOOK = "/books/:isbn/";
    }

    public static class Template {
        public final static String INDEX = "/velocity/index/index.html";
        public final static String LOGIN = "/velocity/login/login.vm";
        public final static String BOOKS_ALL = "/velocity/produto/all.vm";
        public static final String BOOKS_ONE = "/velocity/produto/one.vm";
        public static final String NOT_FOUND = "/velocity/notFound.vm";
    }

}
