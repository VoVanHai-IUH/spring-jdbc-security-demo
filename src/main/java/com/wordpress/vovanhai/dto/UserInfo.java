package com.wordpress.vovanhai.dto;

public record UserInfo(String userName, String password, boolean enable, String [] authorities){

}
