package com.flo.alwaysbom.subs.controller;

import com.flo.alwaysbom.subs.service.SubsService;
import com.flo.alwaysbom.subs.vo.SubsVo;
import com.flo.alwaysbom.util.CloudFileHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BackSubsController {

    private final SubsService subsService;
    private final CloudFileHandler fileHandler;


    //백오피스 정기구독 이동
    @GetMapping("/admin/subs")
    public String goIndex() {
        return "subs/b_subsManager";
    }

    //백오피스 정기구독 상품등록 이동
    @GetMapping("/admin/subsAddForm")
    public String goAddForm() {
        return "subs/b_addForm";
    }

    //정기구독 등록 ! (파일 업로드) -> 담영언니한테 물어보기!
    @PostMapping("/admin/addSubs")
    public String addSubs(SubsVo svo, List<MultipartFile> file) throws IOException {
        svo.setImage1(fileHandler.uploadFile(file.get(0),null,"subs"));
        svo.setImage1(fileHandler.uploadFile(file.get(1),null,"subs"));
        svo.setImage1(fileHandler.uploadFile(file.get(2),null,"subs"));
        System.out.println("svo = " + svo);
        subsService.addSubs(svo);
        return "redirect:/admin/subsList";
    }

    @GetMapping("/admin/subsList")
    public String findAll(Model model) {
        System.out.println("findAll()실행");
        List<SubsVo> list = subsService.findAll();
        model.addAttribute("subsList",list);
        return "subs/b_subsList";
    }


}