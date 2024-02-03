package com.carleasingsystem.api.Config;

public class ConfigConstants 
{
    public static final String DATABASE = "car_leasing_system";
    public static final String USER_TABLE = "userdetail";
    public static final String RESERVATION_TABLE = "reservationdetail";

    public static final String FIND_BY_USERNAME_QUERY = "select * from " + USER_TABLE + " where username = ?1"; //to access data with apis
    public static final String FIND_BY_EMAIL_QUERY = "select * from " + USER_TABLE + " where email = ?1";

    public static final String SECRET = "snake";
    public static final long EXPIRATION_TIME = 900_000;
    public static final String TOKEN_PREFIX = "ekans";
    public static final String HEADER_STRING = "Authorization";
    public static final String LOGIN_URL = "/login";

    public static final String EMAIL = "project00543@gmail.com";
    public static final String EMAIL_APP_PASSWD = "dtihlfhxoxquicoc";
    public static final String EMAIL_SMTP_SERVER = "smtp.gmail.com";
    public static final int EMAIL_SMTP_PORT = 587;

    public static final String EMAIL_SUBJECT = "forget password - car leasing system";
    public static final String EMAIL_TEXT = "don't forget your password. here is your new password for login : ";
    
    public static final String EMAIL_REGEX = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}";

    public static final String POSSIBLE_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@#_";


}