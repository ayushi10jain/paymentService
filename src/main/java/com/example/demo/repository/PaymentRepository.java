package com.example.demo.repository;

public interface PaymentRepository {
    Group addGroup(Group group);
    Group getGroup( String  gId);

    void addUserGroupMapping(Group group);
    String getUserGroupMapping(final String userId);
}
