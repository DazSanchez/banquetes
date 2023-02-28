package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import mx.tecnm.itorizaba.banquetes.entidades.Banquete;
import mx.tecnm.itorizaba.banquetes.entidades.Menu;

@WebServlet(name = "EditarBanqueteAdmin", urlPatterns = {"/panel-administrador/banquetes/editar"})
public class EditarBanqueteAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesion = req.getSession();
        Object tipoUsuario = sesion.getAttribute("tipo_usuario");

        if (tipoUsuario == null) {
            resp.sendRedirect(req.getContextPath() + "/autenticacion");
            return;
        } else if (!((String) tipoUsuario).equals("admin")) {
            resp.sendRedirect(req.getContextPath());
            return;
        }

        Menu[] menus = new Menu[]{};

        Banquete banquete = new Banquete(1, 
                "Banquete 1", 
                "Mensaje 1", 
                "Mensaje 1 s", 
                "Titulo", 
                "Contenido", 
                "icon", 
                "url", 
                Arrays.asList(menus));
        
        req.setAttribute("banquete", banquete);

        req.getRequestDispatcher("/editar_banquete_admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener los campos del cuerpo de la peticion
        Map<String, String[]> cuerpoPeticion = req.getParameterMap();
        
        req.setAttribute("tieneExito", true);
        
        req.getRequestDispatcher("/editar_banquete_admin.jsp").forward(req, resp);
    }

}
