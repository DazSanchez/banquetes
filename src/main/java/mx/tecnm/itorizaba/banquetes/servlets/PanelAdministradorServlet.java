package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PanelAdministradorServlet", urlPatterns = {"/panel-administrador"})
public class PanelAdministradorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Object tipoUsuario = sesion.getAttribute("tipo_usuario");

        if (tipoUsuario == null) {
            response.sendRedirect(request.getContextPath() + "/autenticacion");
            return;
        } else if(!((String) tipoUsuario).equals("admin")) {
            response.sendRedirect(request.getContextPath());
            return;
        }
        
        request.getRequestDispatcher("/panel_administrador.jsp").forward(request, response);
    }
}
