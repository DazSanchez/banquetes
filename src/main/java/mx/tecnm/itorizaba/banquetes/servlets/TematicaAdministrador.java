
package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import mx.tecnm.itorizaba.banquetes.entidades.TematicaSimple;

@WebServlet(name = "TematicaAdministrador", urlPatterns = {"/panel-administrador/tematicas"})
public class TematicaAdministrador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesion = req.getSession();
        Object tipoUsuario = sesion.getAttribute("tipo_usuario");

        if (tipoUsuario == null) {
            resp.sendRedirect(req.getContextPath() + "/autenticacion");
            return;
        } else if(!((String) tipoUsuario).equals("admin")) {
            resp.sendRedirect(req.getContextPath());
            return;
        }
        
        TematicaSimple[] ts = new TematicaSimple[] {
            new TematicaSimple(1, "Tematica 1"),
            new TematicaSimple(2, "Tematica 2"),
            new TematicaSimple(3, "Tematica 3"),
        };
        
        req.setAttribute("tematicas", ts);
        
        req.getRequestDispatcher("/tematicas_admin.jsp").forward(req, resp);
    }

}
