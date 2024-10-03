package org.example.controller;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class HomeController {

    private final static String LOCAL_PAGES_PATH = "static/pages/";

    @GetMapping({"/main"})
    public String markdownView(Model model) throws Exception {
        String markdownValueFormLocal = getMarkdownValueFormLocal("developer", "introduction.md");
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdownValueFormLocal);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        model.addAttribute("contents", renderer.render(document));
        return "index";
    }

    @GetMapping({"/main/{type}/{page}"})
    public String markdownView(@PathVariable("type") String type, @PathVariable("page") String page, Model model) throws Exception {
        if (type == null || type.isEmpty()) {
            type = "developer";
        }
        if (page == null || page.isEmpty()) {
            page = "introduction.md";
        }
        String markdownValueFormLocal = getMarkdownValueFormLocal(type, page);
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdownValueFormLocal);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        model.addAttribute("contents", renderer.render(document));
        return "index";
    }

    public String getMarkdownValueFormLocal(String type, String page) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        ClassPathResource classPathResource = new ClassPathResource(LOCAL_PAGES_PATH + type + "/" + page);
        BufferedReader br = Files.newBufferedReader(Paths.get(classPathResource.getURI()));
        br.lines().forEach(line -> stringBuilder.append(line).append("\n"));
        return stringBuilder.toString();
    }

}
