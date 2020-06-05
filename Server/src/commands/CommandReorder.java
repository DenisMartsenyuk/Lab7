package commands;

import communication.Response;

public class CommandReorder extends Command {

    @Override
    public String getName() {
        return "reorder";
    }

    @Override
    public String getManual() {
        return "Отсортировать коллекцию в порядке, обратном нынешнему.";
    }

    @Override
    public Response execute() {
        try {
            if(context.handlerDatabase.isExistingUser(login, password) == -1) {
                throw new Exception();
            }
            else {
                return new Response(getName(), context.productList.reverse());
            }
        } catch (Exception e) {
            return new Response(getName(), "Вы не прошли авторизацию.");
        }
    }
}
