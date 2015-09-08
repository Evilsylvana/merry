package com.xuanjia.merry.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuanjia.merry.handle.HomeHandle;

/**
 * 
 * @author huxuan.hx
 * @version $Id: HomeServlet.java, v 0.1 2015-9-7 ÏÂÎç12:39:44 huxuan.hx Exp $
 */
public class HomeServlet extends HttpServlet {

    /**  */
    private static final long serialVersionUID = -1906015913963431047L;

    /** 
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
                                                                          IOException {

        doPost(req, resp);
    }

    /** 
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                                                                           throws ServletException,
                                                                           IOException {
        req.setAttribute("wedding", HomeHandle.getWedding());
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}
