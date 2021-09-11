package com.springboot.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.demo.mapper.WordMapper;
import com.springboot.demo.model.Student;
import com.springboot.demo.model.Word;
import com.springboot.demo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("wordService")
public class WordServiceImpl implements WordService {
    @Autowired
    private WordMapper wordMapper;

    @Override
    public List<Word> getAllWords() {
        System.out.println(555);
        System.out.println(wordMapper.getAllWords().size());
        return wordMapper.getAllWords();
    }


    @Override
    public PageInfo<Word> findAllWordByPage(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<Word> lists = wordMapper.getAllWords();
        PageInfo<Word> pageInfo = new PageInfo<>(lists);
        return pageInfo;
    }

    @Override
    public void deleteWord(int wid) {
        wordMapper.deleteWord(wid);
    }
}
