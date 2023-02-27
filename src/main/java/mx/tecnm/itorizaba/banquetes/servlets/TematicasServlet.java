package mx.tecnm.itorizaba.banquetes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import mx.tecnm.itorizaba.banquetes.entidades.Adorno;
import mx.tecnm.itorizaba.banquetes.entidades.Color;
import mx.tecnm.itorizaba.banquetes.entidades.Tematica;

@WebServlet(name = "TematicasServlet", urlPatterns = {"/tematicas"})
public class TematicasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idTematica = req.getParameter("id_tematica");
        System.out.println("idTematica: " + idTematica);

        Color[] colores = new Color[]{
            new Color(1, "Rojo", "https://entrefiestas.com/imagen/blog/decoracion-en-rojo-para-fiestas-de-15-anos-1.jpg"),
            new Color(1, "Azul", "https://image.jimcdn.com/app/cms/image/transf/dimension=647x10000:format=jpg/path/sdd2b9b442c59d78e/image/if1868a8df376c95b/version/1570511472/image.jpg"),
            new Color(1, "Morado", "https://cdn0.matrimonio.com.pe/article-real-wedding-o/8162/3_2/960/jpg/11_12618.jpeg")};

        Adorno[] adornos = new Adorno[]{
            new Adorno(1, "Adorno 1", "https://cdn0.casamientos.com.ar/article-real-wedding-o/1667/3_2/960/jpg/7_177661.jpeg"),
            new Adorno(2, "Adorno 2", "https://cdn0.casamientos.com.ar/article-real-wedding-o/1667/3_2/960/jpg/7_177661.jpeg"),
            new Adorno(3, "Adorno 3", "https://cdn0.casamientos.com.ar/article-real-wedding-o/1667/3_2/960/jpg/7_177661.jpeg")};

        Tematica tematica = new Tematica(1,
                "Tematica 1",
                "Lorem ipsum",
                "Doloret sit amet",
                "Consectetur adipiscing elit",
                "Sed ullamcorper urna sit amet bibendum rutrum.",
                "celebration",
                "https://actioncoach.com.mx/mariainesmoran/wp-content/uploads/sites/3/2020/06/Haz-de-tu-reapertura-una-celebraci%C3%B3n-memorable-1.jpg",
                Arrays.asList(colores),
                Arrays.asList(adornos));

        req.setAttribute("tematica", tematica);

        req.getRequestDispatcher("/tematicas.jsp").forward(req, resp);
    }

}
