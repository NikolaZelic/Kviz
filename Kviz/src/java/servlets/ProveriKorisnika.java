package servlets;
import baza.DB;
import baza.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author Grupa1
 */

@WebServlet(name = "ProveriKorisnika", urlPatterns = {"/proverikorisnika"})
public class ProveriKorisnika extends HttpServlet {

    static List<Korisnik> users;
    static Map<String,String> userPassword;
    public ProveriKorisnika() {
        users = DB.selectAllUsers();
        userPassword = new HashMap<>();
        for (Korisnik k: users) {
            userPassword.put(k.getKorUsername(), k.getKorPassword());
        }        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("");
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        response.setContentType("application/json;charset=UTF-8");
        HttpSession session = request.getSession();
        int proveraU=0;
        int proveraP=0;
        if(userPassword.containsKey(user)){
            proveraU = 1;
            if(userPassword.get(user).equals(password)){
                proveraP =1;
                session.setAttribute("user", user);
            }
        }
        //  {"user":"proveraU","password":"proveraP"}
        String sb = "{\"user\":\"" + proveraU + "\",\"password\":\"" + proveraP + "\"}";
        try (PrintWriter out = response.getWriter()) {
           out.println(sb);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}