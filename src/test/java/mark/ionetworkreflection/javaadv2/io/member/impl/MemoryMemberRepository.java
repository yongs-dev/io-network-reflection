package mark.ionetworkreflection.javaadv2.io.member.impl;

import mark.ionetworkreflection.javaadv2.io.member.Member;
import mark.ionetworkreflection.javaadv2.io.member.MemberRepository;

import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository {

    private final List<Member> members = new ArrayList<>();

    @Override
    public void add(Member member) {
        members.add(member);
    }

    @Override
    public List<Member> findAll() {
        return members;
    }
}
