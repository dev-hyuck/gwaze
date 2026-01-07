package com.example.basic7.member.controller;

import com.example.basic7.member.dto.MemberCreateRequest;
import com.example.basic7.member.dto.MemberCreateResponse;
import com.example.basic7.member.dto.MemberGetResponse;
import com.example.basic7.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberCreateResponse> create (
            @RequestBody MemberCreateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.save(request));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberGetResponse>> getAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberGetResponse> getOne (@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.findOne(memberId));
    }
}
