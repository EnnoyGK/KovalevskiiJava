import service.RoleDispatcher;

import java.io.IOException;

public class Park{
    public static void main(String[] args) throws IOException {
        RoleDispatcher rd = new RoleDispatcher();
        rd.dispatch();
    }
}