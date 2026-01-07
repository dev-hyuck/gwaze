package com.example.basic7.member.dto;

import lombok.Getter;

@Getter

public class MemberGetResponse {

    private final Long id;
    private final String name;

    public MemberGetResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
