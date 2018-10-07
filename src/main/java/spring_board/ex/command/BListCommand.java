package spring_board.ex.command;

import org.springframework.ui.Model;
import spring_board.ex.dao.BDao;
import spring_board.ex.dto.BDto;

import java.util.ArrayList;

public class BListCommand implements BCommand {
    public void execute(Model model) {
        BDao dao = new BDao();
        ArrayList<BDto> dtoArrayList =  dao.list();

        model.addAttribute("list", dtoArrayList);
    }
}
