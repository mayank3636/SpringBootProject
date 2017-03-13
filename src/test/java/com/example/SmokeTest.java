package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cms.project.springboot.dao.CMSDao;
import cms.project.springboot.dao.CommentDao;
import cms.project.springboot.dao.userDao;
import cms.project.springboot.main.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class SmokeTest {

    @Autowired
    private CMSDao dao;
    @Autowired
    private userDao user;
    @Autowired
    private CommentDao comments;
    @Test
    public void contexLoads() throws Exception {
    	assertThat(dao).isNotNull();
    	assertThat(user).isNotNull();
    	assertThat(comments).isNotNull();
    }
}