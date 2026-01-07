package com.example.memo.service;

import com.example.basic7.member.entity.Member;
import com.example.basic7.member.repository.MemberRepository;
import com.example.memo.dto.MemoCreateRequest;
import com.example.memo.dto.MemoCreateResponse;
import com.example.memo.dto.MemoGetResponse;
import com.example.memo.entity.Memo;
import com.example.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class MemoService {

    private final MemoRepository memoRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public MemoCreateResponse save(MemoCreateRequest request) {
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(
                () -> new IllegalArgumentException("없는 멤버입니다.")
        );

        Memo memo = new Memo(request.getText(), member);
        Memo memoSaved = memoRepository.save(memo);
        return new MemoCreateResponse(memoSaved.getText(), memoSaved.getId());
    }

    @Transactional(readOnly = true)
    public MemoGetResponse findOne(Long memoId) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalArgumentException("없는 메모입니다.")
        );
        Member member = memo.getMember();
        return new MemoGetResponse(
                memo.getId(),
                memo.getText(),
                member.getId(),
                member.getName()
        );
    }
}
