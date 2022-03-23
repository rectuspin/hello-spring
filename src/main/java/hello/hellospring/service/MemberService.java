package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository=new MemoryMemberRepository();

    /** 회워가입**/
    public Long join (Member member){
        //같은 이름 중복 회원 x
        Optional<Member> result = memberRepository.findByName(member.getName());

        result.ifPresent(m-> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

        memberRepository.save(member);
        return member.getId();
    }
}
