/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import Sessions.EmailEntryFacade;
import Entity.EmailEntry;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DalidasMac
 */
@WebServlet(name = "EmailEditorServlet", urlPatterns = {"/EmailEditorServlet"})

public class EmailEditorServlet extends HttpServlet {

    @EJB
    private EmailEntryFacade emailSessionObj;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        switch (action) {
            case "Search": {
                String lastName = request.getParameter("lastname");

                List<EmailEntry> emailList = emailSessionObj.findByLastName(lastName);
                request.setAttribute("emailList", emailList);
                break;

            }

            case "Show All": {
                List<EmailEntry> emailList = emailSessionObj.showAllRecords();
                request.setAttribute("emailList", emailList);
                break;
            }
            case "Edit": {
                int id = Integer.parseInt(request.getParameter("emailID"));
                List<EmailEntry> emailList = emailSessionObj.findById(id);
                String firstName = request.getParameter("firstname");
                String lastName = request.getParameter("lastname");
                String emailAddress = request.getParameter("emailaddress");


                emailList.get(0).setId(id);
                emailList.get(0).setFirstName(firstName);
                emailList.get(0).setLastName(lastName);
                emailList.get(0).setEmailAddress(emailAddress);

                try {
                    emailSessionObj.edit(emailList.get(0));
                    String message = "Edit successful";
                    request.setAttribute("message1", message);
                } catch (Exception e) {
                    String message = "Edit failure";
                    request.setAttribute("message1", message);
                }
                break;
            }
            case "Delete": {
                int id = Integer.parseInt(request.getParameter("emailID"));
                List<EmailEntry> emailList = emailSessionObj.findById(id);
                try {
                    emailSessionObj.deleteById(emailList.get(0));
                    String message = "Delete successful";
                    request.setAttribute("message2", message);
                } catch (Exception e) {
                    String message = "Delete failure";
                    request.setAttribute("message2", message);
                }
                break;
            }
            case "Total Records": {
                int count = emailSessionObj.getNumberOfRecords();
                String message = Integer.toString(count);
                request.setAttribute("message3", message);
                break;
            }
            default: {
                int id = Integer.parseInt(request.getParameter("emailID"));
                String firstName = request.getParameter("firstname");
                String lastName = request.getParameter("lastname");
                String emailAddress = request.getParameter("emailAddress");
                emailSessionObj.persistEmailData(id, firstName, lastName, emailAddress);
                List<EmailEntry> emailList = emailSessionObj.findAll();
                request.setAttribute("emailList", emailList);
            }

        }
        getServletContext()
                .getRequestDispatcher("/editor.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
