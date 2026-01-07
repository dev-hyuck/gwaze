package com.example.basic7.memo.dto;

import lombok.Getter;

@Getter

public class MemoCreateRequest {

    private String text;
    private Long memberId;
}
