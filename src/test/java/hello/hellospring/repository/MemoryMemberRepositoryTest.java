package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository =new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member=new Member();
        member.setName("Chris");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //System.out.println("result = "+(result=member));
        //Assertions.assertEquals(member,result);
        Assertions.assertThat(member).isEqualTo(result);

    }
    @Test
    public void findByName(){
        Member member1=new Member();
        member1.setName("Chris");
        repository.save(member1);


        Member member2=new Member();
        member2.setName("Ines");
        repository.save(member2);

        Member result = repository.findById(member1.getId()).get();
        //System.out.println("result = "+(result=member));
        //Assertions.assertEquals(member,result);
        Assertions.assertThat(result).isEqualTo(member1);

    }

}
