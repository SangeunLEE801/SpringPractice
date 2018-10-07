package spring_board.ex.command;

import org.springframework.ui.Model;
import spring_board.ex.dao.BDao;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BDeleteCommand implements BCommand {
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");

        String bId = request.getParameter("bId");
        BDao dao = new BDao();
        dao.delete(bId);
    }
}
