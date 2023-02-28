
package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import mx.tecnm.itorizaba.banquetes.entidades.Menu;
import mx.tecnm.itorizaba.banquetes.entidades.Platillo;

@WebServlet(name = "MenusAdministradorServlet", urlPatterns = {"/panel-administrador/menus"})
public class MenusAdministradorServlet extends HttpServlet {

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
        
        Platillo[] platillos = new Platillo[] {};
        
        Menu[] menus = new Menu[] {
            new Menu(1, "Menu 1", Arrays.asList(platillos)),
            new Menu(2, "Menu 2", Arrays.asList(platillos)),
            new Menu(3, "Menu 3", Arrays.asList(platillos))
        };
        
        req.setAttribute("menus", menus);
        
        req.getRequestDispatcher("/menus_admin.jsp").forward(req, resp);
    }

}
