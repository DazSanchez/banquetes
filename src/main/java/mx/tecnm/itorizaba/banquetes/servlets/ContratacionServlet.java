package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import mx.tecnm.itorizaba.banquetes.entidades.OpcionSimple;

@WebServlet(name = "ContratacionServlet", urlPatterns = {"/contratacion"})
public class ContratacionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idBanquete = req.getParameter("id_banquete");
        String idTematica = req.getParameter("id_tematica");
        String idColor = req.getParameter("id_color");

        HttpSession sesion = req.getSession();
        Object tipoUsuario = sesion.getAttribute("tipo_usuario");

        if (tipoUsuario == null) {
            String redireccion = req.getContextPath() + "/contratacion?id_banquete=" + idBanquete + "&id_tematica=" + idTematica + "&id_color=" + idColor;
            redireccion = resp.encodeRedirectURL(redireccion);
            resp.sendRedirect(req.getContextPath() + "/autenticacion?redireccion=" + redireccion);
            return;
        }

        System.out.println("idBanquete: " + idBanquete);
        System.out.println("idTematica: " + idTematica);
        System.out.println("idColor: " + idColor);

        OpcionSimple[] banquetes = new OpcionSimple[]{
            new OpcionSimple(1, "Banquete 1"),
            new OpcionSimple(2, "Banquete 2"),
            new OpcionSimple(3, "Banquete 3")
        };

        OpcionSimple[] tematicas = new OpcionSimple[]{
            new OpcionSimple(1, "Tematica 1"),
            new OpcionSimple(2, "Tematica 2"),
            new OpcionSimple(3, "Tematica 3"),
        };

        OpcionSimple[] colores = new OpcionSimple[]{
            new OpcionSimple(1, "Color 1"),
            new OpcionSimple(2, "Color 2"),
            new OpcionSimple(3, "Color 3"),
        };
        
        req.setAttribute("banquetes", banquetes);
        req.setAttribute("tematicas", tematicas);
        req.setAttribute("colores", colores);

        req.getRequestDispatcher("/contratacion.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener los campos del cuerpo de la peticion
        Map<String, String[]> cuerpoPeticion = req.getParameterMap();

        // Mostrar cuerpo en consola
        for (Map.Entry<String, String[]> campo : cuerpoPeticion.entrySet()) {
            String nombreCampo = campo.getKey();
            String[] valoresCampo = campo.getValue();
            for (String valorCampo : valoresCampo) {
                System.out.println("Parametro: " + nombreCampo + " = " + valorCampo);
            }
        }
        
        // Crear contrato temporal en la bd
        // ...
        // Obtener id de operacion para realizar pago
        int idOperacion = 1;
        
        resp.sendRedirect(req.getContextPath() + "/pago?id_operacion=" + idOperacion);
    }

}
