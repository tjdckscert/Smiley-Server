package com.smiley.smileybackend.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    @DisplayName("member_creation_test")
    void createMember(){
    /*
    given
     */
        Member member = new Member("hello",23);

    /*
    when, then
     */
        Assertions.assertThat(member.getAge()).isEqualTo(23);
        Assertions.assertThat(member.getName()).isEqualTo("hello");
    }

}