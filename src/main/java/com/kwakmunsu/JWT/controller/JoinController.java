package com.kwakmunsu.JWT.controller;


import com.kwakmunsu.JWT.dto.JoinDTO;
import com.kwakmunsu.JWT.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequiredArgsConstructor
@Controller
@Log4j2
@ResponseBody
public class JoinController {
    private final JoinService joinService;

    @PostMapping("/join")
    public String joinProcess(JoinDTO joinDTO) {
        try {
            joinService.join(joinDTO);
        } catch (Exception e) {
            log.info(e.getMessage());

        }

        return "ok";
    }
}
