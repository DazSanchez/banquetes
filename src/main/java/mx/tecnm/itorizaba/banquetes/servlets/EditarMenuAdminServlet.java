
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
import mx.tecnm.itorizaba.banquetes.entidades.Menu;
import mx.tecnm.itorizaba.banquetes.entidades.Platillo;

@WebServlet(name = "EditarMenuAdmin", urlPatterns = {"/panel-administrador/menus/editar"})
public class EditarMenuAdminServlet extends HttpServlet {

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
        
        Platillo[] platillos = new Platillo[] {
            new Platillo(1, "Platillo 1"),
            new Platillo(2, "Platillo 2"),
            new Platillo(3, "Platillo 3")
        };
        
        Menu m = new Menu(1, "Nombre", Arrays.asList(platillos));
        
        req.setAttribute("menu", m);
        
        req.getRequestDispatcher("/editar_menu_admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener los campos del cuerpo de la peticion
        Map<String, String[]> cuerpoPeticion = req.getParameterMap();
        
        req.setAttribute("tieneExito", true);
        
        req.getRequestDispatcher("/editar_menu_admin.jsp").forward(req, resp);
    }

}
