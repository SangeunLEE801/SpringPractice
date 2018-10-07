package spring_board.ex.command;

import org.springframework.ui.Model;
import spring_board.ex.dao.BDao;
import spring_board.ex.dto.BDto;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BReplyViewCommand implements BCommand {
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest)map.get("request");

        String bId = request.getParameter("bId");
        BDao dao = new BDao();
        BDto dto = dao.reply_view(bId);

        model.addAttribute("reply_view", dto);
    }
}
