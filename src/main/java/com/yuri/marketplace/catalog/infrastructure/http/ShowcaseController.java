package com.yuri.marketplace.catalog.infrastructure.http;

import com.yuri.marketplace.catalog.application.BrowserShowcaseUseCase;
import com.yuri.marketplace.catalog.application.dto.EventOutput;
import com.yuri.marketplace.catalog.domain.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/showcase")
public class ShowcaseController {
    private final BrowserShowcaseUseCase browserShowcaseUseCase;

    public ShowcaseController(BrowserShowcaseUseCase browserShowcaseUseCase) {
        this.browserShowcaseUseCase = browserShowcaseUseCase;
    }

    @GetMapping
    public List<EventOutput> browseShowcase (){
        return browserShowcaseUseCase.execute();
    }
}
