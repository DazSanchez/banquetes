package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CerrarSesionServlet", urlPatterns = {"/cerrar-sesion"})
public class CerrarSesionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesion = req.getSession();
        sesion.invalidate();
        
        resp.sendRedirect(req.getContextPath() + "/autenticacion");
    }

}
