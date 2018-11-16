package com.app.reservation.domain.member.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles
public class MemberRepositoryTest {

    private long memNo;

    @Before
    public void setUp() throws Exception {
        memNo = 10001;
    }

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void findMemberByMemNo() {
        Member member = memberRepository.findById(memNo).orElse(null);
        assertThat(member).isNotNull();
        assertThat(member.getMemNo()).isEqualTo(memNo);
    }
}
