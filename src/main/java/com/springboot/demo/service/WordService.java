package com.springboot.demo.service;

import com.github.pagehelper.PageInfo;
import com.springboot.demo.model.Student;
import com.springboot.demo.model.Word;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WordService {
    List<Word> getAllWords();

    PageInfo<Word> findAllWordByPage(int pageNum, int pageSize);

    void deleteWord(int wid);
}
