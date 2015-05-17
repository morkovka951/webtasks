package controllers;

import services.DisciplineServise;
import services.impl.DisciplineServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Skenalard on 21.04.2015.
 */
public class DisciplineDeleteController extends AbstractWebtasksServletHandler {
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //null ?????? предосмотреть валидацию что делать если отвалился(отключён, не работает) javascript
        String strId = request.getParameter("id");
        int id = Integer.valueOf(strId);
        DisciplineServise disciplineServise = new DisciplineServiceImpl();
        if (disciplineServise.delete(id)) {
            forwardRequest("/admin/disciplinesList.php", request, response);
        } else {
            gotoToJSP("/main/discipline/home.php", request, response);
        }

    }
}
