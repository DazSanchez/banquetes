package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import mx.tecnm.itorizaba.banquetes.entidades.Menu;
import mx.tecnm.itorizaba.banquetes.entidades.Platillo;
import java.util.Arrays;
import mx.tecnm.itorizaba.banquetes.entidades.Banquete;

@WebServlet(name = "BanquetesServlet", urlPatterns = {"/banquetes"})
public class BanquetesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idBanquete = req.getParameter("id_banquete");
        System.out.println("idBanquete: " + idBanquete);

        Platillo[] platillos = new Platillo[]{
            new Platillo(1, "Platillo 1"),
            new Platillo(2, "Platillo 2"),
            new Platillo(3, "Platillo 2"),};

        Menu[] menus = new Menu[]{
            new Menu(1, "Menu 1", Arrays.asList(platillos)),
            new Menu(2, "Menu 2", Arrays.asList(platillos)),
            new Menu(3, "Menu 3", Arrays.asList(platillos))
        };

        Banquete banquete = new Banquete(1, 
                "Banquete 1", 
                "Lorem ipsum", 
                "Doloret sit amet", 
                "Consectetur adipiscing elit", 
                "Sed ullamcorper urna sit amet bibendum rutrum.", 
                "restaurant_menu", 
                "https://i0.wp.com/thehappening.com/wp-content/uploads/2016/10/catering.jpg?fit=1024%2C694&ssl=1",
                Arrays.asList(menus));

        req.setAttribute("banquete", banquete);

        req.getRequestDispatcher("/banquetes.jsp").forward(req, resp);
    }

}
