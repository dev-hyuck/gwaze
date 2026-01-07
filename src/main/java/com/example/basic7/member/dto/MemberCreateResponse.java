package com.example.basic7.member.dto;

import lombok.Getter;

@Getter

public class MemberCreateResponse {

    private final long id;
    private final String name;

    public MemberCreateResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
