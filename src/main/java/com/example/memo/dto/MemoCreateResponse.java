package com.example.memo.dto;

import lombok.Getter;

@Getter

public class MemoCreateResponse {

    private final String text;
    private final Long memberId;

    public MemoCreateResponse(String text, Long memberId) {
        this.text = text;
        this.memberId = memberId;
    }
}
