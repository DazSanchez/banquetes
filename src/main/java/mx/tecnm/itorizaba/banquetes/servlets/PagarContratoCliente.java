package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import mx.tecnm.itorizaba.banquetes.entidades.DesglosePago;

@WebServlet(name = "PagarContratoCliente", urlPatterns = {"/panel-cliente/pagar"})
public class PagarContratoCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DesglosePago desglosePago = new DesglosePago(1, 35000, "", "");
        
        req.setAttribute("desglosePago", desglosePago);
        
        req.getRequestDispatcher("/pagar_contrato_cliente.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener los campos del cuerpo de la peticion
        Map<String, String[]> cuerpoPeticion = req.getParameterMap();

        String idContrato = cuerpoPeticion.get("idContrato")[0];
        
        req.setAttribute("tieneExito", true);
        
        req.getRequestDispatcher("/pagar_contrato_cliente.jsp").forward(req, resp);
    }

}
