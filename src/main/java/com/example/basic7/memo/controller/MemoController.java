package com.example.basic7.memo.controller;

import com.example.basic7.memo.dto.CreateMemoRequest;
import com.example.basic7.memo.dto.CreateMemoResponse;
import com.example.basic7.memo.service.MemoService;
import com.example.basic7.user.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class MemoController {

    private final MemoService memoService;

    @PostMapping("/memos")
    public ResponseEntity<CreateMemoResponse> create(
            @SessionAttribute(name = "loginUser", required = false) SessionUser sessionUser,
            @RequestBody CreateMemoRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memoService.save(sessionUser, request));
    }
}

