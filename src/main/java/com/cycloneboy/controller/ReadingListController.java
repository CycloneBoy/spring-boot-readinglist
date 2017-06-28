package com.cycloneboy.controller;

import com.cycloneboy.config.AmazonProperties;
import com.cycloneboy.domain.Book;
import com.cycloneboy.domain.Reader;
import com.cycloneboy.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/6/27.
 */
@Controller
@RequestMapping("/")
public class ReadingListController {

    @Autowired
    private ReadingListRepository readingListRepository;
    @Autowired
    private AmazonProperties amazonProperties;

    @RequestMapping(method = RequestMethod.GET)
    public String readersBooks(
            Reader reader,
            Model model){

        List<Book> readingList = readingListRepository.findByReader(reader);
        if(readingList != null){
            model.addAttribute("books",readingList);
            model.addAttribute("reader",reader);
            model.addAttribute("amazonID",amazonProperties.getAssociateId()); //向模型中注入Associate ID
        }
        return "readingList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addReadingList(
            Reader reader,Book book){
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/";
    }

}
