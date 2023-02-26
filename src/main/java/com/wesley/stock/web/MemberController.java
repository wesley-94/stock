package com.wesley.stock.web;

import com.wesley.stock.domain.Address;
import com.wesley.stock.domain.Member;
import com.wesley.stock.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public void create(@RequestBody MemberForm form) {
//    public void create(@Valid MemberForm form, BindingResult result) {

//        if (result.hasErrors()) {
//            return "members/createMemberForm";
//        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());
        Member member = new Member();
        member.setName(form.getName());

        member.setAddress(address);

        memberService.join(member);

//        return "redirect:/";
    }

    @PostMapping(value = "/members")
    public Map list(Model model, @RequestBody Map parameterMap) {
        Map returnMap = new HashMap();
        // 전체 회원 건수 count
        Long count = memberService.count();
        returnMap.put("count", count);
        if (count > 0) {
            List<Member> members = memberService.findMembers(parameterMap);
            model.addAttribute("members", members);
            returnMap.put("members", members);
        }
        return returnMap;
    }

}
