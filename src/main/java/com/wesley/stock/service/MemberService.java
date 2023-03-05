package com.wesley.stock.service;

import com.wesley.stock.domain.Member;
import com.wesley.stock.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional // 변경
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 전체 회원 건수 count
     */
    public long count() {
        return memberRepository.count();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(Map parameterMap) {
//        return memberRepository.findAll();
        if (parameterMap.get("pageLimit") == null) {
            return memberRepository.findAll();
        } else {
            return memberRepository.selectMemberByPaging(parameterMap);
        }
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

}
