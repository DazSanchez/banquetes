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
import mx.tecnm.itorizaba.banquetes.entidades.Adorno;
import mx.tecnm.itorizaba.banquetes.entidades.Color;
import mx.tecnm.itorizaba.banquetes.entidades.Tematica;

@WebServlet(name = "EditarTematicaAdmin", urlPatterns = {"/panel-administrador/tematicas/editar"})
public class EditarTematicaAdminServlet extends HttpServlet {

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
        
        Color[] colores = new Color[]{};
        Adorno[] adornos = new Adorno[]{};
        
        Tematica t = new Tematica(1, 
                "Tematica 1", 
                "Mensaje 1", 
                "Mensaje 2", 
                "Titulo 1", 
                "Descripcion", 
                "icon", 
                "url", 
                Arrays.asList(colores), Arrays.asList(adornos));
        
        req.setAttribute("tematica", t);

        req.getRequestDispatcher("/editar_tematica_admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener los campos del cuerpo de la peticion
        Map<String, String[]> cuerpoPeticion = req.getParameterMap();
        
        req.setAttribute("tieneExito", true);
        
        req.getRequestDispatcher("/editar_tematica_admin.jsp").forward(req, resp);
    }

}
