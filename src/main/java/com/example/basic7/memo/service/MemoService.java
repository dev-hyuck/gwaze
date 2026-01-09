package com.example.basic7.memo.service;


import com.example.basic7.memo.dto.CreateMemoRequest;
import com.example.basic7.memo.dto.CreateMemoResponse;
import com.example.basic7.memo.entity.Memo;
import com.example.basic7.memo.repository.MemoRepository;
import com.example.basic7.user.dto.SessionUser;
import com.example.basic7.user.entity.User;
import com.example.basic7.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class MemoService {

    private final MemoRepository memoRepository;
    private final UserRepository userRepository;

    @Transactional
    public CreateMemoResponse save(SessionUser sessionUser, CreateMemoRequest request) {
        User user = (User) userRepository.findById(sessionUser.getId()).orElseThrow(
                () -> new IllegalStateException("없는 유저")
        );

        Memo memo = new Memo(request.getText(), user);
        Memo savedMemo = memoRepository.save(memo);
        return new CreateMemoResponse(
                savedMemo.getId(),
                savedMemo.getText()
        );
    }
}