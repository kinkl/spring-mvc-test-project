package com.springapp.mvc.controllers;

import com.springapp.model.FunnyCat;
import com.springapp.services.FunnyCatsService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.io.File;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Kin on 19.04.2015.
 */
@Controller
public class HomeController {
    @Autowired
    //@Setter
    private FunnyCatsService funnyCatsService;

    @RequestMapping({"/", "/home"})
    public String showHomePage(Model model) {
        model.addAttribute("spittles", funnyCatsService.getAllCatsAsArray());
        return "home";
    }

    /*@RequestMapping(value = "/validate", method = GET)
    public String validateNewKitten(@RequestParam("cat_name") String name, @RequestParam("cat_file") String filename, Model model) {
        if (name.equals("not valid") || filename.equals("not valid")) {
            return "bad_data";
        }
        funnyCatsService.addNewFunnyCat(new FunnyCat(name, filename));
        return showHomePage(model);
    }*/

    @RequestMapping(value = "/edit_cat", method = GET, params = "new")
    public String addNewCat(Model model) {
        model.addAttribute(new FunnyCat());
        return "new_cat";
    }

    @RequestMapping(value = "/edit_cat", method = POST, params = "new")
    public String processFunnyCatAdding(@Valid FunnyCat funnyCat, BindingResult bindingResult, @RequestParam(value = "kitty_image", required = false) MultipartFile image) {
        boolean hasErrors = bindingResult.hasErrors();
        if (hasErrors || funnyCat.getName().equals("not valid")) {
            return "new_cat";
        }
        if (image != null && !image.isEmpty() && image.getContentType().equals("image/jpeg")) {
            String relative = "resources/" + image.getOriginalFilename();
            String absolute = "C:/projects/educational_projects/spring-mvc-app-for-testing/src/main/webapp/" + relative;
            File f = new File(absolute);
            try {
                FileUtils.writeByteArrayToFile(f, image.getBytes());
                funnyCat.setFilename(relative);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        funnyCatsService.addNewFunnyCat(funnyCat);
        return "redirect:/funny_cats/gifs/" + funnyCat.getName();
    }
}
