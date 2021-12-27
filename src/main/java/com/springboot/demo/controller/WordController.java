package com.springboot.demo.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.demo.model.Word;
import com.springboot.demo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/word-manage")
public class WordController {
    @Autowired
    private WordService wordService;
    //全部单词展览
    @RequestMapping(value = "/words", method = RequestMethod.GET)
    public ModelAndView getAllWords() {
        ModelAndView mvc = new ModelAndView("/word-manage/words");
        List<Word> words = wordService.getAllWords();
        mvc.addObject("words", words);

        return mvc;
    }

    //分页展览
    @RequestMapping("/pagehelper")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,
                                @RequestParam(name = "size",required = true,defaultValue = "4") int size) throws Exception {
        ModelAndView mv=new ModelAndView("/word-manage/pagehelper");

        PageInfo pageInfo = wordService.findAllWordByPage(page,size);
        //PageInfo就是一个分页Bean

        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

//    @RequestMapping(value = "/word-manage/pagehelper")
//    public ModelAndView getPageHelper() {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        ModelAndView mvc = new ModelAndView("/word-manage/pagehelper");
//
////        String pageNum = request.getParameter("pageNum");
//
//        PageInfo<Word> pages = wordService.findAllWordByPage(0, 4);
//        mvc.addObject("pages", pages.getList());
//        return mvc;
//    }



    @RequestMapping(value = "/word-card")
    public ModelAndView getWordCards() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ModelAndView mvc = new ModelAndView("/word-card");

//        String pageNum = request.getParameter("pageNum");

        PageInfo<Word> pages = wordService.findAllWordByPage(0, 4);
        mvc.addObject("pages", pages.getList());
        return mvc;
    }

    @RequestMapping(value = "/word-card-list")
    public ModelAndView getWordCardsByNum() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ModelAndView mvc = new ModelAndView("/word-card-list");

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
