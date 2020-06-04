package application;

import communication.Request;
import communication.Response;

import java.util.ArrayList;

public class HandlerRequest implements Runnable {

    public Context context;

    public HandlerRequest(Context context) {
        this.context = context;
    }

    @Override
    public void run() {

        if(!context.queueAddressedRequests.isEmpty()) {

            try {
                AddressedRequest addressedRequest = context.queueAddressedRequests.poll();

                ArrayList<Response> responses = new ArrayList<>(addressedRequest.getRequests().size());
                for (Request request : addressedRequest.getRequests()) {
                    responses.add(context.handlerCommands.executeCommand(request));
                }
                context.queueAddressedResponse.add(new AddressedResponse(addressedRequest.getSocketAddress(), responses));
            }
            catch (Exception e) {
                System.out.println("fghjkl");
            }
        }
    }
}
