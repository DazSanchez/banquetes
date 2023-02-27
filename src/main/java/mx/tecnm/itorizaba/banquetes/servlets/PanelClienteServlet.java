package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import mx.tecnm.itorizaba.banquetes.entidades.ContratoClienteSimple;

@WebServlet(name = "PanelClienteServlet", urlPatterns = {"/panel-cliente"})
public class PanelClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        Object tipoUsuario = sesion.getAttribute("tipo_usuario");

        if (tipoUsuario == null) {
            response.sendRedirect(request.getContextPath() + "/autenticacion");
            return;
        } else if(!((String) tipoUsuario).equals("cliente")) {
            response.sendRedirect(request.getContextPath());
            return;
        }

        ContratoClienteSimple[] contratos = new ContratoClienteSimple[]{
            new ContratoClienteSimple(1, "Banquete 1", "30/01/2023", "Pagado"),
            new ContratoClienteSimple(2, "Banquete 2", "30/02/2023", "Pendiente 2do Pago"),
            new ContratoClienteSimple(3, "Banquete 3", "10/03/2023", "Pendiente 3er Pago"),
            new ContratoClienteSimple(4, "Banquete 4", "01/01/2023", "Cancelado"),
        };
        
        request.setAttribute("contratos", contratos);

        request.getRequestDispatcher("/panel_cliente.jsp").forward(request, response);
    }
}
