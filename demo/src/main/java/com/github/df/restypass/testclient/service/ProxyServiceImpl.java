package com.github.df.restypass.testclient.service;

import com.github.df.restypass.command.RestyFuture;
import com.github.df.restypass.exception.execute.RestyException;
import com.github.df.restypass.testclient.entity.Response;
import com.github.df.restypass.testclient.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.concurrent.Future;

/**
 * 说明:
 * <p/>
 * Copyright: Copyright (c)
 * <p/>
 * Company:
 * <p/>
 *
 * @author darren -fu
 * @version 1.0.0
 * @contact 13914793391
 * @date 2016 /11/22
 */
@Slf4j
@Component(value = "ProxyServiceImpl")
@RequestMapping(value = "/fallback")
public class ProxyServiceImpl implements ProxyService {
    @Override
    @RequestMapping(value = "/get_nothing", method = RequestMethod.GET, headers = "Client=RestyProxy", params = "Param1=val1")
    public void getNothing() {
        log.error("Fallback nothing");
    }

    @Override
    public String getStatus(RestyFuture<String> future) {
        log.error("Fallback String");
        return "Fallback String";
    }

    @Override
    public Future<User> getUser() {
        return null;
    }

    @Override
    public Future<Void> getVoidAsync() {
        return null;
    }

    /**
     * Gets string.
     *
     * @param ex the ex
     * @return the string
     */
    public String getString(RestyException ex) {
        System.out.println("执行加强降级，Ex:" + ex.getMessage());
        log.error("FallbackException:{}", ex.getMessage());
        return "FallbackException String";
    }

//
//    @Override
//    public User getUser() {
//        User user = new User();
//        user.setName("Fallback");
//
//        return user;
//    }


    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public Response<String> getAge(Long id, String code, String name) {
        return null;
    }

    @Override
    public int getHeight(Long id) {
        return 0;
    }

    @Override
    public String update(Long id, String name, User user) {
        System.out.println("执行基本降级");

        return "FALLBACK";
    }

    @Override
    public void applicationIndex() {

    }
}
