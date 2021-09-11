package com.springboot.demo.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.demo.model.Word;
import com.springboot.demo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WordController {
    @Autowired
    private WordService wordService;

    @RequestMapping(value = "/word-manage/words", method = RequestMethod.GET)
    public ModelAndView getAllWords() {
        ModelAndView mvc = new ModelAndView("/word-manage/word-list");
        mvc.addObject("words", wordService.getAllWords());
        PageInfo<Word> page = wordService.findAllWordByPage(1, 10);
        PageInfo<Word> pages = wordService.findAllWordByPage(0, 4);
        mvc.addObject("pages", pages.getList());
        mvc.addObject("page", page.getList());

        return mvc;
    }

    @RequestMapping(value = "/word-manage/word-card")
    public ModelAndView getWordCards() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ModelAndView mvc = new ModelAndView("/word-manage/word-card");

//        String pageNum = request.getParameter("pageNum");

        PageInfo<Word> pages = wordService.findAllWordByPage(0, 4);
        mvc.addObject("pages", pages.getList());
        return mvc;
    }

    @RequestMapping(value = "/word-manage/word-card-list")
    public ModelAndView getWordCardsByNum() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ModelAndView mvc = new ModelAndView("/word-manage/word-card-list");

        String pageNum = request.getParameter("pageNum");
        System.out.println(pageNum);

        PageInfo<Word> pages = wordService.findAllWordByPage(Integer.parseInt(pageNum), 4);
        mvc.addObject("pages", pages.getList());
        return mvc;
    }

    @RequestMapping(value = "/word-manage/words/page", method = RequestMethod.POST)
    public ModelAndView getPage() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ModelAndView mvc = new ModelAndView("/word-manage/word-page");
        mvc.addObject("words", wordService.getAllWords());
        String pageNum = request.getParameter("pageNum");

        PageInfo<Word> page = wordService.findAllWordByPage(Integer.parseInt(pageNum), 10);
        mvc.addObject("page", page.getList());
        mvc.addObject("pageNum", page.getPageNum());
        mvc.addObject("pageinfo", page);

        return mvc;
    }


    @RequestMapping(value = "deleteWord", method = RequestMethod.POST)
    public void deleteWord() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String num = request.getParameter("wid");
        System.out.println(num);
        wordService.deleteWord(Integer.parseInt(num));
    }
}
