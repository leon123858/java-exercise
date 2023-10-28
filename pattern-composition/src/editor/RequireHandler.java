package editor;

import editor.*;

import java.util.ArrayList;

public class RequireHandler implements CommandHandler {
    ArrayList<Element> dataArray;
    RequireHandler(ArrayList<Element> data) {
        dataArray = data;
    }

    public void handle(String[] args) {
        assert args.length == 1;
        // args => [editor.BreakStrategy]
        BreakStrategy strategy = BreakStrategy.valueOf(args[0]);
        IBreakStrategy breakStrategy = BreakStrategyFactory.getBreakStrategy(strategy);
        breakStrategy.print(dataArray);
    }
}
