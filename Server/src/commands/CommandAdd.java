package commands;

import communication.Response;
import elements.Product;

import java.sql.SQLException;

public class CommandAdd extends Command {

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getManual() {
        return "Добавить новый элемент в коллекцию. Параметры: {element}.";
    }

    @Override
    public Response execute() {
        try {
            return new Response(getName(), context.productList.add((Product) arguments[0].getValue(), context.handlerDatabase.isExistingUser(login, password)));
        }
        catch (Exception e) {
            return new Response(getName(), "Вы не прошли авторизацию.");
        }
    }
}
