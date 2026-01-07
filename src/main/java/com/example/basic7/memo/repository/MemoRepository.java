package com.example.basic7.memo.repository;

import com.example.basic7.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
