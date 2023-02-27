package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import mx.tecnm.itorizaba.banquetes.entidades.DesglosePago;

@WebServlet(name = "PagoServlet", urlPatterns = {"/pago"})
public class PagoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object idOperacion = req.getParameter("id_operacion");
        
        if(idOperacion == null || ((String) idOperacion).isEmpty()) {
            resp.sendRedirect(req.getContextPath());
            return;
        }
        
        DesglosePago desglosePago = new DesglosePago(1, 35000, "30/01/2023", "01/03/2023");
        
        req.setAttribute("desglosePago", desglosePago);
        
        req.getRequestDispatcher("/pago.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener los campos del cuerpo de la peticion
        Map<String, String[]> cuerpoPeticion = req.getParameterMap();

        String idOperacion = cuerpoPeticion.get("idOperacion")[0];
        
        req.setAttribute("tieneExito", true);
        
        req.getRequestDispatcher("/pago.jsp").forward(req, resp);
    }

}
