package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import mx.tecnm.itorizaba.banquetes.entidades.BanqueteSimple;

@WebServlet(name = "BanquetesAdministrador", urlPatterns = {"/panel-administrador/banquetes"})
public class BanquetesAdministrador extends HttpServlet {

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

        BanqueteSimple[] banquetes = new BanqueteSimple[]{
            new BanqueteSimple(1, "Banquete 1"),
            new BanqueteSimple(2, "Banquete 2"),
            new BanqueteSimple(3, "Banquete 3")
        };
        
        req.setAttribute("banquetes", banquetes);

        req.getRequestDispatcher("/banquetes_administrador.jsp").forward(req, resp);
    }

}
