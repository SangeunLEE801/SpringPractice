package spring_board.ex.command;

import org.springframework.ui.Model;

public interface BCommand {
    void execute(Model model);
}
