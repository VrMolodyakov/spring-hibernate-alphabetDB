package com.example.HiberTest.Controller;

import com.example.HiberTest.Repositories.daoRepository;
import com.example.HiberTest.Entities.textTable;
import com.example.HiberTest.StatPrinter.statPrinterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TextController {

    @Autowired
    daoRepository dao;
    Logger logger = LoggerFactory.getLogger(statPrinterImpl.class);

    @GetMapping("/allTexts")
    public String getAllTexts(Model model){
        List<textTable> list =dao.findAll();
        model.addAttribute("texts",list);
        return "allTexts";
    }

    @GetMapping(value="/insertText")
    public String greetingForm(Model model) {
        model.addAttribute("text", new textTable());
        return "insertText";
    }

    @PostMapping(value="/insertText")
    public String greetingSubmit(@ModelAttribute textTable text, Model model) {

        Integer id = dao.save(text);
        logger.debug("id is saved : " + id);
        model.addAttribute("text", text);
        return "result";
    }


}
