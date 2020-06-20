package com.bhargav.ssr.controller;

import com.bhargav.ssr.model.Blog;
import com.bhargav.ssr.model.SeoContent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView getBlogHome(Map<String, Object> model) {
        List<Blog> blogList =
                IntStream.range(1, 3).mapToObj(i -> generateBlog(System.currentTimeMillis() + i)).collect(Collectors.toList());
        model.put("blogList", blogList);
        model.put("seoContent", generateSeoContent());
        model.put("pageTitle", "Welcome to Bhargav's Blog Site");
        return new ModelAndView("index", model);
    }

    private SeoContent generateSeoContent() {
        String content = "Search engine optimization (" + System.currentTimeMillis() + ") is the process of growing the quality and " +
                "quantity of website traffic by increasing the visibility of a website or a web page to users of a web search engine. " +
                "SEO refers to the improvement of unpaid results and excludes direct traffic and the purchase of paid" +
                " placement (" + System.currentTimeMillis() + ")";
        return new SeoContent("Search Engine Optimization", content);
    }

    private Blog generateBlog(long seq){
        return new Blog("Blog #" + seq, "Author: Nataraj Srikantaiah", "Category-" + seq,
                "AWS Device Farm is an app testing service that can be used to test and interact with your Android, " +
                        "iOS, and web apps on real, physical phones and tablets which are hosted by Amazon Web Services (AWS). " +
                        "AWS like any other device farm provides a wide range of mobile devices which provides access to test an " +
                        "app on various OS version with or without the brand’s skin. As a result, this lets the user overcome the " +
                        "challenge of maintaining and upgrading their assets as per the market changes." );
    }
}
