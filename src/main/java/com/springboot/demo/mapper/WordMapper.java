package com.springboot.demo.mapper;

import com.springboot.demo.model.Word;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface WordMapper {

    List<Word> getAllWords();

    void deleteWord(int wid);

}
