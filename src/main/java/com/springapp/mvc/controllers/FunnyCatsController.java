package com.springapp.mvc.controllers;

import com.springapp.services.FunnyCatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Кирилл Кин
 * @created 21.04.2015
 */
@Controller
@RequestMapping("/funny_cats")
public class FunnyCatsController {
    @Autowired
    private FunnyCatsService funnyCatsService;

    @RequestMapping(value = "/gifs/{name}", method = GET)
    public String getFunnyCatGifImageByName(@PathVariable String name, Model model) {
        model.addAttribute(funnyCatsService.getFunnyCatByName(name));
        return "view_gif";
    }
}
