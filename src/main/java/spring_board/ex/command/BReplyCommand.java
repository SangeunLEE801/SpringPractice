package spring_board.ex.command;

import org.springframework.ui.Model;
import spring_board.ex.dao.BDao;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BReplyCommand implements BCommand {
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");

        String bId = request.getParameter("bId");
        String bName = request.getParameter("bName");
        String bTitle = request.getParameter("bTitle");
        String bContent = request.getParameter("bContent");
        String bGroup = request.getParameter("bGroup");
        String bStep = request.getParameter("bStep");
        String bIndent = request.getParameter("bIndent");

        BDao dao = new BDao();
        dao.reply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);
    }
}
