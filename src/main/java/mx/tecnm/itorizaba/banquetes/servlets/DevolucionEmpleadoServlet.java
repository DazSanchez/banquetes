package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import mx.tecnm.itorizaba.banquetes.entidades.DevolucionContrato;

@WebServlet(name = "DevolucionEmpleadoServlet", urlPatterns = {"/panel-empleado/devolucion"})
public class DevolucionEmpleadoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DevolucionContrato devolucionContrato = new DevolucionContrato(1, 23000, 0.5, true);
        
        req.setAttribute("devolucionContrato", devolucionContrato);
        
        req.getRequestDispatcher("/devolucion_empleado.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener los campos del cuerpo de la peticion
        Map<String, String[]> cuerpoPeticion = req.getParameterMap();

        String idContrato = cuerpoPeticion.get("idContrato")[0];
        
        req.setAttribute("tieneExito", true);
        
        req.getRequestDispatcher("/devolucion_empleado.jsp").forward(req, resp);
    }

}
