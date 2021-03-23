package com.flo.alwaysbom.flower;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class FlowerController {

    @GetMapping("/flower")
    public String flower() {
        return "flower/list";
    }
}
