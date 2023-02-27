package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import mx.tecnm.itorizaba.banquetes.entidades.MenuNavegacion;
import mx.tecnm.itorizaba.banquetes.entidades.MenuNavegacionItem;
import mx.tecnm.itorizaba.banquetes.entidades.TipoBanquete;
import mx.tecnm.itorizaba.banquetes.entidades.TipoTematica;

@WebServlet(name = "IndexServlet", urlPatterns = {"/inicio"})
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener banquetes
        List<TipoBanquete> banquetes = new ArrayList<>();
        banquetes.add(new TipoBanquete(1, "Comidas", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas imperdiet enim dui, nec bibendum nisi tincidunt nec.", "https://www.quinceanera.com/es/wp-content/uploads/sites/2/2013/05/catering1.jpg"));
        banquetes.add(new TipoBanquete(2, "Cenas", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas imperdiet enim dui, nec bibendum nisi tincidunt nec.", "https://i.pinimg.com/originals/a4/db/89/a4db893d1203bdb1456318f78962c72c.jpg"));
        banquetes.add(new TipoBanquete(3, "Cocteles", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas imperdiet enim dui, nec bibendum nisi tincidunt nec.", "https://cdn0.matrimonios.cl/article-vendor/0459/3_2/960/jpg/matrimonio-001_8_130459-1563739792.jpeg"));

        request.setAttribute("banquetes", banquetes);
        
        // Obtener Tematicas
        List<TipoTematica> tematicas = new ArrayList<>();
        tematicas.add(new TipoTematica(1, "Bodas", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas imperdiet enim dui, nec bibendum nisi tincidunt nec.", "https://mobar.mx/wp-content/uploads/2022/05/579562.jpeg"));
        tematicas.add(new TipoTematica(2, "Cumpleaños", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas imperdiet enim dui, nec bibendum nisi tincidunt nec.", "https://madridsecreto.co/wp-content/uploads/2022/06/celebrar-cumpleanos-en-Madrid.jpg"));
        tematicas.add(new TipoTematica(3, "XV's", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas imperdiet enim dui, nec bibendum nisi tincidunt nec.", "https://comoorganizarlacasa.com/wp-content/uploads/2018/10/programa-para-15-anos.jpg"));
        
        request.setAttribute("tematicas", tematicas);
        
        // Crear navegacion banquetes
        List navegacionBanquete = banquetes.stream().map(new Function<TipoBanquete, MenuNavegacionItem>() {
            @Override
            public MenuNavegacionItem apply(TipoBanquete t) {
                return new MenuNavegacionItem(t.getId(), t.getNombre());
            }
            
        }).collect(Collectors.toList());
        
        // Crear navegacion tematica
        List navegacionTematica = tematicas.stream().map(new Function<TipoTematica, MenuNavegacionItem>() {
            @Override
            public MenuNavegacionItem apply(TipoTematica t) {
                return new MenuNavegacionItem(t.getId(), t.getNombre());
            }
            
        }).collect(Collectors.toList());
        
        // Crear nevagacion superior
        MenuNavegacion navegacion = new MenuNavegacion(navegacionBanquete, navegacionTematica);
        request.getSession().setAttribute("navegacion", navegacion);

        request.getRequestDispatcher("/inicio.jsp").forward(request, response);
    }
}
