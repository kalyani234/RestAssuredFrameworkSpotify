package com.spotify.oauth2.api;



public enum StatusCode {
    code200(200,""),
    code201(201,""),
    code400(400,"Missing required field: name"),
    code401(401,"Invalid access token");


    public final int code;
    public final String msg;

     StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
