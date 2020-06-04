package commands;

import communication.Response;
import elements.Product;

public class CommandClear extends Command {

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getManual() {
        return "Очистить коллекцию.";
    }

    @Override
    public Response execute() {
        try {
            return new Response(getName(), context.productList.clear(context.handlerDatabase.isExistingUser(login, password)));
        }
        catch (Exception e) {
            return new Response(getName(), "Вы не прошли авторизацию.");
        }
    }
}
