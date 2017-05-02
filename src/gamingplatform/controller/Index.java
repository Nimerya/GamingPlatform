package gamingplatform.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import gamingplatform.model.User;
import gamingplatform.view.FreemarkerHelper;

public class Index extends HttpServlet {


    //container dati che sarà processato da freemarker
    private Map<String, Object> data = new HashMap<>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //data.put("message","OK-login");
        //data.put("user", new User(3,"pippo","pippo2","pippo3","lll@aaa.it","vl",333,"cvkgc"));

        //process template
        FreemarkerHelper.process("index.ftl", data, response, getServletContext());

    }
}